<%--  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/5 0005
  Time: 21:04
  To change this template use File | Settings | File Templates.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>这是首页啊</title>
</head>
<body>
<center>
    <a href="download?fileName=图片.jpg">图片</a>
    <%--<%
        request.getParameter()
    %>--%>
    <a href="download?fileName=commons.zip">jar</a>
</center>
</body>
</html>


<%--
<html>
<head>
    <title>这是首页啊</title>
</head>
<body>
<center>
    <form action="myUpload" enctype="multipart/form-data" method="post">
        文件描述：<input type="text" name="des"><br/><br/>
        选择文件：<input type="file" name="file"/><br/>
        选择文件：<input type="file" name="file"/><br/><br/><br/>
        <input type="submit" value="提交"/>
    </form>
</center>
</body>
</html>
--%>
