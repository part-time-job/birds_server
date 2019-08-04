package com.ue.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ue.domain.Event;
import com.ue.service.EventService;
import com.ue.utils.BeanUtils;
import com.ue.utils.LogUtils;

/**
 * 
 * @author bage
 *
 */
@Controller
@RequestMapping("/puretext")
public class PureTextController {
	
	private EventService pureTextService;

	public PureTextController() {
		LogUtils.sysoln("*********PureTextController***********");
		pureTextService = (EventService) BeanUtils.getBean("eventService");
	}
	
	
	@RequestMapping(value="/show")
	public String show(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap){
		LogUtils.sysoln("*********show********");		
		
		List<Event> res = pureTextService.findEventsByUse_id_page(10,2,8,2);
		LogUtils.sysoln(res.toString());
		
		return "index";
	}
		
	
}
