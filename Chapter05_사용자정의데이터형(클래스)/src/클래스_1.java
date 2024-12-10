/*  
 *  ** 프로그램은 데이터 관리
 *  		   ---------
 *  			상태 관리 : Vue, React (Front)
 *  데이터 저장하는 방법
 *  ---------------
 *  변수 : 데이터 한개 저장	=> 데이터를 변경할 수 있다
 *  		읽기(메모리에서 데이터를 가지고 온다)
 *  		쓰기(메모리 저장)
 *  		수정(값 수정)
 *  		=> 데이터형 변수명 = 값;
 *  상수 : 데이터 한개 저장	=> 데이터를 변경할 수 없다
 *  		읽기(메모리에서 데이터를 가지고 온다)
 *  		쓰기(메모리 저장)
 *  		=> final 데이터형 변수명 = 값;
 *  --------------- 변수와 상수가 많은 경우에는 제어
 *  배열 : 변수 여러개를 한개의 이름으로 제어 (관리가 쉽다)
 *  	  => 고정적
 *  	  => 같은 데이터형만 모아서 관리
 *  클래스 => 여러개의 데이터를 저장할 수 있다
 *  		=> 고정적이 아니다 (원하는 갯수만큼 저장이 가능)
 *  	=>
 *  		 1) 데이터를 모아준다 => 한개의 대한 정보
 *  			사람 => 사람1명에 대한 변수
 *  			학생 => 학생 1명에 대한 정보 저장
 *  			영화 => 영화정보 1개만 설계
 *  			----------------------------
 *  			저장하는 공간을 따로 생성
 *  		=> 데이터형 클래스
 *  		=> 액션 ==> 변수 / 메소드
 *  --------------- 메모리에 저장
 *  파일
 *  데이터베이스
 *  --------------- 영구적인 저장
 */
class Student{
	int hakbun;
	String name;
	int age;
}
public class 클래스_1 {
	
	public static void main(String[] args) {
		Student hong = new Student();
		hong.hakbun = 1;
		hong.name = "홍길동";
		hong.age = 23;
		System.out.println(hong);
		/*  
		 *  hong => Student@4aa8f0b4
		 *  ----------
		 *  	 1 	==> hakbun
		 *  ----------
		 *     홍길동	==> name
		 *  ----------
		 *  	23	==> age
		 *  ----------
		 */
		System.out.println("학번 :" + hong.hakbun);
		System.out.println("이름 :" + hong.name);
		System.out.println("나이 :" + hong.age);
		Student shim = new Student();
		shim.hakbun = 2;
		shim.name = "심청이";
		shim.age = 18;
		System.out.println("학번 :" + shim.hakbun);
		System.out.println("이름 :" + shim.name);
		System.out.println("나이 :" + shim.age);
	}
	
}
