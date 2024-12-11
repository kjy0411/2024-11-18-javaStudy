package com.sist.main;

class Member{
	String name;
	String id;
	String password;
	int age;
	
	public Member(String name, String id) {
		this.name = name;
		this.id = id;
	}
}
public class 문제예제 {

	public static void main(String[] args) {
		Member m = new Member("홍길동", "hong");
		
		m.password = "1234";
		m.age = 24;
		
		System.out.println(m.name);
		System.out.println(m.id);
		System.out.println(m.password);
		System.out.println(m.age);
		
		System.out.println(new Member("test", "123").name);
	}
	
}
