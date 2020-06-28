package com.spring.pro08.member.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.pro08.member.service.MemberService;
import com.spring.pro08.member.vo.MemberVO;

@Controller("memberController")
public class MemberControllerImpl implements MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberControllerImpl.class);
	
	@Autowired
	private MemberService memberService; 
	
	@Autowired
	private MemberVO memberVO;
	
	String viewName = ""; 
	
	@Override
	@RequestMapping(value = "/member/memberList.do", method = RequestMethod.GET)
	public ModelAndView memberList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		viewName = getViewName(request);
		//System.out.println(viewName );
		//System.out.println("view = " + viewName);
		logger.info("info Level "+viewName);
		logger.debug("debug Levle" +viewName);
		
		ModelAndView mav= new ModelAndView(viewName);
		List memberList = memberService.memberList();
		mav.addObject("memberList", memberList);
		return mav; 
	}
	
	@RequestMapping(value="/member/memberForm.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("UTF-8");
		viewName = getViewName(request);
		logger.info("viewName"+viewName);
		logger.debug("viewName"+viewName);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		//System.out.println("mav = "+ mav);
		return mav;
	}
	
	
	@RequestMapping(value= "/member/memberInsert.do", method= {RequestMethod.POST})
	@Override
	public ModelAndView memberInsert(@ModelAttribute("member") MemberVO memberVO, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		viewName = getViewName(request);
		logger.info("viewName"+viewName);
		logger.debug("viewName"+viewName);
		
		ModelAndView mav = new ModelAndView("redirect:/member/memberList.do");
		memberService.memberInsert(memberVO);
		return mav;
		
	}
	
	@RequestMapping(value ="/member/memberUpdate.do", method=RequestMethod.POST)
	@Override
	public ModelAndView memberUpdate(MemberVO memberVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		viewName = getViewName(request);
		//System.out.println(viewName);
		logger.info("viewName"+viewName);
		logger.debug("viewName"+viewName);
		
		ModelAndView mav = new ModelAndView("redirect:/member/memberList.do"); 
		memberService.memberUpdate(memberVO);
		return mav;
	}
	
	@RequestMapping(value ="/member/memberInformation.do", method= {RequestMethod.POST,RequestMethod.GET})
	@Override
	public ModelAndView memberInformation(@ModelAttribute ("member") MemberVO memberVO, 
											@RequestParam("id") String id, HttpServletRequest request,HttpServletResponse response) throws Exception {
		viewName = getViewName(request);
		logger.info("viewName"+viewName);
		logger.debug("viewName"+viewName);
		memberVO = memberService.memberSelect(id); 
		ModelAndView mav = new ModelAndView(viewName); 
		mav.addObject("member", memberVO);
		return mav;
	}
	
	

	@RequestMapping(value ="/member/memberDelete.do", method= {RequestMethod.POST,RequestMethod.GET})
	@Override
	public ModelAndView memberDelete(String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		viewName = getViewName(request);
		logger.info("viewName"+viewName);
		logger.debug("viewName"+viewName);
		ModelAndView mav = new ModelAndView("redirect:/member/memberList.do");
		memberService.memberDelete(id);
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

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}
	
	
	
	
}
