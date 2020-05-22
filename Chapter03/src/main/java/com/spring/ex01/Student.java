package com.spring.ex01;

public class Student {
	private String name; 
	private String age; 
	private String classNumber; 
	private String gradeNumber;
	
	
	public Student() {}
	
	public Student(String name, String age, String classNumber, String gradeNumber) {
		
		this.name = name;
		this.age = age;
		this.classNumber = classNumber;
		this.gradeNumber = gradeNumber;
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

	public String getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}

	public String getGradeNumber() {
		return gradeNumber;
	}

	public void setGradeNumber(String gradeNumber) {
		this.gradeNumber = gradeNumber;
	}
	

}
