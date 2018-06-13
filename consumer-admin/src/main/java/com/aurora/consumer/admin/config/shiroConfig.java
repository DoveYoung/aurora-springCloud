package com.aurora.consumer.admin.config;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aurora.consumer.admin.bean.ShiroRealm;
import com.aurora.consumer.admin.util.Const;
import com.aurora.consumer.admin.util.Jurisdiction;

@Configuration
public class shiroConfig {
	
	@Autowired ShiroRealm shiroRealm;

	/**
	 * securityManager
	 */
	@Bean
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(shiroRealm);
		return securityManager;
	}
	
	/**
	 * ShiroFilterFactoryBean
	*/
	@Bean
	public ShiroFilterFactoryBean shiroFilter() {	
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		shiroFilter.setSecurityManager(securityManager());
		shiroFilter.setSuccessUrl(Const.HOME_PATH);
		shiroFilter.setLoginUrl(Const.LOGIN_PATH);
		shiroFilter.setFilterChainDefinitionMap(getFilterChainDefinitionMap());
		return shiroFilter;
	}
	
/**
 * 1.anon:例子/admins/**=anon 没有参数，表示可以匿名使用。
 * 2.authc:例如/admins/user/**=authc表示需要认证(登录)才能使用，没有参数
 * 3.roles(角色)：例子/admins/user/**=roles[admin],参数可以写多个，多个时必须加上引号，并且参数之间用逗号分割，当有多个参数时，
 *	例如admins/user/**=roles["admin,guest"],每个参数通过才算通过，相当于hasAllRoles()方法。
 * 4.perms（权限）：例子/admins/user/**=perms[user:add:*],参数可以写多个，多个时必须加上引号，并且参数之间用逗号分割，
 * 例如/admins/user/**=perms["user:add:*,user:modify:*"]，当有多个参数时必须每个参数都通过才通过，想当于isPermitedAll()方法。
 */

	//过滤拦截路径
	private Map<String, String> getFilterChainDefinitionMap(){
		//此Map需为LinkedHashMap，不然设置authc后anon不起作用
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		//静态资源
		filterChainDefinitionMap.put("/common/**", "anon");
		filterChainDefinitionMap.put("/css/**", "anon");
		filterChainDefinitionMap.put("/img/**", "anon");
		filterChainDefinitionMap.put("/js/**", "anon");
		filterChainDefinitionMap.put("/plugin/**", "anon");
		//退出路径
		filterChainDefinitionMap.put("/login/**", "anon");
		filterChainDefinitionMap.put(Const.LOGOUT_PATH, "logout");
		filterChainDefinitionMap.put("/**", "authc");//
		return filterChainDefinitionMap;
	}
	
	/**
	 * 配置MyErrorController需要此bean
	*/
	@Bean
	public ErrorProperties errorProperties() {
	    return new ErrorProperties();
	}
	
}
