<%--
  Created by IntelliJ IDEA.
  User: 97218
  Date: 2021/1/20
  Time: 0:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript">

        function ajaxFunction() {
            var xmlHttp;
            try {// Firefox  Opera 8.0+  Safari
                xmlHttp = new XMLHttpRequest();
            } catch (e) {
                try {// IE
                    xmlHttp = new ActiveXObject("Msxml2.XMLTYPE");
                } catch (e) {
                    try {// IE
                        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e) {
                    }
                }
            }

            return xmlHttp;
        }

        //执行get请求
        function get() {
            //1、创建xmlhttprequest对象
            var request = ajaxFunction();

            //2、发送请求
            /**
             * 参数一：请求方式 get  or  post
             * 参数二： 请求路径
             * 参数三： 是否异步
             */
            // request.open("GET", "/webStudy/DemoServlet01", true);
            request.open("GET", "/webStudy/DemoServlet01?name=aa&age=18", true);

            request.onreadystatechange = function() {
                if(request.readyState == 4 && request.status == 200) {
                    alert(request.responseText);
                }
            }

            request.send();
        }
    </script>
</head>
<body>
<h3><a href="" onclick="get()">使用Ajax方式发送Get请求</a></h3>
</body>
</html>
