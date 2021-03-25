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
</head>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

    function get() {
        $.get("/webStudy/DemoServlet02", function (data, status) {
           alert(data + "===" + status);
           $("#div01").text(data);
        })
    }

</script>

<body>
<input type="button" onclick="get()" value="使用JQuery执行get方法">
<div id="div01" style="width: 100px; height: 100px; border: 1px solid blue"></div>

</body>
</html>
