package com.aurora.consumer.admin.remote;

import java.util.List;
import java.util.Set;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aurora.consumer.admin.entity.Menu;
import com.aurora.consumer.admin.entity.Page;
import com.aurora.consumer.admin.entity.User;

/**
 * @FeignClient(name= "zuul")对应spring:application:name: zuul
 * 通过网关统一访问
 */
@FeignClient(name= "server-zuul1", fallback=UserRemoteHystrix.class)
public interface UserRemote {



	/**
	 * @Title: getUserByUserEmail 
	 * @Description: 根据用户登陆账号邮箱查询用户信息;
	 * @param 
	 * @return User  
	 * @author SSY
	 * @date 2018年4月12日 上午10:14:36
	 */
    @RequestMapping(value = "/provider-user/user/getUserByUserEmail")
    User getUserByUserEmail(@RequestParam(value = "userEmail")String userEmail);
	
    /**
     * @Title: getUserPermissions 
	 * @Description: 查询用户权限url
	 * @param    
	 * @return Set<String>  
	 * @author SSY
	 * @date 2018年4月13日 下午1:47:08 
	 */
    @RequestMapping(value = "/provider-user/user/getUserPermissions")
    Set<String> getUserPermissions(@RequestParam(value = "userID")Integer userID);
    
    
    /**
     * @Title: getUserMenu 
	 * @Description: 查询用户菜单列表
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月13日 下午5:58:17 
	 */
    @RequestMapping(value = "/provider-user/user/getUserMenu")
	List<Menu> getUserMenu(@RequestParam(value = "userID")Integer userID);

	/**
	 * @Title: getUserList 
	 * @Description: 分页条件查询用户列表
	 * @param    Page page
	 * @return List<PageData>  
	 * @author SSY
	 * @date 2018年4月16日 下午1:54:58 
	 */
    @RequestMapping(value = "/provider-user/user/getUserList")
	List<User> getUserList(@RequestBody Page page);

	/** 
	 * @Title: getUserNum 
	 * @Description:  分页条件查询用户数量;
	 * @param    
	 * @return String  
	 * @author SSY
	 * @date 2018年4月16日 下午1:58:46 
	 */
    @RequestMapping(value = "/provider-user/user/getUserNum")
	int getUserNum(@RequestBody Page page);

	/**
	 * @Title: saveUser 
	 * @Description: 新增用户
	 * @param    
	 * @return int addNum  
	 * @author SSY
	 * @date 2018年4月16日 下午7:33:59 
	 */
    @RequestMapping(value = "/provider-user/user/saveUser")
	int saveUser(@RequestBody User user);

	/**
	 * @Title: updateUser 
	 * @Description: 更新用户信息
	 * @param     User  updateUser
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 上午9:33:55 
	 */
    @RequestMapping(value = "/provider-user/user/updateUser")
	int updateUser(@RequestBody User updateUser);

	/**
	 * @Title: deleteUser 
	 * @Description: 支持批量删除用户
	 * @param    String userIDs
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 上午9:55:28 
	 */
    @RequestMapping(value = "/provider-user/user/deleteUser")
	int deleteUser(@RequestParam(value = "userIDs") String userIDs);

	 
	 

    
    
    
     
	
	
	
    
}
