<%@ page import="Test.Student" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/24
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%
            Student stu = (Student) request.getAttribute("s");
            out.print(stu.getName());
        %>
        ${s.city.address}
        ${s["city"]["address"]}
</body>
</html>
