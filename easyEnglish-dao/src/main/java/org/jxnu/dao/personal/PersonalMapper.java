package org.jxnu.dao.personal;

import org.jxnu.pojo.SysUser;

/**
 * 用户中心模块
 * @author MR.S
 *
 */
public interface PersonalMapper {

	/**
	 * 更新用户信息
	 * @param sysUser
	 * @return
	 */
	public int updateSysUser(SysUser sysUser);
	
}
