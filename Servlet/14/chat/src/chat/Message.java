package chat;

public class Message {
	private String content;
	private String author;
	
	public Message(String author, String content) {
		this.content = content;
		this.author = author;
	}
	
	public String displayString() {
		return author + ":" + content;
	}
}
