//10개의 정수를 임의로 추출(1~100) => max, min
// => max,min의 위치

import java.util.Arrays;

public class 배열_3 {

	public static void main(String[] args) {
		/*
		int[] arr = new int[10];
		int max = 0, min = 100, maxIndex = 0, minIndex = 0;
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*100) + 1;
			if(max < arr[i]) {
				max = arr[i];
				maxIndex = i;
			}
			if(min > arr[i]) {
				min = arr[i];
				minIndex = i;
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		System.out.println("최대값의 인덱스 : " + maxIndex);
		System.out.println("최소값의 인덱스 : " + minIndex);
		*/
		
		int[] arr = new int[10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*100) + 1;
		}
		System.out.println(Arrays.toString(arr));
		int max = arr[0], min = arr[0];
		for(int i : arr) {
			if(max < i) {
				max = i;
			}
			if(min > i) {
				min = i;
			}			
		}
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		
		//최대값 / 최소값의 인덱스는 몇번인지 확인
		int maxIndex = 0;
		int minIndex = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == max) {
				maxIndex = i;
			}
			if(arr[i] == min) {
				minIndex = i;
			}
		}
		System.out.println("최대값의 인덱스 : " + maxIndex);
		System.out.println("최소값의 인덱스 : " + minIndex);
		
	}
	
}
