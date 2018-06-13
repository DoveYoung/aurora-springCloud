package com.aurora.consumer.admin.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * 合同实体类
 * @author SSY 2018-1-9
 */
public class ContractManage {

	/**
	 * 合同单id
	 */
	private String contractID;
	/**
	 * 上一份合同id,客户采购创建的则为空
	 */
	private String sourceID;
	/**
	 * 询价源id
	 */
	private String inquiryID;
	/**
	 * 合同专属销售id
	 */
	private Integer salesManager;
	/**
	 *  1.合同待校对;2.合同文件待上传,代付款;3.合同已失效;4.合同已作废;5.定金付款(线上付款);6.尾款已支付(线上付款);7.待转账(包含定金和尾款);8.已转账(包含定金和尾款);9.交易完成;
	 */
	private Integer contractState;
	/**
	 * 贸易方式:1CIF；2FCA；3EXW ; 4.FOB;
	 */
	private Integer tradeType;
	/**
	 * 运输方式
	 */
	private Integer logisticsType;
	/**
	 * 结算货币;
	 */
	private String currencyName;
	/**
	 * 结算货币符号;
	 */
	private String currencySign;
	/**
	 * 交货国家
	 */
	private String deliverCountry;
	/**
	 * 交货城市;
	 */
	private String deliverCity;
	/**
	 * 备货时间
	 */
	private Integer readyTime;
	/**
	 * 合同有效时间;
	 */
	private String validDate;
	/**
	 * 合同总邮费;
	 */
	private BigDecimal totalPostage;
	/**
	 * 合同总金额包含邮费;
	 */
	private BigDecimal contractMoney;
	/**
	 * 首付款金额;
	 */
	private BigDecimal downPayment;
	/**
	 * 首付比例;
	 */
	private Integer downPaymentPercent;
	/**
	 * 首付时间;
	 */
	private String downPayTime;
	/**
	 * 首付实际支付金额;
	 */
	private BigDecimal downPayMoney;
	/**
	 * 首付支付渠道;1支付宝；2微信；3快钱;4.转账
	 */
	private Integer downPayPath;
	/**
	 * 首付第三方支付单号;
	 */
	private String downTradeNo;
	/**
	 * 尾款支付款金额;
	 */
	private BigDecimal finalPayment;
	/**
	 * 尾款支付比例;
	 */
	private Integer finalPaymentPercent;
	/**
	 * 尾款支付时间;
	 */
	private String finalPayTime;
	/**
	 * 尾款实际支付金额;
	 */
	private BigDecimal finalPayMoney;
	/**
	 * 尾款支付渠道; 1支付宝；2微信；3快钱;4.转账
	 */
	private Integer finalPayPath;
	/**
	 * 尾款第三方支付单号;
	 */
	private String finalTradeNo;
	/**
	 * 合同文件url
	 */
	private String contractFile;
	/**
	 * 合同上传时间
	 */
	private String uploadTime;
	/**
	 * 上传合同者账号
	 */
	private String uploadOperator;
	/**
	 * 合同生成时间
	 */
	private String createTime;
	/**
	 * 客户ID
	 */
	private Integer customerID;
	/**
	 * 用户名称
	 */
	private String customerName;
	/**
	 * 用户邮箱
	 */
	private String customerEmail;
	/**
	 * 联系电话
	 */
	private String customerMobile;
	/**
	 * 合同公司名称
	 */
	private String company;
	/**
	 *  公司地址
	 */
	private String address;
	
	/**
	 * 合同中商品列表;
	 */
	private List<ContractGoods> contractGoodsList;

	/**
	 * 获取: contractID
	 * @return the contractID
	 */
	public String getContractID() {
		return contractID;
	}

	/**
	 * 设置: contractID
	 * @param contractID the contractID to set
	 */
	public void setContractID(String contractID) {
		this.contractID = contractID;
	}

	/**
	 * 获取: inquiryID
	 * @return the inquiryID
	 */
	public String getInquiryID() {
		return inquiryID;
	}

