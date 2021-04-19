package com_Signup_Components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com_display.Display;
import com_mail.Mail;

public class SIgnup_pnl implements KeyListener,ActionListener,MouseListener{
	private JLabel name,mail,password,cpassword,mobile,mail_caution,login_hint,regionl;
	public JTextField namet,mailt,mobilet;
	public JPasswordField past,cpast;
	public static JTextField otpt;
	private JButton otpb,clearbutton,submitButton,backButton;
	public static JComboBox region;
	
	public static String sentURL="C:\\Users\\lenovo\\eclipse-workspace\\Where To Go\\img_res\\sent.png";
	public static String notsentURL="C:\\Users\\lenovo\\eclipse-workspace\\Where To Go\\img_res\\notsent.png";
	public static String errorURL="C:\\Users\\lenovo\\eclipse-workspace\\Where To Go\\img_res\\Error.png";
	private String region_list[]= {"None","Hyderabad","Karimnagar","Nizamabad","Warangal"};
			
	public static String result= "OTP sent Successfully";
	public static String selected_region="";
	public static boolean send=true;
	
	char tpass[]=new char[40];
	char tcpas[]=new char[40];
	
	String otp="";
	
	public static Font cn24=new Font("Cambria Math",Font.BOLD,24);
	public static Font cm20=new Font("Cambria Math",Font.BOLD,20);
	
