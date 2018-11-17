<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
		function queryUpdateSubmit(){
			document.itemsform.action="${pageContext.request.contextPath }/items/queryUpdateSubmit.action";
			document.itemsform.submit();
		}
	</script>
</head>
<body>
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
			<th>商品名称</th>
			<th>商品价格</th>
			<th>商品描述</th>
			<th>生产日期</th>
		</tr>
		<c:forEach items="${itemsList }" var="item" varStatus="status">
			<tr>
				<td><input type="text" name="listItemsCustom[${status.index}].name" value="${item.name }"/> </td>
				<td><input type="text" name="listItemsCustom[${status.index}].price" value="${item.price }"/> </td>
				<td><input type="text" name="listItemsCustom[${status.index}].detail" value="${item.detail }"/></td>
				<td><input type="text" name="listItemsCustom[${status.index}].createtime" value="<fmt:formatDate value="${item.createtime }"
						pattern="yyyy-MM-dd HH:mm:ss" />" > 
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td><input type="button" value="批量修改提交" onclick="queryUpdateSubmit()"></td>
		</tr>
	</table>
</form>
</body>
</html>