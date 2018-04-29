<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/29
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>修改</title>
    <link rel="stylesheet" href="css/index.css" type="text/css" />
</head>

<body>
<form action="/findid" method="post">
    <table border="2">
        <tr>
            <td>请输入学号:</td>
            <td><input  type="text" name="id" /></td>
        </tr>
        <tr>
            <td><input  type="submit" value="查询"/>|<a href="list.jsp" >返回</a></td>
        </tr>
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.sex }</td>
            <td>${student.school}</td>
        </tr>
    </table>
</form>
</body>
</html>
