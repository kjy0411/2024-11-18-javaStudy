// 1~10까지 난수 10개 발생 => 평균 출력
public class 반복문_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double avg = 0.0;
		int sum = 0;
		
		int i = 1;
		while(i <= 10) {
			int num = (int)(Math.random()*10) + 1;
			System.out.print(num + " ");
			sum += num;
			i++;
		}
		avg = sum / 10.0;
		System.out.println();
		System.out.println("난수의 총합 : " + sum);
		System.out.println("난수의 평균 : " + avg);
	}

}
