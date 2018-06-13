package com.aurora.consumer.admin.entity;

import java.io.Serializable;

/** 
 * 商品管理信息类
 * @author SSY 2017-12-5
 * @version 1.0
 */
public class Brand implements Serializable{
	
	
		private static final long serialVersionUID = 1L;
		/**
		 *   品牌ID
		 */
		private String brandID;	
		/**
		 *   品牌名称
		 */
		private String brandCname;	
		/**
		 *   品牌英文名称
		 */
		private String brandEname;
		/**
		 *   品牌类目id
		 */ 
		private String brandCategoryID;
		/**
		 *  品牌最小购买金额
		 */ 
		private Double minBuy;	
		/**
		 *  品牌主图
		 */ 
		private String  brandMap;	
		/**
		 *  品牌广告图
		 */ 
		private String  advertiseMap;
		/**
		 *  品牌推荐图
		 */  
		private String recommendMap;
		/**
		 *  品牌国家id
		 */  
		private String countryID;
		/**
		 *  品牌在售商家数
		 */  
		private int sellStoreNum;
		/**
		 *  品牌关注数
		 */  
		private int careNum;
		/**
		 * 品牌描述1
		 */ 
		private String brandDescribe1;	
		/**
		 *  品牌描述2
		 */  
		private String brandDescribe2;
		
