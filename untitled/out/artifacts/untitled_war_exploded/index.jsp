<%--
  Created by IntelliJ IDEA.
  User: bwb
  Date: 2021/8/31
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Jsp</title>
  </head>
  <style>
    *{
      padding: 0px;
    }
    @keyframes moveBg{
      0%{
        background-position: 0% 50%;
      }
      50%{
        background-position: 100% 50%;
      }
      100%{
        background-position: 0 50%;
      }
    }
    body {
      width: 100%;
      height: 100vh;
      background: linear-gradient(-45deg,#fff121, #f403d1,#64b5f6, #fff121);
      background-size: 400% 400%;
      animation: moveBg 20s linear infinite;
    }
    .posi{
      box-shadow: 5px 5px 5px #888888;
      position: relative;
      bottom: 400px;
      left: 500px;
      width:300px;
    }
    form{
    //border: aquamarine solid 2px;
      height: 75px;
      padding:0px;
      margin:0px;
      opacity: 0.5;
    }
    form:hover{
      opacity: 1.0;
    }
    .box{
      height: 700px;
      width: 100%;
    }
    .welcom{
    //border: aquamarine solid 2px;
      width: 500px;
      left: 450px;
      top: 200px;
      position: absolute;
      font-family: verdana;
      font-size: 50px;
    }
    .inp{
      width: 200px;
      left:100px;
      margin: 0px;
      background-color:transparent;
    }
    .d{
      width: 200px;
      height: 200px;
      border-radius: 100%;
      background-color: #77fdd7;
      position: absolute;
      top: -50px;
      left: 260px;
      z-index: -9;
    }</style>
  <body>
<%--  <form action="Login" method="post">--%>
<%--    <input name="uname">--%>
<%--    <input name="pass">--%>
<%--    <button>tijiao</button>--%>
<%--  </form>--%>
  <h2 class="box"></h2>
  <h2 class="welcom">欢迎进入登录页</h2>
  <form class="posi" action="Login" method="post">
    <a>账号 <input type="text" name="uname" class="inp"><br>
      密码 <input type="password" name="pass" class="inp"><br>
      <input type="submit" name="submit" value="login"
             style="background-color:transparent;left: 95px;top: 50px;position:absolute;">
    </a>
    <pr style="color: aqua;font-size: 0.5em;margin-left: 130px;">${zhuangtai}</pr>
    <div class="d"></div>
    <%--    ${}这是EL表达式，具体用法用来把作用域目标的s对应成o--%>
    <%--    <span style="font-size: 4em;color: aqua;">${zhuangtai}</span>--%>
<%--    <c:if test="${1==1}">--%>
<%--      ${zhuangtai}--%>
<%--    </c:if>--%>
  </form>
  </body>
</html>
