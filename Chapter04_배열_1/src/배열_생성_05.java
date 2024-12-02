/*  
 *  정수 => 0~9 사이의 난수 발생 => 30회의 빈도수 구한다
 */
public class 배열_생성_05 {

	public static void main(String[] args) {
		final int roof = 30;
		int[] arr = new int[10];
		//아이디마다 => 장바구니에 추가한 갯수
		for(int i = 0; i < roof; i++) {
			int num = (int)(Math.random()*10);
			//System.out.print(num + " ");
			arr[num]++;
		}
		System.out.println();
		for(int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "] = " + arr[i]);
		}
	}
	
}
                                                                                               