	/**
	 * 设置: inquiryID
	 * @param inquiryID the inquiryID to set
	 */
	public void setInquiryID(String inquiryID) {
		this.inquiryID = inquiryID;
	}

	/**
	 * 获取: salesManager
	 * @return the salesManager
	 */
	public Integer getSalesManager() {
		return salesManager;
	}

	/**
	 * 设置: salesManager
	 * @param salesManager the salesManager to set
	 */
	public void setSalesManager(Integer salesManager) {
		this.salesManager = salesManager;
	}

	/**
	 * 获取: contractState
	 * @return the contractState
	 */
	public Integer getContractState() {
		return contractState;
	}

	/**
	 * 设置: contractState
	 * @param contractState the contractState to set
	 */
	public void setContractState(Integer contractState) {
		this.contractState = contractState;
	}

	/**
	 * 获取: contractMoney
	 * @return the contractMoney
	 */
	public BigDecimal getContractMoney() {
		return contractMoney;
	}

	/**
	 * 设置: contractMoney
	 * @param contractMoney the contractMoney to set
	 */
	public void setContractMoney(BigDecimal contractMoney) {
		this.contractMoney = contractMoney;
	}

	/**
	 * 获取: totalPostage
	 * @return the totalPostage
	 */
	public BigDecimal getTotalPostage() {
		return totalPostage;
	}

	/**
	 * 设置: totalPostage
	 * @param totalPostage the totalPostage to set
	 */
	public void setTotalPostage(BigDecimal totalPostage) {
		this.totalPostage = totalPostage;
	}

	 
	/**
	 * 获取: contractFile
	 * @return the contractFile
	 */
	public String getContractFile() {
		return contractFile;
	}

	/**
	 * 设置: contractFile
	 * @param contractFile the contractFile to set
	 */
	public void setContractFile(String contractFile) {
		this.contractFile = contractFile;
	}

	/**
	 * 获取: uploadTime
	 * @return the uploadTime
	 */
	public String getUploadTime() {
		return uploadTime;
	}

	/**
	 * 设置: uploadTime
	 * @param uploadTime the uploadTime to set
	 */
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	/**
	 * 获取: uploadOperator
	 * @return the uploadOperator
	 */
	public String getUploadOperator() {
		return uploadOperator;
	}

