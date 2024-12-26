package com.sist.io;
//파일 제어
import java.util.*;
import java.io.File;
public class IO_2 {

	public static void main(String[] args) {
		//폴더 생성
		File dir = new File("c:\\javaDev");
		// listFiles => 어떤 파일 / 폴더가 있는지 확인
		File[] list = dir.listFiles();
		for(File f : list) {
			if(f.isFile()) {
				System.out.println(f.getName() + " " + f.length() + "bytes");
			}else if (f.isDirectory()) {
				System.out.println(f.getName() + " <DIR>");
			}
		}
		
	}
	
}
