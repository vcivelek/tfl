package com.volkan.tfl.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.volkan.tfl.domain.Disruption;
import com.volkan.tfl.repository.DisruptionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by vcivelek on 24/08/16.
 */

@Controller
@RequestMapping("/roads")
public class DisruptionMapController {
	private static Logger logger = LoggerFactory.getLogger(DisruptionController.class);

	@Autowired
	private DisruptionRepository disruptionRepository;

	@RequestMapping(value= "/disruptionmap", method = RequestMethod.GET)
	public String showWatchlistPage(Model model, HttpServletRequest request) {
//		List<Disruption> disruptionlists = (List<Disruption>) disruptionRepository.findAll();
		String severity = request.getParameter("severity");
		List<Disruption> disruptionlists;
		if(severity.equals("All")){
			disruptionlists = (List<Disruption>) disruptionRepository.findAllByEnddate(request.getParameter("enddate"));
		} else {
			disruptionlists = (List<Disruption>) disruptionRepository.findBySeverityAndEnddate(request.getParameter("severity"), request.getParameter("enddate"));
		}
		model.addAttribute("disruptionlists", disruptionlists);

		ObjectMapper mapper = new ObjectMapper();
		String mapList = null;
		try {
			mapList = mapper.writeValueAsString(disruptionlists);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		model.addAttribute("mapList", mapList);

		return "disruptionmap";
	}

}
