package com.spring.ex01;

public class StudentInfo {
	private Student student;
	
	public StudentInfo() {}
	
	public StudentInfo(Student student) {
		this.student = student;
	}
	
	public void setStudnt(Student studnt) {
		this.student = studnt;
	}
	
	public void getStudentInfo() {
		if(student!=null) {
			System.out.println("Student Name : "+ student.getName());
			System.out.println("Student Age : "+ student.getAge());
			System.out.println("Student GradeNumber : "+ student.getGradeNumber());
			System.out.println("Student ClassNumber : "+ student.getClassNumber());
			System.out.println("=======================");
		} 
		
	}
	
	
	
}
