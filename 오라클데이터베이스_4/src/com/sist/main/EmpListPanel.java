package com.sist.main;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
public class EmpListPanel extends JPanel{
	JLabel la = new JLabel("사원 목록", JLabel.CENTER);
	JTable table;
	DefaultTableModel model;
	
	public EmpListPanel() {
		setLayout(new BorderLayout());
		la.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		add("North", la);
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
