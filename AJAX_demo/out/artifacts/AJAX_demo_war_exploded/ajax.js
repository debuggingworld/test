var xmlHttp;

function creatXMLHttp() {
    if (window.XMLHttpRequest){
        xmlHttp = new XMLHttpRequest();
    } else {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
}

function ajax(method, url, data, proc) {
    creatXMLHttp();

    xmlHttp.open(method,url);

    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            console.log(xmlHttp.responseText)
            proc.call(null,xmlHttp.responseText);
        }
    }

    if (method.toLowerCase() == "post") {
        xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlHttp.send(data);
    }else {
        xmlHttp.send();
    }

}