/**
 * 
 */
package com.aurora.provider.user.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import com.aurora.provider.user.entity.Role;

/**
 * @Title: RoleWriteMapper.java 
 * @Package com.aurora.provider.user.mapper 
 * @Description: 角色
 * @author SSY  
 * @date 2018年4月12日 下午8:09:33 
 * @version V1.0
 */
public interface RoleWriteMapper {

	/**@Title: saveRole 
	 * @Description: TODO 
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午3:44:27 
	 */
	@Insert("INSERT INTO admin_role (role_name, role_rights, role_remark, creator, create_time)"
			+ " VALUES (#{roleName},#{roleRights},#{roleRemark},#{creator},#{createTime})")
	int saveRole(Role role);

	/**@Title: updateRole 
	 * @Description:  更新角色
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午4:28:52 
	 */
	@Update("<script>UPDATE admin_role SET role_name = #{roleName}, role_rights = #{roleRights}, role_remark = #{roleRemark}, "
			+ "updator = #{updator}, update_time = #{updateTime} WHERE role_id = #{roleID}</script>")
	int updateRole(Role role);

	/**@Title: deleteRole 
	 * @Description: 支持批量删除角色
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午4:45:59 
	 */
	@Delete("<script>DELETE FROM admin_role WHERE role_id IN <foreach collection='array' item='roleID' open='(' separator=',' close=')'>"
			+ "#{roleID}</foreach></script>")
	int deleteRole(String[] roleIDArray);

 

	 
	
	
	
}
