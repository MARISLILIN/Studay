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

    function load() {
        $("#text01").load("/webStudy/DemoServlet02", function (responseTxt, statusTxt, xhr) {
            // alert("结果：" + responseTxt);
            $("#text01").val(responseTxt);
        });
    }

</script>

<body>
<%--<h3><a href="" onclick="load()">使用JQuery执行load方法</a></h3>--%>
<h3><input type="button" onclick="load()" value="使用JQuery执行load方法"></h3>
<input type="text" id="text01">

</body>
</html>
