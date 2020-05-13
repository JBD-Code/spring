package com.spring.ex02;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController {
	
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String userID = ""; 
		String userPWD = "" ;
		String viewName =getViewName(request);
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("UTf-8");
		userID = request.getParameter("id"); 
		userPWD = request.getParameter("pwd"); 
		mav.addObject("userID", userID);
		mav.addObject("userPWD", userPWD);
		//mav.setViewName("MemberResult");
		mav.setViewName(viewName);
		return mav;
	}
	
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		mav.addObject("id", id);
		mav.addObject("pwd", pwd);
		mav.addObject("name", name);
		mav.addObject("email", email);
		mav.setViewName("MemberInfo");
		
		return mav; 
	}
	//url 요청명에서 do를 제외한 요청명을 가져오는 Method 
	private String getViewName(HttpServletRequest request) throws Exception{
		String contextPath = request.getContextPath();
		String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
		if(uri==null||uri.trim().equals("")) {
			uri=request.getRequestURI();
		}
		
		int begin = 0; 
		if(!((contextPath==null)||("".equals(contextPath)))) {
			begin=contextPath.length();
		}
		
		int end; 
		
		if(uri.indexOf(";")!=-1) {
			end=uri.indexOf(";");
		}else if(uri.indexOf("?")!=-1) {
			end=uri.indexOf("?");
		}else {
			end=uri.length();
		}
		
		String fileName = uri.substring(begin, end);
		if(fileName.indexOf(".")!=-1) {
			fileName=fileName.substring(0,fileName.lastIndexOf("."));
		}
		if(fileName.lastIndexOf("/")!=-1) {
			fileName=fileName.substring(fileName.lastIndexOf("/"),fileName.length());
			
		}
		return fileName;
	}
}
