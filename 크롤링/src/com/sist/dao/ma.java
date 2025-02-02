package com.sist.dao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ma {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "2019년 11월 5일 9:44 오후";
		// SimpleDateFormat 패턴 설정
        ReviewVO vo = new ReviewVO();
        vo.setRegdate(str);
        Date str2 = vo.getRegdate();
        System.out.println(vo.getRegdate());
	}

}
