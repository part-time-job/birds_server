package com.ue.utils;

import com.google.gson.Gson;

public class JSONUtils {
	static Gson gson = new Gson();
	/**
	 * by jackw
	 * @param object 传入object
	 * @return 返回该object的json格式数据
	 */
	public static String getJson(Object object){
		return gson.toJson(object);
	}
	
}
