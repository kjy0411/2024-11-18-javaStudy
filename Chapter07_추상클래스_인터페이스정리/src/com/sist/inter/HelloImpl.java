package com.sist.inter;
/*  => Secvice를 구현
 *  
 *  사용자 요청 ==> Controller ==> Service => ServiceImpl
 */
public class HelloImpl implements Hello{

	@Override
	public void sayHello(String name) {
		System.out.println(name + "님 환영합니다!!");
	}
	
}
