package com.sist.main;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
public class EmpFindPanel extends JPanel{
	JTable table;
	DefaultTableModel model;
	JComboBox box = new JComboBox();
	JTextField tf = new JTextField(10);
	JButton b = new JButton("검색");
	
	public EmpFindPanel() {
		setLayout(new BorderLayout());
		box.addItem("ename");
		box.addItem("job");
		box.addItem("hiredate");
		box.addItem("dname");
		box.addItem("loc");
		/*  
		 *  <select>
		 *    <option value = "ename">이름</option>
		 *    <option value = "hiredate">입사일</option>
		 *    <option value = "dname">부서명</option>
		 *  </select>
		 */
		JPanel p = new JPanel();
		p.add(box);
		p.add(tf);
		p.add(b);
		add("North", p);
		
		String[] col = {"사번", "이름", "직위", "입사일", "부서명", "근무지"};
		String[][] row = new String[0][6];
		// 익명의 클래스 => 상속이 없이 오버라이딩이 가능하게 만든다
		model = new DefaultTableModel(row, col) {
			// 편집 방지
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		// 윈도우 / 쓰레드
		table = new JTable(model);
		table.setRowHeight(30);
		JScrollPane js = new JScrollPane(table);
		add("Center", js);
	}
}
