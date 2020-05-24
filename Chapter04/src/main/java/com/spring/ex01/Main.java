package com.spring.ex01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String [] args) {
		String configLoacation = "classpath:applicationCTX.xml"; 
		String configLoacation1 = "classpath:applicationCTX1.xml"; 
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoacation, configLoacation1);
		Student student1 = ctx.getBean("student1",Student.class);
		System.out.println("Student1 Name :" + student1.getName());
		System.out.println("Student1 Hobby :" + student1.getHobbys());
		
		StudentInfo studentInfo1= ctx.getBean("studentInfo1",StudentInfo.class);
		Student student2 = studentInfo1.getStudent(); 
		System.out.println("Name :" + student2.getName());
		System.out.println("Hobby :" + student2.getHobbys());
		
		if(student1.equals(student2)) {
			System.out.println("student1 == student2");
		}else {
			System.out.println("student1 != student2");
			
		}
		Student student3 = ctx.getBean("student2",Student.class);
		System.out.println("student3 Name :" + student3.getName());
		System.out.println("student3 Hobby :" + student3.getHobbys());
	
		if(student1.equals(student3)) {
			System.out.println("student1 == student3");
		}else {
			System.out.println("student1 != student3");
			
		}
		Family family = ctx.getBean("family", Family.class); 
		
		System.out.println(family.getFatName());
		System.out.println(family.getMotName());
		System.out.println(family.getSisterName());
		System.out.println(family.getBrotherName());
	}
}
