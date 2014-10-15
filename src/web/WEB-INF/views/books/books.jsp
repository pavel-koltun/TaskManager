<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<h2>Book store</h2>
<c:if test="${empty books}">
    <h4>Sorry, we have nothing to show :(</h4>
</c:if>
<c:forEach var="book" items="${books}">
    <h3>${book.id}. ${book.title} - ${book.author}</h3>
</c:forEach>
</body>
</html>
