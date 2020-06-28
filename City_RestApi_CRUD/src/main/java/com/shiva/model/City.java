package com.shiva.model;

public class City 
{
	private String cityId;
	private String cityName;
	private String cityDesc;
	
	public City() {
		super();
	}
	public City(String cityId, String cityName, String cityDesc) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.cityDesc = cityDesc;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityDesc() {
		return cityDesc;
	}
	public void setCityDesc(String cityDesc) {
		this.cityDesc = cityDesc;
	}
}
