package org.jxnu.controller.controller.loginController;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 结合shiro对登陆进行验证
 * @author MR.S
 *
 */
@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(HttpServletRequest request,String username,String password) throws Exception{
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		if(exceptionClassName != null){
			if(UnknownAccountException.class.getName().equals(exceptionClassName)){
				throw new Exception("账号不存在");
			}else{
				throw new Exception(exceptionClassName); 
			}
		}
		//如果没有抛出异常则会直接返回上一个请求url
		return "login";
	}
}
