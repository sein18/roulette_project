package com.practice.roulette.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.roulette.model.dto.RouletteDto;
import com.practice.roulette.model.service.RouletteService;

@Controller
public class RouletteController {
	@Autowired
	RouletteService rouletteService;
	
	@GetMapping("/roulette")
	public String roul(Model model,String name, HttpSession session) {
		String rename = (String)session.getAttribute("name");
		System.out.println(rename);
		RouletteDto rouletteDto = rouletteService.selectone(rename);
		model.addAttribute("rouletteDto", rouletteDto);
		return "roulette";	
	}
	
	@GetMapping("/regist")
	public String regist() {
		return "regist";	
	}
	
	@PostMapping("/registinform")
	public String registinform(RouletteDto rouletteDto, HttpSession session) {
		System.out.println(rouletteDto);
		rouletteDto.setMoney(5000);
		
		int res = rouletteService.insertone(rouletteDto);
		if(res>0) {
			System.out.println(res);
			session.setAttribute("id", rouletteDto.getId());
			session.setAttribute("pw", rouletteDto.getPw());
			session.setAttribute("name", rouletteDto.getName());
		}
		return "redirect:/roulette";
	}
	
	@PostMapping("/login")
	public String login(Model model,String id,String pw) {
		System.out.println(id+" "+pw);
		return "regist";	
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
