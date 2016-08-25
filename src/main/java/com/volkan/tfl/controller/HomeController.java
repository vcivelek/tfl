package com.volkan.tfl.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vcivelek on 24/08/16.
 */
@Configuration
@RequestMapping("/home")
public class HomeController {

	@RequestMapping
	public String showHomePage() {
		return "home";
	}

}

