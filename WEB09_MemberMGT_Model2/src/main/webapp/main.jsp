<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Main</title>
	</head>
	<body>
		<table>
			<tr><td>안녕하세요. ${loginUser.name}(${loginUser.userid})님</td></tr>
			<tr><td>Email : ${loginUser.email}</td></tr>
			<tr><td>전화번호 : ${loginUser.phone}</td></tr>
		</table>
	</body>
</html>