/*  
 *  선택문 : 다중 조건문을 단순화 시킨 제어문
 *  	   => 한개만 수행이 가능
 *  	   => 게임 / 네트워크
 *  	   => ------------ 값을 한개만 선택(선택문), 범위(다중조건문)
 *  	   => 웹에도 사용 빈도가 거의 없다
 *  		  if / if~else / for / while / break
 *  		  ==================================
 *  1. 형식 ) switch(정수 | 문자 | 문자열)
 *  							----
 *  		 1) 정수 => 메뉴
 *  		 switch(no){
 *  			case 0 :
 *  				처리문장 1;
 *  				break; => 종료
 *  			case 1 :
 *  				처리문장 2;
 *  				break;
 *  			case 2 :
 *  				처리문장 3;
 *  				break;
 *  			default : ==> else 해당 번호가 없는 경우에 처리
 *  				처리문장 4;
 *  		 }
 */
// 다중조건문 동일 => 한개의 case에 있는 문장만 수행
public class 자바선택문_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = (int)(Math.random()*101);
		int avg = score / 10;
		/*  
		 * 	주의점
		 *   1) case는 동일하면 안된다
		 *   2) 정렬할 필요는 없다
		 */
		switch(avg) {
			case 10 : case 9 : //같은 출력이 있는 경우에는
				System.out.println(score + "점은 A등급입니다");
				break;
			case 8 :
				System.out.println(score + "점은 B등급입니다");
				break;
			case 7 :
				System.out.println(score + "점은 C등급입니다");
				break;
			case 6 :
				System.out.println(score + "점은 D등급입니다");
				break;
			default :// 생략이 가능
				System.out.println(score + "점은 F등급입니다");
		}
	}

}