	public  SIgnup_pnl()
	{
							//Headings 
		
		name=new JLabel("<html><font color=\"#66ffff\"><b>Name    </b></font></html>");
		name.setFont(cn24);
		name.setBounds(40,80,120,40);
		
		mobile=new JLabel("<html><font color=\"#66ffff\"><b>Mobile </b></font></html>");
		mobile.setFont(cn24);
		mobile.setBounds(40,140,120,40);
		
		password=new JLabel("<html><font color=\"#66ffff\"><b>Password </b></font></html>");
		password.setFont(cn24);
		password.setBounds(40,200,120,40);
		
		cpassword=new JLabel("<html><font color=\"#66ffff\"><b>Confirm it</b></font></html>");
		cpassword.setFont(cn24);
		cpassword.setBounds(40,260,120,40);
		
		mail=new JLabel("<html><font color=\"#66ffff\"><b>Mail ID</b></font></html>");
		mail.setFont(cn24);
		mail.setBounds(40,320,120,40);
		
		mail_caution=new JLabel("<html><font color=\"#ff0000\"><b>/*Make sure it is available</b></html>");
		mail_caution.setBounds(365,325,500,40);
		mail_caution.setFont(cm20);
		
		regionl=new JLabel("Region");
		regionl.setFont(cn24);
		regionl.setForeground(new Color(66,255,255));
		regionl.setBounds(40,380,120,40);
		
										//TextFields
		
		namet=new JTextField();
		namet.setBounds(175,95,150,25);
		namet.setFont(cm20);
		namet.setBorder(BorderFactory.createLineBorder(Color.black,2));
		
		mobilet=new JTextField();
		mobilet.setBounds(175,155,150,25);
		mobilet.setFont(cm20);
		mobilet.setBorder(BorderFactory.createLineBorder(Color.black,2));
		mobilet.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke)
			{
				if(mobilet.getText().length()<10)
					mobilet.setForeground(Color.red);
				else
					mobilet.setForeground(Color.blue);
			}
		});
		
		past=new JPasswordField();
		past.setBounds(175,215,150,25);
		past.setBorder(BorderFactory.createLineBorder(Color.black,2));
		
		cpast=new JPasswordField();
		cpast.setBounds(175,275,150,25);
		cpast.setBorder(BorderFactory.createLineBorder(Color.black,2));
		cpast.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke)
			{
				tpass=past.getPassword();
				tcpas=cpast.getPassword();
				
				String password1=new String(tpass);
				String cpassword1=new String(tcpas);
				if(password1.equals(cpassword1)) {
					cpast.setBorder(BorderFactory.createLineBorder(Color.black,2));
					cpast.setForeground(Color.green);}
				else {
					cpast.setBorder(BorderFactory.createLineBorder(Color.red,2));
					cpast.setForeground(Color.red);}
			}
		});
		
				
		mailt=new JTextField();
		mailt.setBounds(175,335,190,25);
		mailt.setFont(cm20);
		mailt.setBorder(BorderFactory.createLineBorder(Color.black,2));
		mailt.addKeyListener(this);
		
		region=new JComboBox(region_list);
		region.setBounds(175,390,200,30);
		region.addMouseListener(this);
		
		otpb=new JButton("<html><b>Send OTP</b></html>");
		otpb.setBounds(140,450,130,30);
		otpb.setFont(cm20);
		otpb.addActionListener(this);
		otpb.setVisible(false);
		otpb.addMouseListener(this);

		otpt=new JTextField();
		otpt.setBounds(240,500,75,25);
		otpt.setFont(cm20);
		otpt.setBorder(BorderFactory.createLineBorder(Color.black,2));
		otpt.setVisible(false);
		otpt.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke)
			{
				validate(otpt.getText());
			}
		});

		clearbutton=new JButton("<html><b>Clear</b></html>");
		clearbutton.setBounds(195,575,100,30);
		clearbutton.setFont(cm20);
		clearbutton.addActionListener(this);
		clearbutton.addMouseListener(this);
		
		backButton=new JButton("<html><b>Back</b></html>");
		backButton.setFont(cm20);
		backButton.setBounds(80,575,100,30);
		backButton.addActionListener(this);
		backButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me)
			{
				login_hint.setVisible(true);
			}
			public void mouseExited(MouseEvent me)
			{
				login_hint.setVisible(false);
			}
		});
		backButton.addMouseListener(this);
		
		login_hint=new JLabel("Already a User ?");
		login_hint.setFont(cm20);
		login_hint.setForeground(Color.black);
		login_hint.setBounds(50,620,180,30);
		login_hint.setVisible(false);
		
		submitButton=new JButton("<html><b>Submit</b></html>");
		submitButton.setFont(cm20);
		submitButton.setBounds(315,575,100,30);
		submitButton.setVisible(false);
		submitButton.addMouseListener(this);
		
		Display.signup_pnl.add(name); Display.signup_pnl.add(mail); Display.signup_pnl.add(mobile);
		Display.signup_pnl.add(password); Display.signup_pnl.add(cpassword); Display.signup_pnl.add(mail_caution);
		Display.signup_pnl.add(namet); Display.signup_pnl.add(mobilet); Display.signup_pnl.add(past);
		Display.signup_pnl.add(cpast); Display.signup_pnl.add(mailt);Display.signup_pnl.add(regionl);
		Display.signup_pnl.add(otpb);Display.signup_pnl.add(region);
		Display.signup_pnl.add(otpt); Display.signup_pnl.add(clearbutton); Display.signup_pnl.add(backButton);
		Display.signup_pnl.add(submitButton); Display.signup_pnl.add(login_hint);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==otpb)
		{
			
			
			
			if(namet.getText().length()>=3)
			{
				otp="";
				String to=mailt.getText();
				Random rand = new Random();
				for(int i=0;i<6;i++)
				{
					String t=String.valueOf( rand.nextInt(10));
					otp=otp+t;
				}
				new Mail(to,otp);
			}
			else
				JOptionPane.showMessageDialog(Display.frame, "Non of the fields shouldn't be left empty","Error",JOptionPane.PLAIN_MESSAGE,new ImageIcon(errorURL));
		}
		else if(ae.getSource()==submitButton)
		{
			selected_region=region.getSelectedItem().toString();
			otpt.setForeground(Color.black);
			JOptionPane.showMessageDialog(Display.frame, "YOU ARE IN"); 
		}
		else if(ae.getSource()==backButton)
		{
			Display.login_pnl.setVisible(true);
			Display.signup_pnl.setVisible(false);
		}
		
	}
	public void validate(String entered_otp)
	{
		if(entered_otp.equals(otp))
		{
			otpt.setForeground(Color.green);
			submitButton.setVisible(true);
		}
		else {
			otpt.setForeground(Color.red);
			submitButton.setVisible(false);
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		if(mailt.getText().length()>=6)
		{
			otpb.setVisible(true);
		}
		else
			otpb.setVisible(false);
		
	}

	@Override
	public void mouseClicked(MouseEvent me) {
	
		
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
		clearbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		otpb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		region.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent me) {
		submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));		
		clearbutton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		otpb.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
	}

	@Override
	public void mousePressed(MouseEvent me) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent me) {
	
		
	}
}
