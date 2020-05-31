package com.spring.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	@RequestMapping(value="/studentForm")
	 public String studentForm() {
		 return "form";
	 }
	
	@RequestMapping("/studentInsert")
	public String studentCreate(@ModelAttribute("student") Student student, BindingResult result) {
		
		String page = "result";
		StudentValidator validator = new StudentValidator();
		validator.validate(student, result);
		if(result.hasErrors()) {
			page= "form";
		}
		return page;
	
	
	}
	
}
