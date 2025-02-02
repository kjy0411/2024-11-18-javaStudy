package com.sist.dao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
  rno      NUMBER,
   no      NUMBER,
   id      VARCHAR2(20),
   star      NUMBER CONSTRAINT review_star_nn NOT NULL,
   content   CLOB,
   regdate   DATE,								=> default SYSDATE
   up      NUMBER,								=> default 0
   down      NUMBER,							=> default 0
   CONSTRAINT review_rno_pk PRIMARY KEY(rno),
   CONSTRAINT review_no_fk FOREIGN KEY(no)
   REFERENCES novel(no),
   CONSTRAINT review_id_fk FOREIGN KEY(id)
   REFERENCES member(id)   

 */
public class ReviewVO {
	private int rno, no, up, down;
	private double star;
	private String id, content;
	private Date regdate;
	private String strRegdate;
	
	
	public String getStrRegdate() {
		return strRegdate;
	}
	public void setStrRegdate(String str) {
		System.out.println(str);
		this.strRegdate = str;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy MM dd");
		Date date = null;
        try {
			date = (Date) inputFormat.parse(regdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        this.regdate = date;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getUp() {
		return up;
	}
	public void setUp(int up) {
		this.up = up;
	}
	public int getDown() {
		return down;
	}
	public void setDown(int down) {
		this.down = down;
	}
	public double getStar() {
		return star;
	}
	public void setStar(double star) {
		this.star = star;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
