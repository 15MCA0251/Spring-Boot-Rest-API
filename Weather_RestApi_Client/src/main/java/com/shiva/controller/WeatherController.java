package com.shiva.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonValue;

@Controller
public class WeatherController 
{		
	
	@RequestMapping("/Home")
	public ModelAndView homePage() {
		return new ModelAndView("Home");
	}
	
	@RequestMapping("/weather")
	public ModelAndView weatherPage() {
		return new ModelAndView("Weather");
	}
	
	@RequestMapping("/getWeather")
	public ModelAndView LoginProcess(HttpServletRequest req, HttpSession session)
	{
		String cityName=req.getParameter("id");
		System.out.println("TTTTTTTTT"+cityName);
		ModelAndView mv= new ModelAndView();
		String error="City Not Found";
		
		try
		{	
		String key="access_key=40e29e8e121d8cc1b97eafdd0cd77564";
		String query="query="+cityName;
		System.out.println("Key-"+key+"query"+query);
		
		String url = "http://api.weatherstack.com/current?"+key+"&"+query;
	    System.out.println("url->"+url);
	    RestTemplate restTemplate = new RestTemplate();
	    String data = restTemplate.getForObject(url, String.class); 
	    System.out.println(data);

	    
	    //Request....
	    //Location...
	    
	    
	    //current....
	    System.out.println("111");
	    JSONObject jSONObject2 = new JSONObject(data);
	    System.out.println("22");
	    JSONObject request  = jSONObject2.getJSONObject("current");
	    System.out.println("33"+request);
	    
	    int temperature = request.getInt("temperature");
	    int weather_code = request.getInt("weather_code");
	    
	    JSONArray jsonArray = request.getJSONArray("weather_descriptions");	    
	    System.out.println("TYTYT-->"+jsonArray);
	    
	    List<String> Desc = new ArrayList<String>();
	      for(int i=0; i < jsonArray.length(); i++) 
	      {
	         Desc.add(jsonArray.getString(i));
	      }
		String D="";
		String Description=String.join(D, Desc);
		System.out.println("TTTTTTTT"+Description);
	   
		mv.addObject("id",cityName);
		mv.addObject("temperature",temperature);
		mv.addObject("weather_code",weather_code);
		mv.addObject("weather_descriptions",Description);
		mv.setViewName("ViewDetails");
		}
		catch(JSONException  e)
		{
			System.out.println("Exception");
			e.printStackTrace();
			mv.addObject("Error",error);
			mv.addObject("id",cityName);
			mv.setViewName("errorPage");
			return mv;
		}
		return mv;
	}
}