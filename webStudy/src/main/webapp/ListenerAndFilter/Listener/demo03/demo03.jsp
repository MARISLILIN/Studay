<%@ page import="ListenerAndFilter.ListenerDemo.domain.Bean01" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Bean01 bean = new Bean01();
        bean.setName("zhangsan");

        session.setAttribute("bean", bean);
        session.removeAttribute("bean");

    %>
</body>
</html>
