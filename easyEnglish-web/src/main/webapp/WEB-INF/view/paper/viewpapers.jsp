<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,minimum-scale=1.0">
<title>首页</title>
<link href="../adminStatic/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="../adminStatic/js/jquery.min.js"></script>
<script type="text/javascript" src="../adminStatic/js/bootstrap.min.js"></script>	
<script type="text/javascript" src="../adminStatic/js/papers.js"></script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li role="presentation"><a href="${pageContext.request.contextPath}/welcome.html">首页</a></li>
		<li role="presentation"><a href="#" onclick="goPage('viewStudentPapers.html')">我的试卷</a></li>
		<li role="presentation"><a href="#">错题本</a></li>
		<li role="presentation"><a href="#">题目收藏</a></li>
		<li role="presentation"><a href="#">我要刷题</a></li>
		<li role="presentation"><a href="${pageContext.request.contextPath}/paper/viewAddPaper.html">我要出卷</a></li>
		<li role="presentation"><a href="#" onclick="goPage('viewgGradePapers.html')">我要评卷</a></li>
	</ul>
	<div id="data">
	显示数据的div
	</div>
	<table class="table">
		<thead>
			<tr>
				<th>试卷名</th>
				<th>出卷时间</th>
			</tr>
		</thead>
		<c:forEach items="${papers}" var="paper">
			<tr>
				<td><a
					href="${pageContext.request.contextPath }/paper/getpaper.html?id=${paper.id}">
						${paper.paperName }</a></td>
				<td>${paper.paperDate}</td>
			<tr>
		</c:forEach>
	</table>
</body>
</html>

