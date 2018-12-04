<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body><center>
	<button><a href="${pageContext.request.contextPath }/video/uploadPage.html">上传视频</a></button>
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
			<td><button><a href="${pageContext.request.contextPath }/video/play.html?url=${video.url}">播放</a></button></td>
		</tr>	
	   </c:forEach>
	</table>
</center></body>
</html>