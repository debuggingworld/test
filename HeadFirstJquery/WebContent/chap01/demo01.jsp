
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
    <script type="text/javascript">
        function getContent() {
            //var content = document.getElementById("content").value;

            var content = $("#content").val();
            alert(content);
        }
    </script>
</head>
<body>
<center>
    <input type="text" id="content" /> &nbsp;&nbsp;
    <input type="button" value="OK" onclick="getContent();" >
</center>

</body>
</html>
