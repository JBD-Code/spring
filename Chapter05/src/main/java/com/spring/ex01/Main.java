package com.spring.ex01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx =new AnnotationConfigApplicationContext(ApplicationConfig.class);
	
		Student student =ctx.getBean("student", Student.class);
		
		System.out.println("student1 Name : " + student.getName());
		System.out.println("student1 Hobbys : " + student.getHobbys());
		System.out.println("student1 Age : " + student.getAge());
		System.out.println("student1 Weight : " + student.getWeight());
		System.out.println("student1 Height : " + student.getHeight());
		System.out.println("=========================================");
		
		Student student2 =ctx.getBean("student2", Student.class);
		
		System.out.println("student1 Name : " + student2.getName());
		System.out.println("student1 Hobbys : " + student2.getHobbys());
		System.out.println("student1 Age : " + student2.getAge());
		System.out.println("student1 Weight : " + student2.getWeight());
		System.out.println("student1 Height : " + student2.getHeight());
		ctx.close();
	
	}
}
