package com.spring.ex01;

import java.util.List;
import java.util.Map;

public class Student {
	private String name;
	private int age ; 
	private Map<String, String>testScore; 
	private List<String>hobbys; 
	private double weight; 
	private double height; 
	
	public Student() {} 
	public Student(String name, int age) {
		this.name=name;
		this.age=age; 
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
	public List<String> getHobbys() {
		return hobbys;
	}
	public void setHobbys(List<String> hobbys) {
		this.hobbys = hobbys;
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
	
	public void getStudentInfo() {
		System.out.println("Name :" + getName());
		System.out.println("Age : "+ getAge());
		System.out.println("Hobbys :" + getHobbys());
		System.out.println("TestScore :" + getTestScore());
	}
}
