/**
 * 
 */
package com.aurora.provider.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.aurora.provider.user.entity.Role;
import com.aurora.provider.user.util.Page;

/**
 * @Title: RoleReadMapper.java 
 * @Package com.aurora.provider.user.mapper 
 * @Description: 角色
 * @author SSY  
 * @date 2018年4月12日 下午8:09:33 
 * @version V1.0
 */
public interface RoleReadMapper {

	/**@Title: getRole 
	 * @Description: 根据角色id 查询角色
	 * @param    
	 * @return List<String>  
	 * @author SSY
	 * @date 2018年4月13日 下午3:38:17 
	 */
	@Select("SELECT * FROM admin_role WHERE admin_role = #{roleID}")     
	@Results(id = "role",value = {
		       @Result(property = "roleID",  column = "role_id"),
		       @Result(property = "roleName", column = "role_name"),
		       @Result(property = "roleRights", column = "role_rights"),
		       @Result(property = "roleRemark",  column = "role_remark"),
		       @Result(property = "creator", column = "creator"),
		       @Result(property = "createTime",  column = "create_time"),
		       @Result(property = "updator", column = "updator"),
		       @Result(property = "updateTime", column = "update_time")
		    })
	List<Role> getRole(Integer roleID);

	/**@Title: getUserMenuID 
	 * @Description: 查询该角色列表中所有的菜单id
	 * @param    
	 * @return List<String>  
	 * @author SSY
	 * @date 2018年4月13日 下午4:46:16 
	 */
	@Select("<script>SELECT role_rights FROM admin_role WHERE role_id IN "
			+ "<foreach collection='array' item='id' open='(' separator=',' close=')'>"
			+ "#{id}</foreach></script>") 
	List<String> getUserMenuID(String[] roleArray);

	/**
	 * @Title: getAllRoles 
	 * @Description: 查询所有的角色
	 * @param    
	 * @return void  
	 * @author SSY
	 * @date 2018年4月16日 下午3:31:46 
	 */
	@Select("SELECT role_id,role_name FROM admin_role") 
	@ResultMap(value="role")
	List<Role> getAllRoles();

	
	/**@Title: getRoleList 
	 * @Description: TODO 
	 * @param    
	 * @return List<Role>  
	 * @author SSY
	 * @date 2018年4月17日 下午3:23:47 
	 */
	@Select("<script>SELECT * FROM admin_role "
			+ "<if test='pd.roleName!=null'>WHERE role_name LIKE CONCAT ('%',#{pd.roleName},'%') </if>"
			+ "ORDER BY role_id ASC "
			+ "LIMIT #{fromIndex}, #{pageSize}</script>") 
	@ResultMap(value="role")
	List<Role> getRoleList(Page page);
	
	/**@Title: getRoleNum 
	 * @Description: TODO 
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午3:23:41 
	 */
	@Select("<script>SELECT count(role_id) FROM admin_role "
			+ "<if test='pd.roleName!=null'>WHERE role_name LIKE CONCAT ('%',#{pd.roleName},'%') </if></script>") 
	int getRoleNum(Page page);

	/**
	 * @Title: getRoleByID 
	 * @Description: 查询角色
	 * @param    
	 * @return Role  
	 * @author SSY
	 * @date 2018年4月17日 下午4:22:30 
	 */
	@Select("SELECT * FROM admin_role WHERE role_id = #{roleID}")
	@ResultMap(value="role")
	Role getRoleByID(Integer roleID);

	

	 
	
	
	
}
