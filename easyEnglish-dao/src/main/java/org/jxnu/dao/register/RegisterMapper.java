package org.jxnu.dao.register;

import org.apache.ibatis.annotations.Param;
import org.jxnu.pojo.SysRole;
import org.jxnu.pojo.SysUser;

/**
 * 用户注册
 * @author MR.S
 *
 */
public interface RegisterMapper {

	/**
	 * 用户注册在sys_user表中
	 * @param user 需要传入usercode,username,password
	 * @return
	 */
	public int register(SysUser user) throws Exception;
	
	/**
	 * 根据角色名称查询角色信息
	 * @param roleName
	 * @return
	 */
	public SysRole findRoleByName(String roleName) throws Exception;
	
	/**
	 * 为用户分配角色
	 * @param sys_user_id 用户表的id
	 * @param sys_role_id 角色表的id
	 */
	public int insertSysUserRole(@Param("sys_user_id")String sys_user_id, @Param("sys_role_id")String sys_role_id) throws Exception;
	
}
