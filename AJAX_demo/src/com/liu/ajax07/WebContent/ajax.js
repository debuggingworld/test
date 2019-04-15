var xmlhttp;//xmlHTTPRequest 给服务器发请求

function createXmlHTTP()
{

	if (window.XMLHttpRequest)
	  {  // code for IE7+, Firefox, Chrome, Opera, Safari
	     xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }

}


function ajax(method,url,data,proc)
{
	createXmlHTTP();
	xmlhttp.open(method,url);
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4&&xmlhttp.status==200)
		{
			proc.call(null,xmlhttp.responseText);
			
		}
	}
	if(method.toLowerCase()=="post")
		{
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send(data);
		}else
		{
			xmlhttp.send();
		}

}