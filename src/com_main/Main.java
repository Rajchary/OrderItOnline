package com_main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com_display.Display;

public class Main {
	public static Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	public static int width=d.width;
	public static int height=d.height;
	private static String title="Where To GO?";

	public static void main(String[] args) {
	//	System.out.println("Hello");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Display(title,width,height-30);
	}

}
