package com.shiva.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shiva.model.City;
import com.shiva.repository.CityRepository;

@RestController
@RequestMapping("/api")
public class CityController 
{
	@Autowired
    private CityRepository cityRepository;

    // http://localhost:8080/api/citys
    @RequestMapping(value = "/citys", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public List<City> getCitys() 
    {
        List<City> list = cityRepository.getAllCitys();
        return list;
    }
 

    // http://localhost:8080/api/city/{cityid}
    @RequestMapping(value = "/city/{cityid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public City getCityById(@PathVariable("cityid") String cityid) 
    {
        return cityRepository.getCity(cityid);
    }
 

    // http://localhost:8080/api/city
    @RequestMapping(value = "/city", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public City addCity(@RequestBody City city) 
    {
        System.out.println("(Service Side) Creating City: " + city.getCityId());
        return cityRepository.addCity(city);
    }
 

    // http://localhost:8080/api/city
    @RequestMapping(value = "/city", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public City updateCity(@RequestBody City city) 
    {
        System.out.println("(Service Side) Editing City: " + city.getCityId());
        return cityRepository.updateCity(city);
    }
 

    // http://localhost:8080/api/city/{cityid}
    @RequestMapping(value = "/city/{cityid}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public void deleteCity(@PathVariable("cityid") String cityid) 
    {
        System.out.println("(Service Side) Deleting citys: " + cityid);
        cityRepository.deleteCity(cityid);
    }
}
