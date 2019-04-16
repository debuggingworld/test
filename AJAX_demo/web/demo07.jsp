
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>这只是个标题啊</title>
    <script type="text/javascript">
        function proc() {
            document.getElementById("btn").disabled = true;
            var xmlHttp;

            if (window.XMLHttpRequest) {
                xmlHttp = new XMLHttpRequest();
            }else {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");

            }

            xmlHttp.open("post","bookinfoJSON");

            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {

                    var doc = xmlHttp.responseText;
                    var json = eval("("+doc+")");


                    for (var i = 0; i < json.length; i++) {
                        var tr = document.createElement("tr");

                        var td1 = document.createElement("td");
                        var td1txt = document.createTextNode(i+1);
                        td1.appendChild(td1txt);

                        var td2 = document.createElement("td");
                        var td2txt = document.createTextNode(json[i].name);
                        td2.appendChild(td2txt);

                        var td3 = document.createElement("td");
                        var td3txt = document.createTextNode(json[i].author);
                        td3.appendChild(td3txt);

                        tr.appendChild(td1);
                        tr.appendChild(td2);
                        tr.appendChild(td3);

                        document.getElementById("tt").appendChild(tr);
                    }

                }
            }
            xmlHttp.send();
        }

    </script>
</head>
<body>
<center>
    <input type="button" id="btn" onclick="proc();" value="OK"/>
    <br/>
    <table border="1" width="200" id="tt">
        <tr><th>ID</th><th>Name</th><th>Author</th></tr>
    </table>
</center>
</body>
</html>
