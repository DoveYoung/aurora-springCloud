package com.aurora.provider.user.service;

import java.util.List;

import com.aurora.provider.user.entity.Role;
import com.aurora.provider.user.util.Page;

/**管理用户接口
 * @author BYG 2018.4.2
 * @version 1.0
 */
public interface RoleService {

	/**
	 * @Title: getAllRoles 
	 * @Description: 查询所有的角色
	 * @param    
	 * @return List<Role>  
	 * @author SSY
	 * @date 2018年4月16日 下午3:30:15 
	 */
	List<Role> getAllRoles();

	/**
	 * @Title: getRoleList 
	 * @Description: 分页条件查询角色列表;
	 * @param    
	 * @return List<Role>  
	 * @author SSY
	 * @date 2018年4月17日 下午3:19:50 
	 */
	List<Role> getRoleList(Page page);

	/**@Title: getRoleNum 
	 * @Description: 分页条件查询角色数量
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午3:21:04 
	 */
	int getRoleNum(Page page);

	/**@Title: saveRole 
	 * @Description:保存新增角色
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午3:42:35 
	 */
	int saveRole(Role role);

	/**@Title: getRoleByID 
	 * @Description: 查询角色
	 * @param    
	 * @return Role  
	 * @author SSY
	 * @date 2018年4月17日 下午4:21:14 
	 */
	Role getRoleByID(Integer roleID);

	/**
	 * @Title: updateRole 
	 * @Description: 更新角色
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午4:27:44 
	 */
	int updateRole(Role role);

	/**@Title: deleteRole 
	 * @Description:  支持批量删除角色
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午4:44:42 
	 */
	int deleteRole(String roleIDs);

	

	
	
}
