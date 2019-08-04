package com.ue.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ue.utils.LogUtils;

@Controller
@RequestMapping(value="/api/test")
public class Test {

	@RequestMapping(value="/test")
	public String delete(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		System.out.println("*********get***********");		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8"); 
		
		String test = request.getParameter("test");
		LogUtils.sysoln("test:" + test);
		String responseText = "分分合合会复发和萨芬撒娇价格价格和";					
		response.getWriter().write(responseText);
		
		return null;
	}
	@RequestMapping(value="/get2")
	public String delete2(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		System.out.println("*********get***********");		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8"); 
		
		String responseText = "分分合合会复发和萨芬撒娇价格价格和";					
		response.getWriter().write(responseText);
		
		return null;
	}
	
}
