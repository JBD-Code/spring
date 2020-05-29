package com.spring.ex01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[]args) {
		
		//AOP (Aspect Oriented Programming)
		//핵심 기능과 공통 기능을 분리, 공통 기능을 필요로 하는 핵심기능들에서 사용하는 방식 
		//Client(호출) - Proxy(대행) - Target(핵심기능)
		// XML 기반의 AOP 
		// Aspect Annotation 기반의 AOP  
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Student student =ctx.getBean("student",Student.class);
		student.getStudentInfo();
		
		Worker worker = ctx.getBean("worker", Worker.class)	;
		worker.getWorkerInfo();
	}
}
