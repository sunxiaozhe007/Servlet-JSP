<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/2
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示</title>
</head>
<body>
<form action="/list">
    <table border="2">
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>学校</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${student}" var="s">
            <tr>
                <td>${s.num}</td>
                <td>${s.name}</td>
                <td>${s.sex}</td>
                <td>${s.age}</td>
                <td>${s.school}</td>
                <td><a href="/delete?num=${s.num}">删除</a>|<a href="/update1?id=${s.id}">修改</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td><a href="/add.jsp">添加</a>|<a href="/find.jsp">查询</a> </td>
        </tr>
    </table>
</form>
</body>
</html>
