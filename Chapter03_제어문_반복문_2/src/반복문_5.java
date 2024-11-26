import java.io.*;

public class 반복문_5 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		// 70page
		FileReader fr = new FileReader("C:\\javaDev\\javaStudy\\Chapter03_제어문_반복문_2\\src\\반복문_4.java");
		int i = 0; // => 한글자씩 => 문자(X) => 정수로 읽는다
		//횟수를 모르는 경우
		while((i=fr.read())!=-1) {
			System.out.println((char)i);
		}
	}

}
