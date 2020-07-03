package org.zerock.domain;

import lombok.Data;

@Data
public class SampleDTO {
	//Lombok의  @Data Annotation 을 이용하면 getter/setter , equals(), toString의 메서드를 자동 생성  
	
	private String name;
	private String age;
	
}
