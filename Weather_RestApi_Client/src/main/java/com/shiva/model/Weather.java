package com.shiva.model;


public class Weather 
{
	private int weatherCode;
	private String weather_icons;
	private int temperature;
	
	public int getWeatherCode() {
		return weatherCode;
	}
	public void setWeatherCode(int weatherCode) {
		this.weatherCode = weatherCode;
	}
	public String getWeather_icons() {
		return weather_icons;
	}
	public void setWeather_icons(String weather_icons) {
		this.weather_icons = weather_icons;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	@Override
	public String toString() {
		return "Weather [weatherCode=" + weatherCode + ", weather_icons=" + weather_icons + ", temperature="
				+ temperature + "]";
	}
}
