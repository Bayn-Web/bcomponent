<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: bwb
  Date: 2021/9/29
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    乘数1：<s:property value="#request.n"/><br>
    乘数2：<s:property value="#request.n1"/><br>
    乘积结果：<s:property value="#request.fin"/>
</body>
</html>
