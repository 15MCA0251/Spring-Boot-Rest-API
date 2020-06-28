package com.shiva.Main.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Tutorials")
public class Tutorials {

	@Id
	@SequenceGenerator(schema = "bookstore", name = "oraclehr_Company_seq", sequenceName  = "ISEQ$$_73886", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oraclehr_Company_seq")
	private long id;

	@Column(name = "Title")
	private String title;

	@Column(name = "Description")
	private String description;

	public Tutorials() 
	{
		
	}

	public Tutorials(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + "]";
	}
}
