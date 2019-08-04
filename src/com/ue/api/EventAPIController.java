package com.ue.api;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ue.config.ServerConfig;
import com.ue.domain.Event;
import com.ue.domain.User;
import com.ue.service.EventService;
import com.ue.utils.BeanUtils;
import com.ue.utils.FileUtils;
import com.ue.utils.JSONUtils;
import com.ue.utils.JavaUtils;
import com.ue.utils.JsonUtil;
import com.ue.utils.LogUtils;

@Controller // 
@RequestMapping(value = "/api/event") // url映射
public class EventAPIController {
	
	private EventService eventService;

	public EventAPIController() {
		LogUtils.sysoln("*********PureTextController***********");
		eventService = (EventService) BeanUtils.getBean("eventService");
	}

	@RequestMapping(value = "/puretext/countPage")
	public String puretextCountPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		LogUtils.sysoln("*********countPage********");

		int count_page = eventService.countPage(Event.DATATYPE_PURETEXT, ServerConfig.page_length);

		response.getWriter().write(" " + count_page);
		// LogUtils.sysoln("count_page:" + count_page);

		return null;
	}

	@RequestMapping(value = "/puretext/myinfocountPage")
	public String puretextMyinfoCountPage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		LogUtils.sysoln("*********countPage********");
		int use_id = getUseId(request);
		int count_page = eventService.countPageUse_id(use_id, Event.DATATYPE_PURETEXT, ServerConfig.page_length);
		response.getWriter().write(" " + count_page);
		// LogUtils.sysoln("count_page:" + count_page);

		return null;
	}

	@RequestMapping(value = "/puretext/first")
	public String puretextFirst(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		LogUtils.sysoln("*********puretext/first********");

		List<Event> res = eventService.findEventsByPage(1, Event.DATATYPE_PURETEXT, ServerConfig.page_length);

		response.getWriter().write(JsonUtil.toJson(res));

		//LogUtils.sysoln("鏈洪偅閲宨浜嗘璧�" + JavaUtils.toString(res));

		return null;
	}

	@RequestMapping(value = "/puretext/myinfofirst")
	public String puretextMyinfofirst(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		LogUtils.sysoln("*********puretext/first********");
		int use_id = getUseId(request);
		List<Event> res = eventService.findEventsByUse_id_page(1, use_id, Event.DATATYPE_PURETEXT,
				ServerConfig.page_length);

		response.getWriter().write(JsonUtil.toJson(res));

		return null;
	}

	@RequestMapping(value = "/puretext/myinfoprevious")
	public String puretextMyinfoPrevious(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		LogUtils.sysoln("*********puretext/previous********");
		String currentPage = request.getParameter("currentPage").trim();
		int sp = Integer.parseInt(currentPage);
		int use_id = getUseId(request);
		List<Event> res = eventService.findEventsByUse_id_page(sp - 1, use_id, Event.DATATYPE_PURETEXT,
				ServerConfig.page_length);
		response.getWriter().write(JsonUtil.toJson(res));

		// LogUtils.sysoln(JavaUtils.toString(res));

		return null;
	}

	@RequestMapping(value = "/puretext/previous")
	public String puretextPrevious(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		LogUtils.sysoln("*********puretext/previous********");
		String currentPage = request.getParameter("currentPage").trim();
		int sp = Integer.parseInt(currentPage);
		List<Event> res = eventService.findEventsByPage(sp - 1, Event.DATATYPE_PURETEXT, ServerConfig.page_length);

		response.getWriter().write(JsonUtil.toJson(res));

		// LogUtils.sysoln(JavaUtils.toString(res));

		return null;
	}

	@RequestMapping(value = "/puretext/myinfonext")
	public String puretextMyinfoNext(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		LogUtils.sysoln("*********/puretext/next********");

		String currentPage = request.getParameter("currentPage");
		int sp = Integer.parseInt(currentPage);
		int use_id = getUseId(request);
		List<Event> res = eventService.findEventsByUse_id_page(sp + 1, use_id, Event.DATATYPE_PURETEXT,
				ServerConfig.page_length);
		response.getWriter().write(JsonUtil.toJson(res));

		// LogUtils.sysoln(JavaUtils.toString(res));

		return null;
	}

	@RequestMapping(value = "/puretext/next")
	public String puretextNext(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		LogUtils.sysoln("*********/puretext/next********");

		String currentPage = request.getParameter("currentPage");
		int sp = Integer.parseInt(currentPage);
		List<Event> res = eventService.findEventsByPage(sp + 1, Event.DATATYPE_PURETEXT, ServerConfig.page_length);

		response.getWriter().write(JsonUtil.toJson(res));

		// LogUtils.sysoln(JavaUtils.toString(res));

		return null;
	}

	@RequestMapping(value = "/puretext/myinfolast")
	public String puretextMyinfoLast(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		LogUtils.sysoln("*********/puretext/last********");

		int use_id = getUseId(request);
		List<Event> res = eventService.findEventsByUse_id_page(-1, use_id, Event.DATATYPE_PURETEXT,
				ServerConfig.page_length);
		response.getWriter().write(JsonUtil.toJson(res));

		// LogUtils.sysoln(JavaUtils.toString(res));

		return null;
	}

	@RequestMapping(value = "/puretext/last")
	public String puretextLast(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		LogUtils.sysoln("*********/puretext/last********");

		List<Event> res = eventService.findEventsByPage(-1, Event.DATATYPE_PURETEXT, ServerConfig.page_length);

		response.getWriter().write(JsonUtil.toJson(res));

		// LogUtils.sysoln(JavaUtils.toString(res));

		return null;
	}

	@RequestMapping(value = "/puretext/top")
	public String top10(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws IOException {

		response.setCharacterEncoding("utf-8");

		LogUtils.sysoln("*********/puretext/top********");

		List<Event> res = eventService.findEventsByPage(1, Event.DATATYPE_PURETEXT, ServerConfig.PURETEXT_PAGE_SIZE);

		response.getWriter().write(JsonUtil.toJson(res));

		// LogUtils.sysoln(JavaUtils.toString(res));

		return null;
	}

	@RequestMapping(value = "/getDataOfPictureByPage")
	public String getDataOfPictureByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("****getDataOfPictureByPage****");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		int pageNow = Integer.parseInt(request.getParameter("pageNow"));
		// System.out.println(pageNow);
		EventService es = (EventService) BeanUtils.getBean("eventService");
		// System.out.println(es);
		List<Event> list = es.searchEventPictureByPage(pageNow);
		String jsonList = JSONUtils.getJson(list);
		// System.out.println(jsonList);
		response.getWriter().write(jsonList);
		return null;
	}

	@RequestMapping(value = "/getDataOfPictureByPageOfUser")
	public String getDataOfPictureByPageOfUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		System.out.println("****getDataOfPictureByPageOfUser****");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		int pageNow = Integer.parseInt(request.getParameter("pageNow"));
		int userId = Integer.parseInt(request.getParameter("userId"));

		return null;
	}

	@RequestMapping(value = "/addPicturePositiveCount")
	public String addPicturePositiveCount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("****addPicturePositiveCount****");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		int eventId = Integer.parseInt(request.getParameter("eventId"));
		System.out.println(eventId);
		EventService es = (EventService) BeanUtils.getBean("eventService");
		Event event = es.searchEventByEventId(eventId);
		event.setEve_positivecount(event.getEve_positivecount() + 1);
		boolean res = es.updateEventByEventId(event);
		String resCode = res ? "1" : "0";
		response.getWriter().write(resCode);
		return null;
	}

	private int getUseId(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(ServerConfig.loginedUser);
		if (user == null) {
			return -1;
		}
		return user.getUse_id();
	}
	
	// 含有文件的事件上传
	@RequestMapping(value = "/upload/puretext")
	public void puretextUpload(@RequestParam("event") String eventJson, HttpServletRequest request , HttpServletResponse response) throws IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		Event event = JsonUtil.fromJson(eventJson, Event.class);
		boolean res = eventService.insertEvent(event);
		LogUtils.sysoln(" ;; " + eventJson);		
		response.getWriter().write(res + "");
	}
	@RequestMapping(value = "/upload/audio")
	public void audioUpload(@RequestParam("event") String eventJson, HttpServletRequest request ,@RequestParam("audioFile") MultipartFile file, HttpServletResponse response) throws IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		//LogUtils.sysoln(file.getOriginalFilename() +  " ;; " + eventJson);	
		LogUtils.sysoln(" ;; " + eventJson);
		Event event;
		event = JsonUtil.fromJson(eventJson, Event.class);
		
		LogUtils.syso(file.getOriginalFilename() + "  " + file.getName());
		String path = request.getServletContext().getRealPath("/user")+"/audio/" + file.getOriginalFilename();
		event.setEve_audiourl(file.getOriginalFilename());
		boolean res = FileUtils.storeFile(path, file);
		if(res){
			res = eventService.insertEvent(event);
		}
		response.getWriter().write(res+"");
	}
	@RequestMapping(value = "/upload/picture")
	public void pictureUpload(@RequestParam("event") String eventJson, HttpServletRequest request ,@RequestParam("pictureFile") MultipartFile file, HttpServletResponse response) throws IOException {
		
		Event event;
		System.out.println(eventJson);
		event = JsonUtil.fromJson(eventJson, Event.class);
		System.out.println(event.toString());
		
		LogUtils.syso(file.getOriginalFilename() + "  " + file.getName());
		String filename = event.getEve_time() + "pic.jpg";
		String path = request.getServletContext().getRealPath("/user")+"/picture/" + filename;
		event.setEve_pictureurl(filename);
		boolean res = FileUtils.storeFile(path, file);
		if(res){
			res = eventService.insertEvent(event);
		}
		response.getWriter().write(res+"");
		
		
	}
	
}
