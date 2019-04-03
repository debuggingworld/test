<%@ page import="java.util.List" %>
<%@ page import="com.zth.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/26 0026
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    String uanme = null!= request.getParameter("uname")?request.getParameter("uname"):"";
    String upwd = null!= request.getParameter("upwd")?request.getParameter("upwd"):"";

    List<User> list = (List<User>)application.getAttribute("allUsers");
    boolean flag = false;

    if (null!= list && list.size()>0){
        for (User user:list){
            if (user.getUname().equals(uanme) && user.getPwd().equals(upwd)){
                flag = true;
                session.setAttribute("loged",user);
                break;
            }
        }
    }

    if (flag == true){
        response.sendRedirect("success.jsp");
    }else {
        response.sendRedirect("login.jsp");
    }

%>