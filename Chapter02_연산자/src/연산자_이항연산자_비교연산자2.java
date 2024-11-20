/*  
 */
public class 연산자_이항연산자_비교연산자2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char a = (char)((Math.random() * 26) + 65);
		//					0 ~ 25 + 65 => 65 ~ 90 > 'A' ~ 'Z'	
		char b = (char)((Math.random() * 26) + 65);
		System.out.println(a);
		System.out.println(b);
		
		// ==
		System.out.println(a == b);
		// !=
		System.out.println(a != b);
		// <
		System.out.println(a < b);
		// >
		System.out.println(a > b);
		// <=
		System.out.println(a <= b);
		// >=
		System.out.println(a >= b);
		/*
		int[] intArr = new int[26];
		for(int i = 0; i < 1000000000; i++) {
			int c = (int)(Math.random() * 26);
			intArr[c] = ++intArr[c];
		}
		for(int j = 0; j < 26; j++) {
			System.out.println((char)(j + 65) + " : " + intArr[j] + "     " + (38461538 - intArr[j]) * -1);			
		}*/
	}

}
