<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,minimum-scale=1.0">
<title>首页</title>
	<link href='//fonts.googleapis.com/css?family=Source+Sans+Pro:400,200italic,200,300,300italic,400italic,600,600italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="adminStatic/css/style404.css">
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body>
	<div class="main w3l">
		<h2>QAQ</h2>
		<h1> ERROR 404</h1>
		<h3>"请求的页面好像出问题了！"</h3>
		<a href="${pageContext.request.contextPath }/welcome.html" class="back">返 回 首 页</a>
		<div class="social-icons w3">
			<ul>
				<li><a class="twitter" href="#"></a></li>
				<li><a class="facebook" href="#"></a></li>
				<li><a class="pinterest" href="#"></a></li>
			</ul>
		</div>
		<div class="footer agileits">
			<p>Copyright © 2016 Simple Error Page. All Rights Reserved | Design by <a href="http://w3layouts.com" target="_blank">W3layouts</a></p>
		</div>
	</div>
</body>
</html>