<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,minimum-scale=1.0">
<title>添加试卷</title>
<link href="../adminStatic/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="../adminStatic/js/jquery.min.js"></script>
<script type="text/javascript" src="../adminStatic/js/addPaper.js"></script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li role="presentation"><a href="${pageContext.request.contextPath}/welcome.html">首页</a></li>
		<li role="presentation"><a href="#">已出试卷</a></li>
	</ul>
	
	<form action="${pageContext.request.contextPath }/paper/addPaper.html" method="post" class="form-horizontal">
		<div id="show" class='container'>
			<div class='row'>
				<div class='form-group col-sm-12'>
					<label for='paperName' class='col-sm-2 control-label'>试卷名</label>
					<div class='col-sm-4'>
						<input class='form-control' id='paperName' type='text' name='paperName'
							placeholder='输入试卷名' required>
					</div>
					<label for='duration' class='col-sm-2 control-label'>考试时间</label>
					<div class='col-sm-4'>
						<input class='form-control' id='duration' type='text' name='duration'
							placeholder='输入考试时间'>
					</div>
				</div>
			</div>
			
		</div>
		<div class="btn-group" role="group" >
				<button type="button" class="btn btn-info btn-lg" id="addReading">添加阅读题</button>
				<button type="button" class="btn btn-info btn-lg" id="addtype1">添加选择题</button>
				<button type="button" class="btn btn-info btn-lg" id="addType2">添加简答题</button>
				<button type="button" class="btn btn-info btn-lg" id="addType3">添加写作翻译题</button>
				<button type="submit" class="btn btn-info btn-lg">提交</button>
			</div>
	</form>
</body>
</html>