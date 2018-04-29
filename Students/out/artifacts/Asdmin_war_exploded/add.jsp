<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/29
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>添加</title>
</head>

<body>
<form action="/add" method="post">
    <table border="2" >
        <tr>
            <td>学号:</td>
            <td><input  type="text" name="id"/></td>
        </tr>
        <tr>
            <td>姓名:</td>
            <td><input  type="name" name="name"/></td>
        </tr>
        <tr>
            <td>性别:</td>
            <td><input  type="sex" name="sex"/></td>
        </tr>
        <tr>
            <td>学校:</td>
            <td><input  type="school" name="school"/></td>
        </tr>

        <td><input  type="submit" value="提交"/></td>


    </table>
</form>
</body>
</html>
