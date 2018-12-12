package org.jxnu.pojo;

import java.util.List;

public class PaperCustom extends PaperInfo {
	private List<QuestionCustom> questions;

	public List<QuestionCustom> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionCustom> questions) {
		this.questions = questions;
	}
	
}
