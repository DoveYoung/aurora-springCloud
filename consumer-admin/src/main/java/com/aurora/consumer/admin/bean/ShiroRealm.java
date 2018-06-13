package com.aurora.consumer.admin.bean;

import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aurora.consumer.admin.entity.User;
import com.aurora.consumer.admin.remote.UserRemote;
import com.aurora.consumer.admin.util.Const;
import com.aurora.consumer.admin.util.Jurisdiction;
import com.aurora.consumer.admin.util.Tools;

/**
 * @Title: ShiroRealm.java 
 * @Package com.aurora.consumer.admin.interceptor 
 * @Description: shiro认证与授权
 * @author SSY  
 * @date 2018年4月12日 上午10:02:44 
 * @version V1.0
 */
@Component
public class ShiroRealm extends AuthorizingRealm {
	protected Logger logger = Logger.getLogger(this.getClass());
	@Autowired
    protected UserRemote userRemote;
	
	
	/**
	 * @Title: doGetAuthenticationInfo 
	 * @Description: 身份认证
	 * @param    AuthenticationToken token
	 * @return AuthenticationInfo  
	 * @author SSY
	 * @date 2018年4月11日 上午11:49:08
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String userEmail = usernamePasswordToken.getUsername();
		String password = new String(usernamePasswordToken.getPassword());
		User user = userRemote.getUserByUserEmail(userEmail);
		if (user==null) {
			throw new UnknownAccountException();
		}
		if (user.getFallBack()) {//如果服务提供者出现延迟等异常
			logger.info("服务提供者出现延迟等异常");
			throw new AuthenticationException();
		}
		if (Const.LOCK_USER_STATUS==Integer.valueOf(user.getUserStatus())) {
			throw new LockedAccountException();
		}
		String encryptPassword = new SimpleHash("SHA-1", password,user.getSalt()).toString();//加密后的密码;
		usernamePasswordToken.setPassword(encryptPassword.toCharArray());
		if (!user.getUserPassword().equals(encryptPassword)) {
			throw new IncorrectCredentialsException();//密码不正确;
		}
		//账户验证通过
		Session session = Jurisdiction.getSession();
		session.setAttribute(Const.SESSION_USER, user); // 把用户信息放session中
		Set<String> userPermissions = userRemote.getUserPermissions(user.getUserID());
		session.setAttribute("userPermissions", userPermissions);
//		session.setAttribute(Const.SESSION_USER_EMAIL, userEmail);
//		session.setAttribute(Const.SESSION_USER_ID, user.getUserID());
//		String userName = Tools.notEmpty(user.getUserName()) ? user.getUserName() : user.getUserEmail();
//		String userRealName = Tools.notEmpty(user.getUserRealName()) ? user.getUserRealName() : user.getUserEmail();
//		session.setAttribute(Const.SESSION_USER_NAME, userName);
//		session.setAttribute(Const.SESSION_USER_REAL_NAME, userRealName);
		return new SimpleAuthenticationInfo(userEmail, encryptPassword, getName());
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法(non-Javadoc)
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache
	 * .shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		SimpleAuthorizationInfo authorize =  new SimpleAuthorizationInfo();
		Integer userID = Jurisdiction.getUser().getUserID();
		Set<String> userPermissions = userRemote.getUserPermissions(userID);
		authorize.setStringPermissions(userPermissions);
		return authorize;
	}

}
