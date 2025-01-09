package com.sist.main;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int page = -1;
		while(page != 0) {
			System.out.print("페이지 입력 : ");
			page = scan.nextInt();
			
			FoodDAO dao = FoodDAO.newInstance();
			List<FoodVO> list = dao.foodListData(page);
			for(FoodVO vo : list) {
				System.out.println(vo.getFno() + "." + vo.getName());
			}			
		}
	}
	
}
