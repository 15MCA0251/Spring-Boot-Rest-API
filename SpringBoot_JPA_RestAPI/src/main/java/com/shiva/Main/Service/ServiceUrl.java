package com.shiva.Main.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiva.Main.Model.ServiceLoader;
import com.shiva.Main.Repository.UrlRepository;

@Service
public class ServiceUrl 
{
	@Autowired
	UrlRepository  urlRepository;
	
	public List<ServiceLoader> getAllUrls()
	{
		return urlRepository.findAll();
	}
	
	public ServiceLoader createUrl(ServiceLoader load)
	{
		return urlRepository.save(load);
	}
	
	public ServiceLoader getUrlId(Long id)
	{
		return urlRepository.getOne(id);
	}
	
	public void deletebyid(Long id)
	{
		urlRepository.deleteById(id);
	}
}
