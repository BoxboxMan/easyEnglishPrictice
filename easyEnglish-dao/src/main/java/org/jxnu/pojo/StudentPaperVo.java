package org.jxnu.pojo;

import java.util.List;

import org.jxnu.pojo.custom.StudentPaperAnswerCustom;

//有学生答案，正确答案，StudentPaper
public class StudentPaperVo extends StudentPaper {
	private List<StudentPaperAnswerCustom> answerList;
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

	public List<StudentPaperAnswerCustom> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<StudentPaperAnswerCustom> answerList) {
		this.answerList = answerList;
	}
	
}
