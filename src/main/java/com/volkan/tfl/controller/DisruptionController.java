package com.volkan.tfl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.volkan.tfl.dto.DisruptionForm;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by vcivelek on 24/08/16.
 */
@Configuration
@RequestMapping("/roads")
public class DisruptionController {
	private static Logger logger = LoggerFactory.getLogger(DisruptionController.class);
	@RequestMapping(value = "/disruption", method = RequestMethod.GET)
	public String showDisruptionForm(Model model) {
		DisruptionForm disruptionForm = new DisruptionForm();
		model.addAttribute("disruptionForm", disruptionForm);
		logger.info(disruptionForm.toString());

		return "disruption";
	}

	@RequestMapping(value = "/disruption", method = RequestMethod.POST)
	public String postRegisterForm(@ModelAttribute("disruptionForm") DisruptionForm disruptionForm, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors())
			return "disruption";
		logger.info(disruptionForm.toString());

		redirectAttributes.addFlashAttribute("flashType", "success");
		redirectAttributes.addFlashAttribute("flashMessage", "Here is the disruption map below for the selected dates...");

		return "redirect:/home";
	}

}
