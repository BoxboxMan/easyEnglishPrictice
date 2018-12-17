package org.jxnu.service.paper.impl;

import java.util.ArrayList;
import java.util.List;
import org.jxnu.dao.custommapper.AnswerCustomMapper;
import org.jxnu.dao.custommapper.PassageCustomMapper;
import org.jxnu.dao.custommapper.QuestionCustomMapper;
import org.jxnu.dao.custommapper.StudentPaperCustomMapper;
import org.jxnu.dao.generator.OptionInfoMapper;
import org.jxnu.dao.generator.PaperInfoMapper;
import org.jxnu.dao.generator.QuestionInfoMapper;
import org.jxnu.dao.generator.StudentAnswerEssayMapper;
import org.jxnu.dao.generator.StudentPaperAnswerMapper;
import org.jxnu.dao.generator.StudentPaperMapper;
import org.jxnu.pojo.OptionInfo;
import org.jxnu.pojo.OptionInfoExample;
import org.jxnu.pojo.OptionInfoExample.Criteria;
import org.jxnu.pojo.PaperInfo;
import org.jxnu.pojo.PassageInfo;
import org.jxnu.pojo.QuestionCustom;
import org.jxnu.pojo.StudentAnswerEssay;
import org.jxnu.pojo.StudentPaper;
import org.jxnu.pojo.StudentPaperVo;
import org.jxnu.pojo.custom.StudentPaperAnswerCustom;
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
	@Autowired
	private StudentAnswerEssayMapper studentAnswerEssayMapper;
	@Autowired
	private AnswerCustomMapper answerCustomMapper;
	
	@Override
	public List<PaperInfo> getAll() {
		return paperInfoMapper.selectAll();
	}

	@Override
	public List<QuestionCustom> getQuestions(Long paperId) {
		List<QuestionCustom> questionCustoms = questionCustomMapper.selectQuestionCustomsByPaperId(paperId);
		for (QuestionCustom questionCustom : questionCustoms) {
			switch (questionCustom.getType()) {
			// 题型为0，阅读题，将文章放到attachment[0]
			case 0:
				PassageInfo passage = passageCustomMapper.selectPassageByQuestionId(questionCustom.getId());
				List<Object> attachment0 = new ArrayList<>();
				attachment0.add(passage);
				questionCustom.setAttachment(attachment0);

				// 题型为1，选择题，将options放到attachment[0]或[1]
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
				//简答，翻译写作没有任何attachment
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
	public void saveStudentPaperVo(StudentPaperVo studentPaperVo, String id) throws Exception {
		StudentPaper studentPaper = studentPaperVo.getStudentPaper();
		List<StudentPaperAnswerCustom> answerList = studentPaperVo.getAnswerList();
		List<String> rightAnswerList = studentPaperVo.getRightAnswerList();
		
		studentPaper.setStudentId(id);
		studentPaperMapper.insert(studentPaper);
		boolean correct=true;
		int totalScore=0;
		for (int i = 0; i < answerList.size(); i++) {
			StudentPaperAnswerCustom answer = answerList.get(i);
			answer.setStudentPaperId(studentPaper.getId());
			// 给这道题评分
			switch (answer.getType()) {
			case 0:
			case 1:
				if (answer.getAnswer()!=null&&answer.getAnswer().equals(rightAnswerList.get(i))) {
					int score = questionInfoMapper.selectByPrimaryKey(answer.getQuestionId()).getScore();
					answer.setScore(score);
					totalScore=totalScore+score;
				} else {
					answer.setScore(0);
				}
				studentPaperAnswerMapper.insert(answer);
				break;
			case 2:
				if(answer.getAnswer()!=null) {
					answer.setScore(-1);
					correct=false;
				}
				else {
					answer.setScore(0);	
				}
				studentPaperAnswerMapper.insert(answer);
				break;
			case 3:
				if(answer.getAttachment()!=null) {
					answer.setScore(-1);
					studentPaperAnswerMapper.insert(answer);
					StudentAnswerEssay essay = new StudentAnswerEssay();
					essay.setEssay((String) answer.getAttachment());
					essay.setStudentAnswerId(answer.getId());
					studentAnswerEssayMapper.insert(essay);
					correct=false;
				}
				else {
					answer.setScore(0);
					studentPaperAnswerMapper.insert(answer);
				}
				break;
			default:
				throw new Exception("题型错误");
			}
		}
		//如果有主观题，将correct设为0，提示此卷未修改完成
		if(correct) {
			studentPaper.setCorrect(0);
			studentPaper.setScore(totalScore);
		}
		//没有主观题，将correct设为1，将totalScore设为总分
		else {
			studentPaper.setCorrect(1);
			studentPaper.setScore(totalScore);
		}
		studentPaperMapper.updateByPrimaryKey(studentPaper);
	}

	@Override
	public List<StudentPaperCustom> getStudentPaper(String id) {
		return studentPaperCustomMapper.selectByStudentId(id);
	}

	@Override
	public StudentPaperCustom getStudentPaperCustomByPrimaryKey(Long id) {
		StudentPaperCustom studentPaperCustom= studentPaperCustomMapper.selectByPrimaryKey(id);
		studentPaperCustom.setQuestions(getQuestions(studentPaperCustom.getPaperId()));
		studentPaperCustom.setAnswers(answerCustomMapper.selectByStudentPaperId(id));
		studentPaperCustom.setFullScore(studentPaperCustomMapper.selectFullScoreByPaperId(studentPaperCustom.getPaperId()));
		return studentPaperCustom;
	}


}
