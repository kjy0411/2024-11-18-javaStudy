package com.sist.lib;
//finalize() = 소멸자 함수 => 객체가 메모리에서 해제 => 자동 호출
class Sawon /* extends Object */{ 
	private int sabun;
	private String name;
	
	public Sawon() {
		sabun = 1;
		name = "홍길동";
		System.out.println("객체 생성 = 초기화 완료");
	}
	
	public void print() {
		System.out.println("사번 : " + sabun);
		System.out.println("이름 : " + name);
	}
	@Override
	public void finalize() throws Throwable{
		System.out.println("사용 객체 소멸 : Heap에서 사라진다");
	}
	//소멸 여부 확인
	
}
public class 라이브러리_Object_2{
	public static void main(String[] args) {
		//객체의 생명주기
		Sawon sa = new Sawon(); // 객체 생성
		sa.print(); // 객체 활용
		sa = null; // 주소값 지우기
		//직접 회수
		System.gc(); // 가비지 컬렉션 호출 => null, 사용하지 않는 데이터 회수
		
		/*
		Object o = 10; //=> AutoBax
		int i = (int)o; //=> UnBox
		int a = (int)10.5;
		*/
		/*  ==> Object / String / Wrapper
		 *  	Integer i = 100;
		 *  	int k = i;
		 */
	}
	
}
