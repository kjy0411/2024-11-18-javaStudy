/*  
 *  자바에서 지원하는 제어문
 *  = 조건문 : 요청에 맞는 문장만 실행 => 건너뛰는 경우
 *  		=> 오류 방지
 *  		   ======= if으로 처리가 어려운 과정 : 예외처리(8장)
 *  		=> 사전에 방지 => if => 이런 경우
 *  
 *  	단일 조건문
 *  		형식) | 연산자 => 부정연산자(!), 비교연산자, 논리연산자만 사용이 가능
 *  		if(조건문 => true/false)
 *  		{
 *  			조건문이 true일 경우에만 처리하는 문장
 *  		}
 *  		false => 건너뛴다
 *  		=> 독립적으로 실행 => if문을 여러개 사용하는 속도가 저하
 *  		int a = 1
 *  		if문장마다 다른 문장으로 되어 있다 => 모든 if의 조건을 검색
 *  		if(a == 1) => 종료
 *  		if(a == 2)
 *  		if(a == 3)
 *  		if(a == 4)
 *  		if(a == 5)
 *  
 *  		=> 사용처 : 아이디 중복체크, 검색, 상세보기, 예약내용
 *  
 *  		55page
 *  		중첩 if문
 *  		if() ==> 아이디가 같고
 *  		{
 * 				if() ==> 비밀번호가 같다면
 * 				{
 * 				} 
 *  		}
 *  		==> if( 아이디가 같고 && 비밀번호가 같다면)
 *  
 *  	선택 조건문 : 나눠서 처리
 *  		true => 처리
 *  		false => 처리 
 *  		if(조건)
 *  		{
 *  			조건이 true일때
 *  		}
 *  		else
 *  		{
 *  			조건이 false일때
 *  		}
 *  
 *  		=> 두개가 나눠지는 경우
 *  		   1. 로그인 => 로그인 (main화면 이동)
 *  					  로그인이 안된 경우 (back, 회원가입)
 *  		
 *  	다중 조건문
 *  = 선택문 => 게임 => 네트워크
 *  = 반복문
 *    do~while : 무조건 1번이상 수행
 *    while : 반복횟수가 없는 경우 => 데이터베이스 / 파일 읽기
 *    for : 횟수 지정 => 코딩테스트 / 정보처리실기
 *  = 반복제어문
 *    break : 반복을 종료
 *    continue : 특정부분을 제외하고 다시 반복
 *    
 *    1. 중첩 조건문
 *    	 컴퓨터와 사용자의 가위, 바위, 보 게임
 *    				  ============ 가정
 *    				  가위(0), 바위(1), 보(2)
 *    
 *    	경우의 수 => if
 *    	컴퓨터 가위
 *    		= 사용자 가위
 *    		= 사용자 바위
 *    		= 사용자 보
 *    	컴퓨터 바위
 *    		= 사용자 가위
 *    		= 사용자 바위
 *    		= 사용자 보
 *    	컴퓨터 보
 *    		= 사용자 가위
 *    		= 사용자 바위
 *    		= 사용자 보
 *  
 */
//사용자 입력을 받는다
import java.util.Scanner; // 이미 만들어져 있는 클래스를 읽어오는 경로
// => 이미 만들어진 크래스 : 라이브러리
// 클래스를 가지고 올 때 import
public class 제어문_조건문1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		// System.in : 키보드 입력값 => c언어 : scanf()
		System.out.print("가위(0), 바위(1), 보(2) : ");
		int player = scan.nextInt();
		//
		int com = (int)(Math.random()*3);	//0, 1, 2
		System.out.print("Com : ");
		if(com == 0) {
			System.out.println("가위");
		}
		if(com == 1) {
			System.out.println("바위");
		}
		if(com == 2) {
			System.out.println("보");
		}

		System.out.print("Player : ");
		if(player == 0) {
			System.out.println("가위");
		}
		if(player == 1) {
			System.out.println("바위");
		}
		if(player == 2) {
			System.out.println("보");
		}
		System.out.println("====== 결과 ======");
		/*  if(com == 0 && player == 0)
		/*  if(com == 0 && player == 1)
		/*  if(com == 0 && player == 2)
		 */
		//if(com == 0) { //컴퓨터가 가위를 낸 경우
			if(com == 0 && player == 0) { //가위
				System.out.println("비겼다");
			}
			if(com == 0 && player == 1) { //바위
				System.out.println("Player Win!!");
			}
			if(com == 0 && player == 2) { //보
				System.out.println("컴퓨터 Win!!");
			}
		//}
		//if(com == 1) {
			if(com == 1 && player == 0) {
				System.out.println("컴퓨터 Win!!");
			}
			if(com == 1 && player == 1) {
				System.out.println("비겼다");
			}
			if(com == 1 && player == 2) {
				System.out.println("Player Win!!");
			}
		//}
		//if(com == 2) {
			if(com == 2 && player == 0) {
				System.out.println("Player Win!!");
			}
			if(com == 2 && player == 1) {
				System.out.println("컴퓨터 Win!!");
			}
			if(com == 2 && player == 2) {
				System.out.println("비겼다");
			}
		//}
	}
}
