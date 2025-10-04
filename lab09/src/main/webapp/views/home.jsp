<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/layout/header.jsp"/>
<h2>Trang chủ Bookstore</h2>
<c:if test="${not empty user}">
    <p>Xin chào, <b>${user.fullname}</b>!</p>
    <p>Email: ${user.email}</p>
</c:if>
<jsp:include page="/layout/footer.jsp"/>