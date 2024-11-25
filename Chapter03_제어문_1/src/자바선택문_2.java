//64page => 계절 처리
// 3, 4, 5 => 봄
// 6, 7, 8 => 여름
// 9, 10, 11 => 가을
// 12, 1, 2 => 겨울
// ==> 난수처리
public class 자바선택문_2 {

	public static void main(String[] args) {
		//1~12 사이의 수를 임의로 추출
		int month = (int)(Math.random()*12) + 1;
		switch(month) {
			case 3 : case 4 : case 5 :
				System.out.println(month + "월은 봄입니다");
				break;
			case 6 : case 7 : case 8 :
				System.out.println(month + "월은 여름입니다");
				break;
			case 9 : case 10 : case 11 :
				System.out.println(month + "월은 가을입니다");
				break;
			case 12 : case 1 : case 2 :
				System.out.println(month + "월은 겨울입니다");
				break;
			//default => 생략이 가능 : 필요시에만 사용
		}
	}
	
}
