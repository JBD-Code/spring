package com.spring.ex01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ApplicationConfig {

	@Value("${admin.id}")
	private String id;
	@Value("${admin.pwd}")
	private String pwd;
	@Value("${admin.sub_id}")
	private String sub_id;
	@Value("${admin.sub_pwd}")
	private String sub_pwd;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer Properties() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		Resource[]location = new Resource[2];
		
		location[0] = new ClassPathResource("admin.properties");
		location[1] = new ClassPathResource("admin2.properties");
		
		for(int i=0; i<location.length; i++) {
			System.out.println(location[i]);
		}
		
		configurer.setLocations(location);
		System.out.println(location.getClass().getName());
		return configurer;
	}
	
	@Bean
	public AdminConnection adminConfig() {
		AdminConnection adminConnection = new AdminConnection();
		adminConnection.setId(id);
		adminConnection.setPwd(pwd);
		adminConnection.setSub_id(sub_id);
		adminConnection.setSub_pwd(sub_pwd);
		
		return adminConnection;
	}
	
}
