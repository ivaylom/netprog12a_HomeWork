<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Anonymous chat</title>
</head>
<body>
<c:forEach var="message" items="${messages}">
	<c:out value="От: ${message.getName()}"/><br>
	<c:out value="${message.getMessage()}" />
	<hr/>
</c:forEach>
<form method="POST">
	<input type="text" name="name" placeholder="Име" />
	<input type="text" name="message" placeholder="Съобщение" />
	<input type="submit" value="Изпрати"/>
	<a href="/ServletHW">Презареди</a>
</form>
</body>
</html>