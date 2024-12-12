package com.sist.win;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*; //윈도우 관련
/*  
 *  상속 => 기존의 클래스를 재사용 => 추가, 변경해서 사용
 *  	   ----------
 *  	   사용자 정의
 *  	   라이브러리 => 변경해서 사용하는 상속이 많다
 *  	   => 코드의 재사용이 높다
 *  		  --------------- 개발 속도가 빠르다
 *  	   => 코드 관리가 용이하다
 *  	   => 코드가 간결해진다
 *  	   => 기존의 클래스 이미 검증된 상태 : 신뢰성이 높다
 *  	상속 : is-a => 변경 후 사용
 *  	포함 : has-a => 있는 그대로 사용(***)
 *  
 *  객체지향 => 권장(캡슐화, 재사용(상속), 변경, 추가가 쉽게)
 *  							   -------------- 오버라이딩, 오버로딩
 *  *** 상속의 문제점
 *  	= 결합성이 높다 (다른 클래스에 영향이 크다)
 *  	ex) 상속받는 클래스 => 상속을 내리는 클래스 (변경)
 *  	= 제약조건이 많다
 *  	= 메모리가 커진다 => 속도가 느려진다
 *  	
 *  특징)
 *  	1. 단일 상속만 가능
 *  	2. 상속 기호 : extends : 클래스를 확장해서 사용
 *  				--------
 *  		ex) class A extends B
 *  			A클래스는 B클래스를 확장해서 새로운 클래스 제작
 *  			=> A클래스는 B클래스로부터 상속을 받는다
 *  	3. 상속 => 특별한 경우가 아니면 모든 변수, 메소드 상속
 *  							  -----------------
 *  	   => 특별한 경우 (예외)
 *  		  static : => 공유 (여러개의 객체가 공동 사용)
 *  				   => 사용이 가능하게 만든다
 *  		  생성자
 *  		  초기화블록
 *  		  private : 상속은 내려간다 => 접근이 불가능
 *  		  -----------> getter/setter
 *  
 *  	상속 내리는 클래스 (super, 상위클래스, 부모클래스)
 *  		=> 상속을 받을 클래스의 변수, 메소드에 접근이 불가능
 *  		   --------------
 *  			자신의 객체 =======> this
 *  			상위 클래스의 객체 ==> super
 *  	class A
 *  	{
 *  		int a,b
 *  	}
 *  	class B extends A
 *  	{
 *  		//a,b
 *  
 *  		public B()
 *  		{
 *  			this.a = 10;
 *  			this.b = 20;
 *  			super.a = 100;
 *  			super.a = 200;
 *  		}
 *  	}
 *  
 *  	// 두개
 *  	class A
 *  	class B extends A
 *  	class C extends B
 *  
 *  	class A
 *  	class B extends A
 *  
 *  	메모리 할당
 *  
 *  	A a = new A()
 *  	B b = new B()
 *  	A c = new B()
 *  
 *  
 *  
 */
/*
class A{
	int a = 10;
	void display() {
		System.out.println("A클래스가 가지고 있는 display");
	}
}
class B extends A{
	int a = 100;
	void display() {
		System.out.println("B클래스가 가지고 있는 display");
	}
}
*/
// 가장 큰 클래스 상속 => 포함
public class 윈도우상속 extends JFrame{
	//윈도우 설정 => 실무(구현)
	JButton b1 = new JButton("North");//포함 클래스
	JButton b2 = new JButton("East");
	JButton b3 = new JButton("West");
	JButton b4 = new JButton("Center");
	JButton b5 = new JButton("South");
	public 윈도우상속() {
		//setLayout(new FlowLayout());
		setLayout(new GridLayout(3, 2));
		//BorderLayout => default
		add(b1); add(b2); add(b3); add(b4); add(b5);
		//레이아웃
		//add("North", b1);
		//add("South", b5);
		//add("Center", b4);
		//add("East", b2);
		//add("West", b3);
		//크기 결정
		setSize(640, 400);
		
		//윈도우 보여달라
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 윈도우상속();
		/*
		A aa = new A();
		System.out.println(aa.a);
		aa.display();
		
		B bb = new B();
		System.out.println(bb.a);
		bb.display();
		
		//클래스가 많은 경우 => 모아서 한개의 이름으로 제어
		//상위 클래스를 이용해서 접근이 가능
		A cc = new B();
		System.out.println(cc.a);
		cc.display(); //오버라이딩 => 가상함수
		
		//B dd = (B)new A(); // 오류
		A dd = new B();
		B ee = (B)dd;
		*/
	}

}
