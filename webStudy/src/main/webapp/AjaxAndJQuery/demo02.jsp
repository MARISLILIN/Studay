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

        //执行post请求
        function post() {
            //1、创建xmlhttprequest对象
            var request = ajaxFunction();

            //2、发送请求
            /**
             * 参数一：请求方式 get  or  post
             * 参数二： 请求路径
             * 参数三： 是否异步
             */
            // request.open("GET", "/webStudy/DemoServlet01", true);
            request.open("POST", "/webStudy/DemoServlet01", true);

            //想获取服务器传送过来的数据，加一个状态的监听
            request.onreadystatechange = function() {
                if(request.readyState == 4 && request.status == 200) {
                    alert("post" + request.responseText);
                }
            }
            //如果使用post方式带数据，那么这里要添加头，说明提交的数据类型是一个经过url编码的form表单数据
            request.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
            //带数据过去 ， 在send方法里面写form表单数据
            request.send("name=aa&age=19");
        }
    </script>
</head>
<body>
<h3><a href="" onclick="post()">使用Ajax方式发送Post请求</a></h3>
</body>
</html>
