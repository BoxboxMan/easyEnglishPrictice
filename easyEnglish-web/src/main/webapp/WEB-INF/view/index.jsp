<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,minimum-scale=1.0">
<title>首页</title>
<link href="adminStatic/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="adminStatic/js/jquery.min.js"></script>
<script type="text/javascript" src="adminStatic/js/bootstrap.min.js"></script>
<style type="text/css">
ul {
	padding-top: 3px;
}

ul li a {
	font-family: "微软雅黑";
	font-size: large;
	color: white;
}

#header {
	background-color: #ff8b8b;
	margin-bottom: 0;
}

.item img {
	width: 100%;
}

.row {
	margin-top: 20px;
}

.row ul li {
	width: 18%;
	float: left;
	margin-right: 7%;
}

.div1 {
	background-color: #f6f6f6;
}

.row ul li img {
	width: 100%;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default" id="header" role="navigation">
		<div class="container">
			<div class="col-md-8">
				<ul class="nav nav-tabs nav-justified">
					<li><a href="${pageContext.request.contextPath}/welcome.html">首页</a></li>
					<li><a
						href="${pageContext.request.contextPath }/video/list.html">视频</a></li>
					<li><a
						href="${pageContext.request.contextPath }/paper/getpapers.html">刷题</a></li>
					<li><a
						href="${pageContext.request.contextPath }/personal.html">个人中心</a></li>
					<li><a href="#">Java</a></li>
					<li><a href="#">PHP</a></li>
				</ul>
			</div>
			<div class="col-md-4">
				<form class="navbar-form navbar-right" role="search">
					<button type="button" class="btn btn-default">
						<span class="glyphicon glyphicon-log-in"></span> 登录
					</button>
					<a id="logout" onclick="logout()"
						href="${pageContext.request.contextPath}/logout.html">
						<button type="button" class="btn btn-default">
							<span class="glyphicon glyphicon-user"></span>登出
						</button>
					</a>
					<button type="button" class="btn btn-default">
						<span class="glyphicon glyphicon-user"></span> 注册
					</button>
				</form>
			</div>
		</div>
	</nav>
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- 轮播（Carousel）指标 -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<!-- 轮播（Carousel）项目 -->
		<div class="carousel-inner">
			<div class="item active">
				<img src="image/index.jpg" alt="First slide">
			</div>
			<div class="item">
				<img src="image/index.jpg" alt="Second slide">
			</div>
			<div class="item">
				<img src="image/index.jpg" alt="Third slide">
			</div>
		</div>
		<!-- 轮播（Carousel）导航 -->
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev" data-interval="1500"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<div class="container" id="div1">
		<div class="row text-center">
			<h3>选择XXXXX四大理由</h3>
			<h3>立即快速备齐竞争力 挑战名企高薪</h3>
			<ul>
				<li><img src="adminStatic/image/1.png" alt="" />
					<h5>全球外教守候</h5>
					<p>通过TESOL、TEFL资格认证的全球20000+外教，24小时真人指导，让您轻松进入全英文语言环境。</p>
					<div class="clear"></div></li>
				<li class="item-none"><img src="adminStatic/image/2.png" alt="" />
					<h5>精准匹配教材</h5>
					<p>根据您的需求及兴趣智能匹配教材，量身定制，依据12个等级细分学习水平，制定精准提升计划。</p>
					<div class="clear"></div></li>
				<li><img src="adminStatic/image/3.png" alt="" />
					<h5>随时随地学习</h5>
					<p>上课地点自由，随处都是您的英语教室。与其把时间浪费在交通上，不如稳坐家中轻松学习。</p>
					<div class="clear"></div></li>
				<li class="item-none"><img src="adminStatic/image/4.png" alt="" />
					<h5>品牌实力保证</h5>
					<p>专注在线英语20年，服务人次超1.8亿，95%的客户满意度，成就英语在线教育领先品牌。</p>
					<div class="clear"></div></li>
			</ul>
			<div class="clear"></div>
		</div>
	</div>
	<div class="panel-footer text-center">
		<p>商务合作|关于我们|服务条款|信息反馈|联系我们</p>
		<p>©2018 EasyEnglish 版权所有</p>
	</div>
</body>
</html>
<script type="text/javascript">
	function logout() {
		alert("已退出！");
	}
</script>