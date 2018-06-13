/**
 * 
 */
package com.aurora.provider.user.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aurora.provider.user.entity.Role;
import com.aurora.provider.user.service.RoleService;
import com.aurora.provider.user.util.Page;

/**管理用户接口实现类
 * @author BYG 2018.4.2
 * @version 1.0
 */
@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl implements RoleService{
 
	/**
	 * @Title: getAllRoles 
	 * @Description: 查询所有的角色
	 * @param    
	 * @return List<Role>  
	 * @author SSY
	 * @date 2018年4月16日 下午3:30:15 
	 */
	public List<Role> getAllRoles(){
		List<Role> allRoles = roleReadMapper.getAllRoles();
		return allRoles;
	}
	
	
	/**
	 * @Title: getRoleList 
	 * @Description: 分页条件查询角色列表;
	 * @param    
	 * @return List<Role>  
	 * @author SSY
	 * @date 2018年4月17日 下午3:19:50 
	 */
	@Override
	public List<Role> getRoleList(Page page){
		
		return roleReadMapper.getRoleList(page);
	}

	/**@Title: getRoleNum 
	 * @Description: 分页条件查询角色数量
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午3:21:04 
	 */
	@Override
	public int getRoleNum(Page page){
		return roleReadMapper.getRoleNum(page);
	}
	
	/**@Title: getRoleByID 
	 * @Description: 查询角色
	 * @param    
	 * @return Role  
	 * @author SSY
	 * @date 2018年4月17日 下午4:21:14 
	 */
	@Override
	public Role getRoleByID(Integer roleID){
		return roleReadMapper.getRoleByID(roleID);
	}
 
	
	/**@Title: saveRole 
	 * @Description:保存新增角色
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午3:42:35 
	 */
	@Override
	public int saveRole(Role role){
		return roleWriteMapper.saveRole(role);
	}

	/**
	 * @Title: updateRole 
	 * @Description: 更新角色
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午4:27:44 
	 */
	@Override
	public int updateRole(Role role){
		return roleWriteMapper.updateRole(role);
	}

	
	/**@Title: deleteRole 
	 * @Description:  支持批量删除角色
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午4:44:42 
	 */
	public int deleteRole(String roleIDs){
		String[] roleIDArray = roleIDs.split(",");
		return roleWriteMapper.deleteRole(roleIDArray);
	}
	
}
