import java.util.Arrays;
import java.util.Scanner;

public class 배열_문제풀이 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//1) 5명의 학생의 국어점수를 받아서 등수를 출력하는 프로그램 작성
		/*
		int[] kor = new int[5];
		for(int i = 0; i < 5; i++) {
			System.out.print(i + 1 + "번째 학생의 국어 점수 입력 : ");
			kor[i] = scan.nextInt();
		}
		System.out.println(Arrays.toString(kor));
		*/
		//2) 10개의 임의의 정수를 받아서 최대값,최소값(난수)  구하는 프로그램 작성
		/*
		//1. 변수선언
		int[] arr = new int[10];
		int max = 0;
		int min = 100;
		//2. 배열 초기화
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*100) + 1;
		}
		//3. 최대값, 최소값 => 결과값 추출
		for(int i : arr) {
			if(i > max) {
				max = i;
			}
			if(i < min) {
				min = i;
			}
			System.out.print(i + " ");
		}
		//4. 출력
		System.out.println();
		System.out.println("max = " + max);
		System.out.println("min = " + min);
		*/
		//3) 100 개의 난수(0~9)를 발생하여 빈도수를 구하는 프로그램을 작성하시오
		/*
		int[] arr = new int[10];
		for(int i = 0; i < 100; i++) {
			int num = (int)(Math.random()*10);
			arr[num]++;
		}
		System.out.println(Arrays.toString(arr));
		*/
		//4) 10개의 난수를 발생하여 배열에 저장한 후에 인덱스가 1인 곳의 값을 출력하시오.
		/*
		int[] arr = new int[10];
		for(int i = 0; i < 10; i++) {
			arr[i] = (int)(Math.random()*100) + 1;
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(arr[1]);
		
		//5) 위 문제 배열 중에서 최대값의 인덱스를 출력하시오. 
		int max = 0;
		for(int num : arr) {
			if(num > max) {
				max = num;
			}
		}
		System.out.println("최대값 : " + max);
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == max) {
				System.out.println("최대값이 저장된 index : " + i);
			}
		}
		*/
		//6) 10개의 난수를 배열 안의 모든 값을 더하고, 총합과 평균을 출력하시오.
		/*
		int[] arr = new int[10];
		int sum = 0;
		double avg = 0.0;
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*100) + 1;
		}
		for(int num : arr) {
			sum+=num;
		}
		avg = sum / (double)arr.length;
		System.out.println("총합 : " + sum);
		System.out.printf("평균 : %.2f\n", avg);
		*/
		//7) 10개의 난수를 배열에 저장 후에 배열의 인덱스가 3인 곳은 출력하지 말고, 나머지만 출력하시오
		/*
		int[] arr = new int[10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*10) + 1;
		}
		System.out.println(Arrays.toString(arr));
		for(int i = 0; i < arr.length; i++) {
			if(i != 3) {
				System.out.print(arr[i] + " ");
			}
		}
		*/
		//8) 5개의 난수를 배열에 저장한 후에 인덱스번호 두개를 받아서 값을 교환하는 프로그램을 작성하시오
		/*
		int[] arr = new int[5];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*10) + 1;
		}
		System.out.println(Arrays.toString(arr));
		System.out.print("0~4 사이의 정수 입력 : ");
		int a = scan.nextInt();
		System.out.print("0~4 사이의 정수 입력 : ");
		int b = scan.nextInt();
		
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
		System.out.println(Arrays.toString(arr));
		*/
		//9) char 배열을 생성하여, 알파벳 A~Z까지 대입 후, 출력하시오
		/*
		char[] arr = new char[26];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (char)('A' + i);
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		//10) 위문제를 역순으로 출력하시오
		for(int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		*/
		//12) 정수 10개를 입력받아 배열에 저장하고, 배열에 있는 정수 중에서 3의 배수만 출력하시오
		/*
		int[] arr = new int[10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*100) + 1;
		}
		System.out.println(Arrays.toString(arr));
		for(int num : arr) {
			if(num % 3 == 0) {
				System.out.print(num + " ");
			}
		}
		*/
		//12) 10개의 정수를 입력받아서 짝수의 최대값,홀수의 최대값을 출력하는 프로그램을 작성하시오
		/*
		int[] arr = new int[10];
		int evenMax = 0, oddMax = 0;
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*100) + 1;
		}
		for(int num : arr) {
			if(num % 2 == 0 && num > evenMax) {
				evenMax = num;
			}else if(num % 2 != 0 && num > oddMax) {
				oddMax = num;
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("짝수의 최대값 : " + evenMax);
		System.out.println("홀수의 최대값 : " + oddMax);
		*/
		//13) 3명의 학생에 대한 국어,영어,수학 점수를 입력받아서 저장후에 총점,평균,등수를 구하고 국어점수 총점,영어점수 총점,수학점수의 총점을 구해서 출력하는 프로그램을 작성하시오
		final int student = 3;
		int[] kor = new int[3];
		int[] eng = new int[3];
		int[] math = new int[3];
		int[] total = new int[3];
		double[] avg = new double[3];
		int[] rank = new int[3];
		int kTotla = 0, eTotla = 0, mTotal = 0;
		
		for(int i = 0; i < student; i++) {
			kor[i] = (int)(Math.random()*101);
			eng[i] = (int)(Math.random()*101);
			math[i] = (int)(Math.random()*101);
			kTotla += kor[i];
			eTotla += eng[i];
			mTotal += math[i];
		}
		for(int i = 0; i < student; i++) {
			total[i] = kor[i] + eng[i] + math[i];
			avg[i] = total[i]/(double)(student);
		}
		for(int i = 0; i < student; i++) {
			rank[i] = 1;
			for(int j = 0; j < i; j++) {
				if(total[i] < total[j]) {
					rank[i]++;
				}
			}
		}
		for(int i = 0; i < student; i++) {
			System.out.println("====== " + i + 1 + "번째 학생 ======");
			System.out.println("국어점수 : " + kor[i]);
			System.out.println("영어점수 : " + eng[i]);
			System.out.println("수학점수 : " + math[i]);
			System.out.println("총점 : " + total[i]);
			System.out.printf("평균 : %.2f\n", avg[i]);
			System.out.println("등수 : " + rank[i]);
		}
		System.out.println("====== 총점 ======");
		System.out.println("국어 점수 총점 : " + kTotla);
		System.out.println("영어 점수 총점 : " + eTotla);
		System.out.println("수학 점수 총점 : " + mTotal);
	}

}
