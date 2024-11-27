/*  
 *  문자 자르기
 *  
 *  substring : 문자열을 자르기
 *  | 지정된 위치부터 마지막까지 자르기
 *  	Hello Java
 *  	0123456789
 *  	substring(6) => Java
 *  | 중간에서 자르기
 *  	substring(1,4) => ell
 *  				-- endIndex => 마지막은 제외
 *  ---------------------------------------- JavaScript 동일
 */
public class 문자열_6 {

	public static void main(String[] args) {
		/*
		String data = "Hello.Hello.java";
		//			   0123456789123456
		System.out.println(data.substring(data.lastIndexOf(".") + 1));
		*/
		//원본은 그대로 유지
		String data = "ID:admin,PWD:1234";
		String id = data.substring(data.indexOf(":")+1, data.indexOf(","));
		String pwd = data.substring(data.lastIndexOf(":")+1);
		System.out.println("ID = " + id);
		System.out.println("PWD = " + pwd);
		System.out.println("data = " + data);
		String address = "서울 동대문구 회기동 346-14[새주소] 서울 동대문구 경희대로4길 76";
		String addr1 = address.substring(0, address.indexOf("["));
		String addr2 = address.substring(address.indexOf("]") + 1);
		System.out.println("구주소 : " + addr1);
		System.out.println("신주소 : " + addr2.trim());
		// trim()=>좌우의 공백을 제거
		System.out.println(address);
		
		String s = "Hello Java";
		String ss = s.substring(s.indexOf(" ") + 1);
		System.out.println(s);
		System.out.println(ss);
	}

}
