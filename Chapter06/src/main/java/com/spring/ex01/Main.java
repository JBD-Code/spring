package com.spring.ex01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationCTX.xml");
		//AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println("Student1 Name : "+ student1.getName());
		System.out.println("Student1 Age : "+ student1.getAge());
		System.out.println("Student1 Hobbys : "+ student1.getHobbys());
		student1.setHeight(199.0);
		student1.setWeight(83.1);
		System.out.println("Student1 Weight : "+ student1.getWeight());
		System.out.println("Student1 Height : "+ student1.getHeight());

		System.out.println("======================================");
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println("Student2 Name : "+ student2.getName());
		System.out.println("Student2 Age : "+ student2.getAge());
		System.out.println("Student2 Hobbys : "+ student2.getHobbys());
		student1.setHeight(199.0);
		student1.setWeight(83.1);
		System.out.println("Student2 Weight : "+ student2.getWeight());
		System.out.println("Student2 Height : "+ student2.getHeight());
		
		
		
	}
}
