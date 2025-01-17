package com.sist.commons;
import java.awt.*;
import javax.swing.*;

public class ImageChange {
	
	public static Image getImage(ImageIcon icon,int with, int height) {
		
		return icon.getImage().getScaledInstance(with, height, Image.SCALE_SMOOTH); // 이미지 => 축소/확대
	}
}
