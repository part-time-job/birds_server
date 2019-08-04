package com.ue.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ue.utils.LogUtils;

@Controller
@RequestMapping(value="/index")
public class IndexController {

	@RequestMapping(value="/index")
	public String index(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap){
		LogUtils.sysoln("*********delete********");
		
		
		modelMap.put("data", "delete is work ...");
		return "index";
	}
	
	@RequestMapping(value="/audioDetail")
	public String audioDetail(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap){
		LogUtils.sysoln("*********indexmap********");		
		return "audiodetail";
	}
	
	@RequestMapping(value="/indexmap")
	public String indexmap(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap){
		LogUtils.sysoln("*********indexmap********");		
		return "indexmap";
	}
	@RequestMapping(value="/myinfo")
	public String myinfo(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap){
		
		LogUtils.sysoln("*********myinfo********");
		
		return "myinfo";
	}
	
	@RequestMapping(value="/aboutme")
	public String aboutme(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap){
		LogUtils.sysoln("*********aboutme********");	
		
		return "aboutme";
	}
	
	@RequestMapping(value="/picture")
	public String picture(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap){
		LogUtils.sysoln("*********picture********");	
		
		return "picture";
	}
	
	@RequestMapping(value="/audio")
	public String audio(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap){
		LogUtils.sysoln("*********audio********");	
		
		return "audio";
	}
	
	@RequestMapping(value="/puretext")
	public String puretext(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap){
		LogUtils.sysoln("*********puretext********");	
		
		return "puretext";
	}
	
	@RequestMapping(value="/contact")
	public String contact(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap){
		LogUtils.sysoln("*********contact********");	
		
		return "contact";
	}
	
	@RequestMapping(value="/puredetail")
	public String puredetail(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap){
		LogUtils.sysoln("*********puredetail********");	
		
		return "puredetail";
	}
}
