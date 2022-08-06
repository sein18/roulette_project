package com.practice.roulette.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.practice.roulette.model.dto.RouletteDto;

@Mapper
public interface RouletteMapper {
	
	@Select(" select * from roulette where name= #{name} ")
	RouletteDto selectone(String name);
	
	@Update(" update roulette set money = #{money} where name = #{name} ")
	int updateone(RouletteDto dto);
	
	@Insert(" insert into roulette values( #{id},#{pw},#{name},#{money} ) ")
	int insertone(RouletteDto dto);
}
