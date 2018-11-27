package org.jxnu.controller.shiro;

import java.util.List;

import org.jxnu.pojo.SysPermission;
import org.jxnu.pojo.SysUser;

public class SessionObject extends SysUser {

	// 用户对应的权限
	private List<SysPermission> permissions;

	// 用户对应的菜单
	private List<SysPermission> menus;

	public List<SysPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<SysPermission> permissions) {
		this.permissions = permissions;
	}

	public List<SysPermission> getMenus() {
		return menus;
	}

	public void setMenus(List<SysPermission> menus) {
		this.menus = menus;
	}
	
	

}
