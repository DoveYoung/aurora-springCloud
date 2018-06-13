package com.aurora.consumer.admin.controller.system;

import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.aurora.consumer.admin.controller.base.BaseController;
import com.aurora.consumer.admin.entity.Page;
import com.aurora.consumer.admin.entity.Result;
import com.aurora.consumer.admin.entity.Role;
import com.aurora.consumer.admin.entity.User;
import com.aurora.consumer.admin.util.Const;
import com.aurora.consumer.admin.util.DateUtil;
import com.aurora.consumer.admin.util.Jurisdiction;
import com.aurora.consumer.admin.util.PageData;
import com.aurora.consumer.admin.util.Tools;

/**
 * @Title: UserController.java 
 * @Package com.aurora.consumer.admin.controller.system 
 * @Description: 系统用户管理 
 * @author SSY  
 * @date 2018年4月16日 下午1:35:32 
 * @version V1.0
 */
@Controller
@RequestMapping(value = "/systemUser")
public class UserController extends BaseController{
	
	/**
	 * @Title: getUserList 
	 * @Description: 获取用户列表; 
	 * @param    Page page, String keywords, Integer userStatus, Integer roleID
	 * @return    page, pd, userList, allRoleListToSelect  
	 * @author SSY
	 * @date 2018年4月16日 下午1:40:43
	 */
	@RequestMapping(value = "/getUserList")
	public String getUserList(ModelMap map, Page page, String keywords, Integer userStatus, Integer roleID)throws Exception{
		PageData pd = new PageData();
		pd.put("keywords", Tools.notEmpty(keywords)?keywords.replace(" ", ""):null);
		pd.put("userStatus", userStatus);
		pd.put("roleID", roleID);
		page.setPd(pd);
		page.setPageSize(10);
		try {
			List<User> userList = userRemote.getUserList(page);	//列出用户列表
			List<Role> allRoles = roleRemote.getAllRoles();//列出所有系统用户角色
			int totalRecord = userRemote.getUserNum(page);
			page.setTotalRecord(totalRecord);
			map.put("userList", JSON.toJSON(userList));
			map.put("page", JSON.toJSON(page));
			map.put("allRoleListToSelect", JSON.toJSON(allRoles));
		} catch (Exception e) {
			logger.info("【ERROR："+DateUtil.getTime()+"条件查询显示用户列表系统异常！】");
			throw new Exception("查询显示用户列表执行异常");
		}
		map.put("pd", pd);
		return "admin/manager/userList";
	}
	
	 
	/**
	 * @Title: saveUser 
	 * @Description: 新增保存用户
	 * @param    String userRealName,String userMobile,String userEmail,String userRoleIDs(逗号分割),
	 *  			String userRoleNames(逗号分割),String userName,String userPassword 
	 * @return Result<Object>  
	 * @author SSY
	 * @date 2018年4月16日 下午8:22:28
	 */
	@RequestMapping(value="/saveNewUser",produces="application/json;charset=UTF-8")
	@ResponseBody
 	public Result<Object> saveUser(String userRealName,String userMobile,String userEmail,String userRoleIDs,String userRoleNames,String userName,String userPassword) throws Exception {
		Result<Object> result = new Result<Object>();
		if (Tools.isEmpty(userEmail)||Tools.isEmpty(userRoleIDs)||Tools.isEmpty(userRoleNames)) {
			result.setMsg("参数错误!");
			result.setState(Result.STATE_ERROR);
			return result;
		}
		User user = new User();
		user.setUserRealName(userRealName.replace(" ", ""));
		user.setUserMobile(userMobile.replace(" ", ""));
		user.setUserEmail(userEmail.replace(" ", ""));
		user.setRoleIDs(userRoleIDs.replace(" ", ""));
		user.setRoleNames(userRoleNames.replace(" ", "")); 
		user.setUserName(userName.replace(" ", ""));
		if (null != userRemote.getUserByUserEmail(userEmail.replace(" ", ""))) {
			result.setMsg("该邮箱已经注册!");
			result.setState(Result.STATE_ERROR);
			return result;
		}
		String salt = Tools.getRandomNum()+"";
		user.setSalt(salt);    //盐值
		if(Tools.notEmpty(userPassword)){
			userPassword = new SimpleHash("SHA-1", userPassword.replace(" ", ""), salt)+"";
		}else{
			userPassword = new SimpleHash("SHA-1", Const.DEFAULT_PASSWORD, salt)+"";
		}
		user.setUserPassword(userPassword);  //密码
		user.setCreateTime(DateUtil.getTime());
		user.setCreator(Jurisdiction.getUser().getUserEmail());
		try {
			int addNum = userRemote.saveUser(user); 					//执行保存
			result.setState(addNum>=1?Result.STATE_SUCCESS:Result.STATE_ERROR);
			result.setMsg(addNum>=1?"操作成功! ":"操作失败!系统异常!");
		} catch (Exception e) {
			e.printStackTrace();
			result.setMsg("系统异常! ");
			result.setState(Result.STATE_ERROR);
			logger.info("【ERROR："+DateUtil.getTime()+"新增用户系统执行异常！】");
		}
		return result;
	}
	
	
	/**
	 * @Title: getUser 
	 * @Description: 查看用户
	 * @param    String userEmail
	 * @return Result<User>  
	 * @author SSY
	 * @date 2018年4月16日 下午8:22:28
	 */
	@RequestMapping(value="/getUser",produces="application/json;charset=UTF-8")
	@ResponseBody
 	public Result<User> getUser(String userEmail) throws Exception {
		
		Result<User> result = new Result<User>();
		if (Tools.isEmpty(userEmail)) {
			result.setMsg("参数错误!");
			result.setState(Result.STATE_ERROR);
			return result;
		}
		try {
			User user = userRemote.getUserByUserEmail(userEmail.replace(" ", ""));
			result.setResult(user);
			result.setState(user.getFallBack()?Result.STATE_ERROR:Result.STATE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMsg("系统异常! ");
			result.setState(Result.STATE_ERROR);
			logger.info("【ERROR："+DateUtil.getTime()+"用户查询系统执行异常！】");
		}
		return result;
	}
	
	/**
	 * @Title: updateUser 
	 * @Description: 修改更新用户
	 * @param    String userRealName,String userMobile,String userEmail,String userRoleIDs(逗号分割),
	 *  			String userRoleNames(逗号分割),String userName,String userPassword , Integer userStatus(1新账号无操作；2在线；3离线； 4禁用；5.虚拟账号)
	 * @return Result<User>  
	 * @author SSY
	 * @date 2018年4月16日 下午8:22:28
	 */
	@RequestMapping(value="/updateUser",produces="application/json;charset=UTF-8")
	@ResponseBody
 	public Result<Object> updateUser(Integer userStatus, Integer userID, String userRealName,String userMobile,String userEmail,String userRoleIDs, String userRoleNames,String userName,String userPassword) throws Exception {
		Result<Object> result = new Result<Object>();
		if (null==userStatus||null==userID||Tools.isEmpty(userEmail)||Tools.isEmpty(userRoleIDs)||Tools.isEmpty(userRoleNames)) {
			result.setMsg("参数错误!");
			result.setState(Result.STATE_ERROR);
			return result;
		}
		try {
			User user = userRemote.getUserByUserEmail(userEmail.replace(" ", ""));
			if (user!=null&&(user.getUserID().intValue()!=userID.intValue())) {
				result.setMsg("操作失败！  登陆账号重复！ ");
				result.setState(Result.STATE_ERROR);
				return result;
			}
			User updateUser = new User();
			updateUser.setUserID(userID);
			updateUser.setUserStatus(userStatus);
			updateUser.setRoleIDs(userRoleIDs.replace(" ", ""));
			updateUser.setRoleNames(userRoleNames.replace(" ", ""));
			updateUser.setUserMobile(userMobile.replace(" ", ""));
			updateUser.setUserEmail(userEmail.replace(" ", ""));
			updateUser.setUserName(userName.replace(" ", ""));
			updateUser.setUserRealName(userRealName.replace(" ", ""));
			if(Tools.notEmpty(userPassword) ){
				updateUser.setUserPassword(new SimpleHash("SHA-1", userPassword, user.getSalt()).toString());
			}else{//如果密码为空,则默认是123456;
				updateUser.setUserPassword(new SimpleHash("SHA-1", "123456", user.getSalt()).toString());
			} 
			updateUser.setUpdateTime(DateUtil.getTime());
			updateUser.setUpdator(Jurisdiction.getUser().getUserEmail());
			
			int updateNum = userRemote.updateUser(updateUser);
			
			result.setMsg(updateNum>=1?"操作成功!":"操作失败!");
			result.setState(updateNum>=1?Result.STATE_SUCCESS:Result.STATE_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMsg("系统异常! ");
			result.setState(Result.STATE_ERROR);
			logger.info("【ERROR："+DateUtil.getTime()+"更新用户系统执行异常！】");
		}
		return result;
	}
	
	/**
	 * @Title: deleteUser 
	 * @Description: 批量删除用户
	 * @param    String userIDs(逗号拼接)
	 * @return Result<User>  
	 * @author SSY
	 * @date 2018年4月16日 下午8:22:28
	 */
	@RequestMapping(value="/deleteUser",produces="application/json;charset=UTF-8")
	@ResponseBody
 	public Result<Object> deleteUser(String userIDs) throws Exception {
		
		Result<Object> result = new Result<Object>();
		if (Tools.isEmpty(userIDs)) {
			result.setMsg("参数错误!");
			result.setState(Result.STATE_ERROR);
			return result;
		}
		try {
			int deleteNum = userRemote.deleteUser(userIDs);//支持批量删除
			result.setMsg(deleteNum>=1 ? "操作成功！ ": "操作失败！ ");
			result.setState(deleteNum>=1 ? Result.STATE_SUCCESS : Result.STATE_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMsg("系统异常! ");
			result.setState(Result.STATE_ERROR);
			logger.info("【ERROR："+DateUtil.getTime()+"删除用户系统执行异常！】");
		}
		return result;
	}
	
	
	
	
	
	
}
