package com.practice.roulette.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.roulette.config.BcryptPassEncoder;
import com.practice.roulette.model.dto.RouletteDto;
import com.practice.roulette.model.service.RouletteService;

@Controller
public class RouletteController {

	@Autowired
	RouletteService rouletteService;

	@Autowired
	private BcryptPassEncoder bcryptPassEncoder;

	@GetMapping("/main")
	public String index(int num, Model model) {
		System.out.println(num);
		model.addAttribute("num", num);
		return "main";			
		 
	}

	@GetMapping("/regist")
	public String regist() {
		return "regist";
	}

//	@GetMapping("/roulette")
//	public String roul(Model model, HttpSession session) {
//		RouletteDto rename = (RouletteDto)session.getAttribute("rouletteDto");
//		System.out.println(rename);
////		RouletteDto rouletteDto = rouletteService.selectone(rename);
////		model.addAttribute("rouletteDto", rouletteDto);
//		return "roulette";	
//	}

	@PostMapping("/registinform")
	public String registinform(RouletteDto rouletteDto) {
		System.out.println(rouletteDto);
		rouletteDto.setPw(bcryptPassEncoder.encode(rouletteDto.getPw()));
		rouletteDto.setMoney(5000);

		int res = rouletteService.insertone(rouletteDto);
		if (res > 0) {
			return "redirect:/main?num=0";
		} else {
			return "redirect:/main?num=2";
		}
	}

	@PostMapping("/login")
	public String login(Model model, RouletteDto rouletteDto, HttpSession session) {

		String pw = rouletteDto.getPw();

		rouletteDto = rouletteService.selectone(rouletteDto.getId());
		if (rouletteDto == null) {
			System.out.println("아이디, 비밀번호가 존재하지 않습니다.");
			return "redirect:/main?num=1";
		} 
		else {
			Boolean res = bcryptPassEncoder.matches(pw, rouletteDto.getPw());
			if (res) {
				session.setAttribute("Dto", rouletteDto);
				System.out.println(rouletteDto);
				return "roulette";
			} else {
				System.out.println("아이디, 비밀번호가 존재하지 않습니다.");
				return "redirect:/main?num=1";
			}
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("Dto");
		System.out.println(session.getAttribute("Dto"));
		return "main?num=0";
	}

	// ajax이용하여 비동기 처리
	@GetMapping("/roulette/money")
	@ResponseBody
	public RouletteDto money(Model model, @RequestParam("no") int no, HttpSession session) {

		System.out.println(no);
		RouletteDto rouletteDto = (RouletteDto) session.getAttribute("Dto");
		System.out.println(rouletteDto);
		if (no == 100) {

			rouletteDto.setMoney(rouletteDto.getMoney() - no);
			int res = rouletteService.updateone(rouletteDto);
			if (res > 0) {
				System.out.println(rouletteDto.getMoney());
			}
			return rouletteDto;
		} else {
			rouletteDto.setMoney(rouletteDto.getMoney() + no);
			int res = rouletteService.updateone(rouletteDto);
			if (res > 0) {
				System.out.println(rouletteDto.getMoney());
			}
			return rouletteDto;
		}
	}
}
