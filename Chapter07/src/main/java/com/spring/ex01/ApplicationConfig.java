package com.spring.ex01;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:applicationCTX.xml")
public class ApplicationConfig {
	
	@Bean
	public Student student1() {
		List<String>hobbys = new ArrayList<String>();
		hobbys.add("Game");
		hobbys.add("Movie");
		hobbys.add("Swim");
		Student student1 = new Student("학생1",15, hobbys);
		
		return student1; 
	}

}
