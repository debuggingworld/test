<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/14 0014
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
    <script type="text/javascript">

    /*    function init() {
            document.getElementById("btnn").onclick = function () {
                var val = $("#btnn").val();
                alert(val);
            }
        }*/

        $(document).ready(function () {
            $("#btnn").click(function () {
                alert($("#content").val());
            });
        });


    </script>
</head>
<body >
<center>
    <input type="text" id="content" /> &nbsp;&nbsp;
    <input type="button" value="OK" id="btnn" >
</center>

</body>
</html>
