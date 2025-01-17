package com.sist.client;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
//화면 변경
public class ControlPanel extends JPanel {
	HomePenal hp;
	ChatPenal cp;
	FoodGenrePenal fgp;
	FoodFindPenal ffp;
	FoodDetailPenal fdp;
	CardLayout card = new CardLayout();
	public ControlPanel() {
		 setLayout(card);
		 hp = new HomePenal(this);
		 add("HOME",hp);
		 cp = new ChatPenal(this);
		 add("CHAT", cp);
		 fgp = new FoodGenrePenal(this);
		 add("FOOD",fgp);
		 ffp = new FoodFindPenal(this);
		 add("FIND",ffp);
		 fdp = new FoodDetailPenal(this);
		 add("DETAIL",fdp);
	}
	
}
