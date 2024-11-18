/*		
 * 		1. 자바 설치
 * 			path : c:\jdk-17.0.2\bin ==> java/javac
 * 			classpath : 자바에서 지원하는 라이브러리를 사용
 * 						.;c:\jdk-17.0.2\lib
 * 						.== 현재 폴더
 * 		2. 이클립스
 * 			1) file => new => JavaProject
 * 			2) src안에 자바파일 생성
 * 			
 * 			변수 / 연산자 / 제어문 / 배열
 * 			public class ClassName{
 * 				프로그램의 시작
 * 				public static void main(String[] args){
 * 					// 시작 => 코딩
 * 				}
 * 			}
 * 		3. GIT
 * 			=> team ==> shareProject
 * 			=> team ==> commit
 * 
 * 		자바 실행
 * 		=======
 * 		컴파일
 * 		 => 파일 => 기계언어로 변경 (컴퓨터가 인식하는 언어)
 * 			Java / C# / C / C++
 * 		인터프리터 : 한줄씩 읽어서 출력
 * 			HTML / JAVA ...
 * 
 * 		A.java ======= A.class ======= 화면에 출력
 * 				javac			java
 * 							|
 * 						01010001001
 * 		public class MainClass
 * 		{
 * 		}
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Java!");
	}
	/*
	 * 1. 해당 class 파일을 C:\javaDev 에 붙여넣어 MainClass.java 생성
	 * 2. cmd 창에 cd c:\javaDev를 입력
	 * 3. javac MainClass.java를 입력해 MainClass.class 생성
	 * 4. java MainClass를 입력해 MainClass.class 실행
	 * 5. Hello Java! 출력 확인
	 */
}
