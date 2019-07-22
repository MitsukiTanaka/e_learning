<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="date" class="java.util.Date" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/sales/resources/css/common.css" />
<title>山田オンラインショップ(明細追加画面)</title>
</head>
<body>
	<form:form modelAttribute="salesForm" action="/sales/system">
		<div class="header">
			<span class="titleName">山田オンラインショップ</span>
			<fmt:formatDate value="${date}" pattern="yyyy年MM月dd日（E）" />
		</div>

		<div class="main">
			<div>
				<span class="itemName">商品:</span>
				<form:select path="goodsName" items="${nameList}" />
			</div>
			<div>
				<span class="itemnum">点数:</span>
				<form:input path="point" value="1" />
			</div>
			<div class="message">
				<c:out value="${message}" />
			</div>
			<table>
			     <tr><th>商品ID</th><th>商品名</th><th>単価</th><th>点数</th><th>小計</th></tr>
			     <c:forEach items="${allList}" var="list">
			     	<tr>
			     		<td>${list.id}</td>
			     		<td>${list.name}</td>
			     		<td>${list.price}</td>
			     		<td>${list.quantity}</td>
			     		<td>${list.subtotal}</td>
			     	</tr>
			     </c:forEach>
			</table>
		</div>
		<div class="footer">
			<div>
				<input type="submit" name="remove" value="削除" />
				<input type="submit" name="toInit" value="確定" />
			</div>
		</div>
	</form:form>
</body>
</html>
