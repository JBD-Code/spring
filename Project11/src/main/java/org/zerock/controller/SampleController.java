package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
}
