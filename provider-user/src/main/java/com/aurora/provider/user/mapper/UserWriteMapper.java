/**
 * 
 */
package com.aurora.provider.user.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import com.aurora.provider.user.entity.User;
import com.aurora.provider.user.util.PageData;

/**
 * @Title: UserWriteMapper.java 
 * @Package com.aurora.provider.user.mapper 
 * @Description:  UserWriteMapper,写操作
 * @author SSY  
 * @date 2018年4月17日 上午10:33:37 
 * @version V1.0
 */
public interface UserWriteMapper {
	 
	/**@Title: saveUser 
	 * @Description: 新增用户
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月16日 下午7:40:31 
	 */
	@Insert("INSERT INTO admin_user (user_name,user_email,user_password,user_salt,user_real_name,user_mobile,user_role_id,user_role_name,creator,create_time)"
			+ "VALUES (#{userName}, #{userEmail}, #{userPassword}, #{salt}, #{userRealName}, #{userMobile}, #{roleIDs}, #{roleNames}, #{creator}, #{createTime})")
	int saveUser(User user);

	/**
	 * @Title: updateUser 
	 * @Description: 更新用户
	 * @param    User user
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 上午9:38:27 
	 */
	@Update("<script>UPDATE admin_user SET "
			+ "<if test='userName!=null'> user_name = #{userName},</if>  "
			+ "<if test='userEmail!=null'> user_email = #{userEmail},</if> "
			+ "<if test='userPassword!=null'> user_password = #{userPassword},</if> "
			+ "<if test='userRealName!=null'> user_real_name = #{userRealName},</if> "
			+ "<if test='userMobile!=null'> user_mobile = #{userMobile},</if> "
			+ "<if test='roleIDs!=null'> user_role_id = #{roleIDs},</if>"
			+ "<if test='roleNames!=null'> user_role_name = #{roleNames},</if>"
			+ "<if test='userIP!=null'> login_ip = #{userIP},</if>"
			+ "<if test='lastLoginTime!=null'> last_login_time = #{lastLoginTime},</if>"
			+ "<if test='updator!=null'> updator = #{updator},</if>"
			+ "<if test='updateTime!=null'> update_time = #{updateTime}, </if>"
			+ "<if test='userStatus!=null'> login_status = #{userStatus}, </if>"
			+ "user_id = #{userID} "
			+ "WHERE user_id = #{userID}</script>")
	int updateUser(User user);

	/**
	 * @Title: deleteUser 
	 * @Description: 支持批量删除用户
	 * @param    String userIDs
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 上午10:55:28 
	 */
	@Delete("<script>DELETE FROM admin_user WHERE user_id IN <foreach collection='array' item='userID' open='(' separator=',' close=')'>"
			+ "#{userID}</foreach></script>")
	int deleteUser(String[] userIDArray);

	/**@Title: updateUserIP 
	 * @Description: 记录最近一次登陆时间
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月18日 下午4:48:04 
	 */
	@Update("UPDATE admin_user SET login_ip = #{userIP}, last_login_time = #{time} "
			+ "WHERE user_id = #{userID}")
	int updateUserIP(PageData pd);
	
}
