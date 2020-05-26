package com.spring.ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String []args) {
		
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:applicationCTX.xml");
		
		/*
		ctx.refresh();
		
		Student stu1 = ctx.getBean("student1", Student.class);
		System.out.println(stu1.getName());
		System.out.println(stu1.getAge());
		System.out.println(stu1.getHobbys());
		System.out.println(stu1.getWeight());
		System.out.println(stu1.getHeight());
		ctx.close();
		*/
		ctx.refresh();
		OtherStudent stu2 = ctx.getBean("student2", OtherStudent.class);
		System.out.println(stu2.getName());
		System.out.println(stu2.getAge());
		System.out.println(stu2.getTestScore());
		System.out.println(stu2.getHeight());
		System.out.println(stu2.getWeight());
		ctx.close();
	
	}
}
