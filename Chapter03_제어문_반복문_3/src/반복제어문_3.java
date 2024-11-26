/*  
 *  일차 for, while
 *  => break;
 *  조건문 : 단일 / 선택
 *  ----------------- 필수
 */
public class 반복제어문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1; i <= 3; i++) {
			for(int j = 1; j <= 3; j++) {
				if(j==2)
					continue;
				System.out.println("i=" + i + ",j=" + j);
			}
		}
	}

}
