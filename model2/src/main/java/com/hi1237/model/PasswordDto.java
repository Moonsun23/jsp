package com.hi1237.model;

public class PasswordDto {
	private String userId;
	private String userPw;
	private String newUserPw;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getNewUserPw() {
		return newUserPw;
	}
	public void setNewUserPw(String newUserPw) {
		this.newUserPw = newUserPw;
	}
	@Override
	public String toString() {
		return "PasswordDto [userId=" + userId + ", userPw=" + userPw + ", newUserPw=" + newUserPw + "]";
	}
	
	
}
