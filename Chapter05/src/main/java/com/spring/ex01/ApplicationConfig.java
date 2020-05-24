package com.spring.ex01;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	public Student student() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("Swimming");
		hobbys.add("Soccer");
		
		Student student = new Student("학생1", 18, hobbys);
		student.setHeight(188);
		student.setWeight(80);
		
		
		return student; 
	}
	
	@Bean
	public Student student2() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("Game");
		hobbys.add("Hiking");
		hobbys.add("Movie");
		
		Student student2 = new Student("학생2", 17, hobbys);
		student2.setHeight(168);
		student2.setWeight(60);
		
		
		return student2; 
	}
	
}
