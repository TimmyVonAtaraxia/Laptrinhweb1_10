<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bookstore</title>
</head>
<body>
    <!-- Header -->
    <jsp:include page="/layout/header.jsp"/>

    <!-- Nội dung riêng của từng view -->
    <decorator:body/>

    <!-- Footer -->
    <jsp:include page="/layout/footer.jsp"/>
</body>
</html>