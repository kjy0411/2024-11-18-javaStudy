package com.sist.dao;
/*
   no   NUMBER,
   genre      VARCHAR2(500) CONSTRAINT novel_genre_nn NOT NULL,
   title      VARCHAR2(500) CONSTRAINT novel_title_nn NOT NULL,    => unique
   poster   VARCHAR2(4000),
   author   VARCHAR2(200) CONSTRAINT novel_author_nn NOT NULL,
   story      CLOB,
   avgstar   NUMBER DEFAULT 0,
   serial      VARCHAR2(500),
   iscp   CHAR(2),													=> char(2) => char(1)
   CONSTRAINT novel_no_pk PRIMARY KEY(no),
   CONSTRAINT novel_iscp_ck CHECK(iscp IN('y','n'))					=> y,n => Y,N

 */
public class NovelVO {
	private int no;
	private double avgstar;
	private String genre, title, poster, author, story, serial, iscp;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public double getAvgstar() {
		return avgstar;
	}
	public void setAvgstar(double avgstar) {
		this.avgstar = avgstar;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getIscp() {
		return iscp;
	}
	public void setIscp(String iscp) {
		this.iscp = iscp;
	}
}
