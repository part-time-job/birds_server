package com.ue.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ue.config.ServerConfig;
import com.ue.domain.User;
import com.ue.utils.ObjectUtils;

/**
 * 
 * @author bage
 *
 */

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value="/login")
	public String index(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap){
		User user = ObjectUtils.newUser(3);
		request.getSession().setAttribute(ServerConfig.loginedUser, user);
		modelMap.put("data", "delete is work ...");
		return "index";
	}
	
}
