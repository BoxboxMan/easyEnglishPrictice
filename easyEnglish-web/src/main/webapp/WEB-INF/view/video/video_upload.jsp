<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/adminStatic/js/jquery.min.js"></script>
</head>
<body>
	<center>
	  <form action="${pageContext.request.contextPath}/video/upload.html" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>视频名称：</td>
				<td><input name="name" id="name" type="text"></td>
			</tr>
			<tr>
				<td>视频路径：</td>
				<input type="file" style="display: none;" id="file" name="file"
					onchange="javascript:document.getElementById('showLocation').value = document.getElementById('file').value">
				<td><input type="text" id="showLocation" readonly></td>
				<td><input type="button" id="upLoad" value="浏览" 
					onclick="javascript:document.getElementById('file').click()"></td>
			</tr>
			<tr>
				<td>视频描述：</td>
				<td><input name="descprit" type="text" id="descprit"></td>
			</tr>
			<tr>
				<td><input type="submit" value="上传"></td>
			</tr>
		</table>
	   </form>
	   <button><a href="${pageContext.request.contextPath }/video/list.html">返回视频列表</a></but
	</center>
</body>
</html>