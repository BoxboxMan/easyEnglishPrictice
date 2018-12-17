package org.jxnu.dao.custommapper;

import java.util.List;

import org.jxnu.pojo.custom.AnswerCustom;

public interface AnswerCustomMapper {
	List<AnswerCustom> selectByStudentPaperId(Long StudentPaperId);
}
