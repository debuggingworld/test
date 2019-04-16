
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax 封装</title>
    <script type="text/javascript" src="ajax.js"></script>
    <script type="text/javascript">
        function proc() {
            var email=document.getElementById("email").value;
            console.log("email:::"+email);
            ajax("post","email","email="+email,function (data) {
                var info;
                if (data == 0) {
                    info = "<span style='color:green'>可以注册!</span>";
                }else {
                    info = "<span style='color:red'>已注册!</span>";
                }

                document.getElementById("show").innerHTML=info;
            });
        }
    </script>
</head>
<body>
<center>
    <h1>ajax 封装</h1>
    Email:<input type="text" id="email" onblur="proc();"/><span id="show"></span><br/>
    用户名：<input type="text" />

</center>
</body>
</html>
