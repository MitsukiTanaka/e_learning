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
<title>田中オンラインショップ(売上登録画面)</title>
</head>

<body>
  <form:form modelAttribute="salesForm" action="/sales/system">
    <div class="header">
      <span class="titleName">田中オンラインショップ</span>
      <%--div class="date"><%=LocalDate.now()%></div--%>
      <fmt:formatDate value="${date}" pattern="yyyy年MM月dd日（E）" />
    </div>

    <div class="main">
      </div>
      <div class="message">
        <c:out value="${message}" />
      </div>

      <div>
      売上ID：<c:out value="${milli}"></c:out>
      </div>
      <div>
      売上明細
      <table border="1">
      <tr><th>商品ID</th><th>商品名</th><th>単価</th><th>点数</th><th>小計</th></tr>
           <c:forEach items="${allList}" var="allList"  varStatus="loop" >
             <tr>
               <td>${allList.id}</td>
               <td>${allList.name}</td>
               <td>${allList.price}</td>
               <td>${allList.quantity}</td>
               <td>${allList.subtotal}</td>
             </tr>
           </c:forEach>
      </table>
      合計：
      <c:out value="${total}"></c:out>
      円
      </div>

    <div class="footer">
      <div>
      <input type="submit" name="end" value=終了 />
      </div>
    </div>
  </form:form>
</body>
</html>
