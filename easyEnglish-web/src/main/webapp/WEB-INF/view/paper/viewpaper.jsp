<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试页面</title>
<script src="../adminStatic/js/jquery.min.js">
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/paper/submitanswer.html"
		method="post">

		<!-- 遍历所有题目 -->
		<c:forEach items="${questionCustoms}" var="questionCustom"
			varStatus="status">
			<c:choose>

				<c:when test="${questionCustom.type==0 }">
					<c:if
						test="${
	status.count ==1
	||questionCustom.attachment[0].id !=questionCustoms[status.index-1].attachment[0].id 
	}">
						<p>${questionCustom.attachment[0].passage}</p>
					</c:if>
					<div id="question">
						题目题目题目
						<p>${status.count}.${questionCustom.question}</p>
						<!-- 遍历题目的每个选项 -->
						<c:forEach items="${questionCustom.attachment[1] }" var="option">
							<!-- 答案 -->
							<input name="answerList[${status.index }].answer"
								value="${option.optionName }" type="radio">${option.details }<br>
						</c:forEach>
						<!-- 答案的题目的id -->
						<input type="hidden"
							name="answerList[${status.index }].questionId"
							value="${questionCustom.id }" />
						<!-- 答案的类型 -->
						<input type="hidden" name="answerList[${status.index }].type"
							value="0" />
						<!-- 正确答案 -->
						<input type="hidden" name="rightAnswerList[${status.index }]"
							value="${questionCustom.answer }">
					</div>
				</c:when>

				<c:when test="${questionCustom.type==1 }">
					<div id="question">
						题目题目题目
						<!-- 显示题目 -->
						<p>${status.count}.${questionCustom.question}</p>
						<!-- 遍历题目的每个选项 -->
						<c:forEach items="${questionCustom.attachment[0] }" var="option">
							<!-- 答案 -->
							<input name="answerList[${status.index }].answer"
								value="${option.optionName }" type="radio">${option.details }<br>
						</c:forEach>
						<!-- 答案的题目的id -->
						<input type="hidden"
							name="answerList[${status.index }].questionId"
							value="${questionCustom.id }" />
						<!-- 答案的类型 -->
						<input type="hidden" name="answerList[${status.index }].type"
							value="1" />
						<!-- 正确答案 -->
						<input type="hidden" name="rightAnswerList[${status.index }]"
							value="${questionCustom.answer }">
					</div>
				</c:when>

					<c:when test="${questionCustom.type==2 }">
					<!-- 显示题目 -->
					<p>${status.count}.${questionCustom.question}</p>
					<!-- 输入答案 -->
					<input type="text" name="answerList[${status.index }].answer">
					<!-- 答案的题目的id -->
					<input type="hidden" name="answerList[${status.index }].questionId"
						value="${questionCustom.id }" />
					<!-- 答案的类型 -->
					<input type="hidden" name="answerList[${status.index }].type"
						value="2" />
					<!-- 正确答案 -->
					<input type="hidden" name="rightAnswerList[${status.index }]"
						value="${questionCustom.answer }">
				</c:when>


				<c:when test="${questionCustom.type==3 }">
					<!-- 显示题目 -->
					<p>${status.count}.${questionCustom.question}</p>
					<!-- 输入答案 -->
					<textarea rows="5" cols="10"
						name="answerList[${status.index }].attachment"></textarea>
					<!-- 答案的题目的id -->
					<input type="hidden" name="answerList[${status.index }].questionId"
						value="${questionCustom.id }" />
					<!-- 答案的类型 -->
					<input type="hidden" name="answerList[${status.index }].type"
						value="3" />
					<!-- 正确答案 -->
					<input type="hidden" name="rightAnswerList[${status.index }]"
						value="${questionCustom.answer }">
				</c:when>
			</c:choose>
		</c:forEach>

		<!-- 试卷的id -->
		<input type="hidden" name="studentPaper.paperId" value="${paper.id }" />
		<input type="submit" value="提交" >
	</form>
</body>
</html>