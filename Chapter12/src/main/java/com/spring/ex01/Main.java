package com.spring.ex01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
	public static void main(String[] args) {
		//ConfigurableApplicationContext ctx =new GenericApplicationContext();
		//ConfigurableApplicationContext env = (ConfigurableApplicationContext) ctx.getEnvironment(); 
		//AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		AdminConnection adminCon = ctx.getBean("adminConfig", AdminConnection.class);
		System.out.println("admin id : " + adminCon.getId());
		System.out.println("admin password : " + adminCon.getPwd());
		System.out.println("admin Sub_id : " + adminCon.getSub_id());
		System.out.println("admin Sub_pwd : " + adminCon.getSub_pwd());
	
		ctx.close();
	}
}
