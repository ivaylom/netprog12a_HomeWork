package org.elsys.netprog;

import java.util.ArrayList;
import java.util.List;

public class Message {
	
	String name;
	String message;
	
	Message(String name, String message) {
		this.name = name;
		this.message = message;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
