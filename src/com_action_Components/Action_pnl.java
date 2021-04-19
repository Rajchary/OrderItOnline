package com_action_Components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import Action_Sub_Karimnagar.Karimnagar_pnl;
import Sub_Action_hyd.Hyderabad_pnl;
import checkout.Checkout_panel;
import com_OrderList.OrderList_Panel;
import com_Signup_Components.SIgnup_pnl;
import com_display.Display;

public class Action_pnl implements MouseListener{
	private String regionURL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\region.png";
	private String searchURL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\search.png";
	public static String load_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\loading.gif";
	private String logo_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\logo2.png";
	public static String cart_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\cart_edited.png";
	public static String cart45_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\cart_45.png";
	private String list_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\list.png";
	private String listSmall_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\list_small.png";
	private String close_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\close.png";
	private String close2_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\close2.png";
	private String checkout_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\checkout.png";
	private String checkout25_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\checkout_25.png";
	private String checkout75_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\checkout_75.png";
	
	public static ImageIcon cartI=new ImageIcon(cart_URL);
	public static ImageIcon cart45=new ImageIcon(cart45_URL);
	int i;
	static String regs="Showing results in ";
	String par="";
	public static List<String> items_list=new ArrayList<String>();
	public static int cart_limit=20;
	
	private JLabel logo;
	private JLabel regionl,action_backl,searchl,search_hint,cart_hint,list_icon;
	public static JLabel close_icon;
	public static JLabel close_hint;
	private JLabel checkout;
	private JLabel checkout_hint;
	public static JLabel cart;
	public static JLabel header;
	private static JLabel result;
	private static JLabel load;
	JComboBox cb;
	
	Timer t;
	
	public Action_pnl()
	{
		header=new JLabel();
		header.setOpaque(true);
		header.setBackground(Color.yellow);
		header.setVisible(false);
		header.setBounds(870,80,300,25);
		
		close_icon=new JLabel();
		close_icon.setIcon(new ImageIcon(close_URL));
		close_icon.setBackground(Color.red);
		close_icon.setBounds(1150,84,16,16);
		close_icon.addMouseListener(this);
		close_icon.setVisible(false);
		
		close_hint=new JLabel("Close");
		close_hint.setForeground(Color.white);
		close_hint.setBounds(1150,57,70,20);
		close_hint.setVisible(false);
		
		cart=new JLabel();
		cart.setIcon(cartI);
		cart.setBounds(600,200,64,64);
		cart.addMouseListener(this);
		cart.setVisible(false);
		
		cart_hint=new JLabel("ADD");
		cart_hint.setFont(SIgnup_pnl.cn24);
		cart_hint.setForeground(Karimnagar_pnl.name_Color);
		cart_hint.setBounds(550,220,70,30);
		cart_hint.setVisible(false);
		
		logo=new JLabel();
		logo.setIcon(new ImageIcon(logo_URL));
		logo.setBounds(350,45,498,129);
		
		list_icon=new JLabel();
		list_icon.setIcon(new ImageIcon(list_URL));
		list_icon.setBounds(700,210,48,48);
		list_icon.addMouseListener(this);
		list_icon.setVisible(false);
		
		checkout=new JLabel();
		checkout.setIcon(new ImageIcon(checkout_URL));
		checkout.addMouseListener(this);
		checkout.setVisible(false);
		checkout.setBounds(780,200,64,64);
		
		checkout_hint=new JLabel("Checkout");
		checkout_hint.setFont(SIgnup_pnl.cm20);
		checkout_hint.setForeground(Color.magenta);
		checkout_hint.setVisible(false);
		checkout_hint.setBounds(770,180,100,20);
		
		regionl=new JLabel();
		regionl.setIcon(new ImageIcon(regionURL));
		regionl.setBounds(220,98,34,34);
		
		String reg[]= {"Hyderabad","Karimnagar","Nizamabad","Warangal"};
		cb=new JComboBox(reg);
		cb.addMouseListener(this);
		cb.setBounds(70,100,150,30);
		
		search_hint=new JLabel("Search");
		search_hint.setForeground(Color.green);
		search_hint.setFont(SIgnup_pnl.cn24);
		search_hint.setVisible(false);
		search_hint.setBounds(255,200,100,30);
		
		load=new JLabel();
		load.setIcon(new ImageIcon(load_URL));
		load.setBounds(350,130,61,61);
		load.setVisible(false);
		
		searchl=new JLabel();
		searchl.setIcon(new ImageIcon(searchURL));
		searchl.setBounds(260,150,64,64);
		searchl.addMouseListener(this);
		searchl.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent me)
			{
				search_hint.setVisible(true);
			}
			
