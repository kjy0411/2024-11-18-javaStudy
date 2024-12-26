package com.sist.map;

public class UserMain {

	public static void main(String[] args) {
		Container c = new Container();
		Model model = c.getBean("food"); // board/member/mypage/food/recipe
		model.execute();
		System.out.println(model);
		model = c.getBean("food");
		System.out.println(model); // 메모리 절약 => 싱글턴
	}
	
}
