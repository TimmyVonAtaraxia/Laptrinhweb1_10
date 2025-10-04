<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
<h2>Đăng nhập</h2>

<form action="${pageContext.request.contextPath}/login" method="post">
    <label>Email:</label><br/>
    <input type="text" name="email" required/><br/><br/>

    <label>Mật khẩu:</label><br/>
    <input type="password" name="passwd" required/><br/><br/>

    <button type="submit">Đăng nhập</button>
</form>

<p style="color:red">${error}</p>
<p>Bạn chưa có tài khoản? <a href="${pageContext.request.contextPath}/register">Đăng ký</a></p>
</body>
</html>