package com.spring.ex01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ex01.dto.TicketDTO;
import com.spring.ex01.service.TicketService;
import com.spring.ex01.service.TicketServiceImpl;


@Controller
public class TicketController {
	
	
	private TicketService service;
	
	@Autowired
	public void setService(TicketService service) {
		this.service = service;
	}

	@RequestMapping (value = "/ticketBuy")
	public String buyTicketForm(Model model) {
		System.out.println("Buy Ticket");
		return "ticketBuy"; 
	}
	
	//@RequestMapping (value = "/ticketPay", method = {RequestMethod.POST, RequestMethod.GET})
	@RequestMapping (value = "/ticketPay")
	public String buyTicket(TicketDTO ticketDTO, Model model) {
		System.out.println("Pay Ticket");
		//model.addAttribute("request", request);
		service = new TicketServiceImpl();
		service.execute(ticketDTO);
		
		return "ticketResult"; 
	}
}
