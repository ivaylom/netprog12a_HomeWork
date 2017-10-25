<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chat</title>
</head>
<body>

	${messages}
	
	<form action="${location}" method="post">
		<label for="sender"><strong>Name: </strong></label>
		<input name="sender" type="text">
		<br>
		<label for="message"><strong>Message: </strong></label>
		<br>
		<textarea name="message" rows="10" cols="50"></textarea>
		<br>
		<button type="submit">Send</button>
		<a href="${location}" target="_self">Refresh</a>
	</form>
</body>
</html>