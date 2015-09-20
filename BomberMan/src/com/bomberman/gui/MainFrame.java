package com.bomberman.gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import com.bomberman.Game;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
	private JMenu menu;
	
	
	public static final int DEFAULT_BLOCK = 40;
	public static final int DEFAULT_BLOCK_NUMBER = 16;
	public static final int DEFAULT_SCREEN_WIDTH = 700;//647
	public static final int DEFAULT_SCREEN_HEIGHT = 700;//700

	public MainFrame(String title) {

		super(title);

		initMainFrame();
		initBarMenu();
		
		add(new MainPanel());
	}
	
	private void initMainFrame(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dem = kit.getScreenSize();

		Image icon = new ImageIcon("res/bombIcon.png").getImage();
		setIconImage(icon);
		
		setLocation(dem.width / 5, 10);
		setSize(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initBarMenu(){
		// TODO MENUBAR
		menuBar = new JMenuBar();
		menu = new JMenu("ONE");
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}
	
	public void addGame(Game game){
//		TODO 
	}

}
