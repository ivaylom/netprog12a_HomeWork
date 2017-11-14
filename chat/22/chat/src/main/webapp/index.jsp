<html>
	<head>
		<title>Elsys Chat</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
	</head>
	
	<body>
		
		<div id="container"></div>
		
	    <form action="webapi/chat" method="POST">
	    	<input type='text' name='name' placeholder='Name' />
	    	<input type='text' name='message' placeholder='Message' />
	    	<input type='submit' value='Send' />
	    </form>
	    
	    <input type="button" value="Refresh Page" onClick="window.location.reload()">
	    	    
	    <script>
	    $( document ).ready(function() {	    
			$.ajax({
				url: "/chat/webapi/chat",
				type: "GET"
			}).done(function(data) {
				$.each(data["array"], function(id, message) {
					$("#container").append("<div><small>" + message + "</small></div>");
				});	
			});
		});
	    </script>
	</body>
</html>
