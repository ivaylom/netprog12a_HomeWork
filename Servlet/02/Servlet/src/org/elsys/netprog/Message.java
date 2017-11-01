package org.elsys.netprog;

public class Message {
	private String name;
	private String text;
	
	Message(String n,String t){
		this.name = n;
		this.text = t;
	}
	public String getName() {
		return name;
	}
	public String getText() {
		return text;
	}
}
