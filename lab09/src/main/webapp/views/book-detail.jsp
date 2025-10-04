<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${book.title}</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body class="container mt-4">

    <h2>${book.title}</h2>
    <div class="row">
        <!-- Ảnh -->
        <div class="col-md-4">
            <img src="${pageContext.request.contextPath}/images/${book.coverImage}"
                 alt="cover" class="img-fluid img-thumbnail"/>
        </div>

        <!-- Thông tin sách -->
        <div class="col-md-8">
            <p><b>Mã ISBN:</b> ${book.isbn}</p>
            <p><b>Tác giả:</b>
                <c:forEach var="a" items="${book.authors}">
                    ${a.authorName}<br/>
                </c:forEach>
            </p>
            <p><b>Publisher:</b> ${book.publisher}</p>
            <p><b>Publish Date:</b> ${book.publishDate}</p>
            <p><b>Số lượng:</b> ${book.quantity}</p>
        </div>
    </div>

    <hr/>

    <!-- Reviews -->
    <h3>Reviews (${reviewCount})</h3>
    <c:forEach var="r" items="${ratings}">
        <div class="card mb-2">
            <div class="card-body">
                <b>User ${r.id.userId}:</b> ⭐ ${r.rating}<br/>
                ${r.reviewText}
            </div>
        </div>
    </c:forEach>

    <hr/>

    <!-- Form thêm review -->
    <h4>Thêm review</h4>
    <form action="${pageContext.request.contextPath}/books/${book.bookId}/rating" method="post">
        <div class="mb-3">
            <label class="form-label">Rating (1-5):</label>
            <input type="number" name="rating" class="form-control" min="1" max="5" required/>
        </div>
        <div class="mb-3">
            <label class="form-label">Review:</label>
            <textarea name="reviewText" class="form-control" rows="3"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Gửi</button>
    </form>

</body>
</html>
