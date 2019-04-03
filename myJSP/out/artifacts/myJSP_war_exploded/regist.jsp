<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/26 0026
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<center>
    <h2>用户注册</h2>
    <form action="saveRegist.jsp" method="post">
        用户名：<input type="text" name="uname"><br>
        密 &nbsp;码：<input type="password" name="upwd"><br>
        姓 &nbsp;名：<input type="text" name="name"><br>
        <input type="submit" value="注册"><a href="login.jsp">登录</a>
    </form>
</center>

</body>
</html>
