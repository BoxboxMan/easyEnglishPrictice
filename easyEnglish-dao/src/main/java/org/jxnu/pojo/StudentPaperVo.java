package org.jxnu.pojo;

import java.util.List;

import org.jxnu.pojo.custom.AnswerCustom;

//有学生答案，正确答案，StudentPaper
public class StudentPaperVo extends StudentPaper {
	private List<AnswerCustom> answerList;
	private StudentPaper studentPaper;
	private List<String> rightAnswerList;
	
	public List<String> getRightAnswerList() {
		return rightAnswerList;
	}

	public void setRightAnswerList(List<String> rightAnswerList) {
		this.rightAnswerList = rightAnswerList;
	}

	public StudentPaper getStudentPaper() {
		return studentPaper;
	}

	public void setStudentPaper(StudentPaper studentPaper) {
		this.studentPaper = studentPaper;
	}

	public List<AnswerCustom> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<AnswerCustom> answerList) {
		this.answerList = answerList;
	}
	
}
