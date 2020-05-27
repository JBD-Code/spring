package com.spring.ex01;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;


public class AdminConnection implements InitializingBean, DisposableBean {
	
	private String id;
	private String pwd; 
	private String sub_id;
	private String sub_pwd;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSub_id() {
		return sub_id;
	}
	public void setSub_id(String sub_id) {
		this.sub_id = sub_id;
	}
	public String getSub_pwd() {
		return sub_pwd;
	}
	public void setSub_pwd(String sub_pwd) {
		this.sub_pwd = sub_pwd;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Init Bean");
		
	} 
	
	
	@Override
	public void destroy() throws Exception {
		System.out.println("Destory Bean");
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
