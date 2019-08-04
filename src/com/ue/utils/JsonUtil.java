package com.ue.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {

	private static Gson gson = new GsonBuilder().create();

	public static String toJson(Object obj){		
		return gson.toJson(obj);
	}
	
	public static <T> T fromJson(String input,Class<T> cls){
		return gson.fromJson(input, cls);
				
	}	
}

