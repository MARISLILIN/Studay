
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        session.setAttribute("name", "hehehehe");
        session.setAttribute("name", "zhangsan");

        session.removeAttribute("name");

    %>
</body>
</html>
