/**
 * 
 */
package com.aurora.provider.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.aurora.provider.user.entity.User;
import com.aurora.provider.user.util.Page;

/**
 * @Title: UserReadMapper.java 
 * @Package com.aurora.provider.user.mapper 
 * @Description: UserReadMapper
 * @author SSY  
 * @date 2018年4月17日 上午10:36:36 
 * @version V1.0
 */
public interface UserReadMapper {
	

	/**
	 * @Title: getUserByUserEmail 
	 * @Description: 根据登陆账号查询用户信息 
	 * @param    
	 * @return User  
	 * @author SSY
	 * @date 2018年4月12日 上午11:46:41 
	 */
	@Select("SELECT * FROM admin_user WHERE user_email = #{userEmail}")     
	@Results(id = "user",value = {
		       @Result(property = "userID",  column = "user_id"),
		       @Result(property = "userEmail", column = "user_email"),
		       @Result(property = "userPassword", column = "user_password"),
		       @Result(property = "salt",  column = "user_salt"),
		       @Result(property = "userRealName", column = "user_real_name"),
		       @Result(property = "userName",  column = "user_name"),
		       @Result(property = "userMobile", column = "user_mobile"),
		       @Result(property = "roleIDs", column = "user_role_id"),
		       @Result(property = "roleNames", column = "user_role_name"),
		       @Result(property = "userIP",  column = "login_ip"),
		       @Result(property = "userStatus", column = "login_status"),
		       @Result(property = "lastLoginTime", column = "last_login_time"),
		       @Result(property = "lastLoginTime", column = "last_login_time"),
		       @Result(property = "creator", column = "creator"),
		       @Result(property = "createTime",  column = "create_time"),
		       @Result(property = "updator", column = "updator"),
		       @Result(property = "updateTime",  column = "update_time")      
		    })   
	User getUserByUserEmail(String userEmail);

	/**
	 * @Title: getUserByID 
	 * @Description: 根据用户id查询用户信息
	 * @param    
	 * @return User  
	 * @author SSY
	 * @date 2018年4月12日 上午11:46:41 
	 */
	@Select("SELECT * FROM admin_user WHERE user_id = #{userID}")     
	@ResultMap(value = "user")
	User getUserByID(Integer userID);
	 

	/**
	 * @Title: getUserList 
	 * @Description: 分页条件查询用户列表 
	 * @param    
	 * @return List<User>  
	 * @author SSY
	 * @date 2018年4月16日 下午2:07:29 
	 */
	@Select("<script>SELECT * FROM admin_user WHERE 1=1 "
			+ "<if test='pd.keywords!=null'>AND (user_name LIKE CONCAT('%',#{pd.keywords},'%')  "
			+ "OR user_real_name LIKE CONCAT('%',#{pd.keywords},'%')  "
			+ "OR user_mobile = #{pd.keywords})</if>  "
			+ "<if test = 'pd.userStatus!=null'>AND login_status = #{pd.userStatus}</if> "
			+ "<if test = 'pd.roleID!=null'> AND user_role_id LIKE CONCAT('%',#{pd.roleID},'%')</if> "
			+ "ORDER BY user_id ASC  "
			+ "LIMIT #{fromIndex}, #{pageSize}</script>")     
	@ResultMap(value = "user")
	List<User> getUserList(Page page);

	/**
	 * @Title: getUserNum 
	 * @Description: 分页条件查询用户数量 
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月16日 下午2:51:04 
	 */
	@Select("<script>SELECT count(user_id) FROM admin_user WHERE 1=1 "
			+ "<if test='pd.keywords!=null'>AND (user_name LIKE CONCAT('%',#{pd.keywords},'%') "
			+ "OR user_real_name LIKE CONCAT('%',#{pd.keywords},'%') "
			+ "OR user_mobile = #{pd.keywords})</if>"
			+ "<if test = 'pd.userStatus!=null'>AND login_status = #{pd.userStatus}</if>"
			+ "<if test = 'pd.roleID!=null'> AND user_role_id LIKE CONCAT('%',#{pd.roleID}+',','%')</if>"
			+ "</script>")     
	int getUserNum(Page page);
	
	
	
	 
}
