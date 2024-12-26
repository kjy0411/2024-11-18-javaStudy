package com.sist.io;
import java.io.*;
// (폴더 / 파일) 생성 / 존재여부 확인 / 삭제
public class IO_5 {

	public static void main(String[] args) {
		
		//폴더 생성
		File dir = new File("c:\\java_data");
		if(!dir.exists()) { // 폴더 => 존재하지 않는 경우에
			dir.mkdir();
			System.out.println("java_data폴더 생성");
		}else {
			System.out.println("이미 존재하는 폴더입니다");
		}
		
		//파일 생성
		File file = new File("c:\\java_data\\sawon.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e) {}
			System.out.println("파일 생성");
		}else {
			System.out.println("이미 파일이 존재합니다!!");
		}
		System.out.println("프로그램 종료");
	}
	
}
