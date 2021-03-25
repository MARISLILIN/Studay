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

    <script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">

        function checkUserName() {
            //1、获取输入框的内容
            var name = $("#name").val();
            //2、发送请求
            $.post("/webStudy/CheckUserNameServlet", {name:name}, function (data, status) {
                // alert(data);
                if (data == 1) { //用户名存在
                    // alert("用户名存在");
                    $("#span01").html("<font color='red'>用户名存在</font>")
                } else {
                    // alert("用户名可用");
                    $("#span01").html("<font color='green'>用户名可用</font>")
                }
            });

            //3、输出响应的数据到页面上
        }
    </script>
</head>
<body>
<table border="1" width="500">
    <tr>
        <td>用户名</td>
        <td><input type="text" name="name" id="name" onblur="checkUserName()"><span id="span01"></span></td>
    </tr>
    <tr>
        <td>密码</td>
        <td><input type="text" name=""></td>
    </tr>
    <tr>
        <td>邮箱</td>
        <td><input type="text" name=""></td>
    </tr>
    <tr>
        <td>简介</td>
        <td><input type="text" name=""></td>
    </tr>
    <tr>
        <td colspan="2"><input type="submit" value="注册"></td>
    </tr>
</table>

</body>
</html>
