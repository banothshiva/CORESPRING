<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
	<html>
		<head>
			<title>VIEW - BOOKS</title>
				<!-- CSS LINK HERE GETBOOTSTRAP.COM CDN LINKS  -->		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		</head>
		<body>
			<div  class="container-fluid bg-success text-white text-center">
			    <h1>SPRING BOOT MVC PROJECT</h1>
			    <h2>@controller @service @exception @Bootstrap @validation JSP layer...........</h2>
			</div>
			
				<div class="container-fluid text-center">
				<a class="link-primary badge bg-warning" href="/books/addBook">Click Here To Add The New Book</a>
				</div>
				
					<div class="container">
					<h1>LIST OF BOOKS INFORMATION.......</h1>
					
				<div class="text-center badge bg-success container-fluid ">
					<c:if test="${saveSuccessMessage }">
						${saveSuccessMessage}
							Data Saved Successfully............ 
				</c:if>
					<c:if test="${deleteMessage }">
						${deleteMessage}
							Data Deleted  Successfully............ 
				</c:if>
					<c:if   test="${editmessage }">
						${editmessage}
								Data Edited  Successfully............ 
					</c:if>
		</div>
	
		<table class="table table-striped table-bordered ">
			   <thead class="table table-dark">
			      <tr>
			         <th>ISBN</th>
			      	 <th>NAME</th>
			         <th>AUTHOR</th>
			         <th>ACTION</th>
			      </tr>
			   </thead>
			   <tbody>
			      <c:forEach items="${books}" var="book">
				   <tr>
							  <td>${book.isbn}</td>
							  <td>${book.name}</td>
					    	  <td>${book.author}</td>
					   		<td>
							  <a href="/books/edit/${book.isbn}">Edit</a>
							  <a href="/books/delete/${book.isbn}">Delete</a>
  							</td>
					
				   </tr>
				</c:forEach>		
			   </tbody>
			</table>	
		</div>
</html>
