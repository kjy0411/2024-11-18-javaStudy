/*  
 *  문자열
 *   = 비교 (로그인, 아이디 중복) => equals
 *   = 검색 => contains
 *   = 검색어 출력 => startsWith
 *   = 검색어를 자르는 경우
 *     --------------- substring()
 *   = 검색시 => 사용자가 실수 => space => trim()
 *   
 */
import java.util.*;
public class 문자열_3 {

	public static void main(String[] args) {
		String id = "admin";
		//문자열 자체가 String
		if(id.equals(" admin".trim())) {
			System.out.println("아이디가 있다");
		}else {
			System.out.println("아이디가 없다");
		}
	}
	
}
