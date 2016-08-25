package com.volkan.tfl.job;

import com.volkan.tfl.service.TflRoadDisruptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by vcivelek on 25/08/16.
 */

@Component
@EnableScheduling
@PropertySource("classpath:scheduler.properties")
public class TflRoadDisruptionJob {
	private static Logger logger = LoggerFactory.getLogger(TflRoadDisruptionService.class);

	@Autowired
	private TflRoadDisruptionService TflRoadDisruptionService;

	@Autowired
	private Environment env;


	@Scheduled(fixedDelayString = "${com.volkan.tfl.fixedrate}")
	public void runTflRoadDisruptionService() throws InterruptedException {
		Boolean isRun = Boolean.valueOf(env.getProperty("com.volkan.tfl.runTflRoadDisruptionService").toUpperCase());

		if (isRun) {
			logger.info("runTflRoadDisruptionService is running");
			TflRoadDisruptionService.saveDisruptions();
		}
	}

}
