package org.jxnu.controller.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 对全局异常进行处理
 * @author MR.S
 *
 */
public class GlobleExceptionHandler implements HandlerExceptionResolver{

	/**
	 * 如果是登陆异常，就把异常信息往request域中的msg字段抛出。
	 * 其他未知异常均转向404页面。
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		if(ex != null){
			if("账号不存在".equals(ex.getMessage()) || "账号与密码不匹配".equals(ex.getMessage())){
				request.setAttribute("msg", ex.getMessage());
			}else{
				ex.printStackTrace();
				return new ModelAndView("404");
			}
		}
		return null;
	}

}
