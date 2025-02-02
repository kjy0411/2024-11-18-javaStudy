package com.sist.main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import com.sist.dao.*;
import com.sist.vo.*;
import java.text.SimpleDateFormat;
public class BoardMainForm extends JFrame implements ActionListener, MouseListener{
	CardLayout card = new CardLayout();
	BoardList bList = new BoardList();
	BoardDetail bDetail = new BoardDetail();
	BoardInsert bInsert = new BoardInsert();
	BoardUpdate bUpdate = new BoardUpdate();
	BoardDelete bDelete = new BoardDelete();
	// 게시판 관리자
	//변수 설정
	int curpage = 1;
	int totalpage = 0;
	public BoardMainForm() {
		setLayout(card);
		//추가
		add("LIST",bList);
		add("DETAIL",bDetail);
		add("INSERT",bInsert);
		add("UPDATE",bUpdate);
		add("DELETE", bDelete);
		
		setTitle("윈도우 게시판 ver 1.0");
		listPrint();
		setSize(640, 550);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 이벤트 등록
		bList.inBtn.addActionListener(this);
		bInsert.b1.addActionListener(this); // 글쓰기
		bInsert.b2.addActionListener(this); // 취소
		
		//이전
		bList.prevBtn.addActionListener(this);
		//다음
		bList.nextBtn.addActionListener(this);
		
		// table
		bList.table.addMouseListener(this);
		
		// 수정
		bDetail.b1.addActionListener(this);
		// 삭제
		bDetail.b2.addActionListener(this);
		// 목록
		bDetail.b3.addActionListener(this);
		
		// 실제 삭제
		bDelete.b1.addActionListener(this); // 삭제
		bDelete.b2.addActionListener(this); // 취소
		
		// 수정
		bUpdate.b1.addActionListener(this);
		bUpdate.b2.addActionListener(this);
	}
	public void listPrint() {
		//테이블 전체 데이터 지우기
		for(int i = bList.model.getRowCount() - 1; i >= 0; i--) {
			bList.model.removeRow(i);
		}
		// JLabel => init => JLabel 초기화
		FreeBoardDAO dao = FreeBoardDAO.newInstance();
		List<FreeBoardVO> list = dao.boardListDate(curpage);
		
		for(FreeBoardVO vo : list) {
			String[] data = {
				String.valueOf(vo.getNo()),
				vo.getSubject(),
				vo.getName(),
				vo.getRegdate().toString(),
				String.valueOf(vo.getHit())
			};
			
			bList.model.addRow(data);
			//목록 출력
			totalpage = dao.boardTotalPage();
			bList.pageLa.setText(curpage + " page / " + totalpage + " page");
		}
	}
	public void detailPrint(int no) {
		FreeBoardDAO dao = FreeBoardDAO.newInstance();
		FreeBoardVO vo = dao.boardDetailData(no);
		
		bDetail.no.setText(String.valueOf(vo.getNo()));
		bDetail.name.setText(vo.getName());
		bDetail.day.setText(vo.getRegdate().toString());
		bDetail.hit.setText(String.valueOf(vo.getHit()));
		bDetail.sub.setText(vo.getSubject());
		bDetail.ta.setText(vo.getContent());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}catch(Exception ex) {}
		new BoardMainForm(); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bList.prevBtn) { // 이전
			if(curpage > 1) {
				curpage--;
				listPrint();
			}
		}else if(e.getSource() == bList.nextBtn) { // 다음
			if(curpage < totalpage) {
				curpage++;
				listPrint();
			}
		}else if(e.getSource() == bList.inBtn) {//새글 추가
			card.show(getContentPane(), "INSERT");
			bInsert.nameTf.setText("");
			bInsert.subTf.setText("");
			bInsert.ta.setText("");
			bInsert.pwdPf.setText("");
			bInsert.nameTf.requestFocus();
			// card => 단점은 윈도우가 종료하지 않는다 => 입력된 내용 그대로 유지
		}else if(e.getSource() == bInsert.b1) {//글쓰기 등록
			// 입력한 데이터 읽기
			String name = bInsert.nameTf.getText();
			if(name.trim().length() < 1) { // 이름이 입력이 안된 상태
				JOptionPane.showMessageDialog(this, "이름을 입력하세요"); // alert()
				bInsert.nameTf.requestFocus(); // name.focus()
				return;
			}
			String subject = bInsert.subTf.getText();
			if(subject.trim().length() < 1) {
				JOptionPane.showMessageDialog(this, "제목을 입력하세요");
				bInsert.subTf.requestFocus();
				return;
			}
			String content = bInsert.ta.getText();
			if(content.trim().length() < 1) {
				JOptionPane.showMessageDialog(this, "내용을 입력하세요");
				bInsert.ta.requestFocus();
				return;
			}
			String pwd = String.valueOf(bInsert.pwdPf.getPassword());
			if(pwd.trim().length() < 1) {
				JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
				bInsert.pwdPf.requestFocus();
				return;
			}
			// => 유효성 : NOT NULL / CHECK / PRIMARY KEY(id)
			
			//오라클 연동
			FreeBoardDAO dao = FreeBoardDAO.newInstance();
			FreeBoardVO vo = new FreeBoardVO();
			vo.setName(name);
			vo.setSubject(subject);
			vo.setContent(content);
			vo.setPwd(pwd);
			
			dao.boardInsert(vo);
			
			card.show(getContentPane(), "LIST");
			listPrint();
		}else if(e.getSource() == bInsert.b2) {//글쓰기 취소
			// javascript:history.bakc() => JSP 이전화면으로
			card.show(getContentPane(), "LIST");
			// 화면 이동 getContenPane() : Panel관리자
			// => 이동시에 card이름 부여
		}else if(e.getSource() == bDetail.b3) {// 상세보기 => 목록이동
			card.show(getContentPane(), "LIST");
			listPrint();
		}else if(e.getSource() == bDetail.b1) {// 상세보기 => 수정이동
			card.show(getContentPane(), "UPDATE");
			// 처리 => 수정 (이전 입력값)
			FreeBoardDAO dao = FreeBoardDAO.newInstance();
			String no = bDetail.no.getText();
			FreeBoardVO vo = dao.boardUpdateData(Integer.parseInt(no));
			// 윈도우 / 웹 => 정수개념이 ㅇ벗다 (무조건 문자열)
			// <a href="detail.jsp?no=10">
			// 웹 : String no = request.getParameter("no");
			bUpdate.nameTf.setText(vo.getName());
			bUpdate.subTf.setText(vo.getSubject());
			bUpdate.ta.setText(vo.getContent());
			bUpdate.pwdPf.setText("");
		}else if(e.getSource() == bUpdate.b1) {// 수정
			// DB처리
			String name = bUpdate.nameTf.getText();
			if(name.trim().length() < 1) { // 이름이 입력이 안된 상태
				JOptionPane.showMessageDialog(this, "이름을 입력하세요"); // alert()
				bUpdate.nameTf.requestFocus(); // name.focus()
				return;
			}
			String subject = bUpdate.subTf.getText();
			if(subject.trim().length() < 1) {
				JOptionPane.showMessageDialog(this, "제목을 입력하세요");
				bUpdate.subTf.requestFocus();
				return;
			}
			String content = bUpdate.ta.getText();
			if(content.trim().length() < 1) {
				JOptionPane.showMessageDialog(this, "내용을 입력하세요");
				bUpdate.ta.requestFocus();
				return;
			}
			String pwd = String.valueOf(bUpdate.pwdPf.getPassword());
			if(pwd.trim().length() < 1) {
				JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
				bUpdate.pwdPf.requestFocus();
				return;
			}
			String no = bDetail.no.getText();
			
			// 데이터를 모아서 => DAO로 전송
			FreeBoardDAO dao = FreeBoardDAO.newInstance();
			FreeBoardVO vo = new FreeBoardVO();
			
			vo.setNo(Integer.parseInt(no));
			vo.setName(name);
			vo.setSubject(subject);
			vo.setContent(content);
			vo.setPwd(pwd);
			
			boolean bCheck = dao.boardUpdate(vo);
			
			if(bCheck == true) {
				card.show(getContentPane(), "DETAIL");
				detailPrint(Integer.parseInt(no));
			}else {
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다");
				bUpdate.pwdPf.setText("");
				bUpdate.pwdPf.requestFocus();;
			}
		}else if(e.getSource() == bUpdate.b2) {// 수정 취소
			card.show(getContentPane(), "DETAIL");
		}else if(e.getSource() == bDetail.b2) {// 상세보기 => 삭제이동
			card.show(getContentPane(), "DELETE");
			bDelete.pf.setText("");;
			bDelete.pf.requestFocus();
		}else if(e.getSource() == bDelete.b1) {//삭제
			String no = bDetail.no.getText();
			String pwd = String.valueOf(bDelete.pf.getPassword());
			FreeBoardDAO dao = FreeBoardDAO.newInstance();
			boolean bCheck = dao.boardDelete(Integer.parseInt(no), pwd);
			
			if(bCheck == true) {
				card.show(getContentPane(), "LIST");
				listPrint();
			}else {
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다");
				bDelete.pf.setText("");
				bDelete.pf.requestFocus();;
			}
		}else if(e.getSource() == bDelete.b2) {//삭제 취소
			card.show(getContentPane(), "DETAIL");
		}
	}
	// onMouseDown
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == bList.table) {
			if(e.getClickCount() == 2) { // 더블 클릭시
				// 게시물 번호를 읽어온다
				int row = bList.table.getSelectedRow();
				String no = bList.model.getValueAt(row, 0).toString();
				// 게시물을 읽어온다
				card.show(getContentPane(), "DETAIL");
				detailPrint(Integer.parseInt(no));
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	// onMouseUp
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	// onMouseOver
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	// onMouseOut
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
