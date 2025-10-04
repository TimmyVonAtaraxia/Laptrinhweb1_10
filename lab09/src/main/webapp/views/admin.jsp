<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Trang quản trị</title>
</head>
<body>
<h2>Khu vực Quản trị</h2>
<p>Chỉ Admin mới được phép vào đây.</p>

<ul>
    <li><a href="${pageContext.request.contextPath}/admin/users">Quản lý người dùng</a></li>
    <li><a href="${pageContext.request.contextPath}/admin/books">Quản lý sách</a></li>
</ul>
</body>
</html>