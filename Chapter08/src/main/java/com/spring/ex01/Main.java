package com.spring.ex01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[]args) {
		//AnnotationConfigApplicationContext
		//GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("applicationCTX.xml");
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); //생성
		ctx.load("classpath:applicationCTX.xml");//설정
		
		ctx.refresh();//설정을 따로 할 경우 사용 
		
		Student student = ctx.getBean("student1", Student.class);
		System.out.println(student.getName());
		System.out.println(student.getAge());
	
	}
}
