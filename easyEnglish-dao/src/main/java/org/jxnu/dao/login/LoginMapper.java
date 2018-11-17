package org.jxnu.dao.login;

import java.util.List;

import org.jxnu.pojo.SysPermission;

/**
 * 用户登陆DAO
 * @author MR.S
 *
 */
public interface LoginMapper {
	
	/**
	 * 根据用户表id来查对应权限
	 * @param userid
	 * @return
	 */
	public List<SysPermission> findSysPermission(String userid);
	
	/**
	 * 根据用户表id来查对应权限
	 * @param userid
	 * @return
	 */
	public List<SysPermission> findUserMenuList(String userid);
}
