package com.aurora.consumer.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title: LoginController.java 
 * @Package com.aurora.consumer.admin.controller.system 
 * @Description:登陆注册类 
 * @author SSY  
 * @date 2018年4月11日 下午7:28:19 
 * @version V1.0
 */
@Controller
@RequestMapping("/index")
public class LoginController{
	
	/**
	 * @Title: toLogin 
	 * @Description:  登陆页面
	 * @param    
	 * @return String  
	 * @author SSY
	 * @date 2018年4月12日 上午9:40:54
	 */
	@RequestMapping(value = "/home")
	public String index() throws Exception {
		return "index";
	}
	
}
