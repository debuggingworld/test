
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        var xmlHttp;

        function proc() {
            var uname = document.getElementById("uname").value;

            if (window.XMLHttpRequest) {
                xmlHttp = new XMLHttpRequest()
            }else {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }

            xmlHttp.open("get","welcome?uname="+ uname);

            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                    document.getElementById("show").innerHTML = xmlHttp.responseText;
                }
            }

            xmlHttp.send();
        }

    </script>
</head>
<body>
<center>
    <h1>异步请求</h1>
    用户名：<input type="text" id="uname" />
    <input type="button" value="OK" onclick="proc()" />
    <div id="show" style="color: #FF0000"></div>
</center>

</body>
</html>
