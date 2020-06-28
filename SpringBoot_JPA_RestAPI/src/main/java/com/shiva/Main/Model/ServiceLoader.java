package com.shiva.Main.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Service_URL")
public class ServiceLoader 
{
	@Id
	@SequenceGenerator(schema = "bookstore", name = "oraclehr_Company_seq", sequenceName  = "ISEQ$$_73887", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "oraclehr_Company_seq")
	private Long id;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "description")
	private String description;

	public ServiceLoader() {
		super();
	}

	public ServiceLoader(Long id, String url, String desc) {
		super();
		this.id = id;
		this.url = url;
		this.description = desc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	@Override
	public String toString() {
		return "ServiceLoader [id=" + id + ", url=" + url + ", description=" + description + "]";
	}
}