package org.jxnu.pojo.custom;

import org.jxnu.pojo.StudentPaper;

public class StudentPaperCustom extends StudentPaper {
	private String paperName;

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
}
