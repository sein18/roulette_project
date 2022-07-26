package com.practice.roulette.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.practice.roulette.model.dto.RouletteDto;

@Mapper
public interface RouletteMapper {
	
	@Select(" select * from roulette where name= #{name}")
	RouletteDto selectone(String name);
}
