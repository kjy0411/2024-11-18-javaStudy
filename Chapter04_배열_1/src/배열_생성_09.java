// 1~10까지 난수 => 배열[10] => 중복 없이 저장

import java.util.Arrays;

public class 배열_생성_09 {

	public static void main(String[] args) {
		//저장 공간
		int[] arr = new int[10];
		// => Set
		//초기화 => 중복
		for(int i = 0; i < arr.length; i++) {
			//난수 발생
			arr[i] = (int)(Math.random()*10) + 1;
			for(int j = 0; j < i; j++) {
				if(arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
