package com.practice.roulette.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouletteController {

	@GetMapping("/roulette")
	public String roul() {
		return "roulette";	
	}
	
}
