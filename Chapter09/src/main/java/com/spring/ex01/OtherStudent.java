package com.spring.ex01;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class OtherStudent {
	private String name;
	private int age; 
	private Map<String, String> testScore;
	private double weight; 
	private double height; 
	
	public OtherStudent () {}

	public OtherStudent(String name, int age, Map<String, String> testScore) {
		this.name = name;
		this.age = age;
		this.testScore = testScore;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Map<String, String> getTestScore() {
		return testScore;
	}

	public void setTestScore(Map<String, String> testScore) {
		this.testScore = testScore;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	@PostConstruct
	public void initMethod() {
		System.out.println("InitMethod");
	}
	
	@PreDestroy
	public void destoryMethod() {
		System.out.println("DestoryMethod");
	}
	


}
