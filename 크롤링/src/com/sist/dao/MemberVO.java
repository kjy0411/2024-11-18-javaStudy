package com.sist.dao;
import java.util.Date;
/*
ID" VARCHAR2(20 BYTE), 
NICKNAME" VARCHAR2(100 BYTE), 
PW" VARCHAR2(20 BYTE) CONSTRAINT "U_PW_NN" NOT NULL ENABLE, 
NAME" VARCHAR2(51 BYTE) CONSTRAINT "U_NAME_NN" NOT NULL ENABLE, 
GENDER" CHAR(6 BYTE), 
EMAIL" VARCHAR2(100 BYTE), 
BIRTH" DATE CONSTRAINT "U_DAY_NN" NOT NULL ENABLE, 
ADDRESS1" VARCHAR2(1000 BYTE) CONSTRAINT "U_ADR_NN" NOT NULL ENABLE, 
ADDRESS2" VARCHAR2(1000 BYTE), 
PHONE" VARCHAR2(13 BYTE) NOT NULL ENABLE, 
REG_DATE" DATE DEFAULT sysdate, 
IS_ADMIN" CHAR(1 BYTE) DEFAULT 'N', 
LAST_LOGIN" DATE DEFAULT SYSDATE, 
 */
public class MemberVO {
	private String id, nickname, pw, name, gender, email, address1, address2, phone, isAdmin;
	private Date birth, regDate, lastLogin;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
}
