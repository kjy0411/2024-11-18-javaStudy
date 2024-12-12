package com.sist.client;
//MintLookAndFeel
import javax.swing.*;
public class ClientMainFrame extends JFrame { // 상속 => 재사용 => 필요시 변경
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
	}
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
		} catch (Exception ex) {}
		new ClientMainFrame();
	}
}
