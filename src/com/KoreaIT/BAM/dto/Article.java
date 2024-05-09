package com.KoreaIT.BAM.dto;

public class Article {
	private int id;
	private String regDate;
	private String title;
	private String content;
	private int viewCnt;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
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

	public Article(int id, String regDate, String title, String content, int viewCnt) {
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.content = content;
		this.viewCnt = viewCnt;
	}
	
	public void increaseViewcnt() {
		this.viewCnt++;
	}
}