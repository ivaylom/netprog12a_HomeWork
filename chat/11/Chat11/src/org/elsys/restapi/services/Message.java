package org.elsys.restapi.services;

public class Message {

	public String username;
	public String message;
	
	public Message(String username, String message) {
		this.username = username;
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "\"" + username + "\"" + "," + "\"" + message + "\"";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
