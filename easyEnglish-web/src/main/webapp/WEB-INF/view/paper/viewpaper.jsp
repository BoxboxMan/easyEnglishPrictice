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
	<script>
		$(document).ready(function() {
			$("#submit").click(function() {
				$.post("${pageContext.request.contextPath }/paper/submitanswer.html", $("form").serializeArray()
						)
			})
			
		})
	</script>
</head>
<body>
	<form
		method="post">
		<!-- 试卷的id -->
		<input type="hidden" name="studentPaper.paperId" value="${paper.id }" />
		<pre>${questionCustoms[0].attachment[0].passage}</pre>
		<!-- 遍历所有题目 -->
		<c:forEach items="${questionCustoms}" var="questionCustom"
			varStatus="status">
			<c:if
				test="${questionCustom.type }==0&&
	(${questionCustom.attachment[0].id }!=${questionCustoms[status.count-1].attachment[0].id }
	||${status.count }==1
	)">
				
					<p>${questionCustom.attachment[0].passage}</p>
			</c:if>
			<div id="question">题目题目题目
			<!-- 显示题目 -->
			<p>${status.count}.${questionCustom.question}</p>
			<!-- 遍历题目的每个选项 -->
			<c:forEach items="${questionCustom.attachment[1] }" var="option">
				<!-- 答案 -->
				<input name="answerList[${status.index }].answer"
					value="${option.optionName }" type="radio">${option.details }<br>
			</c:forEach>
			<!-- 答案的题目的id -->
			<input type="hidden" name="answerList[${status.index }].questionId"
				value="${questionCustom.id }" />
			<!-- 答案的类型 -->
			<input type="hidden" name="answerList[${status.index }].type"
				value="0" />
			<!-- 正确答案 -->
			<input type="hidden" name="rightAnswerList[${status.index }]" value="${questionCustom.answer }"
			</div>
		</c:forEach>
		<input type="button" id="submit" value="提交" >
	</form>
</body>
</html>