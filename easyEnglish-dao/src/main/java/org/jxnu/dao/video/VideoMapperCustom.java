package org.jxnu.dao.video;

import java.util.List;

import org.jxnu.pojo.Video;

/**
 * 视频功能模块
 * @author MR.S
 *
 */
public interface VideoMapperCustom {

	/**
	 * 查询video列表
	 * @param video 可以根据name属性进行模糊查询
	 * @return
	 */
	public List<Video> listAll(Video video) throws Exception;
	
	/**
	 * 视频上传
	 * @param video
	 * @return
	 */
	public int insertVideo(Video video) throws Exception;
}
