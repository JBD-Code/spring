package com.spring.ex01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.ex01.dao.TicketDAO;
import com.spring.ex01.dto.TicketDTO;


@Controller
public class TicketController {
	TicketDAO dao; 
	
	@Autowired
	public void setDao(TicketDAO dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping (value ="/buyTicket")
	public String buyTicket(Model model) {
		System.out.println("Buy Ticket");
		return "ticketBuy"; 
		 
	}
	
	@RequestMapping (value ="/payTicket", method= {RequestMethod.POST, RequestMethod.GET})
	public String payTicket(TicketDTO dto, Model model) {
		System.out.println("Pay Ticket");
		System.out.println(dto.getConsumerID());
		System.out.println(dto.getAmount());
		System.out.println(dto.getPaymentDate());
		
		dao.payTicket(dto);
		model.addAttribute("dto", dto);
		return "ticketBuy"; 
		 
	}
}
