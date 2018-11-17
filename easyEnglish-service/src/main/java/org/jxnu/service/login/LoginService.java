package org.jxnu.service.login;

import java.util.List;

import org.jxnu.pojo.SysPermission;
import org.jxnu.pojo.SysUser;

/**
 * 用户登陆service
 * @author MR.S
 *
 */
public interface LoginService {

	/**
	 * 根据用户名查找用户信息
	 * @param username
	 * @return
	 */
	public SysUser login(String usercode) throws Exception;
	
	/**
	 * 根据用户表id查找用户对应权限
	 * @param userid
	 * @return
	 */
	public List<SysPermission> findSysPermission(String userid);
	
	/**
	 * 根据用户表id查找用户对应菜单
	 * @param userid
	 * @return
	 */
	public List<SysPermission> findUserMenuList(String userid);
}
