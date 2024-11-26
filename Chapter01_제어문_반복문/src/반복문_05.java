// 1~100 사이의 3의 배수 합, 5의 배수 합, 7의 배수 합
public class 반복문_05 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a3 = 0, a5 = 0, as7 = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 3 == 0) {
				a3 += i;
			}
			if(i % 5 == 0) {
				a5 += i;
			}
			if(i % 7 == 0) {
				as7 += i;
			}
		}
		System.out.println("1~100 사이의 3의 배수의 합 : " + a3);
		System.out.println("1~100 사이의 5의 배수의 합 : " + a5);
		System.out.println("1~100 사이의 7의 배수의 합 : " + as7);
	}

}
