package com.aurora.consumer.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class GoodsManage implements Serializable{
	
	/** 商品管理信息类
	 * @author SSY 2017-12-7
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;
		/**
		 *  商品管理ID
		 */
		private Integer manageID;		
		/**
		 *   商品ID
		 */
		private String goodsID;	
		/**
		 *   关联商品ID
		 */
		private String relate1GID;	
		/**
		 *   关联商品ID
		 */
		private String relate2GID;
		/**
		 *   关联商品ID
		 */ 
		private String relate3GID;
		/**
		 *  商品重量
		 */ 
		private BigDecimal  weight;
		/**
		 *  商品单位;
		 */ 
		private String  currencyUnit;
		/**
		 *  商品一段价格
		 */ 
		private BigDecimal  goodsPrice1;
		/**
		 *  商品二段价格
		 */  
		private BigDecimal  goodsPrice2;
		/**
		 *  商品1段数量
		 */  
		private Integer rnum1;	
		/**
		 * 商品2段数量  
		 */ 
		private Integer rnum2;	
		/**
		 *  商品3段数量
		 */  
		private Integer rnum3;
		/**
		 *  商品规格 
		 */ 
		private String norm;
		/**
		 *  市场价格 
		 */ 
		private BigDecimal  marketPrice;
		/**
		 *  京东价格
		 */  
		private BigDecimal  jdPrice;
		/**
		 *   淘宝价格
		 */  
		private BigDecimal  tbPrice;
		/**
		 *  淘宝在售商家
		 */  
		private Integer sellStoreNum;				 
		/**
		 *  商品真实累计销量
		 */ 
		private Integer goodsSales;				 
		/**
		 *  商品假销量
		 */ 
		private Integer fakeSales;					 
		/**
		 *   商品状态：0未完成录入（草稿）；1录入完成；2审核中；3审核通过；4上架；5下架
		 */ 
		private Integer goodsState;				 
		/**
		 *  商品录入者
		 */ 
		private String inputer;					 
		/**
		 * 商品审核者
		 */  
		private String reviewer;				 
		/**
		 *  商品假库存量
		 */ 
		private Integer fakeStock;					 
		/**
		 *  商品库存库存预警量
		 */ 
		private Integer stockEmergency;	
		/**
		 *  到达预警量时间
		 */ 
		private Integer emergencyTime;		
		/**
		 *  定金支付,100全款
		 */ 
		private Integer deposit;					 
		/**
		 * 邮费:0包邮；1不包邮
		 */ 
		private Integer  postageStyle;				 
		/**
		 *  商品录入时间
		 */ 
		private String inputTime;				 
		/**
		 *  商品提交审核时间
		 */ 
		private String submitTime;				 
		/**
		 * 商品审核通过时间
		 */ 
		private String reviewTime;				 
		/**
		 *  商品上架时间
		 */ 
		private String upTime;					 
		/**
		 *  商品下架时间
		 */ 
		private String downTime;				 
		/**
		 *  上架次数;
		 */ 
		private Integer upNum;					 
		/**
		 * 备注
		 */ 
		private String remark;					 
		/**
		 *  
		 */ 
		private Integer discount;					 
		/**
		 *  商品成本类型;(1固定成本,2不确定成本)
		 */ 
		private Integer costType;	
		/**
		 * 商品属性
		 */
		private GoodsProperty goodsProperty;
		/**
		 * 排序属性
		 */
		private String orderBY;
		/**
		 * 排序规则;
		 */
		private String orderAD;
		/**
		 *  商品折扣
		 */ 
		public Integer getDiscount() {
			return discount;
		}
		/**
		 *  商品折扣
		 */ 
		public void setDiscount(Integer discount) {
			this.discount = discount;
		}
		/**
		 *  商品管理ID
		 */ 
		public Integer getManageID() {
			return manageID;
		}
		/**
		 *  商品管理ID
		 */ 
		public void setManageID(Integer manageID) {
			this.manageID = manageID;
		}
		/**
		 *  商品ID
		 */ 
		public String getGoodsID() {
			return goodsID;
		}
		/**
		 *  商品ID
		 */ 
		public void setGoodsID(String goodsID) {
			this.goodsID = goodsID;
		}
		/**
		 *  商品关联ID
		 */ 
		public String getRelate1GID() {
			return relate1GID;
		}
		/**
		 *  商品关联ID
		 */ 
		public void setRelate1GID(String relate1gid) {
			relate1GID = relate1gid;
		}
		/**
		 * 商品关联ID
		 */ 
		public String getRelate3GID() {
			return relate3GID;
		}
		/**
		 *  商品关联ID
		 */ 
		public void setRelate3GID(String relate3gid) {
			relate3GID = relate3gid;
		}
		/**
		 *  商品假库库存
		 */ 
		public Integer getFakeStock() {
			return fakeStock;
		}
		/**
		 *  商品假库库存
		 */ 
		public void setFakeStock(Integer fakeStock) {
			this.fakeStock = fakeStock;
		}
		/**
		 *  商品上架次数
		 */ 
		public Integer getUpNum() {
			return upNum;
		}
		/**
		 * 商品上架次数
		 */ 
		public void setUpNum(Integer upNum) {
			this.upNum = upNum;
		}
		/**
		 *  商品成本计算类型
		 */ 
		public Integer getCostType() {
			return costType;
		}
		/**
		 *  商品成本计算类型
		 */ 
		public void setCostType(Integer costType) {
			this.costType = costType;
		}
		/**
		 *  商品关联ID
		 */ 
		public String getRelate2GID() {
			return relate2GID;
		}
		/**
		 *  商品关联ID
		 */ 
		public void setRelate2GID(String relate2gid) {
			relate2GID = relate2gid;
		}
		/**
		 *  商品价格1
		 */ 
		public BigDecimal getGoodsPrice1() {
			return goodsPrice1;
		}
		/**
		 *  商品价格1
		 */ 
		public void setGoodsPrice1(BigDecimal goodsPrice1) {
			this.goodsPrice1 = goodsPrice1;
		}
		/**
		 * 商品价格2
		 */ 
		public BigDecimal getGoodsPrice2() {
			return goodsPrice2;
		}
		/**
		 *  商品价格2
		 */ 
		public void setGoodsPrice2(BigDecimal goodsPrice2) {
			this.goodsPrice2 = goodsPrice2;
		}
		/**
		 * 商品价格1数量
		 */ 
		public Integer getRnum1() {
			return rnum1;
		}
		/**
		 *   商品价格1数量
		 */ 
		public void setRnum1(Integer rnum1) {
			this.rnum1 = rnum1;
		}
		/**
		 *   商品价格2数量
		 */ 
		public Integer getRnum2() {
			return rnum2;
		}
		/**
		 *   商品价格2数量
		 */ 
		public void setRnum2(Integer rnum2) {
			this.rnum2 = rnum2;
		}
		/**
		 *   商品价格3数量
		 */ 
		public Integer getRnum3() {
			return rnum3;
		}
		/**
		 *  商品价格3数量
		 */ 
		public void setRnum3(Integer rnum3) {
			this.rnum3 = rnum3;
		}
		/**
		 *  商品市场价
		 */ 
		public BigDecimal getMarketPrice() {
			return marketPrice;
		}
		/**
		 *  商品市场价
		 */ 
		public void setMarketPrice(BigDecimal marketPrice) {
			this.marketPrice = marketPrice;
		}
		/**
		 *  商品京东价格
		 */ 
		public BigDecimal getJdPrice() {
			return jdPrice;
		}
		/**
		 *  商品京东价格
		 */ 
		public void setJdPrice(BigDecimal jdPrice) {
			this.jdPrice = jdPrice;
		}
		/**
		 *  商品淘宝价格
		 */ 
		public BigDecimal getTbPrice() {
			return tbPrice;
		}
		/**
		 *  商品淘宝价格
		 */ 
		public void setTbPrice(BigDecimal tbPrice) {
			this.tbPrice = tbPrice;
		}
		/**
		 *  商品淘宝在售商家数
		 */ 
		public Integer getSellStoreNum() {
			return sellStoreNum;
		}
		/**
		 *  商品淘宝在售商家数
		 */ 
		public void setSellStoreNum(Integer sellStoreNum) {
			this.sellStoreNum = sellStoreNum;
		}
		/**
		 *  商品真实销量
		 */ 
		public Integer getGoodsSales() {
			return goodsSales;
		}
		/**
		 * 商品真实销量
		 */ 
		public void setGoodsSales(Integer goodsSales) {
			this.goodsSales = goodsSales;
		}
		/**
		 *  商品假销量
		 */ 
		public Integer getFakeSales() {
			return fakeSales;
		}
		/**
		 *  商品假销量
		 */ 
		public void setFakeSales(Integer fakeSales) {
			this.fakeSales = fakeSales;
		}
		/**
		 *  商品重量
		 */ 
		public BigDecimal getWeight() {
			return weight;
		}
		/**
		 *  商品重量
		 */ 
		public void setWeight(BigDecimal weight) {
			this.weight = weight;
		}
		/**
		 *  商品包邮否(1包邮；2不包邮)
		 */ 
		public Integer getPostageStyle() {
			return postageStyle;
		}
		/**
		 *  商品包邮否(1包邮；2不包邮)
		 */ 
		public void setPostageStyle(Integer postageStyle) {
			this.postageStyle = postageStyle;
		}
		/**
		 *  商品状态
		 */ 
		public Integer getGoodsState() {
			return goodsState;
		}
		/**
		 *  商品状态
		 */ 
		public void setGoodsState(Integer goodsState) {
			this.goodsState = goodsState;
		}
		/**
		 * 商品录入者
		 */ 
		public String getInputer() {
			return inputer;
		}
		/**
		 * 商品录入者
		 */ 
		public void setInputer(String inputer) {
			this.inputer = inputer;
		}
		/**
		 *  商品审核者
		 */ 
		public String getReviewer() {
			return reviewer;
		}
		/**
		 *  商品审核者
		 */ 
		public void setReviewer(String reviewer) {
			this.reviewer = reviewer;
		}
		/**
		 * 商品库存预警
		 */
		public Integer getStockEmergency() {
			return stockEmergency;
		}
		/**
		 *   商品库存预警
		 */ 
		public void setStockEmergency(Integer stockEmergency) {
			this.stockEmergency = stockEmergency;
		}
		/**
		 *  商品库存定金否(定金：整数（100表示不支持定金）)
		 */ 
		public Integer getDeposit() {
			return deposit;
		}
		/**
		 *  商品库存定金否(定金：整数（100表示不支持定金）)
		 */ 
		public void setDeposit(Integer deposit) {
			this.deposit = deposit;
		}
		/**
		 *  商品录入时间
		 */ 
		public String getInputTime() {
			return inputTime;
		}
		/**
		 * 商品录入时间
		 */ 
		public void setInputTime(String inputTime) {
			this.inputTime = inputTime;
		}
		/**
		 *  商品提交时间
		 */ 
		public String getSubmitTime() {
			return submitTime;
		}
		/**
		 *   商品提交时间
		 */ 
		public void setSubmitTime(String submitTime) {
			this.submitTime = submitTime;
		}
		/**
		 *   商品审核时间
		 */ 
		public String getReviewTime() {
			return reviewTime;
		}
		/**
		 *   商品审核时间
		 */ 
		public void setReviewTime(String reviewTime) {
			this.reviewTime = reviewTime;
		}
		/**
		 *  商品上架时间
		 */ 
		public String getUpTime() {
			return upTime;
		}
		/**
		 * 商品上架时间
		 */ 
		public void setUpTime(String upTime) {
			this.upTime = upTime;
		}
		/**
		 *  商品下架时间
		 */ 
		public String getDownTime() {
			return downTime;
		}
		/**
		 * 商品下架时间
		 */ 
		public void setDownTime(String downTime) {
			this.downTime = downTime;
		}
		/**
		 *  商品备注
		 */ 
		public String getRemark() {
			return remark;
		}
		/**
		 * 商品备注
		 */ 
		public void setRemark(String remark) {
			this.remark = remark;
		}
		/**
		 * 商品规格
		 */ 
		public String getNorm() {
			return norm;
		}
		/**
		 * 商品规格
		 */ 
		public void setNorm(String norm) {
			this.norm = norm;
		}
		/**
		 * 获取: goodsProperty
		 * @return the goodsProperty
		 */
		public GoodsProperty getGoodsProperty() {
			return goodsProperty;
		}
		/**
		 * 设置: goodsProperty
		 * @param goodsProperty the goodsProperty to set
		 */
		public void setGoodsProperty(GoodsProperty goodsProperty) {
			this.goodsProperty = goodsProperty;
		}
		/**
		 * 获取: currencyUnit
		 * @return the currencyUnit
		 */
		public String getCurrencyUnit() {
			return currencyUnit;
		}
		/**
		 * 设置: currencyUnit
		 * @param currencyUnit the currencyUnit to set
		 */
		public void setCurrencyUnit(String currencyUnit) {
			this.currencyUnit = currencyUnit;
		}
		/**
		 * 获取: orderBY
		 * @return the orderBY
		 */
		public String getOrderBY() {
			return orderBY;
		}
		/**
		 * 设置: orderBY
		 * @param orderBY the orderBY to set
		 */
		public void setOrderBY(String orderBY) {
			this.orderBY = orderBY;
		}
		/**
		 * 获取: orderAD
		 * @return the orderAD
		 */
		public String getOrderAD() {
			return orderAD;
		}
		/**
		 * 设置: orderAD
		 * @param orderAD the orderAD to set
		 */
		public void setOrderAD(String orderAD) {
			this.orderAD = orderAD;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "GoodsManage [manageID=" + manageID + ", goodsID=" + goodsID + ", relate1GID=" + relate1GID
					+ ", relate2GID=" + relate2GID + ", relate3GID=" + relate3GID + ", weight=" + weight
					+ ", currencyUnit=" + currencyUnit + ", goodsPrice1=" + goodsPrice1 + ", goodsPrice2=" + goodsPrice2
					+ ", rnum1=" + rnum1 + ", rnum2=" + rnum2 + ", rnum3=" + rnum3 + ", norm=" + norm + ", marketPrice="
					+ marketPrice + ", jdPrice=" + jdPrice + ", tbPrice=" + tbPrice + ", sellStoreNum=" + sellStoreNum
					+ ", goodsSales=" + goodsSales + ", fakeSales=" + fakeSales + ", goodsState=" + goodsState
					+ ", inputer=" + inputer + ", reviewer=" + reviewer + ", fakeStock=" + fakeStock
					+ ", stockEmergency=" + stockEmergency + ", deposit=" + deposit + ", postageStyle=" + postageStyle
					+ ", inputTime=" + inputTime + ", submitTime=" + submitTime + ", reviewTime=" + reviewTime
					+ ", upTime=" + upTime + ", downTime=" + downTime + ", upNum=" + upNum + ", remark=" + remark
					+ ", discount=" + discount + ", costType=" + costType + ", goodsProperty=" + goodsProperty
					+ ", orderBY=" + orderBY + ", orderAD=" + orderAD + ", getDiscount()=" + getDiscount()
					+ ", getManageID()=" + getManageID() + ", getGoodsID()=" + getGoodsID() + ", getRelate1GID()="
					+ getRelate1GID() + ", getRelate3GID()=" + getRelate3GID() + ", getFakeStock()=" + getFakeStock()
					+ ", getUpNum()=" + getUpNum() + ", getCostType()=" + getCostType() + ", getRelate2GID()="
					+ getRelate2GID() + ", getGoodsPrice1()=" + getGoodsPrice1() + ", getGoodsPrice2()="
					+ getGoodsPrice2() + ", getRnum1()=" + getRnum1() + ", getRnum2()=" + getRnum2() + ", getRnum3()="
					+ getRnum3() + ", getMarketPrice()=" + getMarketPrice() + ", getJdPrice()=" + getJdPrice()
					+ ", getTbPrice()=" + getTbPrice() + ", getSellStoreNum()=" + getSellStoreNum()
					+ ", getGoodsSales()=" + getGoodsSales() + ", getFakeSales()=" + getFakeSales() + ", getWeight()="
					+ getWeight() + ", getPostageStyle()=" + getPostageStyle() + ", getGoodsState()=" + getGoodsState()
					+ ", getInputer()=" + getInputer() + ", getReviewer()=" + getReviewer() + ", getStockEmergency()="
					+ getStockEmergency() + ", getDeposit()=" + getDeposit() + ", getInputTime()=" + getInputTime()
					+ ", getSubmitTime()=" + getSubmitTime() + ", getReviewTime()=" + getReviewTime() + ", getUpTime()="
					+ getUpTime() + ", getDownTime()=" + getDownTime() + ", getRemark()=" + getRemark() + ", getNorm()="
					+ getNorm() + ", getGoodsProperty()=" + getGoodsProperty() + ", getCurrencyUnit()="
					+ getCurrencyUnit() + ", getOrderBY()=" + getOrderBY() + ", getOrderAD()=" + getOrderAD() + "]";
		}
		/**
		 * 获取: emergencyTime
		 * @return the emergencyTime
		 */
		public Integer getEmergencyTime() {
			return emergencyTime;
		}
		/**
		 * 设置: emergencyTime
		 * @param emergencyTime the emergencyTime to set
		 */
		public void setEmergencyTime(Integer emergencyTime) {
			this.emergencyTime = emergencyTime;
		}
}
