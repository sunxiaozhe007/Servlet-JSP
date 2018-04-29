<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/29
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>显示</title>
</head>
<body>
<form action="/list" method="post">
<table border="2">
  <tr>
    <td>学号</td>
    <td>姓名</td>
    <td>性别</td>
    <td>学校</td>
    <td>操作</td>
  </tr>
  <c:forEach items="${student}" var="s">
    <tr>
      <td>${s.id}</td>
      <td>${s.name}</td>
      <td>${s.sex}</td>
      <td>${s.school}</td>
      <td><a href="del?id=${s.id}">删除</a>|<a href="/findid?id=${s.id}">修改</a></td>
    </tr>
  </c:forEach>
  <tr>
    <td><a href="add.jsp">添加</a></td>
    <td><a href="find.jsp">查询</a></td>
  </tr>
</table>
</form>
</body>
</html>
