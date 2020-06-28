package com.shiva.Main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiva.Main.Model.ServiceLoader;
import com.shiva.Main.Service.ServiceUrl;

@RestController
@RequestMapping("/api")
public class UrlController 
{
	@Autowired
	ServiceUrl serviceUrl;
	
	
	
	@GetMapping("/GetUrls")
	public List<ServiceLoader> getAllUrl()
	{
		return serviceUrl.getAllUrls();
	}
	
	@PostMapping("/AddUrl")
	public ServiceLoader createNewUrl(@RequestBody ServiceLoader load)
	{
		return serviceUrl.createUrl(load);
	}
	
	@PutMapping("/UpdateUrl/{id}")
	public ResponseEntity<ServiceLoader> updateUrl(@PathVariable(value = "id") Long id, @RequestBody ServiceLoader loader)
	{
		ServiceLoader serviceLoader=serviceUrl.getUrlId(id);
		
		if(serviceLoader==null)
		{
			ResponseEntity.notFound().build();
		}
		serviceLoader.setUrl(loader.getUrl());
		serviceLoader.setDescription(loader.getDescription());
		
		ServiceLoader update= serviceUrl.createUrl(serviceLoader);
		return ResponseEntity.ok().body(update);
	}
	
	@DeleteMapping("/DeleteUrl/{id}")
	public void DeleteUrl(@PathVariable(value = "id") Long id)
	{
		System.out.println("TTTT"+id);
		serviceUrl.deletebyid(id);
	}
}
