<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/29
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>修改</title>
</head>

<body>
<form action="/update1" method="post">
    <table border="1">
        <tr>
            <td>学号:</td>
            <td><input  type="text" name="id" value="${student.id}" /></td>
        </tr>

        <tr>
            <td>姓名:</td>
            <td><input  type="text" name="name" value="${student.name}"/></td>
        </tr>
        <tr>
            <td>性别:</td>
            <td><input  type="text" name="sex" value="${student.sex}"/></td>
        </tr>
        <tr>
            <td>学校:</td>
            <td><input  type="text" name="school" value="${student.school}"/></td>
        </tr>
        <tr>
            <td >
                <input  type="submit" value="提交"/>
                <input  type="button" value="返回" onclick="history.go(-1)"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
