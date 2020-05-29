package com.spring.ex01;

public class OtherStudent {
	private String name; 
	private int age; 
	private String classNumber ;
	private String gradeNumber ;
	
	public OtherStudent() {}
	public OtherStudent(String name, int age) {
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
	
	public void getOtherStudentInfo() {
		System.out.println("Name :" + getName());
		System.out.println("Age : "+ getAge());
		System.out.println("ClassNumber : " + getClassNumber());
		System.out.println("GradeNumber :" + getGradeNumber() );
	}
	
}
