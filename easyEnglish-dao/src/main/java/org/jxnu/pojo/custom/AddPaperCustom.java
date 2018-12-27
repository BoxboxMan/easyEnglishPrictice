package org.jxnu.pojo.custom;

import java.util.List;

import org.jxnu.pojo.PaperInfo;

public class AddPaperCustom extends PaperInfo {
	private List<AddQuestionCustom> questions;
	private List<String> passages;

	public List<AddQuestionCustom> getQuestions() {
		return questions;
	}

	public void setQuestions(List<AddQuestionCustom> questions) {
		this.questions = questions;
	}

	public List<String> getPassages() {
		return passages;
	}

	public void setPassages(List<String> passages) {
		this.passages = passages;
	}
	
}
