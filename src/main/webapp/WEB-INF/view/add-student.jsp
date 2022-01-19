<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="/java_spring_project/reachResourcesFolders/css/add-student.css">
	<link rel="stylesheet" type="text/css"
	href="/java_spring_project/reachResourcesFolders/css/my-style-sheet.css">
</head>
<body class="myFonts">
<div align="center">
<h1>Add Student</h1>

<form:form action="save-student" modelAttribute="student" method="POST">

<form:hidden path="id"/><br>

<label>Name :</label>
<form:input path="name"/><br>

<label>Mobile :</label>
<form:input path="mobile"/><br>

<label>Country :</label>
<form:input path="country"/><br>

<input type="submit" value="Submit" class="btn btn-outline-success">

</form:form>
</div>
</body>
</html>