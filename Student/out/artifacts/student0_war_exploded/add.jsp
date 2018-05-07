<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/2
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
<form action="/add" method="post">
    <table>
        <tr>
            <td>学号</td>
            <td><input type="text" name="num"></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="text" name="sex"></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age"></td>
        </tr>
        <tr>
            <td>学校</td>
            <td><input type="text" name="school"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交">|<a href="/list">返回</a> </td>
        </tr>
    </table>
</form>
</body>
</html>
