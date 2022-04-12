package fst.lsi.entities;

import org.springframework.security.core.userdetails.UserDetails;

public class Message {
private UserDetails user;
private String message;
	public Message() {
		// TODO Auto-generated constructor stub
	}
	
	public Message(String message) {
		super();
		this.message = message;
	}

	public UserDetails getUser() {
		return user;
	}

	public Message(UserDetails user, String message) {
		super();
		this.user = user;
		this.message = message;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
