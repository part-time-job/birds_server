package com.ue.controller;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.ue.utils.BeanUtils;  


@Controller  
@RequestMapping("/code")  
public class CaptchaController {

	private Producer captchaProducer = null;  
  
	public CaptchaController(){
		captchaProducer = (Producer) BeanUtils.getBean("captchaProducer");
	}
	
    @RequestMapping(value = "captcha-image")  
    public ModelAndView getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {  
        
    	HttpSession session = request.getSession();  
        response.setDateHeader("Expires", 0);  
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
        response.setHeader("Pragma", "no-cache");  
        response.setContentType("image/jpeg");  
        
        String capText = captchaProducer.createText();  
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);  
        
        BufferedImage bi = captchaProducer.createImage(capText);  
        ServletOutputStream out = response.getOutputStream();  
        ImageIO.write(bi, "jpg", out);  
        try {  
            out.flush();  
        } finally {  
            out.close();  
        }  
        return null;  
    }  
    
    @RequestMapping(value = "testyanzhengma")  
    public String testyanzhengma(HttpServletRequest request, HttpServletResponse response) throws Exception {  
    	
    	
    	return "yanzhengma";  
    }  
    @RequestMapping(value = "captcha")  
    public String captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {  
    	
    	HttpSession session = request.getSession();      	
        String code = session.getAttribute(Constants.KAPTCHA_SESSION_KEY) + "";  
        System.out.println("captcha: " + code );  
        String captcha = request.getParameter("captcha");
        System.out.println("pcaptcha: " + captcha );  
        String responseText="fialure";
    	if(code.equals(captcha)){
    		responseText = "ok";
    	}
    	response.getWriter().write(responseText);
    	return null;  
    }  
    
}
