package com.sist.io;
// 문자 단위 저장 => write(String s)
import java.io.*;
import java.util.*;
public class IO_5 {

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("c:\\java_data\\student.txt", true);
			/*
			String msg = "Hello Java!! => IO\n";
			fw.write(msg);
			fw.close();
			*/
			String msg = "Hello Oracle!!";
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(msg);
			System.out.println("저장 완료");
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
