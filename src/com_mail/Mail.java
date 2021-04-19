package com_mail;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com_Signup_Components.SIgnup_pnl;
import com_display.Display;


class SendMail extends Thread
{
	String to;
	String otp;
	
	public SendMail(String to,String otp)
	{
		this.to=to;
		this.otp=otp;
	}
	public synchronized void run()
	{
		mailIT(to,otp);
	}
	
	public void mailIT(String to,String otp)
	{
		  String host="smtp.gmail.com";  
		  final String user="assist.curiosity@gmail.com";//change accordingly  
		  final String password="CuriosityA@123";//change accordingly
		  
		  Properties props = new Properties(); 
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable","true");   
		   props.put("mail.smtp.host",host);  
		   props.put("mail.smtp.port","587");
		     
		   Session session = Session.getDefaultInstance(props,  
		    new javax.mail.Authenticator() {  
		      protected PasswordAuthentication getPasswordAuthentication() {  
		    return new PasswordAuthentication(user,password);  
		      }  
		    });
		   
		   try 
		   {
			     MimeMessage message = new MimeMessage(session);  
			     message.setFrom(new InternetAddress(user));  
			     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
			     message.setSubject("OTP From Where To Go ?"); 
			     String htmlC="<html><p>Where to go is the best plartform to choose food places around you</p>"+
			     "<p>Here you can post reviews and get reviews from others like you</p>"
			     +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
			     "<img src='https://images.wallpaperscraft.com/image/food_love_real_love_129141_300x300.jpg' width=70%/><br/><br/>"+
			     "<br/><p><b>Please enter this Otp "+otp+" @ Where to go? by this you will be verified</b></p></html>";
			     message.setContent(htmlC,"text/html");  
			       
			    //send the message  
			     Transport.send(message);  
			  
			    SIgnup_pnl.send=true;
			    	JOptionPane.showMessageDialog(Display.frame,SIgnup_pnl.result,"Sent",JOptionPane.PLAIN_MESSAGE,new ImageIcon(SIgnup_pnl.sentURL));
					SIgnup_pnl.otpt.setVisible(true);
				
		  } 
		   catch (MessagingException e)
				 {
					 SIgnup_pnl.send=false;
					 JOptionPane.showMessageDialog(Display.frame,"<html><p>Invalid Details Entered</p><p>Try again with valid one</p></html>","Error",JOptionPane.PLAIN_MESSAGE,new ImageIcon(SIgnup_pnl.notsentURL));
						SIgnup_pnl.otpt.setVisible(false);
				 }
	
	}
}
class Progress extends Thread
{
	public void run()
	{
		JOptionPane.showMessageDialog(Display.frame,"<html><p>Sending OTP Please Wait</p><p>Thanks for your patience</p>");
	}
}

public class Mail
{
	String to,otp;
	
	public Mail(String to2, String otp2) {
		
		this.to=to2;
		this.otp=otp2;
		SendMail t1=new SendMail(to,otp);
		Progress t2=new Progress();
		t1.start();
		t2.start();
	}
	
}
