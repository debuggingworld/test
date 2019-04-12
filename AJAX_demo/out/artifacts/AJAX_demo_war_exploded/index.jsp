
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function fun() {
            var xmlhttp;
            if (window.XMLHttpRequest) {
                xmlhttp = new XMLHttpRequest();
            }else {
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }

            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
                }
            }

            xmlhttp.open("POST","welcome",true);
            xmlhttp.send();
        }
    </script>
</head>
<body>
<div id="myDiv"><h3 style=""> 南京的雨不停的下不停的下</h3></div>
<button type="button" onclick="fun()" >修改内容</button>
</body>
</html>
