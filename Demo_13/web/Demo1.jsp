<%@ page import="Test.Student" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/24
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%
            Student stu = new Student();
            stu.setName("sunxiaozhe");
            request.setAttribute("s",stu);
            request.getRequestDispatcher("/Demo2.jsp").forward(request,response);
        %>
</body>
</html>
