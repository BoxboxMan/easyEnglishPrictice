package org.jxnu.controller.controller.paperController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.jxnu.controller.shiro.SessionObject;
import org.jxnu.pojo.PaperInfo;
import org.jxnu.pojo.QuestionCustom;
import org.jxnu.pojo.StudentPaperVo;
import org.jxnu.service.paper.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/paper")
public class PaperController {
	@Autowired
	private PaperService paperService;
	
	//获取所有试卷
	@RequestMapping("/getpapers")
	public String getPapers(HttpServletRequest request) {
		List<PaperInfo> papers=paperService.getAll();
		request.setAttribute("papers", papers);
		return "paper/viewpapers";
	}
	
	//获取一个试卷所有的题目
	@RequestMapping("/getpaper")
	public String previewpaper(Model model , Long id) {
		List<QuestionCustom> questionCustoms=paperService.getQuestions(id);
		PaperInfo paper= paperService.selectByPrimaryKey(id);
		model.addAttribute("questionCustoms", questionCustoms);
		model.addAttribute("paper", paper);
		return "paper/viewpaper";
	}
	
	@RequestMapping("/submitanswer")
	public void submitanswer(StudentPaperVo studentPaperVo) {
		SessionObject sessionObject=(SessionObject) SecurityUtils.getSubject().getPrincipal();
		paperService.saveStudentPaperVo(studentPaperVo , sessionObject.getId());
	}
	
	@RequestMapping("/getFinishedPapers")
	@ResponseBody
	public Object getFinishedPapers() {
		SessionObject sessionObject=(SessionObject) SecurityUtils.getSubject().getPrincipal();
		return paperService.getStudentPaper(sessionObject.getId());
	}
	
	@RequestMapping("/viewFinishedPapers")
	public String viewFinishedPapers() {
		return "paper/viewFinishedPapers";
	}

}
