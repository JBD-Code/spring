package com.spring.ex01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.ex01.service.TicketService;
import com.spring.ex01.service.TicketServiceImpl;


@Controller
public class TicketController {
	TicketService service;
	

	@RequestMapping (value = "/ticketBuy")
	public String buyTicketForm(Model model) {
		System.out.println("Buy Ticket");
		return "ticketBuy"; 
	}
	
	
	@RequestMapping (value = "/ticketPay", method = {RequestMethod.POST, RequestMethod.GET} )
	public String buyTicket(HttpServletRequest request, Model model) {
		System.out.println("Pay Ticket");
		
		model.addAttribute("request", request);
		service = new TicketServiceImpl();
		service.execute(model);
		return "ticketResult"; 
	}
}
