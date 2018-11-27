package org.jxnu.service.register.impl;

import org.jxnu.dao.register.RegisterMapper;
import org.jxnu.pojo.Constant;
import org.jxnu.pojo.SysRole;
import org.jxnu.pojo.SysUser;
import org.jxnu.service.register.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterMapper registerMapper;
	
	@Override
	public SysUser register(SysUser user) throws Exception {
		//sys_user表中insert
		registerMapper.register(user);
		//获取到插入sys_user表后后生成的id
		user.setId(user.getUsercode());
		//对该用户进行角色分配,初始都为学生
		SysRole role = registerMapper.findRoleByName(Constant.ROLE_NAME_STUDENT);
		int infectRows = registerMapper.insertSysUserRole(user.getId(), role.getId());
		if(infectRows < 1){
			throw new Exception("注册失败");
		}
		return user;
	}

}
