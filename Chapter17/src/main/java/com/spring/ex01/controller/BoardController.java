package com.spring.ex01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ex01.command.BoardCommand;
import com.spring.ex01.command.boardListImpl;

@Controller
public class BoardController {
	BoardCommand command;
	
	@RequestMapping(value = "/boardList")
	public String list(Model model) {
		System.out.println("List");
		command = new boardListImpl();
		command.execute(model);
		
		return "boardList"; 
	}
}
