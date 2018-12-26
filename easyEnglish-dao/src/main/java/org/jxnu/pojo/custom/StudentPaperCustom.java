package org.jxnu.pojo.custom;

import java.util.List;

import org.jxnu.pojo.QuestionCustom;
import org.jxnu.pojo.StudentPaper;

//有题目，答案的studentPaper
public class StudentPaperCustom extends StudentPaper {
	private String paperName;
	private int fullScore;
	private String studentName;
	private List<QuestionCustom> questions;
	private List<AnswerCustom> answers;
	
	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public int getFullScore() {
		return fullScore;
	}

	public void setFullScore(int fullScore) {
		this.fullScore = fullScore;
	}

	public List<QuestionCustom> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionCustom> questions) {
		this.questions = questions;
	}

	public List<AnswerCustom> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerCustom> answers) {
		this.answers = answers;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
}
