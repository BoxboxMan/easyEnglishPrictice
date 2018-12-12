package org.jxnu.dao.custommapper;

import java.util.List;

import org.jxnu.pojo.QuestionCustom;

public interface QuestionCustomMapper {
	List<QuestionCustom> selectQuestionCustomsByPaperId(Long paperId);
}
