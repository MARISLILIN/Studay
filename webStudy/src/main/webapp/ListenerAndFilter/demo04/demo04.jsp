<%@ page import="ListenerAndFilter.ListenerDemo.domain.Bean02" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Bean02 bean = new Bean02();
        bean.setName("李四");

        session.setAttribute("bean", bean);

    %>

这是demo04页面
</body>
</html>
