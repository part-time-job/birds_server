package com.ue.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ue.test.UserTest;

@Controller
@RequestMapping(value="/home")
public class HomeController {

	private UserTest userTest;	
	
	public HomeController(){
		System.out.println("*********home***********");
		userTest = new UserTest();
	} 
	
	@RequestMapping(value="/add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap){
		System.out.println("********add**********");
		
		//userTest.insert();
		userTest.insert();
		modelMap.put("data", "add is work ...");		
		return new ModelAndView("/home");
	}
	
	@RequestMapping(value="/delete")
	public String delete(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap){
		System.out.println("*********delete********");
		
		//userTest.deleteid();
		userTest.deletename();
		
		modelMap.put("data", "delete is work ...");
		return "home";
	}
	
	@RequestMapping(value="/update")
	public String update(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap){
		System.out.println("*********update*********");
		modelMap.put("data", "update is work ...");
		
		//userTest.updateid();
		userTest.updatename();
		
		return "home";
	}
	
	@RequestMapping(value="/search")
	public String search(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap){
		System.out.println("********search*********");
		
		//userTest.searid();
		//userTest.searname();
		userTest.getAllUsers();
		
		modelMap.put("data", "search is work ...");
		return "home";
	}
}
