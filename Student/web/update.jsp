<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/3
  Time: 0:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<form action="/update" method="post">
    <input type="hidden" name="id" value="${student.id}">
    <table border="2">
        <tr>
            <td>学号</td>
            <td><input type="text" name="num" value="${student.num}" ></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name" value="${student.name}"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="text" name="sex" value="${student.sex}"></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age" value="${student.age}"></td>
        </tr>
        <tr>
            <td>学校</td>
            <td><input type="text" name="school" value="${student.school}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交">|<a href="/list">返回</a> </td>
        </tr>

    </table>
</form>
</body>
</html>