			public void mouseExited(MouseEvent me)
			{
				search_hint.setVisible(false);
			}
			
			public void mouseReleased(MouseEvent me)
			{
				load.setVisible(true);
				par= (String) cb.getItemAt(cb.getSelectedIndex());
				engageMenu(par);
				cart.setVisible(true);
				list_icon.setVisible(true);
				
			}
		
		});
		
		result=new JLabel(regs);
		result.setFont(SIgnup_pnl.cn24);
		result.setForeground(new Color(128,0,0));
		result.setBounds(100,15,350,30);
		result.setVisible(false);
		
		Display.action_pnl.setBackground(Color.black);
		
		Display.action_pnl.add(cb);Display.action_pnl.add(regionl);Display.action_pnl.add(searchl);Display.action_pnl.add(search_hint);
		Display.action_pnl.add(load); Display.action_pnl.add(result);Display.action_pnl.add(logo);Display.action_pnl.add(cart);
		Display.action_pnl.add(cart_hint);Display.action_pnl.add(list_icon);Display.action_pnl.add(checkout);Display.action_pnl.add(checkout_hint);
		Display.action_pnl.add(close_icon);Display.action_pnl.add(close_hint);Display.action_pnl.add(header);
		
		new Hyderabad_pnl(Display.width,Display.height);
		new Karimnagar_pnl();
		new OrderList_Panel();
		new Checkout_panel();
	}
	@Override
	public void mouseClicked(MouseEvent me) {
		
		if(me.getComponent()==cart)
		{
			if(OrderList_Panel.order_sp.isVisible()) {
				OrderList_Panel.order_sp.setVisible(false);
				header.setVisible(false);
				close_icon.setVisible(false);
			}
			add_to_cart();
			blink("list");
			if(items_list.size()>=1&&(!(checkout.isVisible())))
				checkout.setVisible(true);
			if(items_list.size()>=1)	
				blink("checkout");
			else
				JOptionPane.showMessageDialog(Display.frame, "<html><p><B>No items Selected !!</p>"+
			"<p>Please Select items</B></p>"
			,"Alert",JOptionPane.PLAIN_MESSAGE,
						new ImageIcon(Display.error_URL));
		}
		else if(me.getComponent()==list_icon)
		{
			OrderList_Panel.take_Order(items_list.size());
			if(OrderList_Panel.order_sp.isVisible())
			{
				OrderList_Panel.order_sp.setVisible(false);
				OrderList_Panel.order_panel.setVisible(false);
				header.setVisible(false);
				close_icon.setVisible(false);
				OrderList_Panel.minus.setVisible(false);
			}
			else if(!(OrderList_Panel.order_sp.isVisible())&&items_list.size()>0)
			{
				OrderList_Panel.order_sp.setVisible(true);
				OrderList_Panel.order_panel.setVisible(true);
				header.setVisible(true);
				close_icon.setVisible(true);
			}
		}
		
		else if(me.getComponent()==checkout)
		{
			if(items_list.size()>=1)
			{
				OrderList_Panel.take_Order(items_list.size());
				Checkout_panel.listMenu(items_list.size(),OrderList_Panel.item_list);
				Checkout_panel.checkout_pnl.setVisible(true);
				Display.action_pnl.setVisible(false);
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(Display.frame, "<html><B>Iam affraid no items were Carted</B></hmtl>", "Alert",JOptionPane.PLAIN_MESSAGE,
						new ImageIcon(Display.error_URL));
			}
		}
		
		else if(me.getComponent()==close_icon) 
		{
			OrderList_Panel.order_sp.setVisible(false);
			OrderList_Panel.order_panel.setVisible(false);
			header.setVisible(false);
			close_icon.setVisible(false);
			close_hint.setVisible(false);
		}
			
	}
	private void blink(String blink_comp) {
		
		if(blink_comp.equals("list"))
		{
			ImageIcon icon_list=new ImageIcon(new ImageIcon(list_URL).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH));
			list_icon.setIcon(icon_list);
			Timer timer=new Timer(1000,new ActionListener() {
				public void actionPerformed(ActionEvent ae)
				{
					list_icon.setIcon(new ImageIcon(list_URL));
				}
			});
			timer.start();
			timer.setRepeats(false);
		}
		else if(blink_comp.contentEquals("checkout"))
		{
				i=0;
				t=new Timer(500,new ActionListener() {
					public void actionPerformed(ActionEvent ae)
					{
						
						i+=1;
						if(i==1||i==4) 
							checkout.setIcon(new ImageIcon(checkout25_URL));
						else if(i==2||i==5)
							checkout.setIcon(new ImageIcon(checkout75_URL));
						else if(i==3||i==6)
							checkout.setIcon(new ImageIcon(checkout_URL));
						if(i<=6)
							t.restart();
						else 
						{
							checkout.setIcon(new ImageIcon(checkout_URL));
						}
						
					}
				});
				t.start();
				
			
			
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent  me) {
		cb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		list_icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		close_icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		if(me.getComponent()==cart)
			cart_hint.setVisible(true);
		else if(me.getComponent()==close_icon)
		{
				close_icon.setIcon(new ImageIcon(close2_URL));
				close_hint.setVisible(true);
		}
		else if(me.getComponent()==checkout)
			checkout_hint.setVisible(true);
		
	}
	@Override
	public void mouseExited(MouseEvent me) {
		cb.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		searchl.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		if(me.getComponent()==cart)
			cart_hint.setVisible(false);
		if(me.getComponent()==close_icon) {
			close_hint.setVisible(false);
			close_icon.setIcon(new ImageIcon(close_URL));
			}
		else if(me.getComponent()==checkout)
			checkout_hint.setVisible(false);
	}
	@Override
	public void mousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}
	
	public void engageMenu(String reg) {
	//	reg=SIgnup_pnl.selected_region;
		if(reg.contentEquals("Hyderabad"))
		{
			
			if(Karimnagar_pnl.kar_sp.isVisible())
				Karimnagar_pnl.kar_sp.setVisible(false);
			if(!(Hyderabad_pnl.list_sp.isVisible())) 
			{
				Hyderabad_pnl.list_sp.setVisible(true);
				load.setVisible(false);
				result.setText(regs+cb.getSelectedItem().toString());
				result.setVisible(true);
			}
		}
		else if(reg.contentEquals("Karimnagar"))
		{
			if(Hyderabad_pnl.list_sp.isVisible())
				Hyderabad_pnl.list_sp.setVisible(false);
			
			Karimnagar_pnl.kar_sp.setVisible(true);
			result.setText(regs+cb.getSelectedItem().toString());
			result.setVisible(true);
			
		}
	}
	
	public void add_to_cart()
	{
		String place=cb.getSelectedItem().toString();
		if(place.contentEquals("Hyderabad"))
			Hyderabad_pnl.cartIt_Hyd();
		else if(place.contentEquals("Karimnagar"))
			Karimnagar_pnl.cartIT_Knr();
	/*	for(String temp:items_list)
		{
			System.out.println(temp);
		}*/
	}

}
