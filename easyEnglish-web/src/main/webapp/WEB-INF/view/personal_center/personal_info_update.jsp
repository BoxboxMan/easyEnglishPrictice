<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,minimum-scale=1.0">
<title>修改个人信息</title>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="../adminStatic/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="../adminStatic/css/style.css">
<script type="text/javascript" src="../adminStatic/js/jquery.min.js"></script>
<script type="text/javascript" src="../adminStatic/js/bootstrap.min.js"></script>
<link href="../adminStatic/css/style_personal.css" rel='stylesheet' type='text/css' />
<!--fonts--> 
<link href="//fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700,800" rel="stylesheet">
<!--//fonts--> 
</head>
<body>
<!--background-->
<!-- login -->
<h1>个人信息</h1>
	        <div class="login-w3l">	
			<div class="top-img-agileits-w3layouts">
				<h2 class="sub-head-w3-agileits">修改个人信息</h2>
				<p>请在需要修改的位置填写正确有效的信息!</p>
			</div>			
			<div class="login-form">	
					<input type="text" name="username" id="username" placeholder="名称" required="" />
					<input type="password" name="password" id="password" placeholder="登陆密码" required="" />
					<input type="password" name="password_config" id="password_config" placeholder="确认密码" required="" />
					<textarea name="Comments" id="comments" placeholder="个人简介" required=""></textarea>
					<input type="submit" onclick="update()" value="修改">
			</div>
			<!-- //login -->
				</div> 
				<div class="clear"></div>
			<div class="footer-agileits">
			<p>© 2018 EasyEnglish.</p>
			</div>
			<!--//login-->
</body>
</html>
<script type="text/javascript">
/* function check(){
	if(${"#password_config"}==""||${"#passwor"}==""){
		
	}
} */
/* 	$(document).on("keyup",'#password_config',function(){
	var psd=$("#password_config").val();
	//var reg=/^[0-9a-zA-Z]{6,15}$/;
	if(psd==""||psd==null){
		alert("请输入密码！");
		}
	else if(psd!=${"#password"}.val()){
		alert("两次密码不相同");
		}
	});
	 */
	function update(){
		$.ajax({
			type:"post",
			dataType:"json",
			url:"${pageContext.request.contextPath}/personal/updateSysUser.action",
			data:{
				username:$('#username').val(),
				password:$('#password').val()
			},
			success:function(data){
				if(data > 0){
					alert("更新成功！");
					location="${pageContext.request.contextPath }/personal.html";
				}else{
					alert("更新失败！");
				}
			}
		})
	}
</script>