package com.spring.ex01;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class Main {
	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();
		
		MutablePropertySources propertySource = env.getPropertySources();
		
		try {
			propertySource.addLast(new ResourcePropertySource("classpath:admin.properties"));
			System.out.println(env.getProperty("admin.id"));
			System.out.println(env.getProperty("admin.password"));
		} catch (IOException e) {
			System.out.println("propertySource Error" +e);
			e.printStackTrace();
		}
		GenericXmlApplicationContext gCtx= (GenericXmlApplicationContext)ctx;
		gCtx.load("applicationCTX.xml");
		gCtx.refresh();
		
		AdminConnection  adminConnection = gCtx.getBean("adminConnection",AdminConnection.class); 
		System.out.println(adminConnection.getAdmin_id());
		System.out.println(adminConnection.getAdmin_pwd());
		
		gCtx.close();
		ctx.close();
	}
}
