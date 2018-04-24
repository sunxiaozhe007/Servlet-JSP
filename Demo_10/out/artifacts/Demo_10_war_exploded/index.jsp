<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/23
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function changeCode(){
            var img = document.getElementsByTagName("img")[0];
            img.src = "/Demo4?time="+new Date().getTime();
        }
    </script>
</head>
<body>
        <%
            String msg = (String) request.getAttribute("msg");
            if (msg!=null){
                out.println(msg);
            }
        %>
<form action="/Demo3" method="post">
    用户名：<input type="text" name="userName"/><br>
    密码：<input type="password" name="pwd"/><br>
    验证码：<input type="text" name="code"/><img src="/Demo4" onclick="javascript:changeCode()"/><a href="javascript:changeCode()">看不清楚换一张</a> <br>
    <input type="submit" value="登录"/><br>
</form>
</body>
</html>
