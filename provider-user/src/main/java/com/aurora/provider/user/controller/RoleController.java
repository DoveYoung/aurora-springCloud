/**
 * 
 */
package com.aurora.provider.user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurora.provider.user.entity.Role;
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
@RequestMapping(value = "/role")
public class RoleController extends BaseController{

	/**
	 * @Title: getAllRoles 
	 * @Description: 查询所有的角色列表 
	 * @param    
	 * @return List<Role>  
	 * @author SSY
	 * @date 2018年4月16日 下午3:13:51 
	 */
	@RequestMapping(value = "/getAllRoles")
	public List<Role> getAllRoles(){
		List<Role> rolesList = roleService.getAllRoles();
		return rolesList;
	}
	
	/**
	 * @Title: getRoleList 
	 * @Description: 分页条件查询角色列表
	 * @param    
	 * @return List<Role>  
	 * @author SSY
	 * @date 2018年4月17日 下午3:00:30 
	 */
	@RequestMapping(value = "/getRoleList")
	List<Role> getRoleList(@RequestBody Page page){
		
		 return roleService.getRoleList(page);
	}

	/**
	 * @Title: getRoleNum 
	 * @Description: 分页条件查询角色数量
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午3:01:35 
	 */
	@RequestMapping(value = "/getRoleNum")
	int getRoleNum(@RequestBody Page page){
		
		return roleService.getRoleNum(page);
		
	}

	/**@Title: saveRole 
	 * @Description:保存新增角色
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午3:40:33 
	 */
	@RequestMapping(value = "/saveRole")
	int saveRole(@RequestBody Role role){
		return roleService.saveRole(role);
		
	}
	/**
	 * @Title: getRoleByID 
	 * @Description:查询角色
	 * @param    
	 * @return Role  
	 * @author SSY
	 * @date 2018年4月17日 下午4:13:06 
	 */
	@RequestMapping(value = "/getRoleByID")
	Role getRoleByID(@RequestBody Integer roleID) {
		return roleService.getRoleByID(roleID);
	}
    
	/**@Title: updateRole 
	 * @Description: 更新保存角色
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午4:25:45 
	 */
	@RequestMapping(value = "/updateRole")
	int updateRole(@RequestBody Role role){
		return roleService.updateRole(role);
	}
	
	/**@Title: deleteRole 
	 * @Description: 支持批量删除角色
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午4:43:02 
	 */
	@RequestMapping(value = "/deleteRole")
	int deleteRole(@RequestBody String roleIDs){
		return roleService.deleteRole(roleIDs);
	}
	
	
	
	
	
}
