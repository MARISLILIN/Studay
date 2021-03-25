
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table style="width: 100%">
    <c:forEach items="${list }" var="wordBean">
        <tr>
            <td>${wordBean.words}</td>
        </tr>
    </c:forEach>
</table>
