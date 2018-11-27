package org.jxnu.controller.controller.loginController;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.jxnu.controller.shiro.SessionObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 结合shiro对登陆进行验证
 * @author MR.S
 *
 */
@Controller
public class LoginController {

	/**
	 * 结合shiro验证登陆是否成功
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request,String username,String password) throws Exception{
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		if(exceptionClassName != null){
			if(UnknownAccountException.class.getName().equals(exceptionClassName)){
				throw new Exception("账号不存在");
			}else if(CredentialsException.class.getName().equals(exceptionClassName)){
				throw new Exception("账号与密码不匹配");
			}
			else{
				throw new Exception(exceptionClassName); 
			}
		}
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()){	//登陆成功则将信息返回至session中
			SessionObject sessionObject = (SessionObject) subject;
			request.getSession().setAttribute("sessionObject", sessionObject);
		}
		//如果没有抛出异常则会直接返回上一个请求url
		return "login";
	}
}
