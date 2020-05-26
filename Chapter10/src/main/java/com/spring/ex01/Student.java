package com.spring.ex01;

import java.util.Map;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean {
	private String name;
	private String age; 
	private Map<String, String>testScore; 
	private double weight; 
	private double height; 
	
	
	public Student() {}


	public Student(String name, String age, Map<String, String> testScore) {
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


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
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


	@Override
	public void destroy() throws Exception {
		System.out.println("destroy Bean");
		
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Init Bean");
		
	}
	
	
	
	
}
