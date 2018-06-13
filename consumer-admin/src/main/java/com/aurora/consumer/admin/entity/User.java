package com.aurora.consumer.admin.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Title: User.java 
 * @Package com.aurora.consumer.admin.entity 
 * @Description: 用户实体类
 * @author SSY  
 * @date 2018年4月11日 下午12:11:23 
 * @version V1.0
 */
public class User extends BaseEntity implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7489556304808078204L;

	/**
	 * 用户ID
	 */
	private Integer userID;					
	
	/**
	 * 用户姓名
	 */
	private String userRealName;	
	
	/**
	 * 用户昵称名
	 */
	private String userName;			
	
	/**
	 * 手机号
	 */
	private String userMobile;				
	
	/**
	 * 密码
	 */
	private String userPassword;	 
	
	/**
	 * 用户盐值
	 */
	private String salt;		
	
	/**
	 * 邮箱
	 */
	private String userEmail;				
	
	/**
	 * 角色,多对多
	 */
	private String roleIDs;	
	/**
	 * 角色名称,多对多
	 */
	private String roleNames;	

	/**
	 * 权限
	 */
	private String userRights;	
	
	/**
	 * 用户登陆IP
	 */
	private String userIP;			
	
	/**
	 * 用户状态
	 */
	private Integer userStatus;	
	
	/**
	 * 最后登陆时间
	 */
	private String lastLoginTime;	 
	
	/**
	 * 创建者
	 */
	private String creator;
	
	/**
	 * 创建时间
	 */
	private String createTime;			 
	
	/**
	 * 更新者
	 */
	private String updator;
	
	/**
	 * 更新时间
	 */
	private String updateTime;	
	
	
	/**
	 * 角色,多对多
	 */
	private List<Role> roleList;

	/**
	 * 获取: userID
	 * @return the userID
	 */
	public Integer getUserID() {
		return userID;
	}


	/**
	 * 获取: roleNames
	 * @return the roleNames
	 */
	public String getRoleNames() {
		return roleNames;
	}

	/**
	 * 设置: roleNames
	 * @param roleNames the roleNames to set
	 */
	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}
	
	/**
	 * 设置: userID
	 * @param userID the userID to set
	 */
	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	/**
	 * 获取: userRealName
	 * @return the userRealName
	 */
	public String getUserRealName() {
		return userRealName;
	}

	/**
	 * 设置: userRealName
	 * @param userRealName the userRealName to set
	 */
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	/**
	 * 获取: userName
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置: userName
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取: userMobile
	 * @return the userMobile
	 */
	public String getUserMobile() {
		return userMobile;
	}

	/**
	 * 设置: userMobile
	 * @param userMobile the userMobile to set
	 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	/**
	 * 获取: userPassword
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * 设置: userPassword
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * 获取: salt
	 * @return the salt
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * 设置: salt
	 * @param salt the salt to set
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * 获取: userEmail
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * 设置: userEmail
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * 获取: roleIDs
	 * @return the roleIDs
	 */
	public String getRoleIDs() {
		return roleIDs;
	}

	/**
	 * 设置: roleIDs
	 * @param roleIDs the roleIDs to set
	 */
	public void setRoleIDs(String roleIDs) {
		this.roleIDs = roleIDs;
	}

	/**
	 * 获取: userRights
	 * @return the userRights
	 */
	public String getUserRights() {
		return userRights;
	}

	/**
	 * 设置: userRights
	 * @param userRights the userRights to set
	 */
	public void setUserRights(String userRights) {
		this.userRights = userRights;
	}

	/**
	 * 获取: userIP
	 * @return the userIP
	 */
	public String getUserIP() {
		return userIP;
	}

	/**
	 * 设置: userIP
	 * @param userIP the userIP to set
	 */
	public void setUserIP(String userIP) {
		this.userIP = userIP;
	}

	/**
	 * 获取: userStatus
	 * @return the userStatus
	 */
	public Integer getUserStatus() {
		return userStatus;
	}

	/**
	 * 设置: userStatus
	 * @param userStatus the userStatus to set
	 */
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	/**
	 * 获取: userLastLoginTime
	 * @return the userLastLoginTime
	 */
	public String getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * 设置: userLastLoginTime
	 * @param userLastLoginTime the userLastLoginTime to set
	 */
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * 获取: createTime
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * 设置: createTime
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取: roleList
	 * @return the roleList
	 */
	public List<Role> getRoleList() {
		return roleList;
	}

	/**
	 * 设置: roleList
	 * @param roleList the roleList to set
	 */
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	/**
	 * 获取: creator
	 * @return the creator
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * 设置: creator
	 * @param creator the creator to set
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	/**
	 * 获取: updator
	 * @return the updator
	 */
	public String getUpdator() {
		return updator;
	}

	/**
	 * 设置: updator
	 * @param updator the updator to set
	 */
	public void setUpdator(String updator) {
		this.updator = updator;
	}

	/**
	 * 获取: updateTime
	 * @return the updateTime
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置: updateTime
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userRealName=" + userRealName + ", userName=" + userName + ", userMobile="
				+ userMobile + ", userPassword=" + userPassword + ", salt=" + salt + ", userEmail=" + userEmail
				+ ", roleIDs=" + roleIDs + ", userRights=" + userRights + ", userIP=" + userIP + ", userStatus="
				+ userStatus + ", userLastLoginTime=" + lastLoginTime + ", createTime=" + createTime + ", roleList="
				+ roleList + "]";
	}			 
	 
		
}
