package com.sist.io;
/*  
 *  355page ~ 357page
 *  IO => InputStream / OutputStream
 *  		  입력			출력
 *  
 *  	  = 메모리 입출력
 *  	  = 파일 입출력
 *  	  = 네트워크 입출력
 *  
 *  *** java.io : CheckException => 예외처피 필요
 *  *** File => 파일업로드 / 다운로드
 *  		 => 파일 읽기 / 쓰기
 *  *** 관련 클래스
 *  	1. File
 *  	2. FileInputStream / FileOutputStream
 *  	3. FileReader / FileWriter
 *  	4. BufferedReader / BufferedWriter
 *  	5. BufferedInputStream / BufferOutputStream
 *  	6. ObjectInputStream / ObjectOutputStream
 *  	
 *  	=> InputStream / OutputStream
 *  	   => 1byte 입출력
 *  	   => Byte 스트림 = 일반 파일 읽기(zip, doc...)
 *  	=> Reader / Writer
 *  	   => 2byte 입출력
 *  	   => 문자 스트림 = 한글 포함 파일 읽기
 *  	=> 브라우저 (1byte) = 자바 2byte
 *  	   인코딩				디코딩
 *  	-------------------------------------------
 *  	입력과 출력
 *  	-------- 자바에서 지원하는 IO는 단방향이다
 *  	=> 입력/출력 프로그램을 따로 만든다
 *  	   ------- 동시에 처리 (네트워크) => 프로그램을 동시에 실행(쓰레드)
 *  	=> InputStream / OutputStream => 읽기/쓰기
 *  			=> 1byte씩 읽기/쓰기
 *  			=> 업로드 / 다운로드
 *  	=> Reader / Writer => 읽기/쓰기
 *  			=> 2byte씩 읽기/쓰기
 *  			=> 파일 읽기 / 파일 쓰기
 *  			=> 문자 단위로 저장, 읽기
 *  	
 *  	File
 *  	 => 파일 / 디렉토리(폴더)를 동시에 처리
 *  	 => 생성 방법
 *  		File file = new File("경로명\\파일명") => 파일 정보
 *  		File dir = new File("경로명\\폴더") => 디렉토리 정보
 *  	 => 주요 메소드
 *  		--------
 *  	***	1. 파일명 : String getName()
 *  		2. 경로명 : String getParent()
 *  	***	3. 파일명 + 경로명 : String getPath()
 *  	***	4. 파일크기 : long length()
 *  		5. 숨김파일 : boolean isHidden()
 *  		6. 읽기/쓰기 가능여부 : boolean canRead() / boolean canWrith()
 *  		7. 최종 수정날짜 : long lastModiyfied()
 *  	***	8. 폴더안에 있는 모든 파일/폴더 리스트 : String[] listFiles
 *  		9. 파일/디렉토리 확인 : boolean isFile / boolean isDirectory
 *  		
 *  		File 제어
 *  	***	1. 폴더 생성 : mkdir()
 *  	***	2. 파일 생성 : createNewFile()
 *  	***	3. 파일 삭제 : delete()
 *  	***	4. 파일 존재 여부 : exisits
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 *  
 */
//파일 정보 확인
import java.io.*;
import java.util.*;
import java.text.*;
public class IO_1 {

	public static void main(String[] args) {
		// => 파일 생성
		File file = new File("c:\\javaDev\\movie.txt");
		System.out.println("파일명 : " + file.getName());
		System.out.println("경로명 : " + file.getParent());
		System.out.println("경로+파일명 : " + file.getPath());
		System.out.println("파일크기 : " + file.length() + "Bytes");
		// => byte단위 => KB  file.length()/1024	
		System.out.println("읽기 전용 : " + file.canRead());
		System.out.println("쓰기 전용 : " + file.canWrite());
		System.out.println("숨김파일 : " + file.isHidden());
		System.out.println("파일여부 : " + file.isFile());
		System.out.println("최종 수정일 : " + new SimpleDateFormat("yyyy-MM-dd").format(new Date(file.lastModified())));
		
	}
	
}
