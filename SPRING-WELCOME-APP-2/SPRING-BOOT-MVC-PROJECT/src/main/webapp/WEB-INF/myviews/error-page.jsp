<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html>
<html>
	<head>
		<title>ERROR - PAGE - BOOKS</title>
		<!-- CSS LINK HERE GETBOOTSTRAP.COM CDN LINKS  -->		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	</head>
<body>
		<div  class="container-fluid bg-success text-white text-center">
			    <h1>SPRING BOOT MVC PROJECT</h1>
			    <h2>@controller @service @exception @Bootstrap @validation JSP layer...........</h2>
			</div>
			<div class="container-fluid text-center bg-success">
			
			Book ISBN :${book.isbn }<br>
			Book Name :${book.name }<br>
			Book Author :${book.author }<br>
			Message : ${message }
			</div>

</body>
</html>