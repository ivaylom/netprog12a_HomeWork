package org.elsys;

public class User {
	
	private String Name; 
	
	private String Message;

	
	public User(String Name, String Message) {
		this.Name = Name;
		this.Message = Message;
	}
	
	public String getName() {
		return Name;
	}

	public String getMessage() {
		return Message;
	}
		
}
