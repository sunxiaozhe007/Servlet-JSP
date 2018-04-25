<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/25
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <c:if test="${5>3}">
            aaaaaaaaaa
        </c:if>
        <c:if test="${5<3}">
            bbbbbbbbb
        </c:if>
</body>
</html>
