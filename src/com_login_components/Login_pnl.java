package com_login_components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com_Signup_Components.SIgnup_pnl;
import com_display.Display;

public class Login_pnl implements MouseListener,ActionListener {
	
	private Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	
	private JLabel username,password,hint,signup_hint;
	public static JLabel toggle_onl,toggle_offl,night_mood_hint;
	private JButton login,signup,reset;
	
	public JTextField usernamet;
	private JPasswordField passwordt;
	
	private static int width,height;
	
	public static String toggle_onURL="C:\\Users\\lenovo\\eclipse-workspace\\Where To Go\\img_res\\toggle_on.png";
	public static String toggle_offURL="C:\\Users\\lenovo\\eclipse-workspace\\Where To Go\\img_res\\toggle_off.png";
	public static String night_moods="OFF";
	
	public static boolean night_mood=false;
	public Login_pnl()
	{
		Login_pnl.width=d.width;
		Login_pnl.height=d.height;
		
		toggle_onl=new JLabel();
		toggle_onl.setIcon(new ImageIcon(toggle_onURL));
		toggle_onl.setBounds(1040,100,60,60);
		toggle_onl.setVisible(false);
		toggle_onl.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me)
			{
				toggle_onl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				night_mood_hint.setVisible(true);
			}
			public void mouseExited(MouseEvent me)
			{
				night_mood_hint.setVisible(false);
			}
			public void mouseClicked(MouseEvent me)
			{
				engageNightMood();
			}
		});
		
		toggle_offl=new JLabel();
		toggle_offl.setIcon(new ImageIcon(toggle_offURL));
		toggle_offl.setBounds(1040,100,60,60);
		toggle_offl.setVisible(true);
		toggle_offl.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me)
			{
				night_mood_hint.setVisible(true);
				toggle_offl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent me)
			{
				night_mood_hint.setVisible(false);
			}
			public void mouseClicked(MouseEvent me)
			{
				engageNightMood();
			}
		});
		
		night_mood_hint=new JLabel("Night mood is "+night_moods);
		night_mood_hint.setForeground(Color.red);
		night_mood_hint.setFont(SIgnup_pnl.cn24);
		night_mood_hint.setBounds(970,80,250,35);
		night_mood_hint.setVisible(false);
		
		username=new JLabel("USERNAME :");
		username.setForeground(Color.red);
		username.setFont(SIgnup_pnl.cn24);
		username.setBounds(600, 300, 150,40);
		
		password=new JLabel("PASSWORD :");
		password.setForeground(Color.red);
		password.setFont(SIgnup_pnl.cn24);
		password.setBounds(600,350,150,40);
		
		hint=new JLabel("/*YOUR MAIL ID");
		hint.setFont(SIgnup_pnl.cm20);
		hint.setForeground(Color.blue);
		hint.setBounds(940, 300, 180, 25);
		
		usernamet=new JTextField();
		usernamet.setFont(SIgnup_pnl.cm20);
		usernamet.setBorder(BorderFactory.createLineBorder(Color.black,3));
		usernamet.setBounds(760, 305, 180, 30);
		usernamet.setFont(SIgnup_pnl.cm20);
		
		passwordt=new JPasswordField();
		passwordt.setFont(SIgnup_pnl.cm20);
		passwordt.setBorder(BorderFactory.createLineBorder(Color.black,3));
		passwordt.setBounds(760,355,180,30);
		passwordt.setFont(SIgnup_pnl.cm20);
		
		login=new JButton("Login");
		login.setFont(SIgnup_pnl.cm20);
		login.setBounds(715,395,100,30);
		login.addMouseListener(this);
		login.addActionListener(this);
		
		signup=new JButton("Signup");
		signup.setFont(SIgnup_pnl.cm20);
		signup.setBounds(600,395,100,30);
	//	signup.addMouseListener(this)
		signup.addMouseListener(this);
		signup.addActionListener(this);
		
		signup_hint=new JLabel("New User ?");
		signup_hint.setFont(SIgnup_pnl.cm20);
		signup_hint.setBounds(550,420,150,40);
		signup_hint.setVisible(false);
		
		reset=new JButton("Reset");
		reset.setFont(SIgnup_pnl.cm20);
		reset.setBounds(830,395,100,30);
		reset.addMouseListener(this);
		reset.addActionListener(this);
		
		Display.login_pnl.add(username); Display.login_pnl.add(password); Display.login_pnl.add(usernamet);
		Display.login_pnl.add(passwordt); Display.login_pnl.add(hint); Display.login_pnl.add(signup);
		Display.login_pnl.add(login); Display.login_pnl.add(reset); Display.login_pnl.add(signup_hint);
		Display.login_pnl.add(toggle_onl); Display.login_pnl.add(night_mood_hint); Display.login_pnl.add(toggle_offl);
	
	}
	
	public static void engageNightMood()
	{
		if(night_mood||Display.n) 
		{
			Display.n=false;
			night_mood=false;
			night_moods="OFF";
			toggle_offl.setVisible(true);
			toggle_onl.setVisible(false);
			night_mood_hint.setText("Night Mood Is "+night_moods);
			night_mood_hint.setForeground(Color.red);
			Display.login_backu="C:\\Users\\lenovo\\eclipse-workspace\\Where To Go\\img_res\\Food_back1.jpeg";
			Display.login_backi=new ImageIcon(new ImageIcon(Display.login_backu).getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH));
			Display.login_backl.setIcon(Display.login_backi);
			Display.login_backl.setBounds(0,0,width,height);
		//	Display.login_pnl.add(Display.login_backl);
		}
		else
		{
			night_mood=true;
			night_moods="ON";
			toggle_offl.setVisible(false);
			toggle_onl.setVisible(true);
			night_mood_hint.setText("Night Mood Is "+night_moods);
			night_mood_hint.setForeground(Color.green);
			Display.login_backu="C:\\Users\\lenovo\\eclipse-workspace\\Where To Go\\img_res\\night_mood.png";
			Display.login_backi=new ImageIcon(new ImageIcon(Display.login_backu).getImage().getScaledInstance(1216,912,Image.SCALE_SMOOTH));
			Display.login_backl.setIcon(Display.login_backi);
			Display.login_backl.setBounds(0,0,1100,700);
		//	Display.login_pnl.add(Display.login_backl);
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==reset)
		{
			usernamet.setText("");
			passwordt.setText("");
		}
		
		else if(ae.getSource()==signup)
		{
			Display.login_pnl.setVisible(false);
			Display.signup_pnl.setVisible(true);
		}
		
		else if(ae.getSource()==login)
		{
			usernamet.setText("");
			passwordt.setText("");
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		signup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toggle_onl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toggle_offl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		if(me.getComponent()==signup)
		{
			if(toggle_onl.isVisible())
				signup_hint.setForeground(Color.black);
			else
				signup_hint.setForeground(Color.red);
			signup_hint.setVisible(true);
		}
	}

	@Override
	public void mouseExited(MouseEvent me) {
	
		signup.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		login.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		reset.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		toggle_onl.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		toggle_offl.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		if(me.getComponent()==signup)
			signup_hint.setVisible(false);
	}

	@Override
	public void mousePressed(MouseEvent me) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent me) {
	
		
	}

}
