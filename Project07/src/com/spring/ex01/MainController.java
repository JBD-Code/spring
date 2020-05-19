package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller("mainController")
@RequestMapping("/test")
//public class MainController extends MultiActionController {
public class MainController {

	@RequestMapping(value ="/main1.do", method = RequestMethod.GET)
	
	public ModelAndView main1(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ModelAndView mav = new ModelAndView(); 
		mav.addObject("message", "main1");
		mav.setViewName("test01");
		return mav;
	}

	
	@RequestMapping(value="/main2.do", method=RequestMethod.GET)
	//@RequestMapping(value="/main2.do", method=RequestMethod.POST)
	 	public ModelAndView main2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView(); 
		mav.addObject("message", "main2");
		mav.setViewName("test01");
		return mav;	
	}
	
}
