package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {

	private String title; 
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	
	private Date dueDate;
	
	//TodoDTO Class dueDate 변수의 Type 가 java.util.Date 
	
	//Controller 클래스에서 @InitBinder 을 이용해서 날짜를 변환할 수도 있지만 
	//Parameter 로 사용되는 Instance 변수에서 @DataTimeFormat을 적용해도 가능하다 
	//만약 @DateTimeFormat를 이용하는 경우에는 @InitBinder 은 필요없다 
	
	//localhost:8090/sample/ex06?title=test&dueDate=2020/01/01 과 같이 호출 한다면 	
	//Console에 @InitBinder과 같이 TodoDTO(title=test, dueDate=Wed Jan 01 00:00:00 KST 2020) 출력
}
