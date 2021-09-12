<%--
  Created by IntelliJ IDEA.
  User: 97218
  Date: 2021/9/9
  Time: 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>首页</title>
</head>
<body>
    这是首页，
    <c:if test = "${not empty userBean }">
        欢迎您，${userBean.name }
    </c:if>
    <c:if test = "${empty userBean }">
        您好，请登录！
    </c:if>
</body>
</html>
