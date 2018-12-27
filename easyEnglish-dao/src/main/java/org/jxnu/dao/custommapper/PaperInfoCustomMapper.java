package org.jxnu.dao.custommapper;

import java.util.List;

import org.jxnu.pojo.custom.PaperInfoCustom;

public interface PaperInfoCustomMapper {
	PaperInfoCustom selectPaperInfoCustomByPaperId(Long paperId);
	List<Long> selectPaperIdByTeaId(String TeaId);
	
}
