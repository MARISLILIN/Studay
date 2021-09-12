<%--
  Created by IntelliJ IDEA.
  User: 97218
  Date: 2021/9/9
  Time: 0:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>自动登录</title>
</head>
<body>
    <form method="post" action="LoginServlet">
        账号<input type="text" name="username"><br>
        密码<input type="password" name="password"><br>
        <input type="checkbox" name="auto_login"> 自动登录 <br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
