// 10개의 할파벳을 추출 => 대문자 몇개 소문자 몇개
public class 반복문_09 {
	
	public static void main(String[] args) {
		int dsct = 0, scnt = 0;

		for(int i = 1; i <= 10; i++) {
			char c = 'A';
			int no = (int)(Math.random()*2);
		
			if(no == 0) {
				c = (char)((Math.random()*26)+ 65); //대문자 추출
			}else {
				c = (char)((Math.random()*26)+ 97); //소문자 추출
			}
			System.out.print(c + " ");
			
			if(c >= 'A' && c <= 'Z') {
				dsct++;				
			}else {
				scnt++;
			}
		}
		System.out.println();
		System.out.println("소문자 개수 : " + scnt);
		System.out.println("대문자 개수 : " + dsct);
	}

}
