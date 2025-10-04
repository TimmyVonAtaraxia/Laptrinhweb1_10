<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<jsp:include page="/layout/header.jsp" />
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Sách</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body class="container mt-4">

	<h2>Danh sách Sách</h2>

	<div class="mb-3">
		<!-- Nút thêm mới -->
		<a href="${pageContext.request.contextPath}/admin/books/add"
			class="btn btn-success"> ➕ Thêm sách </a>
	</div>

	<table class="table table-bordered table-hover">
		<thead class="table-light">
			<tr>
				<th>Cover Image</th>
				<th>Tiêu đề</th>
				<th>Mã ISBN</th>
				<th>Publisher</th>
				<th>Publish Date</th>
				<th>Quantity</th>
				<th>Review</th>
				<th>Hành động</th>
				<!-- ✅ Thêm cột hành động -->
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${books}">
				<tr>
					<td>File: <c:out value="${book.coverImage}" /><br /> <img
						src="${pageContext.request.contextPath}/images/${book.coverImage}"
						alt="cover" />
					</td>
					<td>
						<!-- ✅ Link chi tiết --> <a
						href="${pageContext.request.contextPath}/books/${book.bookId}">
							${book.title} </a>
					</td>
					<td>${book.isbn}</td>
					<td>${book.publisher}</td>
					<td>${book.publishDate}</td>
					<td>${book.quantity}</td>
					<td>100 Reviews</td>
					<td>
						<!-- ✅ Nút sửa --> <a
						href="${pageContext.request.contextPath}/admin/books/edit/${book.bookId}"
						class="btn btn-primary btn-sm">✏️ Sửa</a> <!-- ✅ Nút xóa --> <a
						href="${pageContext.request.contextPath}/admin/books/delete/${book.bookId}"
						class="btn btn-danger btn-sm"
						onclick="return confirm('Bạn có chắc muốn xóa sách này?');">🗑
							Xóa</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<!-- Pagination -->
	<nav>
		<ul class="pagination">
			<c:if test="${currentPage > 1}">
				<li class="page-item"><a class="page-link"
					href="?page=${currentPage - 1}&size=5">« Trước</a></li>
			</c:if>

			<li class="page-item active"><span class="page-link">Trang
					${currentPage}</span></li>

			<c:if test="${currentPage < totalPages}">
				<li class="page-item"><a class="page-link"
					href="?page=${currentPage + 1}&size=5">Tiếp »</a></li>
			</c:if>
		</ul>
	</nav>

</body>
</html>
<jsp:include page="/layout/footer.jsp" />
