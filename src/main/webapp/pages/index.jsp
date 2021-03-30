<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Starter</title>
</head>
<body>


<h1>Hello</h1>

<c:forEach items="${items}" var="item">
    <p>${item.description}</p>
</c:forEach>

</body>