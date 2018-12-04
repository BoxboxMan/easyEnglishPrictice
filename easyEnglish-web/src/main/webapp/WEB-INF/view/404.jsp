<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<title>404报错页面</title>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<style type="text/css">
	body{
	background:url("image/404.jpg") no-repeat;
	font-family:"微软雅黑";
	background-size:100%;
	}
	#div1{margin-top:35%;margin-left:40%;}
	#div2{margin-left:42%;}
	.btn-primary{margin-right:5%;background-color:#00bfb4;border:none;}
	span{color:#00bfb4;}
</style>
<script>
var t=5;//设定跳转的时间
setInterval("refer()",1000); //每过1秒运行一次refer()
//倒计时跳转函数
function refer(){
if(t==0){
　　location="${pageContext.request.contextPath}/welcome.html"; //#设定跳转的链接地址
　　}
else if(t>0){
   t--; // 计数器递减
　　document.getElementById('time').innerHTML=t; // 显示倒计时
   }   	 
}
</script>
</head>
<body>
	<h1>${excpetionMessage }</h1>
	<div class="col-md-4" id="div1">
		<p>即将离开本页，<span id="time">5</span>秒后自动返回上一页</p>
	</div>
	<div class="col-md-4" id="div2">
		<button class="btn btn-primary">立即返回</button>
		<button class="btn btn-primary"><a href="${pageContext.request.contextPath}/welcome.html">返回首页</a></button>
	</div>
</body>
</html>