package org.jxnu.service.login.impl;

import java.util.List;

import org.jxnu.dao.generator.SysUserMapper;
import org.jxnu.dao.login.LoginMapper;
import org.jxnu.pojo.SysPermission;
import org.jxnu.pojo.SysUser;
import org.jxnu.pojo.SysUserExample;
import org.jxnu.pojo.SysUserExample.Criteria;
import org.jxnu.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public SysUser login(String usercode){
		SysUserExample sysUserExample = new SysUserExample();
		Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsercodeEqualTo(usercode);
		//实际只会查找到一个而已，因为userCode不是主键、不唯一，所以mybatis的逆向工程默认查找到的是list
		List<SysUser> users = sysUserMapper.selectByExample(sysUserExample);
		return users.get(0);
	}

	@Override
	public List<SysPermission> findSysPermission(String userid) {
		return loginMapper.findSysPermission(userid);
	}

	@Override
	public List<SysPermission> findUserMenuList(String userid) {
		return loginMapper.findUserMenuList(userid);
	}

}
