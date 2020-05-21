package com.spring.ex01;

import java.util.ArrayList;

public class MyInfo {
	
	private String name; 
	private double height;
	private double weight;
	private ArrayList<String> hobbys;
	private BmiCalculator bmiCalculator;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public ArrayList<String> getHobbys() {
		return hobbys;
	}
	public void setHobbys(ArrayList<String> hobbys) {
		this.hobbys = hobbys;
	}
	public BmiCalculator getBmiCalculator() {
		return bmiCalculator;
	}
	public void setBmiCalculator(BmiCalculator bmiCalculator) {
		this.bmiCalculator = bmiCalculator;
	}
	public void bmiCalculator() {
		bmiCalculator.bmiCalculator(weight, height);
	}
	
	public void getInfo() {
		System.out.println("Name : " + name);
		System.out.println("Height : " +height);
		System.out.println("Weight : " + weight);
		System.out.println("Hobby : " + hobbys);
		bmiCalculator(); 
		
	}
	
	

}
