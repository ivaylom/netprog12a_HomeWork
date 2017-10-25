<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chat v2</title>
</head>
<body>
<form method="POST">
	<div>Name:</div>
	<input type="text" name="name" placeholder="Name" />
	<br>
	<div>Message:</div>
	<input type="text" name="message" placeholder="Message" />
	<br>
	<input type="submit" value="Send"/>
	<a href="/ChatHomework/Servlet">Refresh</a>
</form>
<c:forEach var="message" items="${messages}">
	<c:out value="From: ${message.getOwner()}"/>
	<br>
	<c:out value="${message.getContent()}" />
	<hr/>
</c:forEach>
</body>
</html>