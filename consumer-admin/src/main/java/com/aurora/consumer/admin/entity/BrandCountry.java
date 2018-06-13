package com.aurora.consumer.admin.entity;

import java.io.Serializable;

public class BrandCountry implements Serializable{
	
	/** 
	 * 国家类
	 * @author SSY 2017-12-5
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;
		/**
		 *   国家ID
		 */
		private String countryID;	
		/**
		 * 国家名称英文
		 */
		private String countryEname;	
		/**
		 *  国家名称中文
		 */
		private String countryCname;
		/**
		 * 国家国旗(云地址)
		 */ 
		private String nationalFlag;
		/**
		 * 获取: countryID
		 * @return the countryID
		 */
		public String getCountryID() {
			return countryID;
		}
		/**
		 * 设置: countryID
		 * @param countryID the countryID to set
		 */
		public void setCountryID(String countryID) {
			this.countryID = countryID;
		}
		/**
		 * 获取: countryEname
		 * @return the countryEname
		 */
		public String getCountryEname() {
			return countryEname;
		}
		/**
		 * 设置: countryEname
		 * @param countryEname the countryEname to set
		 */
		public void setCountryEname(String countryEname) {
			this.countryEname = countryEname;
		}
		/**
		 * 获取: countryCname
		 * @return the countryCname
		 */
		public String getCountryCname() {
			return countryCname;
		}
		/**
		 * 设置: countryCname
		 * @param countryCname the countryCname to set
		 */
		public void setCountryCname(String countryCname) {
			this.countryCname = countryCname;
		}
		/**
		 * 获取: nationalFlag
		 * @return the nationalFlag
		 */
		public String getNationalFlag() {
			return nationalFlag;
		}
		/**
		 * 设置: nationalFlag
		 * @param nationalFlag the nationalFlag to set
		 */
		public void setNationalFlag(String nationalFlag) {
			this.nationalFlag = nationalFlag;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "BrandCountry [countryID=" + countryID + ", countryEname=" + countryEname + ", countryCname="
					+ countryCname + ", nationalFlag=" + nationalFlag + ", getCountryID()=" + getCountryID()
					+ ", getCountryEname()=" + getCountryEname() + ", getCountryCname()=" + getCountryCname()
					+ ", getNationalFlag()=" + getNationalFlag() + "]";
		}
	 
		 
}
