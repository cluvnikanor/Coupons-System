package com.jb.CouponsSystem.utils;

public class UserData {
	private UserType userType;
	private String email;

	public UserData(UserType userType, String email) {
		this.userType = userType;
		this.email = email;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserData [userType=" + userType + ", email=" + email + "]";
	}

}
