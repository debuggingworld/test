<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Title</title>
    <script>
        var xmlHttp;
        function proc() {
            var email = document.getElementById("email").value;
            if (window.XMLHttpRequest) {
                xmlHttp = new XMLHttpRequest()
            }else {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }

            xmlHttp.open("get","email?email="+email);

            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                    var info;

                    if (xmlHttp.responseText == 0) {
                        info = "<span style='color:green'>可以注册!</span>";
                    }else {
                        info = "<span style='color:red'>已注册!</span>";
                    }

                    document.getElementById("show").innerHTML = info;

                }
            }

            xmlHttp.send()


        }
    </script>
</head>
<body>
<center>
    <h1>模拟 email 校验</h1>
    Email:<input type="email" id="email" onblur="proc()"><span id="show"></span><br/>
    用户名:<input type="text" />
</center>

</body>
</html>