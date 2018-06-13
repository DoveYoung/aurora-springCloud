package com.aurora.consumer.admin.entity;

import java.io.Serializable;

/** 操作信息记录类
 * @author BYG 2017-12-8
 * @version 1.0
 */
public class OperationRecord implements Serializable{
	
		private static final long serialVersionUID = 1L;
		/**
		 *   取系统时间为key
		 */
		private String timeKey;	
		/**
		 *   用户id
		 */
		private String userID;	
		/**
		 *   用户邮箱账号
		 */
		private String userEmail;
		/**
		 *   用户本地主机地址
		 */ 
		private String host;
		/**
		 *  用户访问路径
		 */ 
		private String path;	
		/**
		 *  用户访问参数
		 */ 
		private String  parameter;
		/**
		 * 返回 timeKey
		 * @return the timeKey
		 */
		public String getTimeKey() {
			return timeKey;
		}
		/**
		 * 设置 timeKey
		 * @param timeKey the timeKey to set
		 */
		public void setTimeKey(String timeKey) {
			this.timeKey = timeKey;
		}
		/**
		 * 返回 userID
		 * @return the userID
		 */
		public String getUserID() {
			return userID;
		}
		/**
		 * 设置 userID
		 * @param userID the userID to set
		 */
		public void setUserID(String userID) {
			this.userID = userID;
		}
		/**
		 * 返回 userEmail
		 * @return the userEmail
		 */
		public String getUserEmail() {
			return userEmail;
		}
		/**
		 * 设置 userEmail
		 * @param userEmail the userEmail to set
		 */
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		/**
		 * 返回 host
		 * @return the host
		 */
		public String getHost() {
			return host;
		}
		/**
		 * 设置 host
		 * @param host the host to set
		 */
		public void setHost(String host) {
			this.host = host;
		}
		/**
		 * 返回 path
		 * @return the path
		 */
		public String getPath() {
			return path;
		}
		/**
		 * 设置 path
		 * @param path the path to set
		 */
		public void setPath(String path) {
			this.path = path;
		}
		/**
		 * 返回 parameter
		 * @return the parameter
		 */
		public String getParameter() {
			return parameter;
		}
		/**
		 * 设置 parameter
		 * @param parameter the parameter to set
		 */
		public void setParameter(String parameter) {
			this.parameter = parameter;
		}
		/**
		 * 返回 serialversionuid
		 * @return the serialversionuid
		 */
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "OperationRecord [timeKey=" + timeKey + ", userID=" + userID + ", userEmail=" + userEmail + ", host="
					+ host + ", path=" + path + ", parameter=" + parameter + ", getTimeKey()=" + getTimeKey()
					+ ", getUserID()=" + getUserID() + ", getUserEmail()=" + getUserEmail() + ", getHost()=" + getHost()
					+ ", getPath()=" + getPath() + ", getParameter()=" + getParameter() + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}
 
}
