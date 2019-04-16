package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WorldController {

	
	@RequestMapping(value = {"/main/main", "/mobile/main/main"}, method = RequestMethod.GET)
	public String mainPage(Model model,HttpServletRequest request) {
		
		return "main/mainPage";
	}
	
}
