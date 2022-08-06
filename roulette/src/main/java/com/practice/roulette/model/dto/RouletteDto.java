package com.practice.roulette.model.dto;



public class RouletteDto {
	private String id;
	private String pw;
	private String name;
	private int money;
	public RouletteDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RouletteDto(String id, String pw, String name, int money) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.money = money;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "RouletteDto [id=" + id + ", pw=" + pw + ", name=" + name + ", money=" + money + "]";
	}

 
}
