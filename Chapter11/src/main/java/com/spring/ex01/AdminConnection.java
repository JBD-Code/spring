package com.spring.ex01;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements EnvironmentAware, InitializingBean, DisposableBean  {
	private Environment env; 
	private String admin_id; 
	private String admin_pwd;
	
	
	public Environment getEnv() {
		return env;
	}
	public void setEnv(Environment env) {
		this.env = env;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_pwd() {
		return admin_pwd;
	}
	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}
	
	@Override // Bean 생성 전 호출 
	public void setEnvironment(Environment env) {
		System.out.println("SetEnvironment");
		setEnv(env);
		System.out.println(env.getProperty("admin.id"));
		System.out.println(env.getProperty("admin.password"));
		System.out.println("==================================");
	}
	@Override 
	public void afterPropertiesSet() throws Exception {
		System.out.println("Init Bean");
		setAdmin_id(env.getProperty("admin.id"));
		setAdmin_pwd(env.getProperty("admin.password"));
		System.out.println("==================================");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("Destory Bean");
		System.out.println("==================================");
		
	} 
	
	
	
	
}
