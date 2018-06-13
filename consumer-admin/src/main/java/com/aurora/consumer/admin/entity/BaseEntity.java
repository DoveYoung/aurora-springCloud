/**@Title: BaseEntity.java 
 * @Package com.aurora.consumer.admin.entity 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author SSY   
 * @date 2018年4月12日 
 * @date 2018年4月12日 上午10:59:31 
 * @version V1.0   
 */
package com.aurora.consumer.admin.entity;

/**
 * @Title: BaseEntity.java 
 * @Package com.aurora.consumer.admin.entity 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author SSY  
 * @date 2018年4月12日 上午10:59:31 
 * @version V1.0  
 */
public class BaseEntity {
	
	/**
	 * 返回值是否回调,默认没有回调
	 */
	private Boolean fallBack = Boolean.FALSE;

	/**
	 * 获取: exception
	 * @return the exception
	 */
	public Boolean getFallBack() {
		return fallBack;
	}

	/**
	 * 设置: exception
	 * @param exception the exception to set
	 */
	public void setFallBack(Boolean fallBack) {
		this.fallBack = fallBack;
	}
}
