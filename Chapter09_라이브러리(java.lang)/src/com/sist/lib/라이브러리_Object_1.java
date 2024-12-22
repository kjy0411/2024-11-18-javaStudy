package com.sist.lib;
/*  
 *  toString() : 객체를 문자열 => 객체출력시 생략이 가능
 *  Object 클래스
 *  1. 모든 클래스에 상속을 내린다
 *  2. Object는 가장 큰 데이터형 => 모든 데이터값을 받을 수 있다
 *     Object o = 1
 *     Object o = ""
 *     Object o = 10.5
 *  3. 모든 객체가 사용할 수 있는 기능을 제공
 *     ----------------------------- 메소드
 *  4. java.lang => Object외에 다른 클래스는 final이다
 *  						  ------------------
 *  						  상속을 받아서 변경이 불가능
 *  5. Object
 *     ------
 *     	finalize()/clone/toString()/hashCode()/squals()
 *      -----------------------------------------------
 *  	
 *  	상속
 *  	---
 *  	| 상위 클래스는 하위 클래스에 추가된 메소드, 변수는 접근이 불가능
 *  	  ------------------------------------------------
 *  	  => 오버라이딩된 변수/메소드만 사용이 가능
 *  
 *  	toString() : 문자열 변환 / 객체의 정보 확인
 *  	---------- 멤버변수 확인 => 오버라이딩
 *  							--------
 *  							상위 클래스로 객체를 선언 => 오버라이딩된 메소드 호출이 가능
 *  class A
 *  class B extends A
 *  
 *  A a = new B();
 *  - A가 가지고 있는 변수 + A가 가지고있는 메소드 => 오버라이딩된 메소드 호출
 *    --------------- 주소가 없다		---- 주소
 *    => 정적 바인딩
 *  
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class 라이브러리_Object_1 extends JFrame implements ItemListener{
	JComboBox box = new JComboBox();
	JLabel la = new JLabel();
	public 라이브러리_Object_1() {
		box.addItem("홍길동 : 남자");
		box.addItem("심청이 : 여자");
		box.addItem("박문수 : 남자");
		box.addItem("이순신 : 남자");
		box.addItem("김두한 : 남자");
		
		setLayout(null);
		
		box.setBounds(10, 15, 100, 35);
		add(box);
		
		la.setBounds(10, 100, 300, 35);
		add(la);
		
		setSize(400, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Object는 출력은 가능 => 문자열 제어 불가능
		// 
		// => Object => 매개변수, Object => 리턴형
		// 사용시에는 반드시 형변환
		box.addItemListener(this);
	}
	public static void main(String[] args) {
		new 라이브러리_Object_1();
		/*
		Object o = 1;
		o = "Hello";
		o = 10.5;
		o = 'A';
		*/
		// 혼합된 배열 Object[] obj = {"", 10, 'a', ...};
		// javascript => 배열 => Object
		// => 모든 클래스를 모아서 사용이 가능
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == box) {
			
			String str = box.getSelectedItem().toString();
			//String str = (String)box.getSelectedItem();
			String[] datas = str.split(":");
			la.setText("이름 : " + datas[0] + ", 성별 : " + datas[1]);
			
			//Object obj = box.getSelectedItem();
			//obj.
		}
	}
	
}
