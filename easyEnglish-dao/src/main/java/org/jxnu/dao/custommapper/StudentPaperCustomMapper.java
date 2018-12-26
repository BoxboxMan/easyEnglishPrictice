package org.jxnu.dao.custommapper;

import java.util.List;

import org.jxnu.pojo.custom.StudentPaperCustom;

public interface StudentPaperCustomMapper {
	//通过学生id查找学生所有的答卷
	List<StudentPaperCustom> selectByStudentId(String id);
	//通过答卷id获取答卷
	StudentPaperCustom selectByPrimaryKey(Long id);
	//计算试卷的满分
	Integer selectFullScoreByPaperId(Long paperId);
	//获取只有主观题的答卷
	StudentPaperCustom getSubStuPaper(Long paperId);
}
