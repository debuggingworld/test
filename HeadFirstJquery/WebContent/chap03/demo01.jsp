<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
 
    <script type="text/javascript">
 
        $(function () {
 
            <%-- 操作DOM节点--%>
            // 1. 查找节点
            /* var docu = $("ul li:eq(1)");
            var con = docu.text();
            alert(con); */
 
            //2. 创建节点
            /* var elem1 = $("<li title='乔布斯'>乔布斯</li>");
            var elem2 = $("<li title='扎克伯格'>扎克伯格</li>");
            var docEle = $("ul li:eq(1)");
            $("ul").append(elem1);
            elem2.insertAfter(docEle); */
 
            //3. 删除节点
            //$("ul li:eq(1)").remove();
 
            <%--操作DOM属性--%>
 
            // 获取属性
            /* var elem = $("ul li:eq(1)");
            var attr = elem.attr("title");
            alert(attr); */
 
 
            // 设置属性
            //$("ul li:eq(1)").attr("title","猜猜我是谁");
 
 
            // 删除属性
            //$("ul li:eq(1)").removeAttr("title");
 
            <%-- 操作 DOM 节点样式--%>
            //获取样式
            //var elem = $("ul li:eq(1)");
            //alert(elem.attr("class"));
 
            // 设置样式
            //elem.attr("class","lc2");
 
            // 追加样式
            //elem.addClass("lc3");
 
            // 移除样式
            //elem.removeClass("lc");
 
            /*设置和获取HTML，文本和值 */
            //var elem = $("ul li:eq(0)");
            // 获取 html
            //alert(elem.html());
 
            // 设置html
            //elem.html("<font color='red'>哈哈</font>")
 
            // 获取文本
            //alert(elem.text());
 
            // 设置文本
            //elem.text("啦啦");
 
            // 遍历节点
            /*var elems = $("body").children();
            alert(elems.length);
            var lis = $("ul").children();
            for (var i = 0; i < lis.length; i++) {
                //alert(lis[i].innerHTML);
                alert($(lis[i]).html());
            }*/
 
            // next()、prev()
            /*var elem = $("ul li:eq(1)");
            alert(elem.next().html());
            alert(elem.prev().html());*/
 
           /* css-DOM 操作*/
            // 获取 css 样式
           /* var  c = $("#li").css("color");
            alert(c)*/
 
           // 设置 css 样式
            //$("#li").css("background-color","green")
 
        });
 
        function getUserName() {
            var  userName = $("#userName").val();
            alert(userName);
        }
 
        function setUserName() {
            $("#userName").val("你好啊！");
        }
 
    </script>
    <style type="text/css">
        .lc{
            background-color: red;
        }
 
        .lc2{
            background-color: blue;
        }
 
        .lc3{
            font-weight: bold;
        }
    </style>
</head>
<body>
<p>你最喜欢的名人是？</p>
<ul>
    <li title="马云"><font color="green">马云</font></li>
    <li title="马化腾" class="lc" >马化腾</li>
    <li title="李彦宏" style="color: red; " id="li">李彦宏</li>
</ul>
 
<input type="text" id="userName"/>
<input type="button" value="获取数据" onclick="getUserName()"/>
<input type="button" value="设置数据" onclick="setUserName()"/>
 
</body>
</html>