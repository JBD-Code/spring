package com.spring.ex01.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex01.dao.BoardDAO;
import com.spring.ex01.dto.BoardDTO;

public class boardContentImpl implements BoardCommand {
	
	BoardDAO dao;
	
	@Override
	public void execute(Model model) {
		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int idx = Integer.parseInt(request.getParameter("idx"));
		System.out.println("idx");
		dao = new BoardDAO(); 
		BoardDTO dto = dao.select(idx);
		model.addAttribute("dto", dto);
		
	}

	
}
