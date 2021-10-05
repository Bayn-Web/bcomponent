<%--
  Created by IntelliJ IDEA.
  User: bwb
  Date: 2021/9/25
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name=request.getParameter("userName");String pass=request.getParameter("userPass");
    out.println("用户名是:"+name) ;
    out.println("<br>");
    if( "admin".equals(name)&&"admin".equals(pass)){
    out.println( "OK ,欢迎登录");
    session.setAttribute("login","true");
    }else{
    out.println("ERROR，登录失败");
    }
    %>
</body>
</html>
