package org.jxnu.service.paper.impl;

import java.util.ArrayList;
import java.util.List;
import org.jxnu.dao.custommapper.PassageCustomMapper;
import org.jxnu.dao.custommapper.QuestionCustomMapper;
import org.jxnu.dao.custommapper.StudentPaperCustomMapper;
import org.jxnu.dao.generator.OptionInfoMapper;
import org.jxnu.dao.generator.PaperInfoMapper;
import org.jxnu.dao.generator.QuestionInfoMapper;
import org.jxnu.dao.generator.StudentPaperAnswerMapper;
import org.jxnu.dao.generator.StudentPaperMapper;
import org.jxnu.pojo.OptionInfo;
import org.jxnu.pojo.OptionInfoExample;
import org.jxnu.pojo.OptionInfoExample.Criteria;
import org.jxnu.pojo.PaperInfo;
import org.jxnu.pojo.PassageInfo;
import org.jxnu.pojo.QuestionCustom;
import org.jxnu.pojo.StudentPaper;
import org.jxnu.pojo.StudentPaperAnswer;
import org.jxnu.pojo.StudentPaperVo;
import org.jxnu.pojo.custom.StudentPaperCustom;
import org.jxnu.service.paper.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaperServiceImpl implements PaperService {

	@Autowired
	private PaperInfoMapper paperInfoMapper;
	@Autowired
	private QuestionCustomMapper questionCustomMapper;
	@Autowired
	private PassageCustomMapper passageCustomMapper;
	@Autowired
	private OptionInfoMapper optionInfoMapper;
	@Autowired
	private StudentPaperMapper studentPaperMapper;
	@Autowired
	private StudentPaperAnswerMapper studentPaperAnswerMapper;
	@Autowired
	private QuestionInfoMapper questionInfoMapper;
	@Autowired
	private StudentPaperCustomMapper studentPaperCustomMapper;

	@Override
	public List<PaperInfo> getAll() {
		return paperInfoMapper.selectAll();
	}

	@Override
	public List<QuestionCustom> getQuestions(Long paperId) {
		List<QuestionCustom> questionCustoms = questionCustomMapper.selectQuestionCustomsByPaperId(paperId);
		for (QuestionCustom questionCustom : questionCustoms) {
			switch (questionCustom.getType()) {
			// 题型为0，阅读题，将文章放到attachment
			case 0:
				PassageInfo passage = passageCustomMapper.selectPassageByQuestionId(questionCustom.getId());
				List<Object> attachment0 = new ArrayList<>();
				attachment0.add(passage);
				questionCustom.setAttachment(attachment0);

				// 题型为1，选择题，将options放到attachment
			case 1:
				OptionInfoExample example = new OptionInfoExample();
				Criteria criteria = example.createCriteria();
				criteria.andQuestionIdEqualTo(questionCustom.getId());
				List<OptionInfo> options = optionInfoMapper.selectByExample(example);
				if (questionCustom.getType() == 0) {
					List<Object> attachment1 = questionCustom.getAttachment();
					attachment1.add(options);
					questionCustom.setAttachment(attachment1);
				} else {
					List<Object> attachment1 = new ArrayList<>();
					attachment1.add(options);
					questionCustom.setAttachment(attachment1);
				}
				break;

			default:
				break;
			}
		}

		return questionCustoms;
	}

	@Override
	public PaperInfo selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return paperInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public void saveStudentPaperVo(StudentPaperVo studentPaperVo, String id) {
		// TODO Auto-generated method stub
		StudentPaper studentPaper = studentPaperVo.getStudentPaper();
		List<StudentPaperAnswer> answerList = studentPaperVo.getAnswerList();
		List<String> rightAnswerList = studentPaperVo.getRightAnswerList();

		studentPaper.setStudentId(id);
		studentPaperMapper.insert(studentPaper);
		for (int i = 0; i < answerList.size(); i++) {
			StudentPaperAnswer answer = answerList.get(i);
			answer.setStudentPaperId(studentPaper.getId());
			// 给这道题评分
			if (answer.getAnswer() == null) {
				answer.setScore(0);
			} else if (answer.getAnswer().equals(rightAnswerList.get(i)) && answer.getType().equals(0)) {
				int score = questionInfoMapper.selectByPrimaryKey(answer.getQuestionId()).getScore();
				answer.setScore(score);
			} else {
				answer.setScore(-1);
			}
			studentPaperAnswerMapper.insert(answer);
		}

	}

	@Override
	public List<StudentPaperCustom> getStudentPaper(String id) {
		return studentPaperCustomMapper.selectStudentPaperCustomByStudentId(id);
	}

}
