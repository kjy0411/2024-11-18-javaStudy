/*  
 *  ABCD
 *  EFGH
 *  IJKL
 *  
 *  ABCD
 *  ABCD
 *  ABCD
 *  ABCD
 *  
 *  #123
 *  1#23
 *  12#3
 *  123#
 */
public class 반복문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*  ABCD
		 *  EFGH
		 *  IJKL
		 *  MNOP
		 */
		/*
		char c = 'A';
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= 4; j++) {
				System.out.print(c++);
			}
			System.out.println();
		}
		*/
		/*  ABCD
		 *  ABCD
		 *  ABCD
		 *  ABCD
		 */
		/*
		for(int i = 1; i <= 4; i++) {
			char c2 = 'A';
			for(int j = 1; j <= 4; j++) {
				System.out.print(c2++);
			}
			System.out.println();
		}
		*/
		/*  AAAA
		 *  BBBB
		 *  CCCC
		 *  DDDD
		 */
		/*
		char c3 = 'A';
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= 4; j++) {
				System.out.print(c3);
			}
			c3++;
			System.out.println();
		}
		*/
		/*  #123
		 *  1#23
		 *  12#3
		 *  123#
		 */
		/*
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= 4; j++) {
				if(i == j) {
					System.out.print("#");
				}else {
					System.out.print(j);					
				}
			}
			c3++;
			System.out.println();
		}
		*/
		/* 
		 * ★
		 * ★★
		 * ★★★
		 * ★★★★
		 */
		/*
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		*/
		/* 
		 * ★★★★
		 * ★★★
		 * ★★
		 * ★
		 */
		/*
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= 5-i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		*/
		// 주사위 2개를 던져서 6이 나올 경우수를 출력
		/*
		for(int i = 1; i <= 6; i++) {
			for(int j = 1; j <= 6; j++) {
				if(i + j == 6) {
					System.out.printf("[%d,%d]\n", i, j);					
				}
			}
		}
		*/
		/* 
		 *    ★
		 *   ★★
		 *  ★★★
		 * ★★★★
		 */
		/*
		for(int i = 1; i <= 4; i ++) {
			for(int j = 1; j <= 4-i; j++) {
				System.out.print(" ");
			}
			for(int k = 1; k <= i; k++) {
				System.out.print("★");	
			}				
			System.out.println();
		}
		*/
		/*
		 * ★★★★
		 *  ★★★
		 *   ★★
		 *    ★
		 */
		for(int i = 1; i <= 4; i ++) {
			for(int j = 1; j <= i - 1; j++) {
				System.out.print(" ");
			}
			for(int k = 1; k <= 5 - i; k++) {
				System.out.print("★");	
			}				
			System.out.println();
		}
	}
}
