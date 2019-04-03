<%@ page import="com.zth.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/26 0026
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String uanme = null!= request.getParameter("uname")?request.getParameter("uname"):"";
    String pwd = null!= request.getParameter("upwd")?request.getParameter("upwd"):"";
    String name = null!= request.getParameter("name")?request.getParameter("name"):"";

    User user = new User();
    user.setName(name);
    user.setPwd(pwd);
    user.setUname(uanme);

    List<User> list = (List<User>)application.getAttribute("allUsers");

    if (null == list){
        list = new ArrayList<User>();
    }
    list.add(user);
    application.setAttribute("allUsers",list);

%>
<center>
    <h2>注册成功</h2>
    <br>
    <a href="login.jsp">返回登录</a>
</center>
</body>
</html>
