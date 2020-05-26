package com.spring.ex01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String [] args) {
		GenericXmlApplicationContext ctx =new GenericXmlApplicationContext();
		//AnnotationConfigApplicationContext
		ctx.load("classpath:applicationCTX.xml");
		ctx.refresh();
		Student stu1 = ctx.getBean("student1", Student.class);
		System.out.println(stu1.getName());
		System.out.println(stu1.getAge());
		System.out.println(stu1.getTestScore());
		System.out.println(stu1.getWeight());
		System.out.println(stu1.getHeight());
		System.out.println("=================");
		Student stu2 = ctx.getBean("student1", Student.class);
		stu2.setHeight(188.4);
		stu2.setWeight(67.5);
		System.out.println(stu2.getHeight());
		System.out.println(stu2.getWeight());
		System.out.println("=================");
		System.out.println(stu1.getHeight());
		System.out.println(stu1.getWeight());
		
		if(stu1.getName().equals(stu2.getName())) {
			System.out.println("stu1 == stu2");
		}else {
			System.out.println("stu1 != stu2");
			
		}
		ctx.close();
	}
}
