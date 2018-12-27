package org.jxnu.controller.controller.paperController;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.jxnu.controller.shiro.SessionObject;
import org.jxnu.pojo.PaperInfo;
import org.jxnu.pojo.QuestionCustom;
import org.jxnu.pojo.StudentPaperVo;
import org.jxnu.pojo.custom.AddPaperCustom;
import org.jxnu.pojo.custom.PaperInfoCustom;
import org.jxnu.pojo.custom.StudentPaperCustom;
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
	public String submitanswer(StudentPaperVo studentPaperVo) throws Exception {
		SessionObject sessionObject=(SessionObject) SecurityUtils.getSubject().getPrincipal();
		paperService.saveStudentPaperVo(studentPaperVo , sessionObject.getId());
		return "redirect:/paper/getpapers";
	}
	
	@RequestMapping("/getStudentPapers")
	@ResponseBody
	public Object getStudentPapers() {
		SessionObject sessionObject=(SessionObject) SecurityUtils.getSubject().getPrincipal();
		return paperService.getStudentPaper(sessionObject.getId());
	}
	
	@RequestMapping("/viewStudentPapers")
	public String viewStudentPapers() {
		return "paper/viewStudentPapers";
	}
	
	@RequestMapping("/getStudentPaper")
	public String getStudentPaper(Long studentPaperId, Model model) {
		StudentPaperCustom studentPaperCustom=paperService.getStudentPaperCustomByPrimaryKey(studentPaperId);
		model.addAttribute("studentPaperCustom", studentPaperCustom);
		return "paper/viewStudentPaper";
	}
	
	@RequestMapping("/viewAddPaper")
	public String viewAddPaper() {
		return "paper/addPaper";
	}
	
	@RequestMapping("/addPaper")
	public String addPaper(AddPaperCustom paper) {
		SessionObject sessionObject=(SessionObject) SecurityUtils.getSubject().getPrincipal();
		paperService.saveAddPaperCustom(paper, sessionObject.getId());
		return "";
	}
	
	@RequestMapping("/viewgGradePapers")
	public String viewgGradePapers() {
		return "paper/viewGradePapers";
	}
	
	@RequestMapping("/getGradePapers")
	@ResponseBody
	public Object getGradePapers() {
		SessionObject sessionObject=(SessionObject) SecurityUtils.getSubject().getPrincipal();
		List<PaperInfoCustom> papers= paperService.getPaperInfoCustomsByTeaId(sessionObject.getId());
		return papers;
	}
	
	@RequestMapping("/gradePaper")
	public String gradePaper(Long paperId , Model model) {
		List<QuestionCustom> subQuestions=paperService.getSubQuestionsByPaperId(paperId);
		StudentPaperCustom subStuPaper=paperService.getSubStuPaperByPaperId(paperId, subQuestions);
		model.addAttribute("subStuPaper", subStuPaper);
		return "paper/gradePaper";
	}
	
}
