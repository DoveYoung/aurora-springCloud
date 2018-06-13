package com.aurora.consumer.admin.entity;

import java.io.Serializable;

import com.aurora.consumer.admin.util.Tools;

public class GoodsProperty implements Serializable{
	
	/** 商品管理信息类
	 * @author SSY 2017-12-5
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;
		/**
		 *   商品ID
		 */
		private String goodsID;	
		/**
		 *   商品名称
		 */
		private String goodsName;	
		/**
		 *   商品描述,副标题
		 */
		private String goodsDescribe;
		/**
		 *   商品条码
		 */ 
		private String goodsCode;
		/**
		 *  商品品牌id
		 */ 
		private Integer  brandID;	
		/**
		 *  商品品牌名中文
		 */ 
		private String  brandCname;
		/**
		 *  商品品牌名英文
		 */ 
		private String  brandEname;
		/**
		 *  商品贸易类型
		 */  
		private Integer  tradeType;
		/**
		 *  商品贸易类型中文名称
		 */  
		private String tradeTypeName;	
		/**
		 * 商品国家  原产地
		 */ 
		private String productArea;	
		/**
		 *  商品所属一级类目id
		 */  
		private Integer category1ID;
		/**
		 *  商品所属一级类目名
		 */ 
		private String category1Name;
		/**
		 *  商品所属二级类目id
		 */  
		private Integer category2ID;
		/**
		 *  商品所属二级类目名
		 */ 
		private String category2Name;
		/**
		 *  商品所属三级类目id
		 */  
		private Integer category3ID;
		/**
		 *  商品所属三级类目名
		 */ 
		private String category3Name;
		/**
		 * 商品关键词字符串拼接;
		 */
		private String keywords;
		/**
		 *  商品关键字1
		 */  
		private String keyword1;
		/**
		 *  商品关键字2
		 */  
		private String keyword2;
		/**
		 *  商品关键字3
		 */  
		private String keyword3;
		/**
		 *  商品关键字4
		 */  
		private String keyword4;
		/**
		 *  商品关键字5
		 */  
		private String keyword5;
		/**
		 *  商品体积
		 */  
		private String volume;				 
		/**
		 *  商品属性
		 */ 
		private String property;				 
		/**
		 *  商品六面图
		 */ 
		private String map6;					 
		/**
		 *   商品广告图
		 */ 
		private String advertiseMap;				 
		/**
		 *  商品主图
		 */ 
		private String mainMap;
		/**
		 * 获取: goodsID
		 * @return the goodsID
		 */
		public String getGoodsID() {
			return goodsID;
		}
		/**
		 * 设置: goodsID
		 * @param goodsID the goodsID to set
		 */
		public void setGoodsID(String goodsID) {
			this.goodsID = goodsID;
		}
		/**
		 * 获取: goodsName
		 * @return the goodsName
		 */
		public String getGoodsName() {
			return goodsName;
		}
		/**
		 * 设置: goodsName
		 * @param goodsName the goodsName to set
		 */
		public void setGoodsName(String goodsName) {
			this.goodsName = goodsName;
		}
		/**
		 * 获取: goodsDescribe
		 * @return the goodsDescribe
		 */
		public String getGoodsDescribe() {
			return goodsDescribe;
		}
		/**
		 * 设置: goodsDescribe
		 * @param goodsDescribe the goodsDescribe to set
		 */
		public void setGoodsDescribe(String goodsDescribe) {
			this.goodsDescribe = goodsDescribe;
		}
		/**
		 * 获取: goodsCode
		 * @return the goodsCode
		 */
		public String getGoodsCode() {
			return goodsCode;
		}
		/**
		 * 设置: goodsCode
		 * @param goodsCode the goodsCode to set
		 */
		public void setGoodsCode(String goodsCode) {
			this.goodsCode = goodsCode;
		}
		/**
		 * 获取: brandID
		 * @return the brandID
		 */
		public Integer getBrandID() {
			return brandID;
		}
		/**
		 * 设置: brandID
		 * @param brandID the brandID to set
		 */
		public void setBrandID(Integer brandID) {
			this.brandID = brandID;
		}
		/**
		 * 获取: tradeType
		 * @return the tradeType
		 */
		public Integer getTradeType() {
			return tradeType;
		}
		/**
		 * 设置: tradeType
		 * @param tradeType the tradeType to set
		 */
		public void setTradeType(Integer tradeType) {
			this.tradeType = tradeType;
		}
		/**
		 * 获取: tradeTypeName
		 * @return the tradeTypeName
		 */
		public String getTradeTypeName() {
			return tradeTypeName;
		}
		/**
		 * 设置: tradeTypeName
		 * @param tradeTypeName the tradeTypeName to set
		 */
		public void setTradeTypeName(String tradeTypeName) {
			this.tradeTypeName = tradeTypeName;
		}
		/**
		 * 获取: productArea
		 * @return the productArea
		 */
		public String getProductArea() {
			return productArea;
		}
		/**
		 * 设置: productArea
		 * @param productArea the productArea to set
		 */
		public void setProductArea(String productArea) {
			this.productArea = productArea;
		}
		/**
		 * 获取: category1ID
		 * @return the category1ID
		 */
		public Integer getCategory1ID() {
			return category1ID;
		}
		/**
		 * 设置: category1ID
		 * @param category1id the category1ID to set
		 */
		public void setCategory1ID(Integer category1id) {
			category1ID = category1id;
		}
		/**
		 * 获取: category1Name
		 * @return the category1Name
		 */
		public String getCategory1Name() {
			return category1Name;
		}
		/**
		 * 设置: category1Name
		 * @param category1Name the category1Name to set
		 */
		public void setCategory1Name(String category1Name) {
			this.category1Name = category1Name;
		}
		/**
		 * 获取: category2ID
		 * @return the category2ID
		 */
		public Integer getCategory2ID() {
			return category2ID;
		}
		/**
		 * 设置: category2ID
		 * @param category2id the category2ID to set
		 */
		public void setCategory2ID(Integer category2id) {
			category2ID = category2id;
		}
		/**
		 * 获取: category2Name
		 * @return the category2Name
		 */
		public String getCategory2Name() {
			return category2Name;
		}
		/**
		 * 设置: category2Name
		 * @param category2Name the category2Name to set
		 */
		public void setCategory2Name(String category2Name) {
			this.category2Name = category2Name;
		}
		/**
		 * 获取: category3ID
		 * @return the category3ID
		 */
		public Integer getCategory3ID() {
			return category3ID;
		}
		/**
		 * 设置: category3ID
		 * @param category3id the category3ID to set
		 */
		public void setCategory3ID(Integer category3id) {
			category3ID = category3id;
		}
		/**
		 * 获取: category3Name
		 * @return the category3Name
		 */
		public String getCategory3Name() {
			return category3Name;
		}
		/**
		 * 设置: category3Name
		 * @param category3Name the category3Name to set
		 */
		public void setCategory3Name(String category3Name) {
			this.category3Name = category3Name;
		}
		
