<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/12 0012
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>post请求</title>
    <script type="text/javascript">
        function proc() {
            var xmlhttp;
            var email = document.getElementById("email").value;

            if (window.XMLHttpRequest) {
                xmlhttp = new XMLHttpRequest();
            }else {
                xmlhttp = new ActiveXObject("Microsoft.XMLTHHP");
            }

            xmlhttp.open("post","email");
            xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

            xmlhttp.onreadystatechange = function () {
                var info;

                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    if (xmlhttp.responseText == 0) {

                        info = "<span style='color:green'>可以注册!</span>";
                    }else {

                        info = "<span style='color:red'>已注册!</span>";
                    }

                    document.getElementById("show").innerHTML = info;
                }
            }

            xmlhttp.send("email="+email);
        }

    </script>
</head>
<body>
<center>
    <h1>post 请求</h1>
    Email:<input type="email" id="email" onblur="proc()"><span id="show"></span><br>
    用户名:<input type="text">
</center>
</body>
</html>
