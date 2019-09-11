package com.raghav.springDataJpaDemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
// @Table annotation is not required when using same name like @column is not required for every column
// this line is added on gitHub please checkout this .
public class Course {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;

	public Course() {
		super();
	}

	public Course(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
}
