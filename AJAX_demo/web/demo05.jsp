<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/12 0012
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax 封装</title>
    <script type="text/javascript" src="ajax.js"></script>
    <script type="text/javascript">
        function proc() {
            var email=document.getElementById("email").value;

            ajax("post","welcome","email="+email,function (datta) {
                var info;
                if(1==data){
                    info="<span style='color:red;'>不可以注册1！</span>";
                }else{
                    info="<span style='color:green;'>可以注册1！</span>";
                }

                document.getElementById("show").innerHTML=info;
            });
        }
    </script>
</head>
<body>
<center>
    <h1>ajax02_异步请求</h1>
    Email:<input type="text" id="email" onblur="proc();"/><span id="show"></span><br/>
    用户名：<input type="text" />

</center>
</body>
</html>
