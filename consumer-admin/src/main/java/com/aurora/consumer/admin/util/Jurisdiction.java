package com.aurora.consumer.admin.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import com.aurora.consumer.admin.entity.User;

import antlr.build.Tool;

/**
 * @Title: Jurisdiction.java 
 * @Package com.aurora.consumer.admin.util 
 * @Description: session工具类 
 * @author SSY  
 * @date 2018年4月12日 上午9:23:53 
 * @version V1.0
 */
public class Jurisdiction {
	
	/**
	 * @Title: getUser 
	 * @Description:获取当前登录的用户
	 * @param    
	 * @return User  
	 * @author SSY
	 * @date 2018年4月12日 上午9:24:22
	 */
	public static User getUser(){
		Object object = getSession().getAttribute(Const.SESSION_USER);
		User user = null;
		if (object != null) {
			user = (User)object;
		}else {
			user = new User();
		}
		return user;
	}
	
//	/**
//	 * @Title: getUserName 
//	 * @Description:获取当前登录的用户名
//	 * @param    
//	 * @return String  
//	 * @author SSY
//	 * @date 2018年4月12日 上午9:24:33
//	 */
//	public static String getUserName(){
//		Object object = getSession().getAttribute(Const.SESSION_USER_NAME);
//		String userName = null!=object?object.toString():null;
//		return userName;
//	}
//	
//	/**
//	 * @Title: getUserEmail 
//	 * @Description: 获取当前登录的用户邮箱 
//	 * @param    
//	 * @return String  
//	 * @author SSY
//	 * @date 2018年4月12日 上午9:26:00
//	 */
//	public static String getUserEmail(){
//		Object object = getSession().getAttribute(Const.SESSION_USER);
//		String userEmail = null;
//		if (object != null) {
//			User user = (User)object;
//			userEmail = user.getUserEmail();
//		}
//		return userEmail;
//	}
//	
//	/**
//	 * @Title: getUserID 
//	 * @Description: 获取当前登录的用户id
//	 * @param    
//	 * @return Integer  
//	 * @author SSY
//	 * @date 2018年4月12日 上午9:26:14
//	 */
//	public static Integer getUserID(){
//		Object object = getSession().getAttribute(Const.SESSION_USER);
//		Integer userID = null;
//		if (object != null) {
//			User user = (User)object;
//			userID = user.getUserID();
//		}
//		return userID;
//	}
//	
	
//	/**
//	 * @Title: getSessionCode 
//	 * @Description: 获取session中验证码
//	 * @param    
//	 * @return String  sessionCode
//	 * @author SSY
//	 * @date 2018年4月12日 上午9:26:14
//	 */
//	public static String getSessionCode(){
//		Object object = getSession().getAttribute(Const.SESSION_VERIFICATION_CODE);
//		String sessionCode = null!=object?(String)object:null;
//		return sessionCode;
//	}
	
	
	/**
	 * @Title: getSession 
	 * @Description: shiro管理的session
	 * @param    
	 * @return Session  
	 * @author SSY
	 * @date 2018年4月12日 上午9:26:25
	 */
	public static Session getSession(){ 
		Session session = SecurityUtils.getSubject().getSession();
		session.setTimeout(7200000);//2*60*60*1000=43200000毫秒
		return session;
	}
}
