<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 这是登录弹窗界面模块 -->
<html>
<head>
<meta charset="UTF-8">
<link href="adminStatic/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="adminStatic/js/jquery.min.js"></script>
<script type="text/javascript" src="adminStatic/js/bootstrap.min.js"></script>
<style type="text/css">
	.alert-warning{display: none;margin: 0;padding: 5px 2px;font-size: 10px;}
</style>
<title>登录窗口</title>
<script>
	$(document).on("focus","#psd,#userid",function(){
		$("#err_message").hide();
	});
	$(document).on("keyup","#psd",function(){
		var psd=$("#psd").val();
		var reg=/^[0-9a-zA-Z]{6,15}$/;
		if(psd==""||psd==null){
			$("#psd_err").html("请输入密码！");
			$("#psd_err").show();
			}
		else if(!reg.test(psd)){
			$("#psd_err").html("密码格式不正确，请重新输入！");
			$("#psd_err").show();
			}
		else
			$("#psd_err").html("");
		});
	$(document).on("blur","#userid",function(){
		var userid=$("#userid").val();
		var reg1=/^\d{6,13}$/;
		if(userid==""||userid==null){
			$("#userid_err").html("请输入账号！");
			$("#userid_err").show();
		}
		else if(!reg1.test(userid)){
			$("#userid_err").html("账号格式不正确，请重新输入！");
			$("#userid_err").show();
		}
		else
			$("#userid_err").html("");
		});
	$(document).on("focus","#userid",function(){
		var userid=$("#userid").val();
		var reg1=/^\d{6,13}$/;
		if(userid==""||userid==null){
			$("#userid_err").html("请输入账号！");
			$("#userid_err").show();
		}
		else if(!reg1.test(userid)){
			$("#userid_err").html("账号格式不正确，请重新输入！");
			$("#userid_err").show();
		}
		else
			$("#userid_err").html("");
		});
		$(document).on("keyup","#userid",function(){
			var userid=$("#userid").val();
			var reg1=/^\d{6,13}$/;
			if(userid==""||userid==null){
				$("#userid_err").html("请输入账号！");
				$("#userid_err").show();
			}
			else if(!reg1.test(userid)){
				$("#userid_err").html("账号格式不正确，请重新输入！");
				$("#userid_err").show();
			}
			else
				$("#userid_err").html("");
			});
			$(document).on("click","#denglu",function(){
			  var userid=$("#userid").val();
			  var psd=$("#psd").val();
			  var userid_err=$("#userid_err").val();
			  var psd_err=$("#psd_err").val();;
			  if(userid!=null&&psd!=null&&userid_err==null&&psd_err==null){
				  $.ajax({
				        //直接"post"或者"get",不需要"doPost","doGet"，该函数到后端接收缓冲区会自动匹配
				        type : "get",      
				        //servlet文件名为Calculator，需要提前在web.xml里面注册
				        url : "login", 
				        data :$("#form").serialize(),     //密码           
				        success : function(Result)
				        {
				        	$("#err_message").html(Result);
				        	$("#err_message").show();
				        },
				        error : function(xhr, status, errMsg)
				        {
				             alert("数据传输失败!");
				        }
				    }); 
			  }
			});
</script>
</head>
<body>
	<!-- 登录模态框（Modal） -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog text-center">
						<div class="modal-content text-center">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
								</button>
								<h4 class="modal-title" id="myModalLabel">
									登录窗口
								</h4>
							</div>
							<form id="form">
							<div class="modal-body">
								<div class="row">
									<div class="col-md-4 col-md-offset-4"><input type="text" id="userid" class="form-control" name="username" placeholder="请输入账号/手机号"/></div>
									<div class="col-md-4 text-left"><label id="userid_err" class="alert alert-warning"></label></div>
								</div><br />
								<div class="row">
									<div class="col-md-4 col-md-offset-4"><input type="password" class="form-control" id="psd" name="password" placeholder="请输入密码"/></div>
									<div class="col-md-4 text-left"><label id="psd_err" class="alert alert-warning"></label></div>
								</div>
								<div class="row">
									<div class="col-md-6 col-md-offset-3"><input type="checkbox"/> 下次自动登录&nbsp;&nbsp;&nbsp;<a href="#">忘记密码?</a></div>
								</div>
								<label  id="err_message" class="alert alert-warning"></label>
							</div>
							<div class="modal-footer" style="text-align:center;">
								<button type="reset" class="btn btn-default">
									清空
								</button>
								<button type="button" class="btn btn-primary" id="denglu">
									登录
								</button>
							</div>
							</form>
						</div><!-- /.modal-content -->
				</div><!-- /.modal-dialog -->
			</div><!-- /.modal -->
			<script>
			$(function () { $('#myModal').modal('hide')});
			</script>
</body>
</html>