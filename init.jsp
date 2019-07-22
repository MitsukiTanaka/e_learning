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
<title>山田オンラインショップ(初期画面)</title>
</head>
<body>
	<form:form modelAttribute="salesForm" action="/sales/system">
		<div class="header">
			<span class="titleName">山田オンラインショップ</span>
			<%--div class="date"><%=LocalDate.now()%></div--%>
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

		</div>
		<div class="footer">
			<div>
			<input type="submit" name="add" value="明細追加" />
			</div>
		</div>
	</form:form>
</body>
</html>
