package org.jxnu.controller.controller.personalController;

import org.apache.shiro.SecurityUtils;
import org.jxnu.controller.shiro.SessionObject;
import org.jxnu.pojo.SysUser;
import org.jxnu.service.personal.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 个人信息中心
 * @author MR.S
 *
 */
@Controller
@RequestMapping("/personal")
public class PerSonalController {
	
	@Autowired
	private PersonalService personalService;

	/**
	 * 携带用户信息到用户修改页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updatePage")
	public ModelAndView updateInfo() throws Exception{
		ModelAndView modelAndView = new ModelAndView("personal_center/personal_info_update");
		SessionObject sessionObject = (SessionObject) SecurityUtils.getSubject().getPrincipal();
		SysUser sysUser = personalService.findSysUser(sessionObject.getId());
		modelAndView.addObject("sysUser", sysUser);
		return modelAndView;
	}
	
	/**
	 * 响应Ajax，返回更新结果
	 * @param sysUser
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateSysUser")
	@ResponseBody
	public Object updateSysUser(SysUser sysUser) throws Exception{
		SessionObject sessionObject = (SessionObject) SecurityUtils.getSubject().getPrincipal();
		sysUser.setId(sessionObject.getId());
		return personalService.sysUserUpdate(sysUser);
	}
	
	
}
