package com.aurora.consumer.admin.remote;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aurora.consumer.admin.entity.Menu;
import com.aurora.consumer.admin.entity.Page;
import com.aurora.consumer.admin.entity.Role;
import com.aurora.consumer.admin.entity.User;

/**
 * 创建RemoteHystrix类继承与Remote实现回调的方法
 */
@Component
public class RoleRemoteHystrix implements RoleRemote{
 
	/**
	 * @Title: getAllRoles 
	 * @Description: 查询所有的角色列表 
	 * @param    
	 * @return List<Role>  
	 * @author SSY
	 * @date 2018年4月16日 下午3:13:51 
	 */
	@Override
	public List<Role> getAllRoles(){
		List<Role> allRoles = new ArrayList<Role>();
		return allRoles;
	}
	
	/**
	 * @Title: getRoleList 
	 * @Description: 分页条件查询角色列表
	 * @param    
	 * @return List<Role>  
	 * @author SSY
	 * @date 2018年4月17日 下午3:00:30 
	 */
	@Override
	public List<Role> getRoleList(Page page){
		List<Role> rolesList = new ArrayList<Role>();
		return rolesList;
	}

	/**
	 * @Title: getRoleNum 
	 * @Description: 分页条件查询角色数量
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午3:01:35 
	 */
	@RequestMapping(value = "/provider-user/role/getRoleNum")
	public int getRoleNum(Page page){
		return 0;
	}

	/**@Title: saveRole 
	 * @Description: 保存新增角色
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午3:40:33 
	 */
	@Override
	public int saveRole( Role role){
		return 0;
	}
    
    

	/**
	 * @Title: getRoleByID 
	 * @Description:查询角色
	 * @param    
	 * @return Role  
	 * @author SSY
	 * @date 2018年4月17日 下午4:13:06 
	 */
	@Override
	public Role getRoleByID(Integer roleID){
		Role role = new Role();
		role.setFallBack(Boolean.TRUE);//表示已经回;
		return role;
	}
	
	/**@Title: updateRole 
	 * @Description: 更新保存角色
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午4:25:45 
	 */
	@Override
	public int updateRole(Role role){
		return 0;
	}
	
	/**@Title: deleteRole 
	 * @Description: 支持批量删除角色
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午4:43:02 
	 */
	@Override
	public int deleteRole(String roleIDs){
		return 0;
	}
}
