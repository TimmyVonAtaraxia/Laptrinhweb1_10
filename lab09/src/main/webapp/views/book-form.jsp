<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm / Sửa Sách</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body class="container mt-4">

<h2>Form Thêm / Sửa Sách</h2>

<form:form method="post"
           modelAttribute="book"
           action="${pageContext.request.contextPath}/admin/books/save">

    <form:hidden path="bookId"/>  <!-- ẩn ID khi sửa -->

    <div class="mb-3">
        <label>ISBN</label>
        <form:input path="isbn" cssClass="form-control" required="required"/>
    </div>

    <div class="mb-3">
        <label>Tiêu đề</label>
        <form:input path="title" cssClass="form-control" required="required"/>
    </div>

    <div class="mb-3">
        <label>Publisher</label>
        <form:input path="publisher" cssClass="form-control" required="required"/>
    </div>

    <div class="mb-3">
        <label>Giá</label>
        <form:input path="price" cssClass="form-control" required="required"/>
    </div>

    <div class="mb-3">
        <label>Mô tả</label>
        <form:textarea path="description" cssClass="form-control" required="required"/>
    </div>

    <div class="mb-3">
        <label>Ngày xuất bản</label>
        <form:input path="publishDate" type="date" cssClass="form-control" required="required"/>
    </div>

    <div class="mb-3">
        <label>Ảnh bìa</label>
        <form:input path="coverImage" cssClass="form-control" required="required"/>
    </div>

    <div class="mb-3">
        <label>Số lượng</label>
        <form:input path="quantity" cssClass="form-control" required="required"/>
    </div>

    <button type="submit" class="btn btn-primary">Lưu</button>
</form:form>

</body>
</html>