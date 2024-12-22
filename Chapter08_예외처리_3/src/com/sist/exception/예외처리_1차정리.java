package com.sist.exception;
/*
 *    예외처리가 필요한 클래스 
 *    -------------------
 *    => 라이브러리에서 제공 
 *       -------- 입출력 / 네트워크 / 오라클 / URL / 쓰레드 
 *                -----------------------------------
 *                | CheckException 
 *                  => 컴파일시 확인 (예외처리 설정)
 *    => 예외처리 방법 
 *       1. 직접처리 (예외복구)
 *          try~catch~finally
 *          
 *          try
 *          {
 *             정상 수행문장 => 일부러 에러가 있는 문장을 사용하는 것이 아니다
 *               => 에러발생 (개발자 실수,사용자 입력문제)
 *                                   -------------
 *                          개발자 실수가 거의 없는 것은 자동완성기 
 *                          => 이클립스 => 바로 에러 출력 
 *          }catch(예외클래스)
 *          {
 *               1. 에러내용 출력 (어디서 에러 발생되었는지 확인)
 *                  getMessage() : 에러 내용만 출력 
 *                  printStackTrace(): 실행과정 => 에러의 위치 확인 
 *               2. 예외 복구 => 다시 입력을 유도하는 경우 
 *                          => 웹/윈도우에서만 가능 
 *                          => 데이터 수집 (Jsoup(정적),셀레니움(동적))
 *               3. 에러 확인 => 소스코딩 수정 (******)
 *          }
 *          *** catch절은 필요시에 여러개 사용이 가능 
 *          finally
 *          {
 *              생략이 가능 
 *              => 닫기 (파일,서버,오라클)
 *              => try / catch 상관없이 무조건 수행 
 *          }
 *          *** catch => 통합해서 한번에 처리 
 *              Exception / Throwable 
 *              
 *          ***=> try => finally수행 
 *             : 에러가 없는 경우 
 *          => try => catch => finally 수행
 *             : try수행 과정에서 에러가 발생 => catch에 수행 
 *               => finally 수행  
 *          => 사전에 에러 처리 
 *          => 에러시에 문제점 
 *             ------------
 *             | 에러위치부터 try끝까지 => 스킵
 *             
 *          try
 *          {
 *             1
 *             2
 *             3
 *             --------------
 *             4 => 에러
 *             5
 *             6
 *             7
 *             8
 *             9
 *             10
 *             -------------- 스킵
 *          }catch()
 *          {
 *          }
 *          => 정상 종료
 *          => try~catch 사용 
 *             => 메소드 전체 사용 
 *             => 예외 발생 예상되는 위치만 사용 (부분적으로 사용)
 *                => for 
 *          
 *          // => 요청처리 => 결과값 브라우저로 전송 
 *          try
 *          {
 *             for(int i=1;i<=10;i++)
 *             {
 *                 int a=(int)(Math.random()*3);
 *                     -- 0,1,2
 *                 i=1 a=1
 *                 i=2 a=0
 *                 System.out.println(i/a); => for문 종료 
 *                                 => catch이동 
 *             }
 *          }catch(Exception e){}
 *          
 *          for(int i=1;i<=10;i++)
 *             {
 *                try
 *                {
 *                 int a=(int)(Math.random()*3);
 *                     -- 0,1,2
 *                 i=1 a=1
 *                 i=2 a=0
 *                 System.out.println(i/a); => for문 종료 
 *                                 => catch이동 
 *                 }catch(Exception e){}
 *             }
 *             
 *             // 크롤링 
 *             // HTML => 모든 HTML이 형식이 동일하지 않기 때문에 
 *          => 중요 
 *          => 오라클은 commit => 저장
 *          => 트랜젝션 => 일괄처리(******)
 *          try
 *          {
 *             1.오라클 연결 
 *             2.AutoCommit : 해제
 *             ..
 *             ..
 *             7. commit;
 *          }catch(Exception e)
 *          {
 *            try
 *            {
 *               rollback()
 *            }catch(Exception)
 *          }
 *          finally
 *          {
 *             try
 *             {
 *               close()
 *             }catch(Exception){}
 *          }
 *          
 *          => 공통모듈 
 *          
 *       2. 간접처리 (예외회피) => 선언만 한다
 *          메소드뒤에 throws  
 *          => 직접처리하는 부분이 아니고 이런 에러가 예상이 된다 
 *             (컴파일러에게 알려준다)
 *             => 컴파일러가 예외처리가부를 확인하지 않는다 
 *          => 복구할 수 없다 / 정상종료 불가능/ 시스템 자체 처리 
 *          => 라이브러리 메소드 => 반드시 예외처리후 사용해야 된다 
 *             ----------------------------- try~catch
 *          => 선언방식
 *             method() throws 예외클래스,예외클래스,예외클래스...
 *                             ----------------------------
 *                             구분 ,  순서는 상관없다 
 *             => 처리시에는 통합 
 *                        ---- Exception / Throwable
 *                        ---- catch절 , throws => 통합 
 *          => 임의로 발생 : throw => 사용자 정의 예외처리 
 *          => 모든 => class , method, 예외처리 , 데이터형  
 *                    -------------------------------
 *                    => 완벽하게 지원하지 않는다 
 *                       ------------------- 사용자 정의
 *          -----------------------------------------------
 *          
 *           
 */
public class 예외처리_1차정리 {
    public void display() throws Exception
    {
    	System.out.println(10/0);
    }
	public static void main(String[] args){
		// TODO Auto-generated method stub
        예외처리_1차정리 a=new 예외처리_1차정리();
        try
        {
          a.display();
        }catch(Exception e) {}
        System.out.println("종료");
	}

}