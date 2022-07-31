package com.practice.roulette.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.practice.roulette.model.dto.RouletteDto;
import com.practice.roulette.model.service.RouletteService;

@Controller
public class RouletteController {
	@Autowired
	RouletteService rouletteService;
	
	@GetMapping("/roulette")
	public String roul(Model model) {
		RouletteDto rouletteDto = rouletteService.selectone("박세인");
		model.addAttribute("rouletteDto", rouletteDto);
		return "roulette";	
	}
	
}
