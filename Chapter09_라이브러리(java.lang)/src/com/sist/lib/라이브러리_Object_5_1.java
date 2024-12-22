package com.sist.lib;
import java.util.*;
class Movie{
	private int mno;
	private String title;
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Movie(int mno, String title) {
		this.mno = mno;
		this.title = title;
	}
}
// getclass() => 클래스 타입 (패키지명 클래스명을 찾는 경우)
// => 객체 생성 => 복제 => 소멸 => 비교 => 타입
public class 라이브러리_Object_5_1{
	
	public static void main(String[] args) {
		Movie m1 = new Movie(1, "홍길동전");
		System.out.println(m1.getClass()); // 데이터형 출력
		String s = "";
		System.out.println(s.getClass());
	}
	
}
