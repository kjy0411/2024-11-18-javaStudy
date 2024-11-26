/*  
 *  break ==> 사용하는 위치 반복문, 선택문에서만 사용이 가능
 *  		  조건문에서는 사용이 불가능
 *  		  ---- 단일 사용 불가
 *  		  반복문이 선택문을 종료할 때 사용하는 제어문
 *  continue : 반복문에서만 사용 가능
 *  		   조건문 / 선택문에서 사용 불가능
 *  		   >> 특정 부분을 제외할 때 사용
 *  		   >> for문에서는 증감식으로 이동
 *  		   >> while문에서는 조건식으로 이동
 *  
 */
public class 반복제어문_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1; i <= 10; i++) {
			if(i == 5 || i == 7) {
				//break;
				continue; // i++이동 => 6부터 출력
			}
			System.out.print(i + " ");
		}
	}

}
