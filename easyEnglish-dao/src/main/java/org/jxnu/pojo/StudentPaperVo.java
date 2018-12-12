package org.jxnu.pojo;

import java.util.List;

public class StudentPaperVo extends StudentPaper {
	private List<StudentPaperAnswer> answerList;
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

	public List<StudentPaperAnswer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<StudentPaperAnswer> answerList) {
		this.answerList = answerList;
	}
	
	
}
