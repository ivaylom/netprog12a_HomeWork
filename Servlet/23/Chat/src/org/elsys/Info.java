package org.elsys;


public class Info {
	private String name;
	static String spacing = " : ";
	private String message;
	
	public Info(String name, String message){
		this.name = name;
		this.message = message;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMessage() {
		return message;
	}
}