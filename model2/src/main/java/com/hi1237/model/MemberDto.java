package com.hi1237.model;

public class MemberDto {
	private String id;
	private String name;
	private String password;
	private String email;
	private int Zonecode;
	private String address;
	private String detailAddress;
	private String extraAddress;
	
	
	public MemberDto() {
		super();
	}


	public MemberDto(String id, String name, String password, String email, int zonecode, String address,
			String detailAddress, String extraAddress) {
		super();
		// sql의 컬럼 명이랑 순서를 맞춰서 써줘야함
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		Zonecode = zonecode;
		this.address = address;
		this.detailAddress = detailAddress;
		this.extraAddress = extraAddress;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getZonecode() {
		return Zonecode;
	}


	public void setZonecode(int zonecode) {
		Zonecode = zonecode;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getDetailAddress() {
		return detailAddress;
	}


	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}


	public String getExtraAddress() {
		return extraAddress;
	}


	public void setExtraAddress(String extraAddress) {
		this.extraAddress = extraAddress;
	}


	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", Zonecode="
				+ Zonecode + ", address=" + address + ", detailAddress=" + detailAddress + ", extraAddress="
				+ extraAddress + "]";
	}
	// 순서상관없이 generate 해줌.. getter setter/ superclass/ toString
	
}
 