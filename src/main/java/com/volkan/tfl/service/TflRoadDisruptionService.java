package com.volkan.tfl.service;

import com.volkan.tfl.domain.Disruption;
import com.volkan.tfl.dto.DisruptionJson;
import com.volkan.tfl.repository.DisruptionRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sun.tools.java.Environment;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by vcivelek on 25/08/16.
 */

@Service
@PropertySource("classpath:scheduler.properties")
public class TflRoadDisruptionService {

	private static Logger logger = LoggerFactory.getLogger(TflRoadDisruptionService.class);

	@Autowired
	private DisruptionRepository disruptionRepository;

	// Go back to so many days from the Tfl APIs
	private static Integer fordays = 1;

	public static List<DisruptionJson> getDisruptions() throws MalformedURLException {
		final Calendar cal = Calendar.getInstance();

		// today is the default end date for fetching disruptions
		final Date today = new Date();
		cal.setTime(today);
		String toDay = String.format("%02d", cal.get(Calendar.DAY_OF_MONTH));
		String toMonth = String.format("%02d", cal.get(Calendar.MONTH));
		String toYear = String.format("%02d", cal.get(Calendar.YEAR));

		cal.add(Calendar.DAY_OF_MONTH, -1 * fordays);

		String fromDay = String.format("%02d", cal.get(Calendar.DAY_OF_MONTH));
		String fromMonth = String.format("%02d", cal.get(Calendar.MONTH));
		String fromYear = String.format("%02d", cal.get(Calendar.YEAR));

		try {
			URL tfl = new URL("https://api.tfl.gov.uk/Road/All/Disruption?startDate=" + fromYear+ "-" + fromMonth + "-" + fromDay + "&EndDate="
					+ toYear + "-" + toMonth + "-" + toDay);
			logger.info(tfl.toString());

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<List<DisruptionJson>> tflResponse =
				restTemplate.exchange(tfl.toString(),
						HttpMethod.GET, null, new ParameterizedTypeReference<List<DisruptionJson>>() {
						});
			List<DisruptionJson> disruptionJsonList = tflResponse.getBody();

			return disruptionJsonList;

		}catch (IOException e) {
			logger.error(e.toString(), e);
		}
		return null;
	}

	public static Disruption parseDisruption(DisruptionJson disruptionJson) throws java.text.ParseException {
		String id = "TFL";
		Date startdate = null;
		Date enddate = null;
		float latitude = 0;
		float longitude = 0;
		String severity = "Severe";

		id = disruptionJson.getId();
		startdate = disruptionJson.getStartDateTime();
		enddate = disruptionJson.getEndDateTime();
		latitude = disruptionJson.getLatitude();
		longitude = disruptionJson.getLongitude();
		severity = disruptionJson.getSeverity();

		// create a Disruption POJO
		return new Disruption(id, startdate, enddate, latitude, longitude, severity);
	}

	public void saveDisruptions() {
		try {
			List<DisruptionJson> disruptions = getDisruptions();
			for (DisruptionJson d : disruptions) {
				Disruption disruption = parseDisruption(d);
				// persist the Disruption POJO into Cassandra
				disruptionRepository.save(disruption);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
