<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<meta charset="UTF-8">

<header style="background: #4682A9; padding: 10px; color: white;">
	<nav>
		<a href="${pageContext.request.contextPath}/home"
			style="margin-right: 15px; color: white;">Trang Chủ</a> <a
			href="${pageContext.request.contextPath}/products"
			style="margin-right: 15px; color: white;">Sản phẩm</a>
		<c:choose>
			<c:when test="${sessionScope.user == null}">
				<a href="${pageContext.request.contextPath}/login"
					style="margin-right: 15px; color: white;">Đăng nhập</a>
				<a href="${pageContext.request.contextPath}/register"
					style="margin-right: 15px; color: white;">Đăng ký</a>
			</c:when>
			<c:otherwise>
				<span>Xin chào, ${sessionScope.user.fullname}</span>
				<a href="${pageContext.request.contextPath}/logout"
					style="margin-left: 15px; color: white;">Đăng xuất</a>
				<c:if test="${sessionScope.user.is_admin}">
					<a href="${pageContext.request.contextPath}/admin"
						style="margin-left: 15px; color: yellow;">Trang quản trị</a>
				</c:if>
			</c:otherwise>
		</c:choose>
	</nav>
</header>