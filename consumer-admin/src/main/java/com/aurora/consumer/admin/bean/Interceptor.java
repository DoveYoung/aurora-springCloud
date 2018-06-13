package com.aurora.consumer.admin.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.aurora.consumer.admin.entity.User;
import com.aurora.consumer.admin.util.Const;
import com.aurora.consumer.admin.util.Jurisdiction;

/**
 * @Title: AuthenticationInterceptor.java 
 * @Package com.aurora.consumer.admin.interceptor 
 * @Description:用户身份认证拦截,自定义拦截器,需实现 HandlerInterceptor
 * @author SSY
 * @date 2018年4月11日 上午11:45:01 
 * @version V1.0
 */
@Component
public class Interceptor implements HandlerInterceptor {
	
	/**
	 * @Title: preHandle 
	 * @Description: 对用户请求路径，进行权限二次验证。
	 * @param  preHandle 
	 * @return boolean  
	 * @author BYG
	 * @date 2018年4月24日 上午11:49:08
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String path = request.getServletPath();
		User user = Jurisdiction.getUser();
		if(user != null){
			path = path.substring(1, path.length());
			Subject subject = SecurityUtils.getSubject();
			if(subject.isPermitted(path)){
				return true;
			}
			return false;
		}else{
			response.sendRedirect(request.getContextPath() + Const.LOGIN_PATH);	//未登录请登陆
			return false;		
		}
	}
	
	/**
	 * @Title: afterCompletion 
	 * @Description: 记录操作;
	 * @param     
	 * @return    
	 * @author SSY
	 * @date 2018年4月11日 上午11:49:08
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)throws Exception {
//		String path = request.getServletPath();
//		if(path.matches(Const.NO_INTERCEPTOR_PATH1) || path.matches(Const.NO_INTERCEPTOR_PATH2)){
//			return;
//		}else {
//			OperationRecord or = new OperationRecord();
//			Session session = Jurisdiction.getSession();
//			Object userID = session.getAttribute(Const.SESSION_USER_ID);
//			Object userEmail = session.getAttribute(Const.SESSION_USER_EMAIL);
//			String parameter = JSON.toJSONString(request.getParameterMap());
//			String host = request.getRemoteHost();
//			String time = DateUtil.getTime();
//			PageData pd = new PageData();
//			pd.put("userID", userID);
//			pd.put("userEmail", userEmail);
//			pd.put("path", path);
//			pd.put("parameter", parameter);
//			pd.put("host", host);
//			pd.put("time", time);
//			operationRecordServiceImpl.saveOperationRecord(pd);
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)throws Exception{
		// TODO Auto-generated method stub
		
	}
	

	
 
}

