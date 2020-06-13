package com.spring.ex01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.ex01.command.BoardCommand;
import com.spring.ex01.command.boardContentImpl;
import com.spring.ex01.command.boardDeleteImpl;
import com.spring.ex01.command.boardListImpl;
import com.spring.ex01.command.boardModifyImpl;
import com.spring.ex01.command.boardWriteImpl;
import com.spring.ex01.command.replyViewImpl;
import com.spring.ex01.command.replyWriteImpl;
import com.spring.ex01.util.Constant;

@Controller
public class BoardController {
	BoardCommand command;
	JdbcTemplate template ; 
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template= this.template;
	}
	@RequestMapping(value = "/boardList")
	public String list(Model model) {
		System.out.println("List");
		command = new boardListImpl();
		command.execute(model);
		
		return "boardList"; 
	}
	@RequestMapping(value= "/boardWriteForm")
	public String boardForm(Model model) {
		System.out.println("WriteForm");
		
		return "boardWrite";
	}
	@RequestMapping(value="/boardWrite", method = RequestMethod.POST)
	public String boardWrite(HttpServletRequest request, Model model) {
		System.out.println("Write");
		model.addAttribute("request", request);
		command = new boardWriteImpl();
		command.execute(model);
		return "redirect:boardList"; 
	}
	@RequestMapping(value="/boardContent", method = {RequestMethod.POST, RequestMethod.GET})
	public String boardContent(HttpServletRequest request, Model model) {
		System.out.println("boardContent");
		model.addAttribute("request", request);
		command = new boardContentImpl();
		command.execute(model);
		return "boardContent"; 
	}
	@RequestMapping(value="/boardModify", method = RequestMethod.POST)
	public String boardModify(HttpServletRequest request, Model model) {
		System.out.println("boardModify");
		model.addAttribute("request", request);
		command= new boardModifyImpl(); 
		command.execute(model);
		
		return "redirect:boardList";
	}
	/*
	@RequestMapping(value="/boardReplyView", method = RequestMethod.POST)
	public String boardReplyView(HttpServletRequest request, Model model) {
		System.out.println("boardReplyView");
		model.addAttribute("request", request);
		command= new replyViewImpl(); 
		command.execute(model);
		
		return "boardReplyView";
	}
	*/
	@RequestMapping(value="/boardReplyWrite", method = RequestMethod.POST)
	public String boardReplyWrite(HttpServletRequest request, Model model) {
		System.out.println("boardReplyWrite");
		model.addAttribute("request", request);
		command= new replyWriteImpl(); 
		command.execute(model);
		
		return "redirect:boardList";
	}
	@RequestMapping(value="/boardReplyDelete", method = RequestMethod.POST)
	public String boardReplyDelte(HttpServletRequest request, Model model) {
		System.out.println("boardReplyDelete");
		model.addAttribute("request", request);
		command= new boardDeleteImpl(); 
		command.execute(model);
		
		return "redirect:boardList";
	}
	@RequestMapping(value="/boardDelete", method = {RequestMethod.POST, RequestMethod.GET})
	public String boardDelte(HttpServletRequest request, Model model) {
		System.out.println("boardDelete");
		model.addAttribute("request", request);
		command= new boardDeleteImpl(); 
		command.execute(model);
		
		return "redirect:boardList";
	}
}
 