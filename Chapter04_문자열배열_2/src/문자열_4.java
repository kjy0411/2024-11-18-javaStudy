
public class 문자열_4 {

	public static void main(String[] args) {
		String s1 = "Hello Java";
		String s2 = "Hello Java";
		String s3 = new String("Hello java");
		//equalsIgnoreCase => 대소문자 구분이 없이 비교
		//나머지 String모든 메소드는 대소문자를 구분
		
		if(s1 == s2) { //메모리 주소를 비교
			System.out.println("s1 == s2");
		}else {
			System.out.println("s1 != s2");
		}
		if(s1.equals(s2)) { //저장된 문자열을 비교
			System.out.println("s1 == s2");
		}else {
			System.out.println("s1 != s2");
		}
	}
	
}
