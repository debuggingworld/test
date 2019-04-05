<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/3 0003
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="my" uri="http://www.zth.com/mytag" %>

<html>
<head>
  <title>首页</title>
</head>
<body>

<%--<h2>Tag Demo</h2>
<my:hello counter="1"/>
<a href="<my:root/>">首页</a>

<my:welcome>
  <h2>Welcome,<%=pageContext.getRequest().getAttribute("user")%></h2> &lt;%&ndash;<body-content>JSP</body-content>&ndash;%&gt;
  <h2>Welcome,${user}</h2>    &lt;%&ndash;<body-content>scriptless</body-content>&ndash;%&gt;
</my:welcome>--%>

<%--<table width="400" border="1" >

  <tr><th>ID</th><th>Name</th><th>Sex</th></tr>

  <my:userList>
    <tr><td><my:user pop="id"/></td><td><my:user pop="name"/></td><td><my:user pop="sex"/></td></tr>
  </my:userList>


</table>--%>

<%--<my:decdiv>welcome,###</my:decdiv>--%>
<%--
<my:repalceName>Welcome ,###</my:repalceName>
--%>
<%--<my:userList>--%>
<my:userList/>
</body>

</html>
