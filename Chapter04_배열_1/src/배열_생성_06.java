//국어점수 입력 => 5 rank => 5
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class 배열_생성_06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] kor = new int[5];
		int[] rank = new int[5];
		
		// => index로 정보를 매칭
		for(int i = 0; i < kor.length; i++) {
			kor[i] = (int)(Math.random()*101);
		}
		System.out.println(Arrays.toString(kor));
		
		// 등수
		for(int i = 0; i < kor.length; i++) {
			rank[i] = 1;
			for(int j = 0; j < kor.length; j++) {
				if(kor[i] < kor[j]) {
					rank[i]++;
				}
			}
		}
		System.out.println(Arrays.toString(rank));
	}

}
