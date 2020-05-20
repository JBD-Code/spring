package com.spring.member.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.member.service.MemberService;
import com.spring.member.vo.MemberVO;


@Controller("memberController")
public class MemberControllerImpl implements MemberController{
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberVO memberVO;
	
	/*
	 public void setMemberService(MemberService memberService) {
	 	this.memberService = memberService; }
	 */

	@Override
	@RequestMapping(value = "/member/memberList.do" , method= {RequestMethod.GET})
	public ModelAndView memberList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		System.out.println("viewName =" + viewName);
		ModelAndView mav = new ModelAndView(viewName);
		List memberList = memberService.memberList();
		mav.addObject("memberList", memberList);
		return mav;
	}
	@RequestMapping(value="/member/memberForm.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		System.out.println("mav = "+ mav);
		return mav;
	}

	/*
	@RequestMapping(value="/member/memberInsert.do", method={RequestMethod.POST, RequestMethod.GET})
	@Override
	
	public ModelAndView memberInsert(@RequestParam("id")String id,
	   				  				 @RequestParam("pwd")String pwd,
								 	 @RequestParam("name")String name,
									 @RequestParam("email")String email,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return null;
	}
	*/
	
	
	@RequestMapping(value="/member/memberInsert.do", method={RequestMethod.POST, RequestMethod.GET})
	@Override
	public ModelAndView memberInsert(@ModelAttribute("member") MemberVO memberVO,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
	
		memberService.memberInsert(memberVO);
		
		ModelAndView mav = new ModelAndView("redirect:/member/memberList.do");
		System.out.println("mav = "+ mav);
		return mav;
	}
	
	
	@RequestMapping(value="/member/memberDelete.do", method = {RequestMethod.POST, RequestMethod.GET})
	@Override
	public ModelAndView memberDelete(String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		memberService.memberDelete(id);
		ModelAndView mav = new ModelAndView("redirect:/member/memberList.do");
		System.out.println("mav = "+ mav);
		return mav;
	}
	private String getViewName(HttpServletRequest request) throws Exception {
		
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String fileName = uri.substring(begin, end);
		if (fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		}
		if (fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
		}
		return fileName;
	}	
	
	
	
	
}
