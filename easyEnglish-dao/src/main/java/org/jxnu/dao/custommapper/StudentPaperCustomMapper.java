package org.jxnu.dao.custommapper;

import java.util.List;

import org.jxnu.pojo.custom.StudentPaperCustom;

public interface StudentPaperCustomMapper {
	List<StudentPaperCustom> selectStudentPaperCustomByStudentId(String id);
}
