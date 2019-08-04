package com.ue.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanUtils {

	private static ApplicationContext ctx = null;

	public static Object getBean(String daoName) {
		if (ctx == null) {
			ctx = new ClassPathXmlApplicationContext("classpath:beans.xml");
		}
		return ctx.getBean(daoName);
	}

}
