package com.sist.main;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

public class EmpMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("★★★★★ 사원 목록 ★★★★★");
		// 오라클 연결
		EmpDAO dao = EmpDAO.newInstance();
		List<EmpVO> list = dao.empJoinAllData();
		for(EmpVO vo : list) {
			System.out.println(vo.getEmpno() + " "
					+ vo.getEname() + " "
					+ vo.getJob() + " "
					+ vo.getHiredate() + " "
					+ vo.getStrSal() + " "
					+ vo.getDvo().getDname() + " "
					+ vo.getDvo().getLoc() + " "
					+ vo.getSvo().getGrade() + " ");
		}
		System.out.print("사번 : ");
		int sabun = scan.nextInt();
		EmpVO vo = dao.empFindData(sabun);
		System.out.println("사번 : " + vo.getEmpno() + "\n"
				+ "이름 : " + vo.getEname() + "\n"
				+ "직급 : " + vo.getJob() + "\n"
				+ "입사일 : " + vo.getHiredate() + "\n"
				+ "급여 : " + vo.getStrSal() + "\n"
				+ "부서명 : " + vo.getDvo().getDname() + "\n"
				+ "근무지 : " + vo.getDvo().getLoc() + "\n"
				+ "등급 : " + vo.getSvo().getGrade() + "\n");
	}
	
}
