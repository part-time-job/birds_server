package com.ue.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ue.config.ServerConfig;
import com.ue.domain.Event;
import com.ue.service.AudioService;
import com.ue.service.EventService;
import com.ue.utils.BeanUtils;
import com.ue.utils.JSONUtils;
import com.ue.utils.JsonUtil;
import com.ue.utils.LogUtils;

/**
 * 
 * @author JackW
 *
 */
@Controller
@RequestMapping(value = "/audio")
public class AudioController {
	AudioService audioService;
	EventService eventService;

	public AudioController() {
		// this.audioService = (AudioService) DBUtils.getBean("audioService");
		this.eventService = (EventService) BeanUtils.getBean("eventService");
	}

	@RequestMapping(value = "addAudio")
	public String addAudio(@RequestParam("event") String eventJson, @RequestParam MultipartFile file, HttpServletResponse response, HttpServletRequest request) throws IOException {

		Event event = JsonUtil.fromJson(eventJson, Event.class);
		LogUtils.syso(eventJson);
		LogUtils.syso(file.getName());
		LogUtils.syso("" + eventService.insertEvent(event));
		return null;

	}

	@RequestMapping(value = "allAudio")
	public String getAllAudio(HttpServletResponse response, HttpServletRequest request) throws IOException {

		List<Event> allAudio;
		String pageNow = request.getParameter("pageNow");
		System.out.println(pageNow);
		allAudio = eventService.searchEventAudioByPage(Integer.parseInt(pageNow));
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(JSONUtils.getJson(allAudio));
		LogUtils.syso(JSONUtils.getJson(allAudio) + "pageNow:" + pageNow);
		return null;

	}

	@RequestMapping(value = "addGood")
	public void addGoodToEvent(HttpServletRequest request) {
		String id = request.getParameter("eve_id");
		Event event = eventService.searchEventByEventId(Integer.parseInt(id));
		event.setEve_positivecount(event.getEve_positivecount() + 1);
		eventService.updateEventByEventId(event);
//		LogUtils.syso(event.toString());
	}

	@RequestMapping(value = "getPageNum")
	public void getTotalPage(HttpServletResponse response) throws IOException {
		int pageNum = 0;
		pageNum = eventService.getPageNum(2);
		response.setCharacterEncoding("utf-8");
//		LogUtils.syso("pageNum:" + pageNum);
		pageNum = pageNum % ServerConfig.AUDIO_PAGE_SIZE == 0 ? pageNum / ServerConfig.AUDIO_PAGE_SIZE
				: pageNum / ServerConfig.AUDIO_PAGE_SIZE + 1;
		response.getWriter().write(pageNum + "");
	}
	@RequestMapping(value = "getAudioTopTen")
	public void getAudioTopTen(HttpServletResponse response) throws IOException {
		List<Event> tenAudio;
		tenAudio = eventService.getAudioTopTen();
		response.setCharacterEncoding("utf-8");
		
		LogUtils.sysoln("JSONUtils.getJson(tenAudio):" + JSONUtils.getJson(tenAudio));
		response.getWriter().write(JSONUtils.getJson(tenAudio));
	}
	@RequestMapping(value = "getAudioDetail")
	public String getDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Event event = null;
		response.setCharacterEncoding("utf-8");
		event = eventService.searchEventByEventId(Integer.parseInt(request.getSession().getAttribute(ServerConfig.detailAudio).toString()));
//		LogUtils.syso(event.toString());
		response.getWriter().write(JSONUtils.getJson(event));
		return null;
	}
}
