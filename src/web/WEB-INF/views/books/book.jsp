<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>Book: ${book.title} by ${book.author}</h2>
<a href="/remove/${book.id}">Delete this book</a>
</body>
</html>
