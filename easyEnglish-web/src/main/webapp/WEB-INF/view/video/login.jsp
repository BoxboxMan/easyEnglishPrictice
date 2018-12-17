<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录注册页</title>
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
<div class="cotn_principal">
  <div class="cont_centrar">
    <div class="cont_login">
      <div class="cont_info_log_sign_up">
        <div class="col_md_login">
          <div class="cont_ba_opcitiy">
            <h2>登录</h2>
            <button class="btn_login" onClick="cambiar_login()">登录</button>
          </div>
        </div>
        <div class="col_md_sign_up">
          <div class="cont_ba_opcitiy">
            <h2>注册</h2>
            <button class="btn_sign_up" onClick="cambiar_sign_up()">注册</button>
          </div>
        </div>
      </div>
      <div class="cont_back_info">
        <div class="cont_img_back_grey"> <img src="image/po.jpg" alt="" /> </div>
      </div>
      <div class="cont_forms" >
        <div class="cont_img_back_"> <img src="image/po.jpg" alt="" /> </div>
        
        <div class="cont_form_login"> <a href="#" onClick="ocultar_login_sign_up()" ><i class="material-icons">&rarr;</i></a>
          <h2>登录</h2>
          <form action="${pageContext.request.contextPath}/login.html" method="post">
	          <input type="text" placeholder="请输入账户/邮箱"  name="username" id="username"/><br>
	          <p id="username_err" style="color:red"></p>
	          <input type="password" placeholder="请输入密码"  name="password" id="password"/>
	          <p id="password_err"  style="color:red"></p>
	          <div class="alert alert-danger alert-dismissable" style="display:none;bottom:0;"> 
				 <button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">
					&times;
				 </button>
				 账户或者密码错误！请重新输入。
			  </div>
	          <input type="submit" class="btn_login" id="btn_submit" value="登陆">
	      </form>
        </div>
      <form action="${pageContext.request.contextPath}/register.html" method="post">
        <div class="cont_form_sign_up"> <a href="#" onClick="ocultar_login_sign_up()"><i class="material-icons">&larr;</i></a>
        	  <input type="text" placeholder="用户名称" name="username" id="username"/>
	          <p id="username1_err" style="color:red"></p>
	          <input type="text" placeholder="请输入由数字/字母/下划线组成的用户名" name="usercode" id="usercode"/>
	          <p id="username1_err" style="color:red"></p>
	          <input type="password" placeholder="请输入6-15位数字、字母组成的密码"  name="password" id="password"/>
	          <p id="password1_err" style="color:red"></p>
	          <input type="password" placeholder="请确认密码"  name="confirm_password"  id="confirm_password"/>
	          <p id="confirm_password_err" style="color:red"></p>
	          <div class="alert alert-danger alert-dismissable" style="display:none;bottom:0;"> 
					 <button type="button" class="close" data-dismiss="alert"
							aria-hidden="true">
						&times;
					 </button>
					 账户或者密码错误！请重新输入。
				  </div>
	          <input type="submit" class="btn_sign_up" id="btn-zhuce" value="注册">
        </div>
     </form>
      </div>
    </div>
  </div>
<div class="text-center" id="footer">
	<p>商务合作|关于我们|服务条款|信息反馈|联系我们</p>
	<p>©2018 easyEnglish 版权所有</p>
</div>
</div>
<script src="adminStatic/js/yanzheng.js"></script>
<script src="adminStatic/js/index.js"></script>
</body>
</html>