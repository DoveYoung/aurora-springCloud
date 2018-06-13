package com.aurora.consumer.admin.remote;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aurora.consumer.admin.entity.Page;
import com.aurora.consumer.admin.entity.Role;

/**
 * @FeignClient(name= "zuul")对应spring:application:name: zuul
 * 通过网关统一访问
 */
@FeignClient(name= "server-zuul1", fallback=RoleRemoteHystrix.class)
public interface RoleRemote {
 
	/**
	 * @Title: getAllRoles 
	 * @Description: 查询所有的角色列表 
	 * @param    
	 * @return List<Role>  
	 * @author SSY
	 * @date 2018年4月16日 下午3:13:51 
	 */
	@RequestMapping(value = "/provider-user/role/getAllRoles")
	List<Role> getAllRoles();

	/**
	 * @Title: getRoleList 
	 * @Description: 分页条件查询角色列表
	 * @param    
	 * @return List<Role>  
	 * @author SSY
	 * @date 2018年4月17日 下午3:00:30 
	 */
	@RequestMapping(value = "/provider-user/role/getRoleList")
	List<Role> getRoleList(@RequestBody Page page);

	/**@Title: getRoleNum 
	 * @Description: 分页条件查询角色数量
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午3:01:35 
	 */
	@RequestMapping(value = "/provider-user/role/getRoleNum")
	int getRoleNum(@RequestBody Page page);

	/**@Title: saveRole 
	 * @Description: 保存新增的角色
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午3:40:33 
	 */
	@RequestMapping(value = "/provider-user/role/saveRole")
	int saveRole(@RequestBody Role role);

	/**
	 * @Title: getRoleByID 
	 * @Description:查询角色
	 * @param    
	 * @return Role  
	 * @author SSY
	 * @date 2018年4月17日 下午4:13:06 
	 */
	@RequestMapping(value = "/provider-user/role/getRoleByID")
	Role getRoleByID(@RequestBody Integer roleID);

	/**@Title: updateRole 
	 * @Description: 更新保存角色
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午4:25:45 
	 */
	@RequestMapping(value = "/provider-user/role/updateRole")
	int updateRole(@RequestBody Role role);

	/**@Title: deleteRole 
	 * @Description: 支持批量删除角色
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午4:43:02 
	 */
	@RequestMapping(value = "/provider-user/role/deleteRole")
	int deleteRole(@RequestBody String roleIDs);

    
    
    
     
	
	
	
    
}
