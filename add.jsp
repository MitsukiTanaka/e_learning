<%@ page session="false" language="java"
  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<jsp:useBean id="date" class="java.util.Date" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
  href="/sales/resources/css/common.css" />
<title>田中オンラインショップ(明細追加画面)</title>
</head>
<body>
  <form:form modelAttribute="salesForm" action="/sales/system">
    <div class="header">
      <span class="titleName">田中オンラインショップ</span>
      <fmt:formatDate value="${date}" pattern="yyyy年MM月dd日（E）" />
    </div>

    <div class="main">
      <div>
        <span class="itemName">商品:</span>
        <form:select path="goodsName" items="${nameList}" />
      </div>
      <div>
        <span class="itemNum">点数:</span>
        <form:input path="point" value="${point}" />
      </div>

      <div>
      <input type="submit" name="add" value="明細追加" />
      </div>
      <div class="message">
        <c:out value="${message}"/>
      </div>
      <div class="alertmessage">
        <c:out value="${alertmessage}"/>
      </div>
      <div>
      売上明細
      <table border="1">
      <tr><th>削除<th>商品ID</th><th>商品名</th><th>単価</th><th>点数</th><th>小計</th></tr>
           <c:forEach items="${allList}" var="allList"  varStatus="loop" >
             <tr>
               <%--td><input type="radio" name="remove"  ></td--%>
               <td><form:radiobutton path="delNumber" value="${loop.count}"/></td>
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
    </div>

    <div class="footer">
      <div>
        <input type="submit" name="remove" value="削除"  />
        <input type="submit" name="firm" value="確定" />
      </div>
    </div>
  </form:form>
</body>
</html>
