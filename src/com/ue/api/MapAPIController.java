package com.ue.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ue.domain.Event;
import com.ue.service.CommentService;
import com.ue.service.EventCommentUserServiceImp;
import com.ue.service.EventService;
import com.ue.service.UserService;
import com.ue.utils.BeanUtils;
import com.ue.utils.JsonUtil;
import com.ue.utils.LogUtils;

@Controller
@RequestMapping(value = "/api/map")
@MultipartConfig
public class MapAPIController {
	private EventService mapEventService;
	private UserService mapUserService;
	private CommentService mapCommentService;
	private EventCommentUserServiceImp mapCUSI;

	public MapAPIController() {
		LogUtils.sysoln("*********MapAPIController***********");
		mapEventService = (EventService) BeanUtils.getBean("eventService");
		mapUserService = (UserService) BeanUtils.getBean("userService");
		mapCommentService = (CommentService)BeanUtils.getBean("commentService");
		mapCUSI = (EventCommentUserServiceImp)BeanUtils.getBean("eventCommentUserService");
	}
	@RequestMapping(value = "/userCount")
	public String getUserCount(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		int count = mapUserService.getUserCount();
		String countString = count+"";
		response.getWriter().write(countString);
		return null;
	}
	
	@RequestMapping(value = "/eventCount")
	public String getEventCount(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		int count = mapEventService.getEventCount();
		String countString = count+"";
		response.getWriter().write(countString);
		return null;
	}
	@RequestMapping(value = "/countBirds")
	public String countBirds(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		long count = mapCUSI.countBirds();
		String countString = count+"";
		response.getWriter().write(countString);
		return null;
	}
	@RequestMapping(value = "/commentCount")
	public String getCommentCount(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		long count = mapCommentService.getCommentCount();
		String countString = count+"";
		response.getWriter().write(countString);
		return null;
	}
	@RequestMapping(value = "/getAllEvent")
	public String getAllEvent(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		List<Event> list = mapEventService.getAllEvent();
		String allEvent = JsonUtil.toJson(list);
		response.getWriter().write(allEvent);
		return null;
	}
	@RequestMapping(value = "/getEventById")
	public String getEventById(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		int eventId = Integer.parseInt(request.getParameter("eventId"));
		Event event = mapEventService.searchEventByEventId(eventId);
		String eventStr = JsonUtil.toJson(event);
		response.getWriter().write(eventStr);
		return null;
	}
}
