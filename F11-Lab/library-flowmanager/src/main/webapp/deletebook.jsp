<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Book</title>
</head>
<body>
<div>
    <a href="/library">Home</a>
    <p>
    <form action="deletebook" method="post">
        <input type="hidden" name="isbn" value="${param.isbn}">
        <input type="hidden" name="authorid" value="${param.authorid}">
        <p>Are you sure you want to delete this book?</p>
        <div>
            <input type="submit" value="Delete" name="submit">
        </div>
    </form>
</div>
</body>
</html>