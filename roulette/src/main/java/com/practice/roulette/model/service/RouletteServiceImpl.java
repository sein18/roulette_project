package com.practice.roulette.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.roulette.model.dto.RouletteDto;
import com.practice.roulette.model.mapper.RouletteMapper;

@Service
public class RouletteServiceImpl  implements RouletteService{
	
	@Autowired
	RouletteMapper rouletteMapper;
	
	@Override
	public RouletteDto selectone(String name) {
		
		return rouletteMapper.selectone(name);
	}
	@Override
	public int updateone(RouletteDto dto) {
		
		return rouletteMapper.updateone(dto);
	}

}
