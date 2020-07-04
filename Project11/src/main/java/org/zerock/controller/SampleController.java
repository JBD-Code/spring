package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	/*
	@InitBinder
	public void initBindet(WebDataBinder binder ) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class , new CustomDateEditor(dateFormat, false));
	// 화면에서 2020-01-01 과 같이 문자열로 전달된 데이터를 java.util.Date 타입으로 변환할 경우 
	// @InitBinder 를 이용해서 변환 처리가 가능 
		
	}
	*/
	@GetMapping("/ex06")
	public String ex06(TodoDTO todo) {
		log.info("todo : " + todo);
		return "ex06";
	// 만약 브라우저에서 http://localhost:8090/sample/ex06?title=test&dueDate=2020-01-01 과 같이 호출 한다면 	
	// Console TodoDTO(title=test, dueDate=Wed Jan 01 00:00:00 KST 2020) 출력 
	}
	
	
	//Spring 4.3 version 부터는 @RequestMapping 을 줄여서 시영한다 
	//@GetMapping @PostMapping 축약형 표현이 있다 
	
	@RequestMapping(value ="/basic", method = {RequestMethod.POST, RequestMethod.GET})
	public void basicGet() {
	
		log.info("basic Get");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicSet2() {
		log.info("basic Get2");
		
	}
	@GetMapping("/ex01")
	public String ex01(SampleDTO sampleDTO) {
		log.info("ex01");
		log.info("" + sampleDTO);
		return "ex01";
		
	//SampleController 의 경로가 /sample/* 이므로 ex01 의 Method를 호출 하는 경로는 /sample/ex01이된다
	//GetMapping 를 사용했으므로 필요한 파라미터를 URL 뒤에 /sample/ex01?name=AAA&age=10과 같은 형태로 호출이 가능 
		
	}
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age ) {
		log.info("ex02");
		log.info("name : " +name);
		log.info("age  : " +age);
		return "ex02" ;
	}
	@GetMapping("/ex03List")
	public String ex03List(@RequestParam("idList") ArrayList<String>idList) {
		log.info("ex03List");
		log.info("idList : " +idList);
		return "ex03List" ;
	
	//sample/ex03List?idList=111&idList=2222&idList=3333 같은 형태로 호출이 가능 
		
	
	}
	@GetMapping("/ex04Array")
	public String ex04Array(@RequestParam("idList") String [] idList) {
		log.info("ex04Array");
		log.info("Array idList : " +Arrays.toString(idList));
		return "ex04Array" ;
	}
	
	@GetMapping("/ex05Bean")
	public String ex05Bean(SampleDTOList list) {
		log.info("ex05Bean");
		log.info("list dto : " + list);
		return "ex05Bean" ;
		
	//Parameter 은 [index]와 같은 형태로 전달이 가능하다 
	//sample/ex05Bean?list[0].name=add&list[2].name=bbb	형태로 호출 가능 
	}
	
	@GetMapping("/ex07")
	//public String ex07(SampleDTO dto, int page) {
	public String ex07(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("ex07");
		log.info("dto : " + dto);
		log.info("page : " + page);
		
		return "/sample/ex07";
	//localhost:8090/sample/ex07?name=aaa&age=11&page=9 라고 호출할 경우 
	//views/sample/ex07.jsp 의 View 에는 SampleDTO만이 전달 된 것을 확인 가능하다 
	//int type 로 선언된 page는 전달이 되지 않는다 
	//이런 경우 @ModelAttribute 를 이용헤 Model 에 담아서 전달한다 	
	//localhost:8090/sample/ex07?name=aaa&age=11&page=9 라고 호출할 경우 
	//views/sample/ex07.jsp SampleDTO와 page 가 화면에 표시되는 것을 확인 가능 하다 		
	
	}
	
	
	@GetMapping("/ex08")
	public @ResponseBody SampleDTO ex08 () {
		log.info("/ex08");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		return dto; 

	//Controller의 메서드에서 return 타입읍 VO DTO 타입 등 복합적인 데이터가 들어간 객체 타입으로 지정이 가능 
	//이 경우에는 주로 JSON 데이터를 만들어 내는 경우에 사용한다 
	//이를 위해서는 pom.xml에서 jackson-databind 라이브러리를 추가한다 
	//@ResponBody Annotation을 이용 
	}
	
	@GetMapping("/ex09")
	public ResponseEntity<String> ex09() {
		log.info("ex09");
		String msg = "{\"name\":\"홍길동\"}";
		log.info("msg  : " + msg);
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	//WEB를 다루다 보면 HTTP 프로토콜의 헤더를 다루는 경우가 종종 있다 
	//Spring MVC 사상은 HttpServletRequest, HttpServletResponse 를 직접 핸들링 하지 않아도 
	//이런 작업이 가능 하도록 작성되었기 때문에 이러한 처리를 위해서 ResponseEntity를 통해서
	//원하는 헤더 정보, 데이터 전달이 가능하다 
	
	
	}
	
	
	
	
}
