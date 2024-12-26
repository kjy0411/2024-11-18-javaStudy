package com.sist.io;
//파일 제어 => 파일에 읽기/쓰기
//			------------- Reader /Writer
import java.io.*;
import java.util.*;
public class IO_3 {

	public static void main(String[] args) {
		// FileWriter : 파일에 입력
		FileWriter fw = null; // 2byte단위 : 한글은 한글자당 2byte
		
		try {
			fw = new FileWriter("c:\\java_data\\sawon.txt", true);
			// true => append모드 => 이어서 저장이 가능
			//sawon.txt파일이 없는 경우에는 자동으로 생성
			fw.write("3|박문수|영업부|경기|3000\r\n");
			System.out.println("등록 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (Exception e) {}
		}
	}
	
}
