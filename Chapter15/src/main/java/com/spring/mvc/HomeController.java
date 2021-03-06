package com.spring.mvc;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	@RequestMapping(value="/memberForm", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws SerialException, IOException {
		request.setCharacterEncoding("UTF-8");
		ModelAndView mav = new ModelAndView();
		mav.getViewName();
		return mav; 
	}
	@RequestMapping(value="/memberList", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView memberList(Model model, HttpServletRequest rquest, HttpServletResponse response) throws ServletException, IOException{
		model.addAttribute("memberList", "회원1");
		ModelAndView mav = new ModelAndView();
		mav.getViewName();
		return mav;
	}
	
	@RequestMapping(value = "/memberInfo", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav= new ModelAndView();
		mav.addObject("id", "admin");
		mav.getViewName();
		return mav;
	}
	@RequestMapping(value = "/memberInsert", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView memberInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ModelAndView mav= new ModelAndView();
		mav.addObject("id", "admin");
		mav.getViewName();
		return mav;
	}
	
}
