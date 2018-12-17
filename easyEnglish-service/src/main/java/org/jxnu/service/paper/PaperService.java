package org.jxnu.service.paper;

import java.util.List;

import org.jxnu.pojo.PaperInfo;
import org.jxnu.pojo.QuestionCustom;
import org.jxnu.pojo.StudentPaperVo;
import org.jxnu.pojo.custom.StudentPaperCustom;

public interface PaperService {
	List<PaperInfo> getAll();
	List<QuestionCustom> getQuestions(Long paperId);
	PaperInfo selectByPrimaryKey(Long paperId);
	void saveStudentPaperVo(StudentPaperVo studentPaperVo , String id) throws Exception;
	List<StudentPaperCustom> getStudentPaper(String id);
	StudentPaperCustom getStudentPaperCustomByPrimaryKey(Long id);
}
