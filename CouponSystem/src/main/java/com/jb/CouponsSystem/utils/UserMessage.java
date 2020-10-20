package com.jb.CouponsSystem.utils;

public class UserMessage {
	private String message;

	public UserMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "userMessage [message=" + message + "]";
	}
	
}
