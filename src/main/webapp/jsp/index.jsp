<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Hello
    <c:forEach items="${list}" var="Entity">
        <p>${Entity.info}</p>
    </c:forEach>
</body>
</html>
