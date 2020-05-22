package com.spring.ex01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
	
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		studentInfo.getStudentInfo();
		
	
		Student student3=ctx.getBean("student3", Student.class);
		studentInfo.setStudnt(student3);
		studentInfo.getStudentInfo();
		
		Student student2=ctx.getBean("student2", Student.class);
		studentInfo.setStudnt(student2);
		studentInfo.getStudentInfo();
		
		
		ctx.close();
		
	}
}
