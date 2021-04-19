package com_display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com_Signup_Components.SIgnup_pnl;
import com_action_Components.Action_pnl;
import com_login_components.Login_pnl;

public class Display {

	public static int width;
	public static int height;
	private String title;
	public static boolean n=true;
	
	public static JFrame frame;
	
	public static JPanel signup_pnl; 
	public JScrollPane sp;
	
	public static JPanel login_pnl;
	public static JPanel action_pnl;
	
	private ImageIcon sign_backi;
	private String sign_backu="C:\\Users\\lenovo\\eclipse-workspace\\Where To Go\\img_res\\Food_back1.jpeg";
	private JLabel sign_backl;
	
	public static ImageIcon login_backi;
	public  static String login_backu="C:\\Users\\lenovo\\eclipse-workspace\\Where To Go\\img_res\\Food_login.png";
	
									/*Icons URL's as follows*/
	public static String minus_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\minus.png";
	public static String error_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\Error.png";
	public static String clouderror_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\cloud.png";
	public static String offline_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\offline.png";
	public static String member_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\username.png";
	
	
	
	public static JLabel login_backl;
	
	public Display(String title,int width,int height)
	{
		this.title=title;
		Display.width=width;
		Display.height=height;
		engageDisplay();
	}
	
	public void engageDisplay()
	{
		sign_backi=new ImageIcon(new ImageIcon(sign_backu).getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH));
		frame=new JFrame(title);
		frame.setSize(width,height);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("c:\\Users\\lenovo\\eclipse-workspace\\Where To Go\\img_res\\cart_edited.png"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		signup_pnl=new JPanel();
		signup_pnl.setPreferredSize(new Dimension(width,height));
		sp=new JScrollPane(signup_pnl,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		signup_pnl.setLayout(null);
		
		new SIgnup_pnl();
		
		sign_backl=new JLabel();
		sign_backl.setIcon(sign_backi);
		sign_backl.setBounds(0,0,width,height);
		sp.setBounds(0,0,width+10,height);
		
		login_pnl=new JPanel();
		login_pnl.setPreferredSize(new Dimension(width,height));
		login_pnl.setLayout(null);
		login_pnl.setBounds(0,0,width,height);
		login_pnl.setBackground(Color.black);
		
		new Login_pnl();
		
		login_backl=new JLabel();
		Login_pnl.engageNightMood();
		login_backl.setIcon(login_backi);
		
			//Login_panel components
		login_pnl.add(login_backl);
		
		
		action_pnl=new JPanel();
		action_pnl.setPreferredSize(new Dimension(width,height));
		action_pnl.setLayout(null);
		action_pnl.setBounds(0,0,width,height);//(int)(height*0.35));
		action_pnl.setVisible(true);
		action_pnl.setBackground(Color.white);
		
		new Action_pnl();
		
		login_pnl.setVisible(false);
		
		signup_pnl.add(sign_backl);
		signup_pnl.setVisible(false);
		
		frame.add(action_pnl);
		frame.add(login_pnl);
		frame.add(sp);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
