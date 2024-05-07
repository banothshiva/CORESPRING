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
        <h2>@controller @service @exception validation JSP layer...........</h2>
    </div>

    <!-- Form Section -->
    <div class="container mt-4">
        <h2>Add New Book Data........</h2>
        <form method="post" action="/books/editsavebook">

         <!-- Book Name Field -->
            <div class="form-group">
                <label>BOOK NUMBER:</label>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-book"></i></span>
                    </div>
                    <input type="text" name="isbn" readonly="readonly" value="${book.isbn }" class="form-control" placeholder="ENTER ISBN">
                </div>
                <!-- Error Message for Book Name -->
                
            </div>
            <!-- Book Name Field -->
            <div class="form-group">
                <label>BOOK NAME:</label>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-book"></i></span>
                    </div>
                    <input type="text" name="name" value="${book.name }" class="form-control" placeholder="ENTER NAME">
                </div>
                
            </div>

            <!-- Book Author Field -->
            <div class="form-group">
                <label>BOOK AUTHOR:</label>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-user"></i></span>
                    </div>
                    <input type="text" name="author"  value="${book.author }" class="form-control" placeholder="ENTER AUTHOR">
                </div>
                
            </div>

            <!-- Submit Button -->
            <button type="submit" class="btn btn-primary">SAVE BOOK</button>
        </form>
    </div>
</body>
</html>
