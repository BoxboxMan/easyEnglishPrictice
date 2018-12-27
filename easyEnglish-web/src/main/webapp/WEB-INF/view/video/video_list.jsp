<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="adminStatic/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="adminStatic/css/style.css">
<script type="text/javascript" src="adminStatic/js/jquery.min.js"></script>
<script type="text/javascript" src="adminStatic/js/bootstrap.min.js"></script>
</head>
<body>
<ul class="nav nav-tabs nav-justified">
	<li><a href="${pageContext.request.contextPath}/welcome.html">首页</a></li>
	<li><a href="#">视频</a></li>
	<li><a href="#">刷题</a></li>
	<li><a href="#">个人中心</a></li>
	<li><a href="#">Java</a></li>
	<li><a href="#">PHP</a></li>
</ul>
	<form action="${pageContext.request.contextPath }/video/list.html" method="post">
		<input type="text" name="name" value="${video.name }">
		<input type="submit" value="搜索">
	</form>
	<button>
		<a href="${pageContext.request.contextPath }/video/uploadPage.html">上传视频</a>
	</button>
	<table border="1">
		<tr>
			<th>视频名称</th>
			<th>视频描述</th>
			<th>上传者</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${videos }" var="video">
			<tr>
				<td>${video.name }</td>
				<td>${video.descprit }</td>
				<td>${video.userId }</td>
				<td><button>
						<a
							href="${pageContext.request.contextPath }/video/play.html?url=${video.url}">播放</a>
					</button></td>
			</tr>
		</c:forEach>
	</table>
	<div class="text-center" id="footer">
	<p>商务合作|关于我们|服务条款|信息反馈|联系我们</p>
	<p>©2018 easyEnglish 版权所有</p>
</div>
</body>
</html>