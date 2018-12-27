<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Social Media Bar Flat Responsive Widget Template ::
	w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!--Custom Theme files-->
<link href="../adminStatic/css/style_vedio.css" rel="stylesheet" type="text/css" media="all" />
<!--//Custom Theme files -->
<!--web font-->
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<!--web font-->
<!--web font-->
</head>
<body>
	<!-- main -->
	<div class="main">
		<h1>视 频 列 表</h1>
		<!--main-top-->
		<div class="main-info">
			<div class="row-one">
			  <c:forEach items="${videos }" var="video">
				<div class="social-left">
					<ul>
						<li>
							<h4><div style='width:110px;white-space:nowrap;text-overflow:ellipsis;overflow:hidden;' title='${video.name }'>${video.name }</div></h4>
							<h5>名称</h5>
						</li>
						<li>
							<h4><div style='width:110px;white-space:nowrap;text-overflow:ellipsis;overflow:hidden;' title='${video.descprit }'>${video.descprit }</div></h4>
							<h5>描述</h5>
						</li>
						<li>
							<h4><div style='width:110px;white-space:nowrap;text-overflow:ellipsis;overflow:hidden;' title='${video.userId }'>${video.userId }</div></h4>
							<h5>上传者</h5>
						</li>
						<li>
							<h4><button>
									<a
										href="${pageContext.request.contextPath }/video/play.html?url=${video.url}">播放</a>
								</button></h4>
						</li>
					</ul>
				</div>
				<div class="social-middle">
					<h2>Need advice or just want to share?</h2>
					<p>Send this decision to your friends...
					<p>
				</div>
				<div class="social-right">
					<div class="social-icons">
						<ul>
							<li><a href="#"> </a></li>
							<li><a href="#" class="twt"> </a></li>
							<li><a href="#" class="ggp"> </a></li>
							<li><a href="#" class="msg"> </a></li>
						</ul>
					</div>
				</div>
				<div class="clear"></div>
				</c:forEach>
			</div>
			<!-- <div class="row-one two">
				<div class="social-left">
					<ul>
						<li>
							<h4>25</h4>
							<h5>DAYS LEFT</h5>
						</li>
						<li>
							<h4>420</h4>
							<h5>FOLLOWERS</h5>
						</li>
						<li>
							<h4>100</h4>
							<h5>LIKES</h5>
						</li>
						<li>
							<h4>260</h4>
							<h5>SHARES</h5>
						</li>
					</ul>
				</div>
				<div class="social-middle">
					<h3>Need advice or just want to share?</h3>
					<p>Send this decision to your friends...<p>
				</div>
				<div class="social-right">
					<div class="social-icons">
						<ul>
							<li>
								<a href="#"> </a>
							</li>
							<li>
								<a href="#" class="twt"> </a>
							</li>
							<li>
								<a href="#" class="ggp"> </a>
							</li>
							<li>
								<a href="#" class="msg"> </a>
							</li>
						</ul>
					</div>
				</div>
				<div class="clear"> </div>
			</div>
			<div class="row-one three">
				<div class="social-left">
					<ul>
						<li>
							<h4>25</h4>
							<h5>DAYS LEFT</h5>
						</li>
						<li>
							<h4>420</h4>
							<h5>FOLLOWERS</h5>
						</li>
						<li>
							<h4>100</h4>
							<h5>LIKES</h5>
						</li>
						<li>
							<h4>260</h4>
							<h5>SHARES</h5>
						</li>
					</ul>
				</div>
				<div class="social-middle">
					<h3>Need advice or just want to share?</h3>
					<p>Send this decision to your friends...<p>
				</div>
				<div class="social-right">
					<div class="social-icons">
						<ul>
							<li>
								<a href="#"> </a>
							</li>
							<li>
								<a href="#" class="twt"> </a>
							</li>
							<li>
								<a href="#" class="ggp"> </a>
							</li>
							<li>
								<a href="#" class="msg"> </a>
							</li>
						</ul>
					</div>
				</div>
				<div class="clear"> </div>
			</div> -->
		</div>
	</div>
	<!--copy-right-->
	<div class="copyright">
		<p>
			&copy; 2016 Social Media Bar . All rights reserved  <a
				href="${pageContext.request.contextPath}/welcome.html" target="_blank">返回首页</a>
		</p>
	</div>
	<!--//copy-right-->
</body>
</html>