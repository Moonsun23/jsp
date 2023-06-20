package com.hi1237.model;

public class BoardDto {
	private int id;
	private String userID;
	private String name;
	private String title;
	private String contents;
	private String regDate;
	private int hit;
	
	// private이라 바깥으로 못나가니까 getter, setter를 꼭 해줘야함
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public BoardDto(int id, String userID, String name, String title, String contents, String regDate, int hit) {
		super();
		this.id = id;
		this.userID = userID;
		this.name = name;
		this.title = title;
		this.contents = contents;
		this.regDate = regDate;
		this.hit = hit;
	}
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BoardDto [id=" + id + ", userID=" + userID + ", name=" + name + ", title=" + title + ", contents="
				+ contents + ", regDate=" + regDate + ", hit=" + hit + "]";
	}
		
	
}
