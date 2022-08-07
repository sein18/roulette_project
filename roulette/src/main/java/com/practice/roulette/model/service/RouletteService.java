package com.practice.roulette.model.service;

import com.practice.roulette.model.dto.RouletteDto;

public interface RouletteService {
	
	public RouletteDto selectone(String id);
	public int updateone(RouletteDto dto);
	public int insertone(RouletteDto dto);
}
