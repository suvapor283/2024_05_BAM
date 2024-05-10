package com.KoreaIT.BAM.dto;

public class Member {
	private int num;
	private String name;
	private String regDate;
	private String loginId;
	private String loginPw;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPw() {
		return loginPw;
	}

	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}

	public Member(int num, String regDate, String name, String loginId, String loginPw) {
		this.num = num;
		this.regDate = regDate;
		this.name = name;
		this.loginId = loginId;
		this.loginPw = loginPw;
	}
}