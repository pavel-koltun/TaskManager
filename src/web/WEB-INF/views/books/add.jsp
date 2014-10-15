<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" action="add" commandName="book">
    Title: <form:input id="title" path="title" required="required"/>
    <br />
    Author: <form:input id="author" path="author" required="required"/>
    <br/>
    <input type="submit" value="Add">
</form:form>
<c:if test="${not empty message}">
    <h3>Book added</h3>
</c:if>
</body>
</html>
