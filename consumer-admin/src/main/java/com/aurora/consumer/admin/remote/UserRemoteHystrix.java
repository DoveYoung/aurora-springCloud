package com.aurora.consumer.admin.remote;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.aurora.consumer.admin.entity.Menu;
import com.aurora.consumer.admin.entity.Page;
import com.aurora.consumer.admin.entity.User;

/**
 * 创建HelloRemoteHystrix类继承与HelloRemote实现回调的方法
 */
@Component
public class UserRemoteHystrix implements UserRemote{

	/**
	 * @Title: getUserByUserEmail 
	 * @Description: 根据用户登陆账号邮箱查询用户信息;
	 * @param 
	 * @return User  
	 * @author SSY
	 * @date 2018年4月12日 上午10:14:36
	 */
	@Override
	public User getUserByUserEmail(String userEmail) {
		User user = new User();
		user.setFallBack(Boolean.TRUE);
		return user;
	}

	/**
     * @Title: getUserPermissions 
	 * @Description: 获取权限菜单url
	 * @param    
	 * @return Set<String>
	 * @author SSY
	 * @date 2018年4月13日 下午1:47:08 
	 */
	@Override
    public Set<String> getUserPermissions(Integer userID){
		Set<String> userPermissions = null;
		return userPermissions;
	}
	
    /**@Title: getUserMenu 
	 * @Description: 查询用户菜单列表
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月13日 下午5:58:17 
	 */
	@Override
	public List<Menu> getUserMenu(Integer userID){
		List<Menu> userMenu = null;
		return userMenu;
	}
	
	/**
	 * @Title: getUserList 
	 * @Description: 分页查询用户列表
	 * @param    Page page
	 * @return List<PageData>  
	 * @author SSY
	 * @date 2018年4月16日 下午1:54:58 
	 */
	@Override
	public List<User> getUserList(Page page){
    	List<User> userList = null;
		return userList;
    }
	
	/**
	 * @Title: getUserNum 
	 * @Description:  分页条件查询用户数量;
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月16日 下午1:58:46 
	 */
	@Override
	public int getUserNum(Page page){
    	return 0;
    }
    
	/**
	 * @Title: saveUser 
	 * @Description: 新增用户
	 * @param    
	 * @return int addNum    
	 * @author SSY
	 * @date 2018年4月16日 下午7:33:59 
	 */
	@Override
	public int saveUser(User user){
		return 0;
	}

	/**
	 * @Title: updateUser 
	 * @Description: 更新用户信息
	 * @param    User  updateUser
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 上午9:33:55 
	 */
	@Override
	public int updateUser(User updateUser){
    	return 0;
    }
	
	/**
	 * @Title: deleteUser 
	 * @Description: 支持批量删除用户
	 * @param    String userIDs
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 上午9:55:28 
	 */
	@Override
	public int deleteUser(String userIDs){
		return 0;
	}
	
	 
	
	
}
