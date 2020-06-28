package com.shiva.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shiva.model.City;

@Repository
public class CityRepository 
{
	private static final Map<String, City> cityMap = new HashMap<String, City>();
	 
    static 
    {
    	initCity();
    }
 
    private static void initCity() 
    {
    	City c1 = new City("101", "Chennai", "City in Tamil Nadu");
    	City c2 = new City("102", "Bengaluru", "City in Karnataka");
        City c3 = new City("103", "Kochi", "City in Kerala");
 
        cityMap.put(c1.getCityId(), c1);
        cityMap.put(c2.getCityId(), c2);
        cityMap.put(c3.getCityId(), c3);
    }
 
    public City getCity(String id) 
    {
        return cityMap.get(id);
    }
 
    public City addCity(City city) 
    {
    	cityMap.put(city.getCityId(), city);
        return city;
    }
 
    public City updateCity(City city) 
    {
    	cityMap.put(city.getCityId(), city);
        return city;
    }
 
    public void deleteCity(String id) 
    {
    	cityMap.remove(id);
    }
 
    public List<City> getAllCitys() 
    {
        Collection<City> c = cityMap.values();
        List<City> list = new ArrayList<City>();
        list.addAll(c);
        return list;
    }

}
