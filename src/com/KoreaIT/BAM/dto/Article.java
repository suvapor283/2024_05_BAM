package com.KoreaIT.BAM.dto;

public class Article {
	private int num;
	private String regDate;
	private int memberID;
	private String title;
	private String content;
	private int viewCnt;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public Article(int num, String regDate, int memberId, String title, String content, int viewCnt) {
		this.num = num;
		this.regDate = regDate;
		this.memberID = memberId;
		this.title = title;
		this.content = content;
		this.viewCnt = viewCnt;
	}

	public void increaseViewcnt() {
		this.viewCnt++;
	}
}