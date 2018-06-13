package com.aurora.consumer.admin.controller.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.aurora.consumer.admin.util.Tools;


/**系统异常统一处理
 * @author BYG 2018.3.27
 *
 */
@ControllerAdvice
public class ExceptionController{
	
	@ExceptionHandler(value = Exception.class)
	public ModelAndView resolveException( HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
		System.out.println("==============异常开始=============");
		ex.printStackTrace();
		System.out.println("==============异常结束=============");
		ModelAndView mv = new ModelAndView();
		String exception = Tools.notEmpty(ex.getMessage())?ex.getMessage().replaceAll("\n", "<br/>"):ex.toString();
		mv.addObject("exception",exception);
		mv.setViewName("exception");
		return mv;
		
	}
	
}
