import java.util.Arrays;

public class 배열_생성_08 {

	public static void main(String[] args) {
		int[] arr = {100,200,300,400,500};
		System.out.println("===== 일반 for문 : index번호 ====");
		for(int i = 0; i< arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		int a=1,b=2,c=3,d=4,e=5,f=6,u=7,k=8,p=9;
		System.out.println();
		System.out.println("========== for-each문 ==========");
		for(int i:arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("====== Arrays.toString() ======");
		System.out.println(Arrays.toString(arr));
		System.out.println("====== 일반 for문 ======");
	}

}
