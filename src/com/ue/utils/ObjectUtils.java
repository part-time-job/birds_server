package com.ue.utils;

import com.ue.domain.Event;
import com.ue.domain.User;

public class ObjectUtils {

	public static User newUser(int i){
		String add = "";
		if(i < 10){
			add = "0";
		}
		User user = new User(i, "136015092"+add + i, "张三"+i, "123456", "男", "2016-03-27", "user_default.png", "12345678@qq.com", i, "我是河海大学常州校区学生，我是河海大学常州校区学生，我是河海大学常州校区学生", "计算机、程序员、web、Android");
		return user;
		
	}
	
	public static Event newEvent(int i){
		Event eve = new Event(i, i, i, i, "你觉得这里有几只鸟？", "2016-03-27", i, i, i % 3, "今天很开心，看到了这只从来没有见到过的小鸟，给大家看看，希望大家喜欢，今天很开心，看到了这只从来没有见到过的小鸟，给大家看看，希望大家喜欢，今天很开心，看到了这只从来没有见到过的小鸟，给大家看看，希望大家喜欢，今天很开心，看到了这只从来没有见到过的小鸟，给大家看看，希望大家喜欢" + i, i % 30 + ".mp3", "demo"+i%12+".jpg", "嘿嘿，你喜欢么，不管你是喜欢不喜欢，反正我很喜欢，不管你是喜欢不喜欢，反正我很喜欢，不管你是喜欢不喜欢，反正我很喜欢，不管你是喜欢不喜欢，反正我很喜欢，不管你是喜欢不喜欢，反正我很喜欢，不管你是喜欢不喜欢，反正我很喜欢", "好看、新奇、难得一见");
//		if(i % 3 == 2){
//			eve.setEve_audiourl("../resources/1.mp3");
//		}
//		if(i % 3 == 1){
//			eve.setEve_pictureurl("demo"+JavaUtils.nextInt(12)+".jpg");
//		}
		return eve;
		
	}
	
}
