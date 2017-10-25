
public class Message {
	private String owner;
	private String content;
	
	public Message(String owner, String content) {
		this.setOwner(owner);
		this.content = content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getOwner() {
		return owner;
	}	
}
