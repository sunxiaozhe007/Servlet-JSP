<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/25
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    request.setAttribute("list",list);

    Map map = new HashMap();
    map.put("a","aaaaaaaaa");
    map.put("b","bbbbbbbbbbbbbb");
    map.put("c","cccccccccccccc");

    request.setAttribute("m",map);

%>
        ${list[1]}<br/>

        ${m["c"]}<br/>

        ${m.a}
</body>
</html>
