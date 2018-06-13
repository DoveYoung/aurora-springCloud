package com.aurora.provider.user.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.aurora.provider.user.service.MenuService;
import com.aurora.provider.user.service.RoleService;
import com.aurora.provider.user.service.UserService;
import com.aurora.provider.user.util.Page;
import com.aurora.provider.user.util.PageData;

/**
 * @Title: BaseController.java 
 * @Package com.aurora.consumer.admin.controller.base 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author SSY  
 * @date 2018年4月11日 上午11:44:47 
 * @version V1.0
 */
public class BaseController {
	
	protected Logger logger = Logger.getLogger(this.getClass());

	private static final long serialVersionUID = 6357869213649815390L;
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	MenuService menuService;
	
	
	/**
	 * @Title: getPageData 
	 * @Description:  new PageData
	 * @param    getPageData 
	 * @return PageData  
	 * @author SSY
	 * @date 2018年4月11日 上午11:49:08
	 */
	public PageData getPageData(){
		return new PageData(this.getRequest());
	}
	
	/**得到ModelAndView
	 * @return
	 */
	public ModelAndView getModelAndView(){
		return new ModelAndView();
	}
	
	/**得到request
	 * @return
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
	 
 
	
	/**得到分页列表信息
	 * @return
	 */
	public Page getPage(){
		return new Page();
	}
	
	public static void logBefore(Logger logger, String interfaceName){
		logger.info("");
		logger.info("start");
		logger.info(interfaceName);
	}
	
	public static void logAfter(Logger logger){
		logger.info("end");
		logger.info("");
	}
	
}
