<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>ADD - BOOK</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <!-- Header Section -->
    <div class="container bg-success text-white text-center">
        <h1>SPRING BOOT MVC PROJECT</h1>
        <h2>@controller @service @exception @Bootstarp @validation JSP layer...........</h2>
    </div>

    <!-- Form Section -->
    <div class="container mt-4">
        <h2>Add New Book Data........</h2>
        <form method="post" action="/books/savebook">
<!-- BOOTSTARP LINK AJAX AND CLOUDFARE ARE REQUIRED TO ADD THE BOOK LOGO AND USER LOGO  -->
                <!-- Error Validate Message for Book ISBN -->
            <div class="form-group">
                <label>Book ISBN Number:</label>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-phone"></i></span>
                    </div>
                    <input type="text" name="isbn" class="form-control" placeholder="Enter Isbn">
                </div>
                <!-- Error Validate Message for Book Name -->
                <c:if test="${not empty errors.getFieldError('isbn')}">
                    <div class="text-danger">${errors.getFieldError('isbn').defaultMessage}</div>
                </c:if>
            </div>
            <!-- Book Name Field -->
            <div class="form-group">
                <label>Book Name:</label>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-book"></i></span>
                    </div>
                    <input type="text" name="name" class="form-control" placeholder="Enter Name ">
                </div>
                <!-- Error Message for Book Name -->
                <c:if test="${not empty errors.getFieldError('name')}">
                    <div class="text-danger">${errors.getFieldError('name').defaultMessage}</div>
                </c:if>
            </div>

                <!-- Error Validate Message for Book Author -->
            <div class="form-group">
                <label>Book Author:</label>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-user"></i></span>
                    </div>
                    <input type="text" name="author" class="form-control" placeholder="Enter Author">
                </div>
                <!-- Error Message for Book Author -->
                <c:if test="${not empty errors.getFieldError('author')}">
                    <div class="text-danger">${errors.getFieldError('author').defaultMessage}</div>
                </c:if>
            </div>

            <!-- Submit Button -->
            <button type="submit" class="btn btn-primary">SAVE BOOK</button>
        </form>
    </div>
</body>
</html>
