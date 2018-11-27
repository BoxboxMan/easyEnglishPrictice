package org.jxnu.controller.controller.registerController;

import javax.mail.Session;

import org.jxnu.controller.shiro.SessionObject;
import org.jxnu.pojo.SysUser;
import org.jxnu.service.register.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户注册
 * @author MR.S
 *
 */
@Controller
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;

	/**
	 * 注册成功后返回sessionObj存储注册成功的值
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/register")
	public ModelAndView register(SysUser user) throws Exception{
		SessionObject sessionObject = (SessionObject) registerService.register(user);
		return new ModelAndView("redirect:/welcome.html").addObject("sessionObj", sessionObject);
	}
}
