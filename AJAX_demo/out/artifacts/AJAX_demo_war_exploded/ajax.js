var xmlHttp;

function creatXMLHttp() {
    if (window.XMLHttpRequest){
        xmlHttp = new XMLHttpRequest();
    } else {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
}

function ajax(method, url, data, proc) {

   console.log("ajax.....开始");

    creatXMLHttp();

   /* if (method.toLowerCase() == "post") {
        xmlHttp.open(method,url);
    }else {
        console.log(url+"?"+data);

        xmlHttp.open("get","email?email="+data);
        //xmlHttp.open(method,"email?email=admin@qq.com");
    }*/
    xmlHttp.open("get",url+"?email="+data);
   // xmlHttp.open(method,url);

    xmlHttp.onreadystatechange = function () {

        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            proc.call(null,xmlHttp.responseText);
        }
    }
    xmlHttp.send();
   /* if (method.toLowerCase() == "post") {
        xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlHttp.send(data);
    }else {
        xmlHttp.send();
    }*/

}