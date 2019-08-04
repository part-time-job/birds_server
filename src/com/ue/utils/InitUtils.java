package com.ue.utils;

import java.util.ArrayList;
import java.util.List;

import com.ue.domain.Event;
import com.ue.domain.User;
import com.ue.service.EventService;
import com.ue.service.EventServiceImp;
import com.ue.service.UserService;
import com.ue.service.UserServiceImp;

public class InitUtils {
	
	public static List<Event> initEvents(int n) {
		
		List<Event> list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			list.add(ObjectUtils.newEvent(i));
		}
		return list;
	}
	public static void initDBEvents(int n) {
		
		EventService s= new EventServiceImp();
		
		for (int i = 0; i < n; i++) {
			Event temp = ObjectUtils.newEvent(i);
			temp.setUse_id(i % 20 + 1);
			s.insertEvent(temp);
		}
		
	}
	public static void initDBUsers(int n) {
		
		UserService s= new UserServiceImp();
		
		for (int i = 0; i < n; i++) {
			User user = ObjectUtils.newUser(i);
			s.insertUser(user);
		}
		
	}

	public static void main(String[] args) {
//		List<Event> list = initEvents(10);
//		System.out.println(JavaUtils.toString(list));
		
		initDBEvents(240);
		
		initDBUsers(20);
	}
}
