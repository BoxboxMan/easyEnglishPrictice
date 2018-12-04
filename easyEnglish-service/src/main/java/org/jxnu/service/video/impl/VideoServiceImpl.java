package org.jxnu.service.video.impl;

import java.util.List;

import org.jxnu.dao.video.VideoMapperCustom;
import org.jxnu.pojo.Video;
import org.jxnu.service.video.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService{
	
	@Autowired
	private VideoMapperCustom videoMapper;

	@Override
	public List<Video> listAll(Video video) throws Exception{
		return videoMapper.listAll(video);
	}

	@Override
	public int insertVideo(Video video)  throws Exception{
		return videoMapper.insertVideo(video);
	}

}
