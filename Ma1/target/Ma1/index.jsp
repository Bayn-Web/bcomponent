<%@ page import="com.cun" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="validate.jsp" method="post">
    用户名:<label>
    <input type="text" name="userName" value=""/>
</label><br>
    密码:<label>
    <input type="password" name="userPass" value=""/>
</label><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
