//输入框获得焦点报错信息消除；
$(document).on("focus",".cont_form_login #password,.cont_form_login #usercode",function(){
	$(".cont_form_login .alert-danger").css("display","none")
});
//松开键盘判断密码输入框的值
$(document).on("keyup",".cont_form_login #usercode",function(){
	var usercode=$(".cont_form_login #usercode").val();
	var reg=/^[0-9a-zA-Z]{6,15}$/;
	if(usercode==""||usercode==null){
		$(".cont_form_login #usercode_err").html("请输入手机号/邮箱！");
		}
	else if(!reg.test(usercode)){
		$(".cont_form_login #usercode_err").html("长度不正确，请输入6-15的邮箱/手机号");
		}
	else
		$(".cont_form_login #usercode_err").html("");
	});
$(document).on("keyup",".cont_form_login #password",function(){
	var psd=$(".cont_form_login #password").val();
	var reg=/^[0-9a-zA-Z]{6,15}$/;
	if(psd==""||psd==null){
		$(".cont_form_login #password_err").html("请输入密码！");
		}
	else if(!reg.test(psd)){
		$(".cont_form_login #password_err").html("密码格式不正确，6-15的数字/字母组合");
		}
	else
		$(".cont_form_login #password_err").html("");
	});

//点击登录后与后端数据库进行交互

//$(document).on("click","#btn_submit",function(){
//			var usercode=$(".cont_form_login #usercode").val();
//	 		 var password=$(".cont_form_login #password").val();
//	 		var usercode_err=$(".cont_form_login #usercode_err").text();
//	 		var password_err=$(".cont_form_login #password_err").text();
//	 		 if(usercode!=""&&password!=""&&usercode_err==""&&password_err==""){
//	 			$.ajax({
//			        //直接"post"或者"get",不需要"doPost","doGet"，该函数到后端接收缓冲区会自动匹配
//			        type : "post",
//			        url :"${pageContext.request.contextPath}/login.html",
//			        data :{
//			        	"usercode":usercode,//获取输入的账号密码
//			        	"password":password,
//			        },
//			        success : function(Result)
//			        {
//			        	//Result为错误提示信息
////			        	if(Result!=null){
////			        		$(".cont_form_login .alert-danger").html(Result);//将servlet中的print的报错信息赋值到报警框中
////			        		$(".cont_form_login .alert-danger").css("display","block")//交互后报错信息显示
////			        	}
//			        	alert("登陆成功！");
//			        },
//			        error : function(xhr, status, errMsg)
//			        {
//			             alert("数据传输失败!");
//			        }
//			    }); 
//	 		 }
//		});
//松开键盘即与后端数据库连接查询邮箱是否已注册
$(document).on("keyup",".cont_form_sign_up #email",function(){
	var email=$(".cont_form_sign_up #email").val();
	var reg=/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
	//符合邮箱规范则进行交互
	if(reg.test(email)){
	$.ajax({
        //直接"post"或者"get",不需要"doPost","doGet"，该函数到后端接收缓冲区会自动匹配
        type : "get",
        url : "${pageContext.request.contextPath}/register.html", 
        data :{
        	"email":email,//获取手机号/邮箱
        },
        success : function(Result)
        {
        	//Result为错误提示信息
        	if(Result!=null){
        		$(".cont_form_login .alert-danger").html(Result);
        		$(".cont_form_login .alert-danger").css("display","block")
        	}
        	
        },
        error : function(xhr, status, errMsg)
        {
             alert("数据传输失败!");
        }
    }); 
	}
	else if(email==""||email==null){
		$(".cont_form_sign_up #email_err").html("请输入邮箱！");
		}
	else $(".cont_form_sign_up #email_err").html("请输入正确的邮箱！");
});
//松开键盘判断用户名输入框的值
$(document).on("keyup",".cont_form_sign_up #usercode",function(){
	var usercode=$(".cont_form_sign_up #usercode").val();
	var reg=/^[a-zA-Z0-9_-]{4,10}$/;
	if(usercode==""||usercode==null){
		$(".cont_form_sign_up #usercode1_err").html("请输入用户名！");
		}
	else if(!reg.test(usercode)){
		$(".cont_form_sign_up #usercode1_err").html("用户名长度不符合要求！");
		}
	else
		$(".cont_form_sign_up #usercode1_err").html("");
	});
//松开键盘判断密码输入框的值
$(document).on("keyup",".cont_form_sign_up #password",function(){
	var password=$(".cont_form_sign_up #password").val();
	var reg=/^[0-9a-zA-Z]{6,15}$/;
	if(password==""||password==null){
		$(".cont_form_sign_up #password1_err").html("请输入密码！");
		}
	else if(!reg.test(password)){
		$(".cont_form_sign_up #password1_err").html("请输入6-15位的数字或字母密码！");
		}
	else
		$(".cont_form_sign_up #password1_err").html("");
	});
//松开键盘判断二次密码输入框的值
$(document).on("keyup",".cont_form_sign_up #confirm_password",function(){
	var confirm_password=$(".cont_form_sign_up #confirm_password").val();
	var password=$(".cont_form_sign_up #confirm_password").val();
	if(confirm_password==""||confirm_password==null){
		$(".cont_form_sign_up #confirm_password_err").html("请再此输入密码以确认！");
		}
	else if(confirm_password!=password){
		$(".cont_form_sign_up #confirm_password_err").html("两次密码输入不一致！");
		}
	else
		$(".cont_form_sign_up #confirm_password_err").html("");
	});
//点击注册后提交到数据库中
//$(document).on("click","#btn_submit",function(){
//		var usercode=$(".cont_form_sign_up #usercode").val();
//		 var password=$(".cont_form_sign_up #password").val();
//		 var email=$(".cont_form_sign_up #email").val();
//		 var confirm_password=$(".cont_form_sign_up #confirm_password").val();
//		var usercode1_err=$(".cont_form_sign_up #usercode_err").text();
//		var password1_err=$(".cont_form_sign_up #password_err").text();
//		var email_err=$(".cont_form_sign_up #email_err").text();
//		var confirm_password_err=$(".cont_form_sign_up #confirm_password_err").text();
//		 if(usercode!=""&&password!=""&&email!=""&&confirm_password!=""&&
//			usercode1_err==""&&password1_err==""&&email_err==""&&confirm_password_err==""){
//			$.ajax({
//	        //直接"post"或者"get",不需要"doPost","doGet"，该函数到后端接收缓冲区会自动匹配
//	        type : "get",
//	        url :"${pageContext.request.contextPath}/register.html",
//	        data :{
//	        	"usercode":usercode,//获取输入的账号/密码/用户名
//	        	"password":password,
//	        	"email":email,
//	        },
//	        success : function(Result)
//	        {
//	        	//Result为错误提示信息
//	        	if(Result!=null){
//	        		$(".cont_form_sign_up .alert-danger").html(Result);//将servlet中的print的报错信息赋值到报警框中
//	        		$(".cont_form_sign_up .alert-danger").css("display","block")//交互后报错信息显示
//	        	}
//	        	
//	        },
//	        error : function(xhr, status, errMsg)
//	        {
//	             alert("数据传输失败!");
//	        }
//	    }); 
//		 }
//});