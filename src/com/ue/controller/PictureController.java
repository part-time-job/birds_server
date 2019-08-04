package com.ue.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Frank
 *
 */
@Controller
@RequestMapping(value="/picture")
public class PictureController {
	@RequestMapping(value="/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap){
//		System.out.println("*********delete********");
		modelMap.put("data", "delete is work ...");
		return new ModelAndView("index");
	}

}
