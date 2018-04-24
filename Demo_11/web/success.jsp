<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/24
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        welcome:<%
           String userName = (String) session.getAttribute("name");
           out.print(userName);
        %>
        <a href="/home.jsp">跳到首页</a>
</body>
</html>
