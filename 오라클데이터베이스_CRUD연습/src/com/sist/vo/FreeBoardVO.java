package com.sist.vo;
import java.util.*;
/*  
 *  오라클		자바
 *  컬럼명		멤버변수명
 *  -------------------
 *  데이터형
 *  CHAR
 *  VARCHAR2
 *  CLOB		String
 *  NUMBER		int / double => 저장값
 *  DATE		java.util.Date
 *  BFILE/BLOB	java.io.InputStream => 사용빈도가 거의 없다
 *  => 이미지 => URL
 *  
 */
public class FreeBoardVO {
	private int no, hit;
	private String name, subject, content, pwd;
	private Date regdate;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
