package com.aurora.consumer.admin.controller.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;


/** 系统错误统一处理
 * @author BYG 2018.3.27
 *
 */
@Controller
public class MyErrorController extends BasicErrorController{

	public MyErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
		super(errorAttributes, errorProperties);
	}


	@Override
	public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
		HttpStatus status = getStatus(request);
		ModelAndView mv = new ModelAndView();
		if (status == HttpStatus.NOT_FOUND) {
			mv.setViewName("404");
		}else {
			mv.setViewName("500");
		}
		return mv;
	}
	
}
