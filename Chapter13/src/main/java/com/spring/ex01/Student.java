package com.spring.ex01;

import java.util.List;
import java.util.Map;

public class Student {
	private String name; 
	private int age; 
	private double height;
	private double weight; 
	private Map<String, String>testScore; 
	private List<String>hobbys;
	
	
	public Student() {}

	/*
	 * public Student(String name, int age, double weight, double height) {
	 * this.name=name; this.age=age; this.weight=weight; this.height=height; }
	 */
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
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
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
	
	public void getStudentInfo () {
		System.out.println("Name :" +getName());
		System.out.println("Age :" + getAge());
		System.out.println("Height :" + getHeight());
		System.out.println("Weight :" + getWeight());
		System.out.println("TestScore" + getTestScore());
		System.out.println("Hobbys" + getHobbys());
	}
	
	
}
