package org.elsys.data;

import java.util.Date;
import java.util.List;

public class Message {
	
	private Date date;
	private String sender;
	private String text;
	
	public static String formatHTML(List<Message> messages) {
		String html = "";
		
		for (int i = 0; i < messages.size(); i++) {
			html += "<p><strong>" + messages.get(i).getSender() + "</strong>: " + messages.get(i).getText() + "</p>";
		}
		
		return html;
	}
	
	public Message(String sender, String text) {
		this(new Date(), sender, text);
	}

	public Message(Date date, String sender, String text) {
		super();
		this.date = date;
		this.sender = sender;
		this.text = text;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getSender() {
		return sender;
	}
	
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
