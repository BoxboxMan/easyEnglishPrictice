package org.jxnu.controller.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.jxnu.pojo.CustomUser;
import org.jxnu.pojo.SysPermission;
import org.jxnu.pojo.SysUser;
import org.jxnu.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * shiro的realm
 * @author MR.S
 *
 */
public class CustomRealm extends AuthorizingRealm{

	@Autowired
	private LoginService loginService;
	
	/**
	 * 授权处理
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		CustomUser customUser = (CustomUser) principals.getPrimaryPrincipal();
		List<SysPermission> permissions = customUser.getPermissions();
		//将获取到的所有权限加入权限匹配器中
		for(SysPermission permission:permissions){
			String perCode = permission.getPercode();
			simpleAuthorizationInfo.addStringPermission(perCode);
		}
		return simpleAuthorizationInfo;
	}

	/**
	 * 认证处理
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取登录时刻的用户名
		String usercode = (String) token.getPrincipal();
		//在数据库中进行匹配
		SysUser sysUser = null;
		try {
			sysUser = loginService.login(usercode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CustomUser customUser = new CustomUser();
		customUser.setId(sysUser.getId());
		customUser.setUsercode(sysUser.getUsercode());
		customUser.setUsername(sysUser.getUsername());
		//放入用户对应的权限
		customUser.setPermissions(loginService.findSysPermission(sysUser.getId()));
		//放入用户对应显示菜单
		customUser.setMenus(loginService.findUserMenuList(sysUser.getId()));
		//将与用户的密码进行加密
		
		//将查询到的信息放入凭证匹配器中自动匹配
		SimpleAuthenticationInfo simpleAuthenticationInfo 
			= new SimpleAuthenticationInfo(customUser, sysUser.getPassword(), this.getName());
		return simpleAuthenticationInfo;
	}


}
