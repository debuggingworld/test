<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>这只是个标题啊</title>
    <script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
    <script>

        // 文档加载事件
        $(document).ready(
            function () {
                //alert("文档加载完毕！");

                // 单击事件
                $("#btn").click(function () {
                    $("#cont").html("<font color = red>点我干嘛</font>");
                });

                // 双击事件
                $("#btn").dblclick(function () {
                    $("#cont").html("<font color = red>双击我干嘛</font>");
                });

                // 获得焦点
                $("#t1").focus(function () {
                    $("#t1").val("获得焦点");
                });
                // 失去焦点
                $("#t1").blur(function () {
                    $("#t1").val("失去焦点");
                });

                // 鼠标移入、移除
                $("#d1").mouseover(function () {
                    $("#d1").html("鼠标移入");
                });
                $("#d1").mouseout(function () {
                    $("#d1").html("鼠标移出");
                });
            }
        );

    </script>
</head>
<body>
<input type="button" id="btn" value="OK" />
<p id="cont"></p>
<input type="text" id="t1" /><br/><br/>
<div id="d1" style="border: 1px red solid ; width: 100px;height: 100px;"></div>
</body>

</html>