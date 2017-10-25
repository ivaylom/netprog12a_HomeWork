package org.elsys;

public class Message {
	private String sender;
	private String message;
	
	
	public Message(String sender, String message) {
		this.sender = sender;
		this.message = message;
		
	}
	
	public String generateMsgHtml() {
		return "<p><b>" + this.sender + "<b>: " + this.message + "</p>";
	}
	
	public String getSender() {
		return sender;
	}
	
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public String getMsg() {
		return message;
	}
	
	public void setMsg(String message) {
		this.message = message;
	}
	
	

}
