<%--
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<center>
    <h3><a href="demo01.jsp">demo01</a></h3>
    <h3><a href="demo02.jsp">demo02</a></h3>
    <h3><a href="demo03.jsp">demo03</a></h3>
    <h3><a href="demo04.jsp">demo04</a></h3>
    <h3><a href="demo05.jsp">demo05</a></h3>
    <h3><a href="demo06.jsp">demo06</a></h3>

</center>
</body>
</html>
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JQuery ajax</title>
    <script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
    <script type="text/javascript">

        $(document).ready(function () {
            $("#load").click(function () {
                $("div").load("../ajax?action=load",{name:"张三"},function(resptxt,status,xhr){
                    if(status=="success"){
                        alert("加载成功!");
                    }
                    if(status == "error"){
                        alert("Erro:"+xhr.status+":"+xhr.statusText);
                    }
                });

            });


        		$("#email").blur(function () {
                $.get("../ajax?action=getPost&email="+$("#email").val(),function (data, status) {
                    if (data == 1) {
                        $("#cont1").html("<font color=\"red\">已注册</font>");
                    }else {
                        $("#cont1").html("<font color=\"green\">未注册</font>");
                    }
                });
            });

        }); 
        
        /* $("#email").blur(function () {
            $.post("../ajax?action=getPost",{email : $("#email").val()},function (data, status) {
                if (data == 1) {
                    $("#cont1").html("<font color=\"red\">已注册</font>");
                }else {
                    $("#cont1").html("<font color=\"green\">未注册</font>");
                }
            });
        }); 

    });*/



    </script>
</head>
<body>
<center>
    <button type="button" id="load">加载数据</button><br>
     <div></div><br/>
    

    email:<input type="email" id ="email"/><span id="cont1"></span><br>
    密码:<input type="password">

</center>

</body>
</html>
