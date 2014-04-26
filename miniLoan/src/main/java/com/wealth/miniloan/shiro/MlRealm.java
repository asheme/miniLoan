package com.wealth.miniloan.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.service.LoginServiceI;

@Component
public class MlRealm extends AuthorizingRealm {
	private LoginServiceI loginService = null;

	public LoginServiceI getLoginService() {
		return loginService;
	}

	@Autowired
	public void setLoginService(LoginServiceI loginService) {
		this.loginService = loginService;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {

		return null;
	}

	/**
	 * 认证用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		MlUser user = this.loginService.getUserInfoByLoginId(token.getUsername());

		if (user != null) {
			String password = new String(token.getPassword());

			// if ("1".equals(user.getStatus())) {
			// // 用户被禁用，抛出异常
			// throw new DisabledAccountException("用户已被禁用");
			// }
			// Date currDate = new Date();
			// if (user.getPassInvalidDate() != null) {
			// if (currDate.after(user.getPassInvalidDate())) {
			// // 密码失效，抛出异常
			// throw new ExpiredCredentialsException("用户密码失效");
			// }
			// }
			// if (user.getPassErrCount() > 3) {
			// // 连续验密错误超过系统配置次数，抛出异常
			// throw new ExcessiveAttemptsException("连续验密错误超过系统设置");
			// }

			return new SimpleAuthenticationInfo(user.getLoginId(),
					user.getPassword(), getName());
		} else {
			// 用户不存在，抛出异常
			throw new UnknownAccountException("系统无此用户");
		}
	}

	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清除所有用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}
}
