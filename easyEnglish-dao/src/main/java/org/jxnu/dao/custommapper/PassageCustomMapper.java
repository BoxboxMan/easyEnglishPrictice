package org.jxnu.dao.custommapper;

import org.jxnu.pojo.PassageInfo;

public interface PassageCustomMapper {
	PassageInfo selectPassageByQuestionId(Long id);
}
