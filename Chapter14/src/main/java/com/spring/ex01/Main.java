package com.spring.ex01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String [] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationCTX.xml");
		Student student = ctx.getBean("student", Student.class);
		OtherStudent otherStudent = ctx.getBean("otherstudent", OtherStudent.class); 
		
		student.getStudentInfo();
		otherStudent.getOtherStudentInfo();
		
	}
}
