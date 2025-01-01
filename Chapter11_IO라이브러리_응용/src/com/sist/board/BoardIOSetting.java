package com.sist.board;
import java.io.*;
import java.util.*;
public class BoardIOSetting {
	
	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		try {
			List<BoardVO> list = new ArrayList<BoardVO>();
			FileOutputStream fos = new FileOutputStream("c:\\java_data\\board.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			System.out.println("파일에 저장공간 생성 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 오라클 /서버 / 파일
			try {
				oos.close();
			} catch (Exception e) {}
		}
	}
}
