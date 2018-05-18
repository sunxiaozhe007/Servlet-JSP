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
<script>
    function addFile() {
        //得到div容器
        var div1 = document.getElementById("div1");
        div1.innerHTML +="<div>\n" +
            "        <input type='file' name='photo'/><input type='button' value='删除' onclick='delFile(this)'/><br/>\n" +
            "    </div>"
    }
    function delFile(input) {
        //使用input对象进行删除
        input.parentNode.parentNode.removeChild(input.parentNode);
    }
</script>
<body>
<form enctype="multipart/form-data" action="/upload1" method="post">

    <input type="text" name="name"/><br/>
    <div id="div1">
    <div>
        <input type="file" name="photo"/><input type="button" value="添加" onclick="addFile()"/><br/>
    </div>
    </div>
    <input type="submit" value="上传"/><br/>

</form>
</body>
</html>
