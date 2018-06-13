package com.aurora.consumer.admin.controller.system;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.aurora.consumer.admin.controller.base.BaseController;
import com.aurora.consumer.admin.entity.Result;
import com.aurora.consumer.admin.entity.User;
import com.aurora.consumer.admin.util.DateUtil;
import com.aurora.consumer.admin.util.Jurisdiction;
import com.aurora.consumer.admin.util.Tools;

/**
 * @Title: LoginController.java 
 * @Package com.aurora.consumer.admin.controller.system 
 * @Description:首页,只要登陆就可以访问
 * @author SSY  
 * @date 2018年4月11日 下午7:28:19 
 * @version V1.0
 */
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {
	
	/**
	 * @Title: passwordPage 
	 * @Description: 密码页面
	 * @param    
	 * @return String  
	 * @author SSY
	 * @date 2018年4月18日 下午4:55:59
	 */
	@RequestMapping(value = "/passwordPage", produces = "application/json;charset=UTF-8")
	public String passwordPage() throws Exception {
		return "admin/myzone/password";
	}

	
	
	/**
	 * @Title: updatePassword 
	 * @Description: 修改密码
	 * @param String oldPassword, String newPassword
	 * @return Result<Object>  
	 * @author SSY
	 * @date 2018年4月18日 下午5:40:30
	 */
	@RequestMapping(value = "/updatePassword")
	@ResponseBody
	public Result<Object> updatePassword(String oldPassword, String newPassword) throws Exception {
		Result<Object> result = new Result<Object>();
		if (Tools.isEmpty(newPassword)||Tools.isEmpty(oldPassword)) {
			result.setMsg("参数错误!");
			result.setState(Result.STATE_ERROR);
			return result;
		} 
		User user = Jurisdiction.getUser();
		oldPassword = new SimpleHash("SHA-1", oldPassword, user.getSalt()).toString(); // 密码加密
		if (!oldPassword.equals(user.getUserPassword())) {
			result.setMsg("密码错误!");
			result.setState(Result.STATE_ERROR);
			return result;
		} 
		newPassword = new SimpleHash("SHA-1", newPassword, user.getSalt()).toString(); // 密码加密
		try {
			User newUser = new User();
			newUser.setUserID(user.getUserID());
			newUser.setUserPassword(newPassword);
			int updateNum = userRemote.updateUser(newUser);
			result.setMsg(updateNum>=1?"操作成功!":"操作失败!");
			result.setState(updateNum>=1?Result.STATE_SUCCESS:Result.STATE_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			result.setState(Result.STATE_ERROR);
			logger.info("【ERROR： "+DateUtil.getTime()+"密码修改异常!】");
		}
		return result;
	}

	/**
	 * @Title: getPersonalInfo 
	 * @Description: 个人资料
	 * @param    user
	 * @return ModelAndView  
	 * @author SSY
	 * @date 2018年4月18日 下午5:16:50
	 */
	@RequestMapping(value = "/personalInfo", produces = "application/json;charset=UTF-8")
	public String getPersonalInfo(ModelMap map) throws Exception {
		User user = Jurisdiction.getUser();
		map.put("user", JSON.toJSON(user));
		return "admin/myzone/userInfo";
	}

	/**
	 * @Title: updateUserInfo 
	 * @Description: 修改个人资料
	 * @param    user{userRealName, userName,userMobile }
	 * @return Object  
	 * @author SSY
	 * @date 2018年4月18日 下午5:19:57
	 */
	@RequestMapping(value = "/updateUserInfo")
	@ResponseBody
	public Result<Object> updateUserInfo(String userRealName, String userName, String userMobile ) throws Exception {
		User user = new User();
		Result<Object> result = new Result<Object>();
		if (Tools.isEmpty(userRealName)||Tools.isEmpty(userName)||Tools.isEmpty(userMobile)) {
			result.setMsg("参数错误!");
			result.setState(Result.STATE_ERROR);
			return result;
		}
		user.setUserID(Jurisdiction.getUser().getUserID());
		user.setUserRealName(userRealName);
		user.setUserName(userName);
		user.setUserMobile(userMobile.replace(" ", ""));
		try{
			int updateNum = userRemote.updateUser(user);
			result.setMsg(updateNum>=1?"操作成功!":"操作失败!");
			result.setState(updateNum>=1?Result.STATE_SUCCESS:Result.STATE_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			result.setState(Result.STATE_ERROR);
			logger.info("【ERROR： "+DateUtil.getTime()+"个人资料修改异常!】");
		}
		return result;
	}

	

}
