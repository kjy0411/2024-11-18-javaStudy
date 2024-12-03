import java.util.*;
import com.sist.data.*;

public class 문자열배열_3 {
	/*  
	 *  클래스 => 한개에 대한 정보
	 *  class Music{
	 *  	String titie, singer, album, state;
	 *  	int modify;
	 *  }
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] title = ArrayData.title;
		String[] singer = ArrayData.singer;
		String[] album = ArrayData.album;
		String[] state = ArrayData.state;
		int[] modify = ArrayData.modify;
		// 이차원 배열 => String[][] music=new String[50][5];
		// 클래스 => Musin[] music = new Music[50]; // 사용자 정의 데이터형
		
		// 뮤직 목록 출력
		System.out.println("Music Top50");
		for(int i = 0; i < 50; i++) {
			String s = state[i];
			String m = "";
			if(s.equals("유지")) {
				m = " - ";
			}else if(s.equals("상승")) {
				m = "▲ " + modify[i];
			}else if(s.equals("하강")) {
				m = "▼ " + modify[i];
			}
			System.out.println((i + 1) + "." + m + " " + title[i] + " " + singer[i] + " " + album[i]);
		}
		/*
		String[][] music = new String[50][5];
		for(int i = 0; i < 50; i++) {
			music[i][0] = title[i];
			music[i][1] = singer[i];
			music[i][2] = album[i];
			music[i][3] = state[i];
			music[i][4] = String.valueOf(modify[i]);
		}
		for(String[] m : music) {
			for(String d : m) {
				System.out.print(d + " | ");
			}
			System.out.println();
			System.out.println(Arrays.toString(m));			
		}
		*/
		System.out.println("=========================================================");
		/*
		//검색
		System.out.print("카테고리 선택(곡명(1), 가수명(2)) : ");
		int menu = scan.nextInt();
		int count = 0;
		
		if(menu == 1) { // 제목 검색
			System.out.print("제목 입력 : ");
			String name = scan.next();
			System.out.println("==========================");
			for(int i =0; i < title.length; i++) {
				if(title[i].contains(name)) {
					System.out.println("노래명 : " + title[i]);
					System.out.println("가수명 : " + singer[i]);
					System.out.println("앨범 : " + album[i]);
					System.out.println("등폭 : " + (state[i].equals("유지") ? "유지" : state[i] + " " + modify[i]));
					System.out.println("==========================");
					count++;
				}
			}
			System.out.println("총 " + count + "건 검색");
		}else if(menu == 2) { // 가수명 검색
			System.out.print("가수 입력 : ");
			String name = scan.next();
			System.out.println("==========================");
			for(int i = 0; i < singer.length; i++) {
				if(singer[i].contains(name)) {
					System.out.println("노래명 : " + title[i]);
					System.out.println("가수명 : " + singer[i]);
					System.out.println("앨범 : " + album[i]);
					System.out.println("등폭 : " + (state[i].equals("유지") ? "유지" : state[i] + " " + modify[i]));
					System.out.println("==========================");
					count++;
				}
			}
			System.out.println("총 " + count + "건 검색");
		}
		*/
		// 등폭(상승,하강)이 가장 많은 노래명, 가수명 출력
		/*
		int max = 0;
		int index = 0;
		for(int i = 0; i < 50; i++) {
			if(max < modify[i]) {
				max = modify[i];
				index = i;
			}
		}
		System.out.println("등폭이 가장 많은 노래 : ");
		System.out.println("노래명 : " + title[index]);
		System.out.println("가수명 : " + singer[index]);
		System.out.println("앨범 : " + album[index]);
		System.out.println("등폭 : " + (state[index].equals("유지") ? "유지" : state[index] + " " + modify[index]));
		*/
		
		//modify => max를 구한다
		/*
		int max = 0;
		for(int i = 0; i < 50; i++) {
			if(max < modify[i]) {
				max = modify[i];
			}
		}
		System.out.println("max = " + max);
		//max값에 해당하는 count구한다
		int count = 0;
		for(int i = 0; i < 50; i++) {
			if(max == modify[i]) {
				count++;
			}
		}
		System.out.println("배열 갯수 : " + count);
		//동적 배열 생성
		int[] arr = new int[count];
		int j = 0;
		for(int i = 0; i < 50; i++) {
			if(max == modify[i]) {
				arr[j] = i;
				j++;
			}
		}
		
		//데이터 출력
		for(int i : arr) {
			System.out.println(title[i] + singer[i]);
		}
		*/
		
		//modify => min를 구한다
		int min = 100;
		for(int i = 0; i < 50; i++) {
			if(min > modify[i] && modify[i] != 0) {
				min = modify[i];
			}
		}
		System.out.println("min = " + min);
		//max값에 해당하는 count구한다
		int count = 0;
		for(int i = 0; i < 50; i++) {
			if(min == modify[i]) {
				count++;
			}
		}
		System.out.println("배열 갯수 : " + count);
		//동적 배열 생성
		int[] arr = new int[count];
		int j = 0;
		for(int i = 0; i < 50; i++) {
			if(min == modify[i]) {
				arr[j] = i;
				j++;
			}
		}
		
		//데이터 출력
		for(int i : arr) {
			System.out.println(title[i] + singer[i]);
		}
		
	}
	
}