		/**
		 *  品牌创建者
		 */ 
		private String createOperator;
		/**
		 *  品牌创建时间
		 */  
		private String createTime;
		/**
		 *  品牌修改者 
		 */ 
		private String updateOperator;
		/**
		 * 品牌修改时间
		 */  
		private String updateTime;
		/**
		 * 品牌
		 */  
		private BrandCountry brandCountry;
		/**
		 * 获取: brandID
		 * @return the brandID
		 */
		public String getBrandID() {
			return brandID;
		}
		/**
		 * 设置: brandID
		 * @param brandID the brandID to set
		 */
		public void setBrandID(String brandID) {
			this.brandID = brandID;
		}
		/**
		 * 获取: brandCname
		 * @return the brandCname
		 */
		public String getBrandCname() {
			return brandCname;
		}
		/**
		 * 设置: brandCname
		 * @param brandCname the brandCname to set
		 */
		public void setBrandCname(String brandCname) {
			this.brandCname = brandCname;
		}
		/**
		 * 获取: brandEname
		 * @return the brandEname
		 */
		public String getBrandEname() {
			return brandEname;
		}
		/**
		 * 设置: brandEname
		 * @param brandEname the brandEname to set
		 */
		public void setBrandEname(String brandEname) {
			this.brandEname = brandEname;
		}
		/**
		 * 获取: brandCategoryID
		 * @return the brandCategoryID
		 */
		public String getBrandCategoryID() {
			return brandCategoryID;
		}
		/**
		 * 设置: brandCategoryID
		 * @param brandCategoryID the brandCategoryID to set
		 */
		public void setBrandCategoryID(String brandCategoryID) {
			this.brandCategoryID = brandCategoryID;
		}
		/**
		 * 获取: brandMap
		 * @return the brandMap
		 */
		public String getBrandMap() {
			return brandMap;
		}
		/**
		 * 设置: brandMap
		 * @param brandMap the brandMap to set
		 */
		public void setBrandMap(String brandMap) {
			this.brandMap = brandMap;
		}
		/**
		 * 获取: advertiseMap
		 * @return the advertiseMap
		 */
		public String getAdvertiseMap() {
			return advertiseMap;
		}
		/**
		 * 设置: advertiseMap
		 * @param advertiseMap the advertiseMap to set
		 */
		public void setAdvertiseMap(String advertiseMap) {
			this.advertiseMap = advertiseMap;
		}
		/**
		 * 获取: recommendMap
		 * @return the recommendMap
		 */
		public String getRecommendMap() {
			return recommendMap;
		}
		/**
		 * 设置: recommendMap
		 * @param recommendMap the recommendMap to set
		 */
		public void setRecommendMap(String recommendMap) {
			this.recommendMap = recommendMap;
		}
		/**
		 * 获取: brandDescribe1
		 * @return the brandDescribe1
		 */
		public String getBrandDescribe1() {
			return brandDescribe1;
		}
		/**
		 * 设置: brandDescribe1
		 * @param brandDescribe1 the brandDescribe1 to set
		 */
		public void setBrandDescribe1(String brandDescribe1) {
			this.brandDescribe1 = brandDescribe1;
		}
		/**
		 * 获取: brandDescribe2
		 * @return the brandDescribe2
		 */
		public String getBrandDescribe2() {
			return brandDescribe2;
		}
		/**
		 * 设置: brandDescribe2
		 * @param brandDescribe2 the brandDescribe2 to set
		 */
		public void setBrandDescribe2(String brandDescribe2) {
			this.brandDescribe2 = brandDescribe2;
		}
		/**
		 * 获取: createOperator
		 * @return the createOperator
		 */
		public String getCreateOperator() {
			return createOperator;
		}
		/**
		 * 设置: createOperator
		 * @param createOperator the createOperator to set
		 */
		public void setCreateOperator(String createOperator) {
			this.createOperator = createOperator;
		}
		/**
		 * 获取: updateOperator
		 * @return the updateOperator
		 */
		public String getUpdateOperator() {
			return updateOperator;
		}
		/**
		 * 设置: updateOperator
		 * @param updateOperator the updateOperator to set
		 */
		public void setUpdateOperator(String updateOperator) {
			this.updateOperator = updateOperator;
		}
		/**
		 * 获取: minBuy
		 * @return the minBuy
		 */
		public Double getMinBuy() {
			return minBuy;
		}
		/**
		 * 设置: minBuy
		 * @param minBuy the minBuy to set
		 */
		public void setMinBuy(Double minBuy) {
			this.minBuy = minBuy;
		}
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
		 * 获取: sellStoreNum
		 * @return the sellStoreNum
		 */
		public int getSellStoreNum() {
			return sellStoreNum;
		}
		/**
		 * 设置: sellStoreNum
		 * @param sellStoreNum the sellStoreNum to set
		 */
		public void setSellStoreNum(int sellStoreNum) {
			this.sellStoreNum = sellStoreNum;
		}
		/**
		 * 获取: careNum
		 * @return the careNum
		 */
		public int getCareNum() {
			return careNum;
		}
		/**
		 * 设置: careNum
		 * @param careNum the careNum to set
		 */
		public void setCareNum(int careNum) {
			this.careNum = careNum;
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
		/**
		 * 获取: brandCountry
		 * @return the brandCountry
		 */
		public BrandCountry getBrandCountry() {
			return brandCountry;
		}
		/**
		 * 设置: brandCountry
		 * @param brandCountry the brandCountry to set
		 */
		public void setBrandCountry(BrandCountry brandCountry) {
			this.brandCountry = brandCountry;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Brand [brandID=" + brandID + ", brandCname=" + brandCname + ", brandEname=" + brandEname
					+ ", brandCategoryID=" + brandCategoryID + ", minBuy=" + minBuy + ", brandMap=" + brandMap
					+ ", advertiseMap=" + advertiseMap + ", recommendMap=" + recommendMap + ", countryID=" + countryID
					+ ", sellStoreNum=" + sellStoreNum + ", careNum=" + careNum + ", brandDescribe1=" + brandDescribe1
					+ ", brandDescribe2=" + brandDescribe2 + ", createOperator=" + createOperator + ", createTime="
					+ createTime + ", updateOperator=" + updateOperator + ", updateTime=" + updateTime
					+ ", brandCountry=" + brandCountry + ", getBrandID()=" + getBrandID() + ", getBrandCname()="
					+ getBrandCname() + ", getBrandEname()=" + getBrandEname() + ", getBrandCategoryID()="
					+ getBrandCategoryID() + ", getBrandMap()=" + getBrandMap() + ", getAdvertiseMap()="
					+ getAdvertiseMap() + ", getRecommendMap()=" + getRecommendMap() + ", getBrandDescribe1()="
					+ getBrandDescribe1() + ", getBrandDescribe2()=" + getBrandDescribe2() + ", getCreateOperator()="
					+ getCreateOperator() + ", getUpdateOperator()=" + getUpdateOperator() + ", getMinBuy()="
					+ getMinBuy() + ", getCountryID()=" + getCountryID() + ", getSellStoreNum()=" + getSellStoreNum()
					+ ", getCareNum()=" + getCareNum() + ", getCreateTime()=" + getCreateTime() + ", getUpdateTime()="
					+ getUpdateTime() + ", getBrandCountry()=" + getBrandCountry() + "]";
		}
		
		 
}
