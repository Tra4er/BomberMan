package com.bomberman.gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	
	
	public static final int DEFAULT_BLOCK = 40;
	public static final int DEFAULT_BLOCK_NUMBER = 17;
	public static final int DEFAULT_SCREEN_WIDTH = 696;//696
	public static final int DEFAULT_SCREEN_HEIGHT = 772;//772

	public MainFrame(String title) {

		super(title);

		initMainFrame();
		initBarMenu();
		
		add(new MainPanel());
	}
	
	private void initMainFrame(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dem = kit.getScreenSize();

		Image icon = new ImageIcon("res/bomb2.gif").getImage();
		setIconImage(icon);
		
		setLocation(dem.width / 5, 0);
		setSize(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initBarMenu(){
		// TODO MENUBAR
		menuBar = new JMenuBar();
		menu = new JMenu("ONE");
		menuItem = new JMenuItem("Close");
		menuItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
//				this.
			}
			
		});
		menu.add(menuItem);
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}

}
