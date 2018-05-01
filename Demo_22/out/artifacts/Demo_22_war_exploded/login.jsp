<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/1
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${msg}
<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
    用户名:<input type="text" name="username"/><br/>
    密  码：<input type="password" name="userpwd"/><br/>
    <input type="checkbox" name="autologin"/>自动登陆<br/>
    <input type="submit" value="登陆"/><br/>
</form>
</body>
</html>
