<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chat</title>
</head>
<body>
	
	<div id="messages-container"></div>
	
	<form id="chat-form">
		<label for="sender"><strong>Name: </strong></label>
		<input id="sender" name="sender" type="text">
		<br>
		<label for="message"><strong>Message: </strong></label>
		<br>
		<textarea id="message" name="message" rows="10" cols="50"></textarea>
		<br>
		<button type="submit">Send</button>
		<a id="refresh" href="#" target="_self">Refresh</a>
	</form>
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	
	<script type="text/javascript">
		window.messages = [];
		$messagesContainer = $('#messages-container');
	
		function updateContainer() {
			$messagesContainer.html('');
			window.messages.forEach(function (message) {
				$messagesContainer.append('<p><strong>' + message.sender +  '</strong>: ' + message.text + '</p>');
			});
		}
		
		function refreshMessages() {
			$.ajax({
				url: '/chat/api/messages',
				method: 'GET'
			})
			.done(function (messages) {
				window.messages = JSON.parse(messages);
				updateContainer();
			});
		}
	
		$(document).ready(function () {
			refreshMessages();
			
			setInterval(refreshMessages, 5000);
			
			$("#refresh").click(refreshMessages);
			
			$('#chat-form').submit(function (e) {
				e.preventDefault();
				
				$.ajax({
					url: '/chat/api/messages',
					method: 'POST',
					data: {
						sender: $('#sender').val().trim(),
						message: $('#message').val().trim(),
					}
				})
				.done(function () {
					refreshMessages();
				});
			});
		});
	</script>
</body>
</html>