<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/2
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询</title>
</head>
<body>
<form action="/find" method="post">
    <table border="2">
        <tr>
            <td>请输入学号</td>
            <td><input type="text" name="num"></td>
        </tr>
        <tr>
            <td><input type="submit" value="查询">|<a href="/list">返回</a></td>
        </tr>
        <tr>
            <td>${student.num}</td>
            <td>${student.name}</td>
            <td>${student.sex}</td>
            <td>${student.age}</td>
            <td>${student.school}</td>
        </tr>
    </table>
</form>

</body>
</html>
