package com.spring.ex03;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*@Controller("memberController")*/
public class MemberController {

	@RequestMapping(value = "/member/memberForm.do", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		ModelAndView mav= new ModelAndView(); 
		mav.setViewName("memberForm");
		return mav; 
		
	}
	//getParameter() X
	@RequestMapping(value ="/member/memberResult.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView memberResult(@RequestParam("id")String id , 
									 @RequestParam("pwd")String pwd,
									 @RequestParam(value="name", required =true) String name,
									 @RequestParam(value="email", required =true) String email,
									 //@RequestParam(value="email", required =false) String email,
									 HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("memberResult");
		mav.addObject("id", id);
		mav.addObject("pwd", pwd);
		mav.addObject("name", name);
		mav.addObject("email", email);
		System.out.println("id =" +id );
		System.out.println("pwd = " + pwd);
		System.out.println("name = " + name);
		System.out.println("email =" + email );
		return mav;  
	}
}
