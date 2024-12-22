package com.sist.lib;
class Sawon2{
	private int sabun;
	private String name;
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//초기화
	public Sawon2(int sabun, String n) {
		this.sabun = sabun;
		name = n;
	}
	
	@Override
	public boolean equals(Object obj) {
		Sawon2 s = (Sawon2)obj; //클래스 형변환
		return name.equals(s.name) && sabun == s.sabun;
	}
	
	
}
public class 라이브러리_Object_4_2{
	
	public static void main(String[] args) {
		Sawon2 s1 = new Sawon2(1, "홍길동");
		Sawon2 s2 = new Sawon2(1, "홍길동");
		// equals는 재정의가 없는 경우 => 주소
		// equals 재정의시에는 멤버변수 비교 => String
		if(s1.equals(s2)) {
			System.out.println("같은 사원입니다");
		}else {
			System.out.println("다른 사원입니다");
		}
	}
	
}
