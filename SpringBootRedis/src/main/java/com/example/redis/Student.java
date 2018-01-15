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
	
	@JsonProperty(value="ID")
    private String id;
	@JsonProperty(value="StudentName")
    private String name;
	@JsonProperty(value="gender")
    private Gender gender;
	@JsonProperty(value="grade")
    private int grade;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Student() {
		super();
	}
	public Student(String id, String name, Gender gender, int grade) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
    
    
}