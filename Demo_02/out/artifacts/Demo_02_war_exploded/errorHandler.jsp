<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/21
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@page isErrorPage="true"%>
<html>
<head>
    <title>Error</title>
</head>
<body>
An error has occurred. <br/>
Error message:
<%
    out.println(exception.toString());
%>
</body>
</html>
