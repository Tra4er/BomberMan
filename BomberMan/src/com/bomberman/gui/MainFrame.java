package com.bomberman.gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public static final int STANDART_SCREEN_WIDTH = 500;
	public static final int STANDART_SCREEN_HEIGHT = 500;

	public MainFrame(String title) {

		super(title);

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dem = kit.getScreenSize();

		Image icon = new ImageIcon("res/bombIcon.png").getImage();
		setIconImage(icon);
		
		setLocation(dem.width / 5, dem.height / 6);
		setSize(STANDART_SCREEN_WIDTH, STANDART_SCREEN_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MenuPanel());
		System.out.println("Frame");
	}

}
