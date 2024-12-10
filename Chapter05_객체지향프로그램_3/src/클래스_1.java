/*  
 *  구성요소
 *    => 멤버변수
 *    	 | 공통으로 사용하는 변수여부(static)
 *    	 | 정보 전체 / 데이터 관리 => 오라클(static)
 *    							 | 공유된 데이터
 *    => 생성자 / 초기화 블록
 *    	 ---- 생략이 가능 / 오라클 연동 (드라이버 등록)
 *    		  윈도우의 레이아웃
 *    		  웹 => 자동 로그인
 *    		  static 블럭 : Mybatis연동
 *    => 활용 => 메소드 ***
 *    			| 다른 클래스 연동 (메세지)
 *    			| 기능처리 => 재사용
 *    	웹(SJP/Spring)
 *    	=> 1. 변수, 2. 메소드, 3. 생성자, 4. 인터페이스, 5. 
 *    		=> 인스턴스
 *    		=> 공통으로 사용되는 부분
 *    		   Header / Footer
 *    -----------------------------------------------------------------
 *    1. 메소드 형식
 *    	 [접근지정어][제어어] 리턴형 메소드명(매개변수) ...=> 선언부
 *    	 => 다른 클래스와 연결 => 공개 (public)
 *    - 접근지정어
 *    	 public : 모든 클래스 사용이 가능
 *    	 protected : 같은 폴더(패키지) / 상속받은 폴더
 *    	 private : 자신의 클래스 영역에서만 사용이 가능
 *    	 default : 같은 폴더에서만 접근가능 
 *    - 제어어
 *    	 static : 공통으로 적용되는 메소드
 *    	 final : 종단 메소드 => 확장, 변경이 불가능
 *    	 abstract : 선언만 할 때
 *    	 -------- 프로그램에 맞게 구현해서 사용
 *    			  => 버튼 => click();
 *    			  => 추상클래스 / 인터페이스
 *    						   -------
 *    - 리턴형
 *    	 반드시 한개값만 설정
 *    	 - 없는 경우에는 void
 *    	 - 기본형 / 배열 / 클래스
 *    - 메소드명
 *    	 변수 => 식별자
 *    	 => 가급적이면 소문자로 시작
 *    	 => 약간의 의미만 부여
 *    	 => 두개의 단어를 이용
 *    		파일 이름을 가지고 온다
 *    				 --------
 *    		getFileName() => 헝거리식 표기법
 *    		get_file_name()
 *    		_temn() => 임시메소드 (메소드용)
 *    - 매개변수
 *    	 0이상 => 여러개 사용이 가능
 *    	 사용자로부터 요청값을 받는다
 *    	 예) 영화검색
 *    		String[] find(String findData)
 *    		boolean isLogin(String id, String pwd)
 *    	*** 매개변수는 3개이상이면 클래스나 배열로 전송
 *    
 *    
 *    리턴형 메소드명(매개변수...) => 선언부
 *    {
 *    	구현부
 *    	return 값; => void일때는 생략이 가능
 *    				  | 컴파일러가 자동으로 추가
 *    				  | return은 반드시 필요하다
 *    				  | return 메소드 종료점
 *    				  | 중간에서 return을 사용할 수 있다
 *    }
 *    리턴형
 *    return 값 => 데이터형 동일(권장)
 *    		   => 리턴형이 큰 데이터형을 사용
 *    
 *    2. 메소드 호출
 *    	 인스턴스 메소드 => 객체명.메소드명(값...)
 *    	 static 메소드 => 클래스명.메소드명(값...)
 *    
 *    	 예)
 *    		class A
 *    		{
 *    			void display(){}
 *    			static void print(){}
 *    		}
 *    
 *    		=> print() => 저장이 완료
 *    		   A.print()
 *    		=> A a = new A();
 *    		   a.display();
 *    		   => 약식
 *    		   new A().display()
 *    	----------------------------
 *    	Date date = new Date();
 *    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 *    	String today = sdf.format(date)
 *    
 *    	String today = new SimpleDateFormat("yyyy-MM-dd).format(new Date());
 *    3. 메소드 종류
 */
import java.util.Date;

public class 클래스_1 {
	int a = 10;
	
	public static void main(String[] args) {
//		Date date = new Date();
//		System.out.println(date);
//		클래스_1 aa = new 클래스_1();
//		System.out.println(new 클래스_1().a);
	}
	
}
