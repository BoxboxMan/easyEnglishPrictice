package org.jxnu.controller.controller.pageController;

import org.apache.shiro.SecurityUtils;
import org.jxnu.controller.shiro.SessionObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 仅仅只用来跳转页面
 * @author MR.S
 *
 */
@Controller
public class PageController {

	/**
	 * 跳转到首页
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/welcome")
	public ModelAndView welcomePage() throws Exception{
		ModelAndView modelAndView = new ModelAndView("index");
		SessionObject sessionObject = (SessionObject) SecurityUtils.getSubject().getPrincipal();
		modelAndView.addObject("sessionObject", sessionObject);
		return modelAndView;
	}
	
	@RequestMapping("/personal")
	public ModelAndView personalPage() throws Exception{
		ModelAndView modelAndView = new ModelAndView("personal_center/personal_center_index");
		return modelAndView;
	}
	
	/**
	 * 测试页面跳转是否成功
	 * @return
	 */
	@RequestMapping("/test")
	public String test() throws Exception{
		return "success";
	}
	
	
}
