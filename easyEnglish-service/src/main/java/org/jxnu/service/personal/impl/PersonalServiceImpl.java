package org.jxnu.service.personal.impl;

import org.jxnu.dao.generator.SysUserMapper;
import org.jxnu.dao.personal.PersonalMapper;
import org.jxnu.pojo.SysUser;
import org.jxnu.service.personal.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalServiceImpl implements PersonalService {
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired 
	private PersonalMapper personalMapper;
	

	@Override
	public int sysUserUpdate(SysUser sysUser) throws Exception{
		return personalMapper.updateSysUser(sysUser);
	}

	@Override
	public SysUser findSysUser(String id) throws Exception{
		return sysUserMapper.selectByPrimaryKey(id);
	}

}
