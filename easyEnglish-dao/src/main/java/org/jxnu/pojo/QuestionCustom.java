package org.jxnu.pojo;

import java.util.List;

public class QuestionCustom extends QuestionInfo {
	private List<Object> attachment;
//属性type 题型（0是阅读题，1是选择题，2是简答题，3是翻译写作）
	
	public List<Object> getAttachment() {
		return attachment;
	}

	public void setAttachment(List<Object> attachment) {
		this.attachment = attachment;
	}
	
}
