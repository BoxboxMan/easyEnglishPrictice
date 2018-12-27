package org.jxnu.pojo.custom;

import java.util.List;

import org.jxnu.pojo.OptionInfo;
import org.jxnu.pojo.QuestionInfo;

public class AddQuestionCustom extends QuestionInfo {
	private int sn;
	private int passage;
	private List<OptionInfo> options;
	
	public List<OptionInfo> getOptions() {
		return options;
	}
	public void setOptions(List<OptionInfo> options) {
		this.options = options;
	}
	public int getPassage() {
		return passage;
	}
	public void setPassage(int passage) {
		this.passage = passage;
	}
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	
}
