package org.jxnu.pojo.custom;

import org.jxnu.pojo.PaperInfo;
//不包括试卷内容，包括试卷成绩的统计信息等
public class PaperInfoCustom extends PaperInfo {
	//平均分
	private int average;
	//完成的人数
	private int totalStudents;
	//未评分的人数
	private int toGrade;
	public int getAverage() {
		return average;
	}
	public void setAverage(int average) {
		this.average = average;
	}
	public int getTotalStudents() {
		return totalStudents;
	}
	public void setTotalStudents(int totalStudents) {
		this.totalStudents = totalStudents;
	}
	public int getToGrade() {
		return toGrade;
	}
	public void setToGrade(int toGrade) {
		this.toGrade = toGrade;
	}
	
}
