<%--
  Created by IntelliJ IDEA.
  User: bwb
  Date: 2021/9/25
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String logined=(String)session.getAttribute("login");
    if(!"true".equals(logined)){
    response.sendRedirect("index.jsp");}
    else{
    out.println("您已登录过，欢迎回来");}
%>
</body>
</html>
