
public class 메소드_문제풀이2 {
	
	public static void main(String[] args) {
		
		int[] kor = new int[3];
		int[] eng = new int[3];
		int[] math = new int[3];
		int[] total = new int[3];
		double[] avg = new double[3];
		int[] rank = new int[3];
		int kTotla = 0, eTotla = 0, mTotal = 0;
		
		for(int i = 0; i < 3; i++) {
			
			kor[i] = (int)(Math.random()*101);
			eng[i] = (int)(Math.random()*101);
			math[i] = (int)(Math.random()*101);
			kTotla += kor[i];
			eTotla += eng[i];
			mTotal += math[i];
		}
		for(int i = 0; i < 3; i++) {
			total[i] = kor[i] + eng[i] + math[i];
			avg[i] = total[i] / 3.0;
		}
		for(int i = 0; i < 3; i++) {
			rank[i] = 1;
			for(int j = 0; j < i; j++) {
				if(total[i] < total[j]) {
					rank[i]++;
				}
			}
		}
		for(int i = 0; i < 3; i++) {
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
