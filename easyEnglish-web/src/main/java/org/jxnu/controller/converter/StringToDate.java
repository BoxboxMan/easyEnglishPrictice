package org.jxnu.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 前端页面的String转换为Date类型
 * 以便自动装填进pojo
 * @author MR.S
 *
 */
public class StringToDate implements Converter<String, Date> {

	/**
	 * 若失败则返回null
	 */
	@Override
	public Date convert(String source){
		Date res = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
		try {
		    res = simpleDateFormat.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

}