		/**
		 * 获取: keywords
		 * @return the keywords
		 */
		public String getKeywords() {
			this.keywords = "";
			if (Tools.notEmpty(keyword1)) {
				this.keywords = this.keywords + keyword1 ;
			}
			if (Tools.notEmpty(keyword2)) {
				this.keywords = this.keywords + "," + keyword2 ;
			}
			if (Tools.notEmpty(keyword3)) {
				this.keywords = this.keywords + "," + keyword3 ;
			}
			if (Tools.notEmpty(keyword4)) {
				this.keywords = this.keywords + "," + keyword4 ;
			}
			if (Tools.notEmpty(keyword5)) {
				this.keywords = this.keywords + "," + keyword5;
			}
			return keywords;
		}
		/**
		 * 设置: keywords
		 * @param keywords the keywords to set
		 */
		public void setKeywords(String keywords) {
			String[] split = keywords.split(",");
			int length = Tools.notEmpty(keywords)?split.length:0;
			switch (length) {
			case 1:
				this.keyword1 = split[0];
				break;
			case 2:
				this.keyword1 = split[0];
				this.keyword2 = split[1];
				break;
			case 3:
				this.keyword1 = split[0];
				this.keyword2 = split[1];
				this.keyword3 = split[2];
				break;
			case 4:
				this.keyword1 = split[0];
				this.keyword2 = split[1];
				this.keyword3 = split[2];
				this.keyword4 = split[3];
				break;
			case 5:
				this.keyword1 = split[0];
				this.keyword2 = split[1];
				this.keyword3 = split[2];
				this.keyword4 = split[3];
				this.keyword5 = split[4];
				break;
			default:
				break;
			}
		}
		/**
		 * 获取: keyword1
		 * @return the keyword1
		 */
		public String getKeyword1() {
			return keyword1;
		}
		/**
		 * 设置: keyword1
		 * @param keyword1 the keyword1 to set
		 */
		public void setKeyword1(String keyword1) {
			this.keyword1 = keyword1;
		}
		/**
		 * 获取: keyword2
		 * @return the keyword2
		 */
		public String getKeyword2() {
			return keyword2;
		}
		/**
		 * 设置: keyword2
		 * @param keyword2 the keyword2 to set
		 */
		public void setKeyword2(String keyword2) {
			this.keyword2 = keyword2;
		}
		/**
		 * 获取: keyword3
		 * @return the keyword3
		 */
		public String getKeyword3() {
			return keyword3;
		}
		/**
		 * 设置: keyword3
		 * @param keyword3 the keyword3 to set
		 */
		public void setKeyword3(String keyword3) {
			this.keyword3 = keyword3;
		}
		/**
		 * 获取: keyword4
		 * @return the keyword4
		 */
		public String getKeyword4() {
			return keyword4;
		}
		/**
		 * 设置: keyword4
		 * @param keyword4 the keyword4 to set
		 */
		public void setKeyword4(String keyword4) {
			this.keyword4 = keyword4;
		}
		/**
		 * 获取: keyword5
		 * @return the keyword5
		 */
		public String getKeyword5() {
			return keyword5;
		}
		/**
		 * 设置: keyword5
		 * @param keyword5 the keyword5 to set
		 */
		public void setKeyword5(String keyword5) {
			this.keyword5 = keyword5;
		}
		/**
		 * 获取: volume
		 * @return the volume
		 */
		public String getVolume() {
			return volume;
		}
		/**
		 * 设置: volume
		 * @param volume the volume to set
		 */
		public void setVolume(String volume) {
			this.volume = volume;
		}
		/**
		 * 获取: property
		 * @return the property
		 */
		public String getProperty() {
			return property;
		}
		/**
		 * 设置: property
		 * @param property the property to set
		 */
		public void setProperty(String property) {
			this.property = property;
		}
		/**
		 * 获取: map6
		 * @return the map6
		 */
		public String getMap6() {
			return map6;
		}
		/**
		 * 设置: map6
		 * @param map6 the map6 to set
		 */
		public void setMap6(String map6) {
			this.map6 = map6;
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
		 * 获取: mainMap
		 * @return the mainMap
		 */
		public String getMainMap() {
			return mainMap;
		}
		/**
		 * 设置: mainMap
		 * @param mainMap the mainMap to set
		 */
		public void setMainMap(String mainMap) {
			this.mainMap = mainMap;
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
		 		 
		 
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "GoodsProperty [goodsID=" + goodsID + ", goodsName=" + goodsName + ", goodsDescribe=" + goodsDescribe
					+ ", goodsCode=" + goodsCode + ", brandID=" + brandID + ", brandCname=" + brandCname
					+ ", brandEname=" + brandEname + ", tradeType=" + tradeType + ", tradeTypeName=" + tradeTypeName
					+ ", productArea=" + productArea + ", category1ID=" + category1ID + ", category1Name="
					+ category1Name + ", category2ID=" + category2ID + ", category2Name=" + category2Name
					+ ", category3ID=" + category3ID + ", category3Name=" + category3Name + ", keyword1=" + keyword1
					+ ", keyword2=" + keyword2 + ", keyword3=" + keyword3 + ", keyword4=" + keyword4 + ", keyword5="
					+ keyword5 + ", volume=" + volume + ", property=" + property + ", map6=" + map6 + ", advertiseMap="
					+ advertiseMap + ", mainMap=" + mainMap + ", getGoodsID()=" + getGoodsID() + ", getGoodsName()="
					+ getGoodsName() + ", getGoodsDescribe()=" + getGoodsDescribe() + ", getGoodsCode()="
					+ getGoodsCode() + ", getBrandID()=" + getBrandID() + ", getTradeType()=" + getTradeType()
					+ ", getTradeTypeName()=" + getTradeTypeName() + ", getProductArea()=" + getProductArea()
					+ ", getCategory1ID()=" + getCategory1ID() + ", getCategory1Name()=" + getCategory1Name()
					+ ", getCategory2ID()=" + getCategory2ID() + ", getCategory2Name()=" + getCategory2Name()
					+ ", getCategory3ID()=" + getCategory3ID() + ", getCategory3Name()=" + getCategory3Name()
					+ ", getKeyword1()=" + getKeyword1() + ", getKeyword2()=" + getKeyword2() + ", getKeyword3()="
					+ getKeyword3() + ", getKeyword4()=" + getKeyword4() + ", getKeyword5()=" + getKeyword5()
					+ ", getVolume()=" + getVolume() + ", getProperty()=" + getProperty() + ", getMap6()=" + getMap6()
					+ ", getAdvertiseMap()=" + getAdvertiseMap() + ", getMainMap()=" + getMainMap()
					+ ", getBrandCname()=" + getBrandCname() + ", getBrandEname()=" + getBrandEname() + "]";
		}
		
		

}
