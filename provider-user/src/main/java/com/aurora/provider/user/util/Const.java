package com.aurora.provider.user.util;

import org.springframework.context.ApplicationContext;
/**
 * 项目名称：
 * 创建:BYG 2017/5/25
 * 修改：
 * @version
*/
public class Const {
	
	/**------------------------------------------------------------------------------------------------
	 * -----------------------------------------关键词常量---------------------------------------
	 * ------------------------------------------------------------------------------------------------
	 */
	/**
	 * 验证码
	 */
	public static final String SESSION_VERIFICATION_CODE = "sessionVerificationCode";	
	
	/**
	 * session用的用户
	 */
	public static final String SESSION_USER = "sessionUser";	
	
	/**
	 * session用户昵称名
	 */
	public static final String SESSION_USER_NAME = "sessionUserName";							
	
	/**
	 * session用户真实姓名
	 */
	public static final String SESSION_USER_REAL_NAME = "sessionUserRealName";
	
	/**
	 * session用的用户ID
	 */
	public static final String SESSION_USER_ID = "sessionUserID";						
	
	/**
	 * session用的用户邮箱
	 */
	public static final String SESSION_USER_EMAIL = "sessionUserEmail";					


	/**------------------------------------------------------------------------------------------------
	 * --------------------------------------地址路径常量--------------------------------------
	 * ------------------------------------------------------------------------------------------------
	 */
	/**
	 * 二维码存放路径
	 */
	public static final String FILEPATHTWODIMENSIONCODE = "uploadFiles/twoDimensionCode/"; 
	/**
	 * 登陆认证地址拦截
	 */
	public static final String NO_INTERCEPTOR_PATH1 = ".*/((login)|(myzone)|(logout)|(code)|(static)|(websocket)|(error)).*"; 
	/**
	 * 菜单权限地址拦截
	 */
	public static final String NO_INTERCEPTOR_PATH2 = ".*/((code)|(upload)|(common)|(developer)).*";
	/**
	 * 登录地址
	 */
	public static final String LOGIN = "/login/toLogin";				


	/**------------------------------------------------------------------------------------------------
	 * ------------------------------------------角色常量-----------------------------------------
	 * ------------------------------------------------------------------------------------------------
	 */
	/**
	 * 销售角色id		
	 */
	public static final String SALES_ROLE_ID = "5"; 
	/**
	 * 客服角色id
	 */
	public static final String SERVICE_ROLE_ID = "6"; 
	/**
	 * 运营角色id	
	 */
	public static final String OPERATION_ROLE_ID = "7"; 
	/**
	 * 公池客户编码;	
	 */
	public static final int PUBLIC_POOL_CODE = 888; //使用int 而不是Integer,原因-128~+127Intege比值是可以的,因为Integer是从缓冲区取的,超出就是一个封装过程;

	/**------------------------------------------------------------------------------------------------
	 * ----------------------------------------用户状态-----------------------------------------
	 * ------------------------------------------------------------------------------------------------
	 */
	/**
	 * 禁用用户状态
	 */
	public static final int LOCK_USER_STATUS = 4; //使用int 而不是Integer,原因-128~+127Intege比值是可以的,因为Integer是从缓冲区取的,超出就是一个封装过程;

	
	/**------------------------------------------------------------------------------------------------
	 * ---------------------------------------- 菜 单  ----------------------------------------
	 * ------------------------------------------------------------------------------------------------
	 */

	/**
	 * 菜单等级  一级菜单;
	 */
	public static final int MENU_LEVEL_FIRST = 1; 
	/**
	 * 菜单等级  一级菜单;
	 */
	public static final int MENU_LEVEL_SECOND = 2; 
	/**
	 * 菜单等级  一级菜单;
	 */
	public static final int MENU_LEVEL_THIRD = 3; 
	
	
	
	

	
}
