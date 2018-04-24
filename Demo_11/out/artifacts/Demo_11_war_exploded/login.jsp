<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/24
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String msg = (String) request.getAttribute("msg");
        if (msg!=null)
        out.print(msg);
    %>
<form action="/dologin" method="post">
    用户名：<input type="text" name="userName"/><br/>
    密 码：<input type="password" name="pwd"/><br/>
    <input type="submit" name="登录"/><br/>
</form>
</body>
</html>
