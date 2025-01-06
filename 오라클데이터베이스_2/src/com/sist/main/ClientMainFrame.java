package com.sist.main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//MintLookAndFeel
import javax.swing.*;
import javax.swing.event.*;
import com.sist.vo.*;
import com.sist.dao.*;
public class ClientMainFrame extends JFrame implements ActionListener{ // 상속 => 재사용 => 필요시 변경
	MenuForm mf = new MenuForm(); // 포함 클래스 => 있는 그대로 사용
	ControlPanel cp = new ControlPanel();
	
	//배치
	public ClientMainFrame() {
		setLayout(null); // 사용자 정의 => 직접 배치
		mf.setBounds(200, 10, 900, 50);
		add(mf);
		cp.setBounds(50, 75, 1200, 750);
		add(cp);
		setSize(1300, 900);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cp.b1.addActionListener(this); // 로그인 버튼
		cp.b2.addActionListener(this); // 취소
	}
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
		} catch (Exception ex) {}
		new ClientMainFrame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cp.b2) {
			System.exit(0);
		}else if(e.getSource() == cp.b1) { // 로그인
			String id = cp.tf.getText();
			if(id.trim().length() < 1) {
				cp.tf.requestFocus();
				return;
			}
			String pwd = String.valueOf(cp.pf.getPassword()); // char[] => String으로 변경
			if(pwd.trim().length() < 1) {
				cp.pf.requestFocus();
				return;
			}
			MemberDAO dao = MemberDAO.newInstance();
			MemberVO vo = dao.isLogin(id, pwd);
			
			if(vo.getMsg().equals("NOID")) {
				JOptionPane.showMessageDialog(this, "아이디가 존재하지 않습니다");
				cp.tf.setText("");
				cp.pf.setText("");
				cp.tf.requestFocus();
			}else if (vo.getMsg().equals("NOPWD")) {
				JOptionPane.showMessageDialog(this, "비밀번호 존재하지 않습니다");
				cp.pf.setText("");
				cp.pf.requestFocus();
			}else { // 로그인된 상태
				String msg = vo.getName() + "님 로그인을 환영합니다\n메인페이지로 이동합니다!!";
				JOptionPane.showMessageDialog(this, msg);// alert()
			}
			
		}
	}
}
