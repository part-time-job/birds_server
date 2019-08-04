package com.ue.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ue.config.ServerConfig;
import com.ue.domain.User;
import com.ue.service.UserService;
import com.ue.utils.BeanUtils;
import com.ue.utils.JsonUtil;
import com.ue.utils.LogUtils;

@Controller
@RequestMapping("/api/user")
public class UserAPIController {

	private UserService userService;

	public UserAPIController() {
		userService = (UserService) BeanUtils.getBean("userService");
	}

	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/text;charset=UTF-8");
		com.ue.utils.LogUtils.sysoln("*************login************");

		String use_phone = request.getParameter("use_phone");
		String use_password = request.getParameter("use_password");

		User user = userService.searchUserByPhone(use_phone);
		// com.ue.utils.LogUtils.sysoln(user + "");
		String responseText = "登录成功";
		if (user == null) {
			responseText = "手机号不存在";
		} else {
			if (!user.getUse_password().equals(use_password)) {
				responseText = "密码错误";
			} else {
				// 将密码置为空
				user.setUse_password("");
				responseText = JsonUtil.toJson(user);
				request.getSession().setAttribute(ServerConfig.loginedUser, user);
			}
		}
		response.getWriter().write(responseText);
		return null;

	}
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/text;charset=UTF-8");
		
		com.ue.utils.LogUtils.sysoln("*************logout************");
		
		request.getSession().setAttribute(ServerConfig.loginedUser,null);
		
		return null;		
	}

	@RequestMapping(value = "/register")
	public String register(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/text;charset=UTF-8");
		com.ue.utils.LogUtils.sysoln("*************register************");

		String use_phone = request.getParameter("use_phone");
		String use_password = request.getParameter("use_password");
		String use_sex = request.getParameter("use_sex");
		String use_name = request.getParameter("use_name");
		User user = userService.searchUserByPhone(use_phone);
		// com.ue.utils.LogUtils.sysoln(user + "");
		String responseText = "注册失败";
		if (user == null) {
			user = new User();
			user.setUse_phone(use_phone);
			user.setUse_password(use_password);
			user.setUse_name(use_name);
			user.setUse_sex(use_sex);
			boolean res = userService.insertUser(user);
			if (res) {
				responseText = "注册成功";
			}
		} else {
			responseText = "该手机号已经注册过";
		}
		response.getWriter().write(responseText);
		return null;

	}

	@RequestMapping(value = "/myinfo")
	public String myinfo(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/text;charset=UTF-8");
		LogUtils.sysoln("*********myinfo2********");

		User loginedUser = (User) request.getSession().getAttribute(ServerConfig.loginedUser);
		String responseText = "请先登录";
		if (loginedUser != null) {
			//User user = userService.searchUserById(loginedUser.getUse_id());
			responseText = JsonUtil.toJson(loginedUser);
		}
		response.getWriter().write(responseText);
		LogUtils.sysoln(responseText);
		return null;
	}

	@RequestMapping(value = "/save")
	public String save(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/text;charset=UTF-8");
		LogUtils.sysoln("*********save********");

		User loginedUser = (User) request.getSession().getAttribute(ServerConfig.loginedUser);
		String responseText = "请先登录";
		if (loginedUser != null) {
			responseText = "保存失败";
			String userJson = request.getParameter("user");
			if (userJson == null || "".equals(userJson)) {
				responseText = "输入不合法";
			} else {
				User user = JsonUtil.fromJson(userJson, User.class);				
				User userr = userService.searchUserById(loginedUser.getUse_id());
				user.setUse_password(userr.getUse_password());
				boolean res = userService.updateUserById(loginedUser.getUse_id(), user);
				if (res) {
					responseText = userJson;
				}
			}

		}
		response.getWriter().write(responseText);
		LogUtils.sysoln(responseText);
		return null;
	}

}
