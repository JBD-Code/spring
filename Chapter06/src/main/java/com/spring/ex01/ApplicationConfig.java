package com.spring.ex01;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/*
@Configuration
@ImportResource("classpath:applicationCTX.xml")
*/
public class ApplicationConfig {
	
	/* @Bean */
	public Student student1() {
		ArrayList<String>hobbys = new ArrayList<String>();
		hobbys.add("Swimming");
		hobbys.add("Hiking");
		hobbys.add("Movie");
		
		Student student1= new Student("Student1", 18, hobbys);
		
		return student1; 
	}
	
}
