<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="/java_spring_project/reachResourcesFolders/css/my-style-sheet.css">
</head>
<body>
	
	<div class="container">
	<h1>Student Registration Form</h1>
		
		<table class="table table-hover" border="5">
			<thead>
				<tr>
					<td>id</td>
					<td>name</td>
					<td>mobile</td>
					<td>country</td>
					<td>update information</td>
					<td>delete information</td>
				</tr>
			</thead>

			<c:forEach var="student" items="${students}">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.mobile}</td>
					<td>${student.country}</td>
					<td><a
						href="/java_spring_project/updateStudent?userId=${student.id}">Update</a></td>
					<td><a
						href="/java_spring_project/deleteStudent?userId=${student.id}"
						onclick="if(!(confirm('Are you sure you want to delete the record'))) return false">Delete</a></td>
				</tr>
			</c:forEach>

		</table>
		<form action="/java_spring_project/showAddStudentPage">
			<br><input type="submit" value="Add" class="btn btn-outline-success">
		</form>
		<img alt="test photo" src="/java_spring_project/reachResourcesImages/20201220_111051.jpg" height="400" width="400">
	</div>
</body>
</html>