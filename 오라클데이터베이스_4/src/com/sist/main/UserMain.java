package com.sist.main;

import javax.swing.*;

import com.sist.dao.EmpDAO;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import com.sist.dao.*;
import com.sist.vo.*;
public class UserMain extends JFrame implements ActionListener, MouseListener{
	CardLayout card = new CardLayout();
	JMenuItem empItem = new JMenuItem("사원관리");
	JMenuItem foodItem = new JMenuItem("맛집관리");
	JMenuItem eFindItem = new JMenuItem("사원검색");
	JMenuItem fFindItem = new JMenuItem("맛집검색");
	JMenuItem exit = new JMenuItem("종료");
	
	// 화면을 모아서 관리 
    EmpListPanel ep = new EmpListPanel();
    EmpFindPanel efp = new EmpFindPanel();
	public UserMain() {
		setLayout(card);
		JMenu menu1 = new JMenu("관리");
		menu1.add(empItem);
		menu1.addSeparator();
		menu1.add(foodItem);
		menu1.addSeparator();
		menu1.add(exit);
		
		JMenu menu2 = new JMenu("검색");
		menu2.add(eFindItem);
		menu2.add(fFindItem);
		
		JMenuBar bar = new JMenuBar();
		bar.add(menu1);
		bar.add(menu2);
		
		setJMenuBar(bar);
		
		add("EFP", efp);
		add("EP", ep);
		
		empDataPrint();
		
		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ep.table.addMouseListener(this);
		
		//메뉴
		empItem.addActionListener(this);
		eFindItem.addActionListener(this);
		exit.addActionListener(this);

		efp.b.addActionListener(this); // 검색버튼
		efp.tf.addActionListener(this); // 엔터
	}
	public void empDataPrint() {
		EmpDAO dao = EmpDAO.newInstance();
		List<EmpVO> list = dao.empListData();
		for(EmpVO vo : list) {
			String[] data = {
				String.valueOf(vo.getEmpno()),
				vo.getEname(),
				vo.getJob(),
				vo.getHiredate().toString(),
				vo.getDvo().getDname(),
				vo.getDvo().getLoc()
			};
			ep.model.addRow(data);
		}
	}
	public void empFindPrint(String col, String fd) {
		for(int i = efp.model.getRowCount() - 1; i >= 0; i--) {
			efp.model.removeRow(i);
		}
		EmpDAO dao = EmpDAO.newInstance();
		List<EmpVO> list = dao.empFindData(col, fd);
		for(EmpVO vo : list) {
			String[] data = {
				String.valueOf(vo.getEmpno()),
				vo.getEname(),
				vo.getJob(),
				vo.getHiredate().toString(),
				vo.getDvo().getDname(),
				vo.getDvo().getLoc()
			};
			efp.model.addRow(data);
		}
	}
	public static void main(String[] args) {
		new UserMain();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == ep.table) {
			if(e.getClickCount() == 2) { // 더블 클릭
				// 사번
				int row = ep.table.getSelectedRow();
				String empno = ep.model.getValueAt(row, 0).toString();
				//JOptionPane.showMessageDialog(this, empno);
				EmpDAO dao = EmpDAO.newInstance();
				EmpVO vo = dao.empDetailData(Integer.parseInt(empno));
				String info = "사번 : " + vo.getEmpno() + "\n"
						+ "이름 : " + vo.getEname() + "\n"
						+ "직위 : " + vo.getJob() + "\n"
						+ "사수명 : " + vo.getMname() + "\n"
						+ "입사일 : " + vo.getHiredate() + "\n"
						+ "급여 : " + vo.getSal() + "\n"
						+ "성과금 : " + vo.getComm() + "\n"
						+ "부서명 : " + vo.getDvo().getDname() + "\n"
						+ "근무지 : " + vo.getDvo().getLoc() + "\n"
						+ "등급 : " + vo.getSvo().getGrade() + "\n";
				JOptionPane.showMessageDialog(this, info);
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit) {
			System.exit(0);
		} else if (e.getSource() == empItem) {
			card.show(getContentPane(), "EP");
			// 화면 변경 => 사원 목록
			// <a href = "list.jsp">
		} else if (e.getSource() == eFindItem) {
			card.show(getContentPane(), "EFP");
			// 화면 변경 => 사원 검색
			// <a href = "find.jsp">
		} else if (e.getSource() == efp.b || e.getSource() == efp.tf) {
			String col = efp.box.getSelectedItem().toString();
			String fd = efp.tf.getText();
			if(fd.trim().length() < 1) {
				efp.tf.requestFocus();
				return;
			}
			
			empFindPrint(col, fd.toUpperCase());
		}
	}

}
