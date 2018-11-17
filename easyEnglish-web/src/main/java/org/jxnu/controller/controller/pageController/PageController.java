package org.jxnu.controller.controller.pageController;

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

	@RequestMapping("/welcome")
	public ModelAndView welcomePage() throws Exception{
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}
	
	@RequestMapping("/test")
	public String test(){
		return "success";
	}
	
}
