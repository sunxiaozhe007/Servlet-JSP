<%@ page import="Test.Student" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/24
  Time: 21:37
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
            out.print(stu.getName());

           // request.getRequestDispatcher("index.jsp").forward(request,response);
        %>

        <jsp:useBean id="stu1" class="Test.Student"></jsp:useBean>
        <jsp:setProperty name="stu1" property="name" value="jerry"/>
        <jsp:getProperty name="stu1" property="name"/>

        <jsp:forward page="/index.jsp">
            <jsp:param name="name" value="sunxiaozhe"/>
            <jsp:param name="pwd" value="123"/>
        </jsp:forward>

</body>
</html>
