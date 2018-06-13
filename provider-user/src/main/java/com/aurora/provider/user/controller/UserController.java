/**
 * 
 */
package com.aurora.provider.user.controller;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurora.provider.user.entity.Menu;
import com.aurora.provider.user.entity.User;
import com.aurora.provider.user.util.Page;

/**
 * @Title: UserController.java 
 * @Package com.aurora.provider.user.controller 
 * @Description: 用户管理
 * @author SSY  
 * @date 2018年4月12日 上午11:37:53 
 * @version V1.0
 */
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController{

	
	/**
	 * @Title: getUserByUserEmail 
	 * @Description: 根据用户登陆账号邮箱查询用户信息;
	 * @param    
	 * @return User  
	 * @author SSY
	 * @date 2018年4月12日 上午11:37:29
	 */
	@RequestMapping(value = "/getUserByUserEmail")
     public User getUserByUserEmail(String userEmail){
		User user = userService.getUserByUserEmail(userEmail);
		return null==user?new User() : user;
		
	}
	
	/**根据用户ID获取用户信息
	 * @author BYG 2018.4.2
	 * @param	userID
	 * @return	User
	 */
	@RequestMapping(value = "/getUserPermissions")
    public Set<String> getUserPermissions(Integer userID){
		Set<String> permissions = userService.getUserPermissions(userID);
		return permissions;
	}
	

    /**
     * @Title: getUserMenu 
	 * @Description: 查询用户菜单列表
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月13日 下午5:58:17 
	 */
    @RequestMapping(value = "/getUserMenu")
    public List<Menu> getUserMenu(Integer userID){
    	List<Menu> userMenu = userService.getUserMenu(userID);
    	return userMenu;
    }
    
    /**
     * @Title: getUserList 
	 * @Description: 查询用户菜单列表
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月13日 下午5:58:17 
	 */
    @RequestMapping(value = "/getUserList")
    public List<User> getUserList(@RequestBody Page page){
    	List<User> userList = userService.getUserList(page);
    	return userList;
    }
    
    /**
     * @Title: getUserNum 
	 * @Description: 查询用户菜单列表
	 * @param    
	 * @return List<Menu>
	 * @author SSY
	 * @date 2018年4月13日 下午5:58:17 
	 */
    @RequestMapping(value = "/getUserNum")
    public int getUserNum(@RequestBody Page page){ 
    	int userNum = userService.getUserNum(page);
    	return userNum;
    }

    /**
	 * @Title: saveUser 
	 * @Description: 新增用户
	 * @param    
	 * @return int addNum  
	 * @author SSY
	 * @date 2018年4月16日 下午7:33:59 
	 */
    @RequestMapping(value = "/saveUser")
    public int saveUser(@RequestBody User user){
    	int addNum = userService.saveUser(user);
    	return addNum;
    }

    /**
	 * @Title: updateUser 
	 * @Description: 更新用户信息
	 * @param     User  updateUser
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 上午9:33:55 
	 */
    @RequestMapping(value = "/updateUser")
    public int updateUser(@RequestBody User user){
    	int updateNum = userService.updateUser(user);
    	return updateNum;
    }

	/**
	 * @Title: deleteUser 
	 * @Description: 支持批量删除用户
	 * @param    String userIDs
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 上午9:55:28 
	 */
    @RequestMapping(value = "/deleteUser")
	int deleteUser(String userIDs) {
    	int deleteNum = userService.deleteUser(userIDs);
		return deleteNum;
	}

    
	
}
