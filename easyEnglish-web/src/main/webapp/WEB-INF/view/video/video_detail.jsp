<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body><center>
	<button><a href="${pageContext.request.contextPath }/video/list.html">返回视频列表</a></button>
	<video src="${pageContext.request.contextPath }/${video_url}" autoplay controls width="900" height="600"></video>
</center></body>	
</html>