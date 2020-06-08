package com.spring.ex01.command;

import java.util.List;

import org.springframework.ui.Model;

import com.spring.ex01.dao.BoardDAO;
import com.spring.ex01.dto.BoardDTO;

public class boardListImpl implements BoardCommand{
	
	BoardDAO dao; 
		
	@Override
	public void execute(Model model) {
		
		BoardDAO dao = new BoardDAO();
 		List<BoardDTO>list = dao.list();
 		model.addAttribute("list", list);
		
	}

	
}
