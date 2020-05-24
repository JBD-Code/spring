package com.spring.ex01;

public class Family {

	 String fatName;
	 String motName;
	 String sisterName; 
	 String brotherName;
	
	public Family(String fatName, String motName) {
		this.fatName = fatName;
		this.motName = motName;
	}

	public String getFatName() {
		return fatName;
	}

	public void setFatName(String fatName) {
		this.fatName = fatName;
	}

	public String getMotName() {
		return motName;
	}

	public void setMotName(String motName) {
		this.motName = motName;
	}

	public String getSisterName() {
		return sisterName;
	}

	public void setSisterName(String sisterName) {
		this.sisterName = sisterName;
	}

	public String getBrotherName() {
		return brotherName;
	}

	public void setBrotherName(String brotherName) {
		this.brotherName = brotherName;
	}
	
	
}
