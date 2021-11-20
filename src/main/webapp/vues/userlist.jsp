<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
</head>
<body>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<h1>Users List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Username</th>
			<th>Mail</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="userVo" items="${list}">
			<tr>
				<td>${userVo.id}</td>
				<td>${userVo.username}</td>
				<td>${userVo.mail}</td>
				<td><a href="edituser/${userVo.id}">Edit</a></td>
				<td><a href="deleteuser/${userVo.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="userform">Add New user</a>
</body>
</html>