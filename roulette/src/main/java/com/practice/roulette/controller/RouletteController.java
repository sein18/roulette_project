package com.practice.roulette.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@GetMapping("/roulette/money")
	@ResponseBody
	public RouletteDto money(Model model, @RequestParam("no") int no) {
		
		System.out.println(no);
		RouletteDto rouletteDto = rouletteService.selectone("박세인");
		if(no==100) {
			
		rouletteDto.setMoney(rouletteDto.getMoney()-no);
		int res = rouletteService.updateone(rouletteDto);
		if(res > 0) {
			System.out.println(rouletteDto.getMoney()); 
		}
		return rouletteDto;	
		}else {
			
			rouletteDto.setMoney(rouletteDto.getMoney()+no);
			int res = rouletteService.updateone(rouletteDto);
			if(res > 0) {
				System.out.println(rouletteDto.getMoney()); 
			}
			return rouletteDto;	
		}
	}
}
