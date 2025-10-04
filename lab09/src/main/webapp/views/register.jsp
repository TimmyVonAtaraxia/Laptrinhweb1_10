<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng ký</title>
</head>
<body>
<h2>Đăng ký</h2>

<form action="${pageContext.request.contextPath}/register" method="post">
    <label>Họ tên:</label><br/>
    <input type="text" name="fullname" required/><br/><br/>

    <label>Email:</label><br/>
    <input type="email" name="email" required/><br/><br/>

    <label>Số điện thoại:</label><br/>
    <input type="text" name="phone"/><br/><br/>

    <label>Mật khẩu:</label><br/>
    <input type="password" name="passwd" required/><br/><br/>

    <button type="submit">Đăng ký</button>
</form>

<p>Đã có tài khoản? <a href="${pageContext.request.contextPath}/login">Đăng nhập</a></p>
</body>
</html>