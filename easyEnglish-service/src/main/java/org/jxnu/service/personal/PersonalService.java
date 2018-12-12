package org.jxnu.service.personal;

import org.jxnu.pojo.SysUser;

/**
 * 我的中心功能模块
 * @author MR.S
 *
 */
public interface PersonalService {

	/**
	 * 用户个人信息更新
	 * @param sysUser
	 * @return
	 */
	public int sysUserUpdate(SysUser sysUser)throws Exception;
	
	/**
	 * 根据id查找用户信息
	 * @param id
	 * @return
	 */
	public SysUser findSysUser(String id)throws Exception;
	
}
