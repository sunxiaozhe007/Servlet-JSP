<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/17
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
<form enctype="multipart/form-data" action="/upload1" method="post">
    <input type="text" name="name"/><br/>

    <input type="file" name="photo"/><br/>
    <input type="file" name="photo"/><br/>


    <input type="submit" value="上传"/><br/>

</form>
</body>
</html>
