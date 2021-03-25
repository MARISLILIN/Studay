
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
    <%--使用xml返回--%>
    <%--    <script type="text/javascript" src="../js/city.js"></script>--%>
    <%--使用json返回--%>
    <script type="text/javascript" src="../js/city_json.js"></script>

</head>
<body>
省份
<select name="province" id="province">
    <option value="">-请选择-</option>
    <option value="1">广东
    <option value="2">湖南</option>
    <option value="3">湖北</option>
    <option value="4">四川</option>
</select>

城市
<select name="city" id="city">
    <option value="">-请选择-</option>
</select>
</body>
</html>
