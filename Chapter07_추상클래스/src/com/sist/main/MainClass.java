package com.sist.main;

import com.sist.dao.DataBase;
import com.sist.dao.Dept;
import com.sist.dao.Emp;

public class MainClass {

	public static void main(String[] args) {
		DataBase db = new Emp();
		db.listPrint();
		System.out.println("=====================");
		db = new Dept();
		db.listPrint();
	}

}
