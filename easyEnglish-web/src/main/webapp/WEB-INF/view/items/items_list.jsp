<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
		function queryDelete() {
			document.itemsform.action="${pageContext.request.contextPath }/items/queryDelete.action";
			document.itemsform.submit();
		}
		function queryUpdate(){
			document.itemsform.action="${pageContext.request.contextPath }/items/queryUpdate.action";
			document.itemsform.submit();
		}
		function listItems(){
			document.itemsform.action="${pageContext.request.contextPath }/items/listItems.action";
			document.itemsform.submit();
		}
	</script>
</head>
<body>
<%-- <shiro:hasPermission name="user:query">
	拥有查看商品信息诶
</shiro:hasPermission> --%>
<br>
<c:if test="${activeUser!=null }">
	欢迎您：${activeUser.username }
</c:if>
<a href="${pageContext.request.contextPath }/logout.action" >登出</a>
	<form name="itemsform"
		action="${pageContext.request.contextPath }/items/listItems.action"
		method="post" name="form">
		查询商品信息
		<table width="100%" border=1>
			<tr>
				<td>商品名称：<input type="text" name="itemsCustom.name" /></td>
				<td><input type="button" value="提交" onclick="listItems()"></td>
			</tr>
		</table>
	商品列表：
	<table width="100%" border=1>
		<tr>
			<th>选中</th>
			<th>商品名称</th>
			<th>图片</th>
			<th>商品价格</th>
			<th>商品描述</th>
			<th>生产日期</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${itemsList }" var="item">
			<tr>
				<td><input type="checkbox" name="items_id" value="${item.id}" /></td>
				<td>${item.name }</td>
				<td>${item.price }</td>
				<td><img src="/pic/photo/${item.pic}" /></td>
				<td>${item.detail }</td>
				<td><fmt:formatDate value="${item.createtime }"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td><a
					href="${pageContext.request.contextPath}/items/findItems.action?id=${item.id}">更新</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td><input type="button" value="批量删除" onclick="queryDelete()"></td>
			<td><input type="button" value="批量修改" onclick="queryUpdate()"></td>
		</tr>
	</table>
</form>
</body>
</html>