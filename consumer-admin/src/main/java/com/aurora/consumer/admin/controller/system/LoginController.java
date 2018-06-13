package com.aurora.consumer.admin.controller.system;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.aurora.consumer.admin.controller.base.BaseController;
import com.aurora.consumer.admin.entity.Result;
import com.aurora.consumer.admin.entity.User;
import com.aurora.consumer.admin.util.Const;
import com.aurora.consumer.admin.util.DateUtil;
import com.aurora.consumer.admin.util.Jurisdiction;
import com.aurora.consumer.admin.util.Tools;

/**
 * @Title: LoginController.java 
 * @Package com.aurora.consumer.admin.controller.system 
 * @Description:登陆注册类 
 * @author SSY  
 * @date 2018年4月11日 下午7:28:19 
 * @version V1.0
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	
	/**
	 * @Title: toLogin 
	 * @Description:  登陆页面
	 * @param    
	 * @return String  
	 * @author SSY
	 * @date 2018年4月12日 上午9:40:54
	 */
	@RequestMapping(value = "/toLogin")
	public String toLogin() throws Exception {
		return "admin/index/login";
	}
	
	/**
	 * @Title: login 
	 * @Description: 登陆验证
	 * @param    String userEmail, String password,String code
	 * @return Object  
	 * @author SSY
	 * @date 2018年4月12日 上午9:43:57
	 */
	@RequestMapping(value = "/verify", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Result<Object> loginVerify(String userEmail, String password,String code) throws Exception {
		Result<Object> result = new Result<Object>();
		if (Tools.isEmpty(userEmail) || Tools.isEmpty(password)) {
			result.setMsg("登陆信息不完整！");
			result.setState(Result.STATE_ERROR);
			return result;
		}
		try {
			Subject subject = SecurityUtils.getSubject(); // shiro身份验证
			UsernamePasswordToken token = new UsernamePasswordToken(userEmail.replace(" ", ""), password.replace(" ", ""));
			subject.login(token);
			result.setState(Result.STATE_SUCCESS);
		} catch (UnknownAccountException uae) {
			result.setMsg("账号不存在！");
			result.setState(Result.STATE_ERROR);
			logger.info("【ERROR："+DateUtil.getTime()+"用户登陆账号不存在！】");
		} catch (IncorrectCredentialsException iae) {
			result.setMsg("密码不正确！");
			result.setState(Result.STATE_ERROR);
			logger.info("【ERROR："+DateUtil.getTime()+"用户登陆密码不正确！】");
		} catch (LockedAccountException lae) {
			result.setMsg("账号被禁用！");
			result.setState(Result.STATE_ERROR);
			logger.info("【ERROR："+DateUtil.getTime()+"账号被禁用！】");
		} catch (AuthenticationException ae) {
			ae.printStackTrace();
			result.setMsg("系统错误！");
			result.setState(Result.STATE_ERROR);
			logger.info("【ERROR："+DateUtil.getTime()+"登陆系统异常！】");
		}
		return result;
	}

	/**
	 * @Title: mainPage 
	 * @Description: 首页
	 * @param    
	 * @return sessionUserMenu  ,menuList
	 * @author SSY
	 * @date 2018年4月12日 下午3:34:38
	 */
	@RequestMapping("/home")
	public String mainPage(ModelMap map) throws Exception {
		try {
			Object userMenu = null;
			Session session = Jurisdiction.getSession();
			Object object = session.getAttribute(Const.SESSION_USER_MENU);
			if (null!=object) {
				userMenu = object;
			} else{
				Integer userID = Jurisdiction.getUser().getUserID();
				userMenu = JSON.toJSON(userRemote.getUserMenu(userID));
				session.setAttribute(Const.SESSION_USER_MENU, userMenu);
			}
			User user = new User();
			HttpServletRequest request = this.getRequest();
			String ip = "";
			if (request.getHeader("x-forwarded-for") == null) {
				ip = request.getRemoteAddr();
			} else {
				ip = request.getHeader("x-forwarded-for");
			}
			user.setUserID(Jurisdiction.getUser().getUserID());
			user.setUserIP(ip);
			user.setLastLoginTime(DateUtil.getTime());
			userRemote.updateUser(user);//更新最近登陆ip
			map.put("menuList", userMenu);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("【ERROR： "+DateUtil.getTime()+"菜单查询异常!】");
			throw new Exception();
		}
		return "admin/index/default";
	}
	
	/**
	 * @Title: logout 
	 * @Description: 退出登陆
	 * @param    
	 * @return  Result<Object>  
	 * @author SSY
	 * @date 2018年4月13日 下午1:33:57
	 */
	@RequestMapping(value = "/logout")
	@ResponseBody
	public Result<Object> logout() throws Exception {
		Result<Object> reslut = new Result<Object>();
		try {
			Subject subject = SecurityUtils.getSubject();
			subject.logout(); // shiro销毁session以及认证缓存信息
			reslut.setState(Result.STATE_SUCCESS);
		} catch (Exception e) {
			logger.info("【ERROR： "+DateUtil.getTime()+"退出异常!】");
			reslut.setState(Result.STATE_SUCCESS);
			reslut.setMsg("系统异常,操作失败!");
		}
		return reslut;
	}
	 
}
