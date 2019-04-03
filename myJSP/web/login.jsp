<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/26 0026
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<center>
    <h2>用户登录</h2>
    <form action="checkLogin.jsp" method="post">
        用户名：<input type="text" name="uname"/><br>
        密 &nbsp; 码：<input type="password" name="upwd"/><br>
        <input type="submit" value="登录"/> <a href="regist.jsp">注册</a>
    </form>
</center>
</body>
</html>
