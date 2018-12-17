<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看已完成的试卷</title>
</head>
<body>
<c:forEach items="${studentPaperCustom.questions}" var="questionCustom"
			varStatus="status">
			<c:choose>
				
				<c:when test="${questionCustom.type==0 }">
					<c:if
						test="${
	status.count ==1
	||questionCustom.attachment[0].id !=studentPaperCustom.questions[status.index-1].attachment[0].id 
	}">
						<p>${questionCustom.attachment[0].passage}</p>

					</c:if>
					<div id="question">
						题目题目题目
						<p>${status.count}.${questionCustom.question}</p>
						<!-- 遍历题目的每个选项 -->
						<c:forEach items="${questionCustom.attachment[1] }" var="option">
							<!-- 答案 -->
						${option.optionName }. ${option.details }<br>
						</c:forEach>
						<!-- 正确答案 -->
						你的答案：${studentPaperCustom.answers[status.index].answer }</br>
						正确答案：${questionCustom.answer }</br>
						解析：${questionCustom.anno }</br>
					</div>
				</c:when>

				<c:when test="${questionCustom.type==1 }">
					<div id="question">
						题目题目题目
						<!-- 显示题目 -->
						<p>${status.count}.${questionCustom.question}</p>
						<!-- 遍历题目的每个选项 -->
						<c:forEach items="${questionCustom.attachment[1] }" var="option">
							<!-- 答案 -->
							${option.optionName }. ${option.details }<br>
						</c:forEach>
						<!-- 正确答案 -->
						你的答案：${studentaperCustom.answers[status.index].answer }
						正确答案：${questionCustom.answer }
						解析：${questionCustom.anno }
					</div>
				</c:when>

				<c:when test="${questionCustom.type==2 }">
					<!-- 显示题目 -->
					<p>${status.count}.${questionCustom.question}</p>
					<!-- 输入答案 -->
					你的答案：<input type="text" value="${studentPaperCustom.answers[status.index].answer }" readonly="readonly">
					<!-- 正确答案 -->
					参考答案：${questionCustom.answer }
					解析：${questionCustom.anno }
				</c:when>


				<c:when test="${questionCustom.type==3 }">
					<!-- 显示题目 -->
					<p>${status.count}.${questionCustom.question}</p>
					<!-- 输入答案 -->
					你的答案：<textarea rows="25" cols="50">${studentPaperCustom.answers[status.index].attachment }
						</textarea></br>
					<!-- 正确答案 -->
					参考答案：${questionCustom.answer }</br>
					解析：${questionCustom.anno }</br>
				</c:when>
			</c:choose>
		</c:forEach>
</body>
</html>