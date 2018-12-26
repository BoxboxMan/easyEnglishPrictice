<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../adminStatic/js/bootstrap.min.js"></script>	
</head>
<body>
	<form action="" method="post" class="form-horizontal">
		<c:forEach items="${subStuPaper.questions }" var="question"
			varStatus="status">
			<div>${question.question }</div>
			<c:choose>
				<c:when test="${question.type==2 }">
					<input type="text" readonly
						value="${subStuPaper.answers[status.index].answer }">
				</c:when>
				<c:otherwise>
					<textarea rows="10" cols="30" readonly>${subStuPaper.answers[status.index].attachment }</textarea>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</form>
</body>
</html>