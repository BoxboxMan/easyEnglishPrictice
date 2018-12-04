package org.jxnu.service.video;

import java.util.List;

import org.jxnu.pojo.Video;

/**
 * 视频功能块
 * @author MR.S
 *
 */
public interface VideoService {

	/**
	 * 列出视频列表
	 * @param video	可以根据其中的name属性进行模糊查找
	 * @return
	 */
	public List<Video> listAll(Video video) throws Exception;
	
	/**
	 * 上传视频
	 * @param video
	 * @return
	 */
	public int insertVideo(Video video) throws Exception;
	
}
