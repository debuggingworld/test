<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JQuery 动画</title>
    <script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {

            /*隐藏和显示*/

            $("#hide").click(function () {
                $("#p1").hide();
            });
            $("#show").click(function () {
                $("#p1").show();
            });
            $("#showHide").click(function () {
                $("#p1").toggle("slow");
            });

            /*-淡入淡出*/
            $("#fadeIN").click(function () {
                $("#div1").fadeIn();
                $("#div2").fadeIn("slow");
                $("#div3").fadeIn(3000);
            });

            $("#fadeOut").click(function () {
                $("#div1").fadeOut();
                $("#div2").fadeOut("slow");
                $("#div3").fadeOut(3000);
            });
            $("#fadeInOut").click(function () {
                $("#div1").fadeToggle();
                $("#div2").fadeToggle("slow");
                $("#div3").fadeToggle(3000);
            });
            $("#fadeTo").click(function () {
                $("#div1").fadeTo("slow",0.1);
                $("#div2").fadeTo("slow",0.4);
                $("#div3").fadeTo("slow",0.8);
            });

            /*滑动*/
            $("#flip").click(function () {
                $("#panel").slideToggle("slow");
            });

            /*动画*/
            $("#animate_btn").click(function () {
                $("#animate_div").animate({
                    left:'100px',
                    opacity:'0.5',
                    height:'150px',
                    width:'150px'
                    },3000
                );
            });

            $("#stop").click(function () {
                $("#animate_div").stop();
            });
            
        });
    </script>
</head>
<body>
<center>
    <%--隐藏和显示--%>
    <p id="p1">点击“隐藏”、“显示”按钮</p>
    <button id="show" type="button">显示</button>
    <button id="hide" type="button">隐藏</button>
    <button id="showHide" type="button">显示\隐藏</button><br/><br/>

    <%--淡入淡出--%>
        <button id="fadeIN" type="button">淡入</button>
        <button id="fadeOut" type="button">淡出</button>
        <button id="fadeInOut" type="button">淡入\淡出</button><br/><br/>
        <button id="fadeTo" type="button">淡化</button>
        <div id="div1" style="width:80px;height:80px;background-color:red;"></div>
        <br>
        <div id="div2" style="width:80px;height:80px;background-color:green;"></div>
        <br>
        <div id="div3" style="width:80px;height:80px;background-color:blue;"></div>

        <%--滑动--%>
    <p id="flip" style="margin: 0px ;padding: 5px;text-align: center;background-color: antiquewhite;
border: 1px red solid ;width: 300px">滑动</p>
    <div id="panel" style="margin: 0px ;padding: 5px;text-align: center;background-color: antiquewhite;
border: 1px red solid; height: 120px;width: 300px;display: none">
        <p>纵有红颜，百生千劫</p>
        <p>难消君心，万古情愁</p>
    </div>


    <%--动画--%>
    <button id="animate_btn" type="button">开始动画</button>
        <button id="stop" type="button">暂停动画</button>
    <div id="animate_div" style="background: antiquewhite;height: 80px;width: 80px;position: absolute"></div>
    
</center>
</body>
</html>
