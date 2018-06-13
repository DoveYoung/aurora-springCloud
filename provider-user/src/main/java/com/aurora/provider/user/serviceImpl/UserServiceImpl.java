/**
 * 
 */
package com.aurora.provider.user.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aurora.provider.user.entity.Menu;
import com.aurora.provider.user.entity.User;
import com.aurora.provider.user.service.UserService;
import com.aurora.provider.user.util.Page;
import com.aurora.provider.user.util.PageData;
import com.aurora.provider.user.util.Tools;

/**
 * @Title: UserServiceImpl.java 
 * @Package com.aurora.provider.user.serviceImpl 
 * @Description:  UserServiceImpl
 * @author SSY  
 * @date 2018年4月17日 下午5:03:12 
 * @version V1.0
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl implements UserService{

	

	/**@Title: getUserByUserEmail 
	 * @Description: 根据用户登陆账号邮箱查询用户信息;
	 * @param    
	 * @return User  
	 * @author SSY
	 * @date 2018年4月12日 上午11:43:38 
	 */
	@Override
	public User getUserByUserEmail(String userEmail){
		User user = userReadMapper.getUserByUserEmail(userEmail);
		return user;	
	}
	

	/**@Title: getUserPermissions 
	 * @Description: 查询该用户的权限Rights集合
	 * @param    
	 * @return Set<String>  
	 * @author SSY
	 * @date 2018年4月12日 下午7:40:16 
	 */
	private Set<String> getUserMenuID(Integer userID){
		User user = userReadMapper.getUserByID(userID);
		if (null==user) {
			return null;
		}
		String roleIDs = user.getRoleIDs();
		if (Tools.isEmpty(roleIDs)) {
			return null;
		}
		String[] roleArray = roleIDs.split(",");
		
		List<String> menuIDArray = roleReadMapper.getUserMenuID(roleArray);//批量查询角色下的菜单id
		Set<String> menuIDSet = new HashSet<String>();
		for (int i = 0; i < menuIDArray.size(); i++) {
			String right = menuIDArray.get(i);
			if (Tools.isEmpty(right)) {
				continue;
			}
			for (String string : right.split(",")) {
				menuIDSet.add(string);//去重
			}
		}
		return menuIDSet;
	}
	
	
	
	/**@Title: getUserPermissions 
	 * @Description: 查询该用户的资源集合,多对多角色去重;
	 * @param    
	 * @return Set<String>  
	 * @author SSY
	 * @date 2018年4月12日 下午7:40:16 
	 */
	@Override
	public Set<String> getUserPermissions(Integer userID){
		Set<String> userMenuID = getUserMenuID(userID);
		Set<String> permissions = new HashSet<String>();
		if (null==userMenuID||userMenuID.isEmpty()) {
			return permissions;
		}
		//根据菜单id 批量查询对应的菜单,取出url集合
		permissions = menuReadMapper.getMenuUrl(userMenuID);
		permissions.remove("");//去掉一级菜单;
		return permissions;
	}
	
	/**@Title: getUserMenu 
	 * @Description: 查询用户菜单列表
	 * @param    
	 * @return List<Object>  
	 * @author SSY
	 * @date 2018年4月13日 下午6:04:54 
	 */
	@Override
	public List<Menu> getUserMenu(Integer userID){
		Set<String> userMenuID = this.getUserMenuID(userID);//查询该用户的权限Rights集合
		if (null==userMenuID||userMenuID.size()==0) {
			return new ArrayList<Menu>();
		}
		List<Menu> userMenu = menuReadMapper.getFirstMenuList(userMenuID);//查询一级菜单;
		List<Menu> userSecondMenu = menuReadMapper.getSecondMenuList(userMenuID);//查询二级菜单;
		for (Iterator iterator = userMenu.iterator(); iterator.hasNext();) {
			Menu menu = (Menu) iterator.next();
			List<Menu> subMenu = new ArrayList<Menu>(12);//下级菜单--二级菜单
			int menuID = menu.getMenuID();
			for (Iterator iterator2 = userSecondMenu.iterator(); iterator2.hasNext();) {
				Menu secondMenu = (Menu) iterator2.next();
				int menuParentID = secondMenu.getMenuParentID();
				if (menuParentID==menuID) {
					subMenu.add(secondMenu);
				}
			}
			menu.setSubMenu(subMenu);
		}
		return userMenu;
	}
	

	/**
	 * @Title: getUserList 
	 * @Description: 分页条件查询用户列表
	 * @param    
	 * @return List<User>  
	 * @author SSY
	 * @date 2018年4月16日 下午2:03:18 
	 */
	@Override
	public List<User> getUserList(Page page){
		List<User> userList= userReadMapper.getUserList(page);
		return userList;
	}
	
	/**
	 * @Title: getUserNum 
	 * @Description: 条件查询用户总数
	 * @param    
	 * @return  int  
	 * @author SSY
	 * @date 2018年4月16日 下午2:49:08 
	 */
	@Override
	public int getUserNum(Page page){
		int userNum= userReadMapper.getUserNum(page);
		return userNum;
	}
	
	
	/**@Title: saveUser 
	 * @Description: 新增用户
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月16日 下午7:38:50 
	 */
	@Override
	public int saveUser(User user){
		int addNum= userWriteMapper.saveUser(user);
		return addNum;
	}
	
	/**
	 * @Title: updateUser 
	 * @Description: 更新用户信息
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 上午9:37:08 
	 */
	@Override
	public int updateUser(User user){
		int updateNum= userWriteMapper.updateUser(user);
		return updateNum;
	}
	
	
	/**
	 * @Title: deleteUser 
	 * @Description: 支持批量删除用户
	 * @param    String userIDs
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 上午10:55:28 
	 */
	@Override
	public int deleteUser(String userIDs){
		String[] userIDArray = userIDs.split(",");
		int deleteNum= userWriteMapper.deleteUser(userIDArray);
		return deleteNum;
	}
	
	
	/**@Title: updateUserIP 
	 * @Description:  更新系统用户登陆记录
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月18日 下午4:37:41 
	 */
	@Override
	public int updateUserIP(PageData pd){
		return userWriteMapper.updateUserIP(pd);
	}

	
	
}
