package com.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.service.MemberService;
import com.spring.member.vo.MemberVO;

public class MemberControllerImpl extends MultiActionController implements MemberController {

	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public ModelAndView memberList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
			String viewName = getViewName(request);
			System.out.println("viewName = "+ viewName);
			List<MemberVO>memberList = memberService.listMember();
			ModelAndView mav =new ModelAndView(viewName);
			mav.addObject("memberList", memberList);

		return mav;
	}
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
			
			String viewName = getViewName(request);
			System.out.println("viewName = "+ viewName);
			ModelAndView mav = new ModelAndView();
			mav.setViewName(viewName);
		
		return mav;
	}
	
	
	@Override
	public ModelAndView memberInsert(HttpServletRequest request, HttpServletResponse response)
			throws DataAccessException, Exception {
			
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			memberService.insertMember(memberVO);
			ModelAndView mav = new ModelAndView("redirect:/member/memberList.do");
		
		return mav;
	}
	

	@Override
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response)
			throws DataAccessException, Exception {
			
			String id = request.getParameter("id");
			MemberVO memberVO = new MemberVO();
			String viewName = getViewName(request); 
			System.out.println("viewName = "+ viewName);
			memberVO = memberService.selectMember(id);
			
			ModelAndView mav = new ModelAndView(viewName);
			mav.addObject("memberVO", memberVO);
		
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
