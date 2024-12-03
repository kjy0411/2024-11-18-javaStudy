import com.sist.data.*;	// 사용자 정의
import java.util.Scanner;

public class 문자열배열_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//데이터 읽기
		String[] fdata = ArrayData.korEng;
		//데이터 확인 / 출력
		System.out.print("과일명을 입력 : ");
		String f = scan.next();
		for(String ff : fdata) {
			//감자:potato => 클래스
			if(ff.contains(f)) {
				String kor = ff.substring(0, ff.indexOf(":"));
				String change = ff.substring(ff.indexOf(":") + 1);
				System.out.println(kor + "는(은) 영어는 " + change);				
			}
		}
	}
	
}
