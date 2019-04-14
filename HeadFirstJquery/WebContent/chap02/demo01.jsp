<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.11.0.js"></script>

<script type="text/javascript">
	$(document).ready(function () {
		//节本选择器
		//$("#a1").css("background-color","red");	// 根据 id 选择
		
		//$(".c1").css("background-color","red");		// 根据 class 选择
		
		//$("a").css("background-color","red");		// 根据标签选择
		
		
		// 属性选择器
		//$("[href]").css("background-color","red");
		//$("[href='#']").css("background-color","red");	//所有 href 属性的值等于 "#" 的元素
		//$("[href$='com']").css("background-color","red");
		
		// 其他选择器
		//$("p.c1").css("background-color","red");
		//$("ul li:first").css("background-color","red");
		//$("ul li:last").css("background-color","red");
		
		
		
	});

</script>

<style type="text/css">
	.c1{
		font-size: 40px;
	}
	
</style>
</script>
</head>
<body>
<p class="c1">Jquery选择器</p>
<ul>
	<li id="i1"><a id="a1" class="c1" href="http://www.java1234.com" >Java知识分享网</a></li>
	<li><a id="a2" class="c1" href="http://www.csdn.net">CSDN</a></li>
	<li><a href="http://www.iteye.com">iteye</a></li>
	<li><a href="http://www.cnblogs.com">博客园</a></li>
	<li><a class="c1" href="#">百度</a></li>
	<li><a href="http://www.google.com">谷歌</a></li>
</ul>

</body>
</html>