package org.jxnu.service.register;

import org.jxnu.pojo.SysUser;

/**
 * 用户注册
 * @author MR.S
 *
 */
public interface RegisterService {

	/**
	 * 用户注册
	 * @param user
	 * @return 注册成功返回注册信息，失败直接抛出异常
	 * @throws Exception
	 */
	public SysUser register(SysUser user) throws Exception;
	
}
