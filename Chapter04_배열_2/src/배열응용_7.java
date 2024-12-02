/*  
 *  char
 *  버블 정렬
 *  
 *  	char => 문자열은 불가능
 *  		==== compare() / equals()
 *  				> <
 *  	=> 정수형 취급한다
 *  	   연산자를 사용하면 정수로 변경
 *  	   'A' < 'B'
 *  	   => 65 < 66
 *  
 *  	i=0	B	C	A	E	D
 *  		-	-
 *  		C	B
 *  		-		-
 *  		C		A
 *  		-			-
 *  		E			C
 *  		-				-
 *  		E				D
 *  --------------------------------
 *  	i=1	E	B	A	C	D
 *  			-	-
 *  			B	A
 *  			-		-
 *  			C		B
 *  			-			-
 *  			D			C
 *  -------------------------------
 *  	i=2	E	D	A	B	C
 *  				-	-
 *  				B	A
 *  				-		-
 *  				C	A	B
 *  --------------------------------
 *  	i=3	E	D	C	A	B
 *  					-	-
 *  					B	A
 *  --------------------------------
 *  	i=4	E	D	C	B	A	==> length - 1
 *  
 *  
 *  	int a1 ~ a10;
 *  	max
 *  	if(max<a1) => 3개이상 한개의 변수명으로 제어
 *  						---------- 배열
 *  						arr[0] ~ arr[9]
 */

import java.util.Arrays;

public class 배열응용_7 {

	public static void main(String[] args) {
		//선언
		char[] arr = new char[5];
		
		//초기화
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (char)((Math.random()*26) + 65);
			for(int j = 0; j < i; j ++) {
				if(arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}
		System.out.println("정렬 전 : ");
		for(char c : arr) {
			System.out.print(c + " ");
		}
		System.out.println();
		System.out.println("정렬 후 : ");
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] < arr[j]) {
					char temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			System.out.println((i+1) + "Round : " + Arrays.toString(arr));
		}
		for(char c : arr) {
			System.out.print(c + " ");
		}
	}
	
}
