package org.jxnu.pojo;

import java.util.List;

/**
 * 自定义User类，用于登陆识别。
 * 拓展字段请继承它，请勿修改
 * @author MR.S
 *
 */
public class CustomUser extends SysUser{

	//用户对应的权限
	private List<SysPermission> permissions;

	//用户对应的菜单
	private List<SysPermission> menus;
	
	public List<SysPermission> getMenus() {
		return menus;
	}

	public void setMenus(List<SysPermission> menus) {
		this.menus = menus;
	}

	public List<SysPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<SysPermission> permissions) {
		this.permissions = permissions;
	} 
	
	
	
}
