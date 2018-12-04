package org.jxnu.controller.controller.videoController;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.jxnu.controller.shiro.SessionObject;
import org.jxnu.pojo.Video;
import org.jxnu.service.video.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/video")
@Controller
public class VideoController {
	
	@Autowired
	private VideoService videoService;

	/**
	 * 跳转到视频展示列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView vedio(Video video) throws Exception{
		ModelAndView modelAndView = new ModelAndView("video/video_list");
		List<Video> videos = videoService.listAll(video);
		modelAndView.addObject("videos", videos);
		return modelAndView;
	}
	
	/**
	 * 跳转到视频播放列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/play")
	public ModelAndView play(String url) throws Exception{
		ModelAndView modelAndView = new ModelAndView("video/video_detail");
		modelAndView.addObject("video_url", url);
		return modelAndView;
	}
	
	/**
	 * 跳转到视频上传页面。
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("uploadPage")
	public ModelAndView uploadPage(HttpServletRequest request) throws Exception{
		ModelAndView modelAndView = new ModelAndView("video/video_upload");
		return modelAndView;
	}
	
	/**
	 * 
	 * @param video
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("upload")
	public ModelAndView upload(Video video, MultipartFile file, HttpServletRequest request) throws Exception{
		ModelAndView modelAndView = new ModelAndView("redirect:/video/uploadPage.html");
		//获取当前用户的存在于session中的id
		SessionObject sessionObject = (SessionObject) SecurityUtils.getSubject().getPrincipal();
		video.setUserId(sessionObject.getId());
		String fileName = file.getOriginalFilename();
		//获取文件后缀名
		String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
		//赋予文件新名字
		String fileNewName = UUID.randomUUID().toString()+fileSuffix;
		File newFile = new File(request.getSession().getServletContext().getRealPath("/")+"/video/"+fileNewName);
		video.setUrl("video/"+fileNewName);
		//把当前日期作为上传日期
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = simpleDateFormat.format(new Date());
		video.setUploadDate(simpleDateFormat.parse(date));
		//插入数据到数据库中
		videoService.insertVideo(video);
		file.transferTo(newFile);
		return modelAndView;
	}
	
}
