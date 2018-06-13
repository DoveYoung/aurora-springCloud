package com.aurora.provider.user.entity;

import java.io.Serializable;

/**
 * @Title: Role.java 
 * @Package com.aurora.provider.user.entity 
 * @Description: 角色实体类
 * @author SSY  
 * @date 2018年4月11日 下午2:17:40 
 * @version V1.0
 */
public class Role implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 918381297122716347L;

	/**
	 * 角色id
	 */
	private Integer roleID;
	
	/**
	 * 角色名称
	 */
	private String roleName;
	
	/**
	 * 菜单id,逗号分割;
	 */
	private String roleRights;    	 
	
	/**
	 * 角色备注
	 */
	private String roleRemark;    	
	
	
	/**
	 * 角色创建者邮箱
	 */
	private String creator;
	
	/**
	 * 角色创建时间
	 */
	private String createTime;
	
	/**
	 * 角色更新者
	 */
	private String updator;

	/**
	 * 角色更新时间
	 */
	private String updateTime;

	/**
	 * 获取: roleID
	 * @return the roleID
	 */
	public Integer getRoleID() {
		return roleID;
	}

	/**
	 * 设置: roleID
	 * @param roleID the roleID to set
	 */
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	/**
	 * 获取: roleName
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * 设置: roleName
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * 获取: roleRights
	 * @return the roleRights
	 */
	public String getRoleRights() {
		return roleRights;
	}

	/**
	 * 设置: roleRights
	 * @param roleRights the roleRights to set
	 */
	public void setRoleRights(String roleRights) {
		this.roleRights = roleRights;
	}

	/**
	 * 获取: roleRemark
	 * @return the roleRemark
	 */
	public String getRoleRemark() {
		return roleRemark;
	}

	/**
	 * 设置: roleRemark
	 * @param roleRemark the roleRemark to set
	 */
	public void setRoleRemark(String roleRemark) {
		this.roleRemark = roleRemark;
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
		return "Role [roleID=" + roleID + ", roleName=" + roleName + ", roleRights=" + roleRights + ", roleRemark="
				+ roleRemark + ", creator=" + creator + ", createTime=" + createTime + ", updator=" + updator
				+ ", updateTime=" + updateTime + "]";
	}
	 
	
	
}
