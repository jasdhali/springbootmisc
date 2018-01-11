package com.example.redis;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student implements Serializable {
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public enum Gender { 
        MALE, FEMALE
    }
	
	@JsonProperty(value="id")
    private String id;
	@JsonProperty(value="name")
    private String name;
    private Gender gender;
    private int grade;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Student(String id, String name, Gender gender, int grade) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.grade = grade;
	}
	
    
    
}