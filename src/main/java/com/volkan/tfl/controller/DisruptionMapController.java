package com.volkan.tfl.controller;

import com.volkan.tfl.domain.Disruption;
import com.volkan.tfl.repository.DisruptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by vcivelek on 24/08/16.
 */

@Controller
@RequestMapping("/roads")
public class DisruptionMapController {

	@Autowired
	private DisruptionRepository disruptionRepository;

	@RequestMapping(value= "/disruptionmap", method = RequestMethod.GET)
	public String showWatchlistPage(Model model) {
		List<Disruption> disruptionlists = (List<Disruption>) disruptionRepository.findAll();
		model.addAttribute("disruptionlists", disruptionlists);
		return "disruptionmap";
	}

}