	/**
	 * 设置: uploadOperator
	 * @param uploadOperator the uploadOperator to set
	 */
	public void setUploadOperator(String uploadOperator) {
		this.uploadOperator = uploadOperator;
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
	 * 获取: customerID
	 * @return the customerID
	 */
	public Integer getCustomerID() {
		return customerID;
	}

	/**
	 * 设置: customerID
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	/**
	 * 获取: customerName
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * 设置: customerName
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * 获取: customerEmail
	 * @return the customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * 设置: customerEmail
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * 获取: customerMobile
	 * @return the customerMobile
	 */
	public String getCustomerMobile() {
		return customerMobile;
	}

	/**
	 * 设置: customerMobile
	 * @param customerMobile the customerMobile to set
	 */
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	/**
	 * 获取: company
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * 设置: company
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * 获取: address
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置: address
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 获取: contractGoodsList
	 * @return the contractGoodsList
	 */
	public List<ContractGoods> getContractGoodsList() {
		return contractGoodsList;
	}

	/**
	 * 设置: contractGoodsList
	 * @param contractGoodsList the contractGoodsList to set
	 */
	public void setContractGoodsList(List<ContractGoods> contractGoodsList) {
		this.contractGoodsList = contractGoodsList;
	}

	/**
	 * 获取: sourceID
	 * @return the sourceID
	 */
	public String getSourceID() {
		return sourceID;
	}

	/**
	 * 设置: sourceID
	 * @param sourceID the sourceID to set
	 */
	public void setSourceID(String sourceID) {
		this.sourceID = sourceID;
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
	 * 获取: logisticsType
	 * @return the logisticsType
	 */
	public Integer getLogisticsType() {
		return logisticsType;
	}

	/**
	 * 设置: logisticsType
	 * @param logisticsType the logisticsType to set
	 */
	public void setLogisticsType(Integer logisticsType) {
		this.logisticsType = logisticsType;
	}

	/**
	 * 获取: currencyName
	 * @return the currencyName
	 */
	public String getCurrencyName() {
		return currencyName;
	}

	/**
	 * 设置: currencyName
	 * @param currencyName the currencyName to set
	 */
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	/**
	 * 获取: currencySign
	 * @return the currencySign
	 */
	public String getCurrencySign() {
		return currencySign;
	}

	/**
	 * 设置: currencySign
	 * @param currencySign the currencySign to set
	 */
	public void setCurrencySign(String currencySign) {
		this.currencySign = currencySign;
	}

	/**
	 * 获取: deliverCountry
	 * @return the deliverCountry
	 */
	public String getDeliverCountry() {
		return deliverCountry;
	}

	/**
	 * 设置: deliverCountry
	 * @param deliverCountry the deliverCountry to set
	 */
	public void setDeliverCountry(String deliverCountry) {
		this.deliverCountry = deliverCountry;
	}

	/**
	 * 获取: deliverCity
	 * @return the deliverCity
	 */
	public String getDeliverCity() {
		return deliverCity;
	}

	/**
	 * 设置: deliverCity
	 * @param deliverCity the deliverCity to set
	 */
	public void setDeliverCity(String deliverCity) {
		this.deliverCity = deliverCity;
	}

	/**
	 * 获取: readyTime
	 * @return the readyTime
	 */
	public Integer getReadyTime() {
		return readyTime;
	}

	/**
	 * 设置: readyTime
	 * @param readyTime the readyTime to set
	 */
	public void setReadyTime(Integer readyTime) {
		this.readyTime = readyTime;
	}

	/**
	 * 获取: validDate
	 * @return the validDate
	 */
	public String getValidDate() {
		return validDate;
	}

	/**
	 * 设置: validDate
	 * @param validDate the validDate to set
	 */
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	/**
	 * 获取: downPayment
	 * @return the downPayment
	 */
	public BigDecimal getDownPayment() {
		return downPayment;
	}

	/**
	 * 设置: downPayment
	 * @param downPayment the downPayment to set
	 */
	public void setDownPayment(BigDecimal downPayment) {
		this.downPayment = downPayment;
	}

	/**
	 * 获取: downPaymentPercent
	 * @return the downPaymentPercent
	 */
	public Integer getDownPaymentPercent() {
		return downPaymentPercent;
	}

	/**
	 * 设置: downPaymentPercent
	 * @param downPaymentPercent the downPaymentPercent to set
	 */
	public void setDownPaymentPercent(Integer downPaymentPercent) {
		this.downPaymentPercent = downPaymentPercent;
	}

	/**
	 * 获取: downPayTime
	 * @return the downPayTime
	 */
	public String getDownPayTime() {
		return downPayTime;
	}

	/**
	 * 设置: downPayTime
	 * @param downPayTime the downPayTime to set
	 */
	public void setDownPayTime(String downPayTime) {
		this.downPayTime = downPayTime;
	}

	/**
	 * 获取: downPayMoney
	 * @return the downPayMoney
	 */
	public BigDecimal getDownPayMoney() {
		return downPayMoney;
	}

	/**
	 * 设置: downPayMoney
	 * @param downPayMoney the downPayMoney to set
	 */
	public void setDownPayMoney(BigDecimal downPayMoney) {
		this.downPayMoney = downPayMoney;
	}

	/**
	 * 获取: downPayPath
	 * @return the downPayPath
	 */
	public Integer getDownPayPath() {
		return downPayPath;
	}

	/**
	 * 设置: downPayPath
	 * @param downPayPath the downPayPath to set
	 */
	public void setDownPayPath(Integer downPayPath) {
		this.downPayPath = downPayPath;
	}

	/**
	 * 获取: downTradeNo
	 * @return the downTradeNo
	 */
	public String getDownTradeNo() {
		return downTradeNo;
	}

	/**
	 * 设置: downTradeNo
	 * @param downTradeNo the downTradeNo to set
	 */
	public void setDownTradeNo(String downTradeNo) {
		this.downTradeNo = downTradeNo;
	}

	/**
	 * 获取: finalPayment
	 * @return the finalPayment
	 */
	public BigDecimal getFinalPayment() {
		return finalPayment;
	}

	/**
	 * 设置: finalPayment
	 * @param finalPayment the finalPayment to set
	 */
	public void setFinalPayment(BigDecimal finalPayment) {
		this.finalPayment = finalPayment;
	}

	/**
	 * 获取: finalPaymentPercent
	 * @return the finalPaymentPercent
	 */
	public Integer getFinalPaymentPercent() {
		return finalPaymentPercent;
	}

	/**
	 * 设置: finalPaymentPercent
	 * @param finalPaymentPercent the finalPaymentPercent to set
	 */
	public void setFinalPaymentPercent(Integer finalPaymentPercent) {
		this.finalPaymentPercent = finalPaymentPercent;
	}

	/**
	 * 获取: finalPayTime
	 * @return the finalPayTime
	 */
	public String getFinalPayTime() {
		return finalPayTime;
	}

	/**
	 * 设置: finalPayTime
	 * @param finalPayTime the finalPayTime to set
	 */
	public void setFinalPayTime(String finalPayTime) {
		this.finalPayTime = finalPayTime;
	}

	/**
	 * 获取: finalPayMoney
	 * @return the finalPayMoney
	 */
	public BigDecimal getFinalPayMoney() {
		return finalPayMoney;
	}

	/**
	 * 设置: finalPayMoney
	 * @param finalPayMoney the finalPayMoney to set
	 */
	public void setFinalPayMoney(BigDecimal finalPayMoney) {
		this.finalPayMoney = finalPayMoney;
	}

	/**
	 * 获取: finalPayPath
	 * @return the finalPayPath
	 */
	public Integer getFinalPayPath() {
		return finalPayPath;
	}

	/**
	 * 设置: finalPayPath
	 * @param finalPayPath the finalPayPath to set
	 */
	public void setFinalPayPath(Integer finalPayPath) {
		this.finalPayPath = finalPayPath;
	}

	/**
	 * 获取: finalTradeNo
	 * @return the finalTradeNo
	 */
	public String getFinalTradeNo() {
		return finalTradeNo;
	}

	/**
	 * 设置: finalTradeNo
	 * @param finalTradeNo the finalTradeNo to set
	 */
	public void setFinalTradeNo(String finalTradeNo) {
		this.finalTradeNo = finalTradeNo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ContractManage [contractID=" + contractID + ", sourceID=" + sourceID + ", inquiryID=" + inquiryID
				+ ", salesManager=" + salesManager + ", contractState=" + contractState + ", tradeType=" + tradeType
				+ ", logisticsType=" + logisticsType + ", currencyName=" + currencyName + ", currencySign="
				+ currencySign + ", deliverCountry=" + deliverCountry + ", deliverCity=" + deliverCity + ", readyTime="
				+ readyTime + ", validDate=" + validDate + ", totalPostage=" + totalPostage + ", contractMoney="
				+ contractMoney + ", downPayment=" + downPayment + ", downPaymentPercent=" + downPaymentPercent
				+ ", downPayTime=" + downPayTime + ", downPayMoney=" + downPayMoney + ", downPayPath=" + downPayPath
				+ ", downTradeNo=" + downTradeNo + ", finalPayment=" + finalPayment + ", finalPaymentPercent="
				+ finalPaymentPercent + ", finalPayTime=" + finalPayTime + ", finalPayMoney=" + finalPayMoney
				+ ", finalPayPath=" + finalPayPath + ", finalTradeNo=" + finalTradeNo + ", contractFile=" + contractFile
				+ ", uploadTime=" + uploadTime + ", uploadOperator=" + uploadOperator + ", createTime=" + createTime
				+ ", customerID=" + customerID + ", customerName=" + customerName + ", customerEmail=" + customerEmail
				+ ", customerMobile=" + customerMobile + ", company=" + company + ", address=" + address
				+ ", contractGoodsList=" + contractGoodsList + "]";
	}

	 
	
}