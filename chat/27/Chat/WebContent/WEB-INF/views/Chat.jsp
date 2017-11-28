<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Anonymous chat</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	</head>
	<body>
		<div id="messages"></div>
		<input type="text" name="name" placeholder="Име" />
		<input type="text" name="message" placeholder="Съобщение" />
		<button onclick="postMessage()">Изпрати</button><br>
		<button onclick="getMessages()">Презареди</button>
		<script>
			function renderMessage(name, message) {
				return "<p>" +
					"От: " + name +
				"</p>" +
				"<p>" +
					message +
				"</p>" +
				"<hr>";
			}
		
			function renderMessages(messages) {
				$("#messages").html("");
				messages.forEach(function (message) {
					$("#messages").append(renderMessage(message.name, message.message));
				});
			}
			
			function postMessage() {
				var name = $("input[name=name]").val();
				var message = $("input[name=message]").val();
				$("input[name=name]").val("");
				$("input[name=message]").val("");
				$.post("/Chat/Chat", {name: name, message: message}, renderMessages);
			}
		
			function getMessages() {
				$.get("/Chat/Chat", renderMessages);
			}
			
			getMessages();
		</script>
	</body>
</html>