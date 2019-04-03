<%@ page import="com.zth.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/26 0026
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<center>
    <h2>登录成功</h2>
    <h2>Welcome,<%=((User)session.getAttribute("loged")).getUname() %></h2>
    <br><br>
    <a href="login.jsp">返回</a> &nbsp;&nbsp;<a href="logout.jsp">注销</a>
</center>
</body>
</html>
