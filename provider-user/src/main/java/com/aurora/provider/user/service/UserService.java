package com.aurora.provider.user.service;

import java.util.List;
import java.util.Set;

import com.aurora.provider.user.entity.Menu;
import com.aurora.provider.user.entity.User;
import com.aurora.provider.user.util.Page;
import com.aurora.provider.user.util.PageData;

/**管理用户接口
 * @author BYG 2018.4.2
 * @version 1.0
 */
public interface UserService {

	/**@Title: getUserByUserEmail 
	 * @Description: 根据用户登陆账号邮箱查询用户信息;
	 * @param    
	 * @return User  
	 * @author SSY
	 * @date 2018年4月12日 上午11:43:38 
	 */
	User getUserByUserEmail(String userEmail);

	/**@Title: getUserPermissions 
	 * @Description: 查询该用户的资源集合,多对多角色去重;
	 * @param    
	 * @return Set<String>  
	 * @author SSY
	 * @date 2018年4月12日 下午7:40:16 
	 */
	Set<String> getUserPermissions(Integer userID);
	
	/**@Title: getUserMenu 
	 * @Description: TODO 
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月13日 下午6:04:54 
	 */
	List<Menu> getUserMenu(Integer userID);

	/**@Title: getUserList 
	 * @Description: 分页条件查询用户列表
	 * @param    
	 * @return List<User>  
	 * @author SSY
	 * @date 2018年4月16日 下午2:03:18 
	 */
	List<User> getUserList(Page page);

	/**
	 * @Title: getUserNum 
	 * @Description: 条件查询用户总数
	 * @param    
	 * @return  int  
	 * @author SSY
	 * @date 2018年4月16日 下午2:49:08 
	 */
	int getUserNum(Page page);

	/**@Title: saveUser 
	 * @Description: 新增用户
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月16日 下午7:38:50 
	 */
	int saveUser(User user);

	/**
	 * @Title: updateUser 
	 * @Description: 更新用户信息
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 上午9:37:08 
	 */
	int updateUser(User user);

	/**
	 * @Title: deleteUser 
	 * @Description: 支持批量删除用户
	 * @param    String userIDs
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 上午10:55:28 
	 */
	int deleteUser(String userIDs);

	/**@Title: updateUserIP 
	 * @Description:  更新系统用户登陆记录
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月18日 下午4:37:41 
	 */
	int updateUserIP(PageData pd);


	
	
}
