package Sub_Action_hyd;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;

import Action_Sub_Karimnagar.Karimnagar_pnl;
import com_Signup_Components.SIgnup_pnl;
import com_action_Components.Action_pnl;
import com_display.Display;

public class Hyderabad_pnl implements MouseListener {
	private int width,height;
	
	
	public static JPanel list;
	
	public static JScrollPane list_sp;
	
	
	private JLabel rest_logo1,rest_name1,menu1,select_hint;
	private JLabel bawarchi_logo,menu2,name2;
	private JLabel mcdonalds_logo,mc_menu,mc_name;
	private JLabel golconda_logo,golconda_menu,golconda_name;
	private JLabel more_logo,more_menu,more_name;
	private JLabel dmart_logo,dmart_name,dmart_menu;
	private JLabel spencers_logo,spencers_menu,spencers_name;
	private JLabel reliance_logo,reliance_name,reliance_menu;
	
	private String rest_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\para.png";
	public static String menu_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\menu.png";
	private String bawarchi_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\bawarchi.png";
	private String mcdonalds_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\mcdonalds.png";
	private String golconda_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\veg_logo.png";
	private String spencers_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\spencers2.png";
	
	public static String more_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\more.png";
	public static String dmart_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\dmart_logo.png";
	public static String reliance_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\reliance_fresh.png";
	
	String bawarchi_list[]= {"None","Chicken Biryani","Mutton Biryani","Grilled Chicken","Chilli Chicken","Fish Curry"};
	String mcdonalds_list[]= {"None","Mexican McAlooTikki Burger","Chicken Kebab Burger","Masala Wedges","Chicken McNuggets","Cappuccino (S)",};
	String golconda_list[]= {"None","Phirni","Qubani Ka Meetha","Mirchi Ka Salan","Special Dosha","Pesarattu Dosa","Lukhmi","Nihari"};
	String reliance_list[]= {"None","Sugar","Dal","Whaet Flour","Cool Drinks"};
	String dmart_list[]= {"None","Sugar","Dal","Whaet Flour","Cool Drinks"};
	String spencers_list[]= {"None","Sugar","Dal","Whaet Flour","Cool Drinks"};
	String more_list[]= {"None","Sugar","Dal","Cheese","CoolDrinks","Wheat Flour"};
	
	private static JComboBox cb1;
	private static JComboBox bawarchi_cb;
	private static JComboBox mcdonalds_cb;
	private static JComboBox golconda_cb;

	private static JComboBox more_cb,dmart_cb,spencers_cb,reliance_cb;
	private JComboBox[] combo_list=new JComboBox[] {};
	
	private int lh=50;
	private int mh=90;
	private int ch=80;
	public Hyderabad_pnl(int width ,int height)
	{
		this.width=width;
		this.height=(int)(height*2);

		int heightp=(int)(height*0.65);
		
		list=new JPanel();
		list.setPreferredSize(new Dimension(width,(int)(height*2.35)));
		list.setBackground(Color.black);
		
		list_sp=new JScrollPane(list,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		list_sp.setBounds(0,(int)(height*0.35),width,heightp);
	//	list_sp.setVisible(true);
		
		list.setLayout(null);
		list_sp.setVisible(false);
		
		rest_logo1=new JLabel();
		rest_logo1.setIcon(new ImageIcon(rest_URL));
		rest_logo1.setBounds(20,lh,171,61);
		rest_logo1.addMouseListener(this);
		
		rest_name1=new JLabel("<html><b><p>New PARADISE</p><p> Restaurant</p></b></html>");
		rest_name1.setForeground(new Color(255,0,102));
		rest_name1.setBounds(200,lh,150,70);
		rest_name1.setFont(SIgnup_pnl.cm20);
		lh+=200;
		
		menu1=new JLabel();
		menu1.setIcon(new ImageIcon(menu_URL));
		menu1.setBounds(400,mh,61,61);
		menu1.addMouseListener(new MouseAdapter() {
			public void maouseClicked(MouseEvent me)
			{
				cb1.setVisible(true);
				System.out.println("Executed");
			}
		});
		menu1.addMouseListener(this);
		menu1.setVisible(true);
		mh+=200;
		
		select_hint=new JLabel("<html><p>Select items</p><p>to your Wishlist</p></html>");
		select_hint.setForeground(new Color(0,102,255));
		select_hint.setFont(SIgnup_pnl.cm20);
		select_hint.setBounds(400,20,300,60);
	
		
		String rest1_list[]= {"None","Hyderabadi Biryani","Haleem","Kebabs","Dum Pukht"};
		
		cb1=new JComboBox(rest1_list);
		cb1.setBounds(500,ch,200,30);
		cb1.addMouseListener(this);
		cb1.setVisible(false);
		ch+=200;
		
		bawarchi_logo=new JLabel();
		bawarchi_logo.setIcon(new ImageIcon(bawarchi_URL));
		bawarchi_logo.setBounds(20,lh,111,86);
		bawarchi_logo.addMouseListener(this);
		
		name2=new JLabel("Bawarchi");
		name2.setFont(SIgnup_pnl.cm20);
		name2.setForeground(new Color(255,0,102));
		name2.setBounds(200,lh,150,70);
		lh+=200;
		
		menu2=new JLabel();
		menu2.setIcon(new ImageIcon(menu_URL));
		menu2.setBounds(400,mh,61,61);
		menu2.setVisible(true);
		menu2.addMouseListener(this);
		mh+=200;
		
		bawarchi_cb=new JComboBox(bawarchi_list);
		bawarchi_cb.setBounds(500,ch,200,30);
		bawarchi_cb.setVisible(false);
		bawarchi_cb.addMouseListener(this);
		ch+=200;
		
		mcdonalds_logo=new JLabel();
		mcdonalds_logo.setIcon(new ImageIcon(mcdonalds_URL));
		mcdonalds_logo.setBounds(20,lh,112,80);
		mcdonalds_logo.addMouseListener(this);
		
		mc_name=new JLabel("<html><p>McDonalds</p></html>");
		mc_name.setFont(SIgnup_pnl.cm20);
		mc_name.setForeground(new Color(255,0,102));
		mc_name.setBounds(200, lh, 150, 70);
		lh+=200;
		
		mc_menu=new JLabel();
		mc_menu.setIcon(new ImageIcon(menu_URL));
		mc_menu.addMouseListener(this);
		mc_menu.setBounds(400,mh,61,61);
		mh+=200;
		
		mcdonalds_cb=new JComboBox(mcdonalds_list);
		mcdonalds_cb.setBounds(500,ch,200,30);
		mcdonalds_cb.addMouseListener(this);
		mcdonalds_cb.setVisible(false);
		ch+=200;
		
		golconda_logo=new JLabel();
		golconda_logo.setIcon(new ImageIcon(golconda_URL));
		golconda_logo.setBounds(20,lh,112,32);
		golconda_logo.addMouseListener(this);
		
		golconda_name=new JLabel("<html><p>    Golconda</p><p>Aroma of Nizams</p>");
		golconda_name.setFont(SIgnup_pnl.cm20);
		golconda_name.setForeground(new Color(255,0,102));
		golconda_name.setBounds(200, lh, 200, 100);
		lh+=200;
		
		golconda_menu=new JLabel();
		golconda_menu.setIcon(new ImageIcon(menu_URL));
		golconda_menu.setBounds(400, mh, 61, 61);
		golconda_menu.addMouseListener(this);
		mh+=200;
		
		golconda_cb=new JComboBox(golconda_list);
		golconda_cb.setBounds(500,ch,200,30);
		golconda_cb.addMouseListener(this);
		golconda_cb.setVisible(false);
		ch+=200;
		
		more_logo=new JLabel();
		more_logo.setIcon(new ImageIcon(more_URL));
		more_logo.setBounds(20,lh,150,79);
		more_logo.addMouseListener(this);

		more_name=new JLabel("<html><p>More</p><p>Super Market</p>");
		more_name.setForeground(Karimnagar_pnl.name_Color);
		more_name.setFont(SIgnup_pnl.cn24);
		more_name.setBounds(200,lh,200,150);
		lh+=200;
		
		more_menu=new JLabel();
		more_menu.setIcon(new ImageIcon(menu_URL));
		more_menu.setBounds(400,mh,64,64);
		more_menu.addMouseListener(this);
		mh+=200;
		
		more_cb=new JComboBox(more_list);
		more_cb.setBounds(500,ch,200,30);
		more_cb.addMouseListener(this);
		more_cb.addMouseListener(this);
		more_cb.setVisible(false);
		ch+=200;
		
		spencers_logo=new JLabel();
		spencers_logo.setIcon(new ImageIcon(spencers_URL));
		spencers_logo.addMouseListener(this);
		spencers_logo.setBounds(20,mh,150,83);
		
		spencers_name=new JLabel("Spencer's");
		spencers_name.setFont(SIgnup_pnl.cn24);
		spencers_name.setForeground(Karimnagar_pnl.name_Color);
		spencers_name.setBounds(200,lh,200,100);
		lh+=200;
		
		spencers_menu=new JLabel();
		spencers_menu.setIcon(new ImageIcon(menu_URL));
		spencers_menu.addMouseListener(this);
		spencers_menu.setBounds(400,mh,64,64);
		mh+=200;
		
		spencers_cb=new JComboBox(spencers_list);
		spencers_cb.addMouseListener(this);
		spencers_cb.setVisible(false);
		spencers_cb.setBounds(500,ch,200,30);
		ch+=200;
		
		reliance_logo=new JLabel();
		reliance_logo.setIcon(new ImageIcon(reliance_URL));
		reliance_logo.addMouseListener(this);
		reliance_logo.setBounds(20,lh,170,100);
		
		reliance_name=new JLabel("Reliance Fresh");
		reliance_name.setFont(SIgnup_pnl.cn24);
		reliance_name.setForeground(Karimnagar_pnl.name_Color);
		reliance_name.setBounds(200,lh,200,100);
		lh+=200;
		
		reliance_menu=new JLabel();
		reliance_menu.setIcon(new ImageIcon(menu_URL));
		reliance_menu.setBounds(400,mh,64,64);
		reliance_menu.addMouseListener(this);
		mh+=200;
		
		reliance_cb=new JComboBox(reliance_list);
		reliance_cb.addMouseListener(this);
		reliance_cb.setVisible(false);
		reliance_cb.setBounds(500,ch,200,30);
		ch+=200;
		
		dmart_logo=new JLabel();
		dmart_logo.setIcon(new ImageIcon(dmart_URL));
		dmart_logo.addMouseListener(this);
		dmart_logo.setBounds(20, lh, 150, 50);
		
		dmart_name=new JLabel("Dmart");
		dmart_name.setFont(SIgnup_pnl.cn24);
		dmart_name.setForeground(Karimnagar_pnl.name_Color);
		dmart_name.setBounds(200,lh,200,50);
		lh+=200;
		
		dmart_menu=new JLabel();
		dmart_menu.setIcon(new ImageIcon(menu_URL));
		dmart_menu.addMouseListener(this);
		dmart_menu.setBounds(400,mh,64,64);
		mh+=200;
		
		dmart_cb=new JComboBox(dmart_list);
		dmart_cb.addMouseListener(this);
		dmart_cb.setVisible(false);
		dmart_cb.setBounds(500,ch,200,30);
		
		list.add(rest_logo1);list.add(rest_name1);list.add(menu1);list.add(cb1);list.add(select_hint);
		list.add(bawarchi_logo);list.add(name2);list.add(menu2);list.add(bawarchi_cb);
		list.add(mcdonalds_logo);list.add(mc_name);list.add(mc_menu);list.add(mcdonalds_cb);
		list.add(golconda_logo);list.add(golconda_name);list.add(golconda_menu);list.add(golconda_cb);
		list.add(more_logo);list.add(more_name);list.add(more_menu);list.add(more_cb);
		list.add(spencers_logo);list.add(spencers_name);list.add(spencers_menu);list.add(spencers_cb);
		list.add(reliance_logo);list.add(reliance_name);list.add(reliance_menu);list.add(reliance_cb);
		list.add(dmart_logo);list.add(dmart_name);list.add(dmart_menu);list.add(dmart_cb);
		
		Display.action_pnl.add(list_sp);
		combo_list=new JComboBox[] {cb1,bawarchi_cb,mcdonalds_cb,golconda_cb,more_cb,dmart_cb,reliance_cb,spencers_cb};
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {	
		if(e.getComponent()==menu1)
		{
			if(cb1.isVisible())
				cb1.setVisible(false);
			else
				cb1.setVisible(true);
		}
		else if(e.getComponent()==menu2)
		{
			if(bawarchi_cb.isVisible())
			{
				bawarchi_cb.setVisible(false);
			}
			else
				bawarchi_cb.setVisible(true);
		}
		else if(e.getComponent()==mc_menu)
		{
			if(mcdonalds_cb.isVisible())
				mcdonalds_cb.setVisible(false);
			else
				mcdonalds_cb.setVisible(true);
		}
		else if(e.getComponent()==golconda_menu)
		{
			if(golconda_cb.isVisible())
				golconda_cb.setVisible(false);
			else
				golconda_cb.setVisible(true);
		}
		else if(e.getComponent()==more_menu)
		{
			if(more_cb.isVisible())
				more_cb.setVisible(false);
			else
				more_cb.setVisible(true);
		}
		else if(e.getComponent()==spencers_menu)
		{
			if(spencers_cb.isVisible())
				spencers_cb.setVisible(false);
			else
				spencers_cb.setVisible(true);
		}
		else if(e.getComponent()==reliance_menu)
		{
			if(reliance_cb.isVisible())
				reliance_cb.setVisible(false);
			else
				reliance_cb.setVisible(true);
		}
		else if(e.getComponent()==dmart_menu)
		{
			if(dmart_cb.isVisible())
				dmart_cb.setVisible(false);
			else
				dmart_cb.setVisible(true);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		menu1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rest_logo1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cb1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		menu2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bawarchi_logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bawarchi_cb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		mcdonalds_logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mc_menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mcdonalds_cb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		golconda_logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		golconda_menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		golconda_cb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		more_logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		more_menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		more_cb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		spencers_logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		spencers_menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		spencers_cb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		reliance_logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reliance_menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reliance_cb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		dmart_logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dmart_menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dmart_cb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		if(anyComboBox(e.getComponent()))
		{
			Action_pnl.cart.setIcon(Action_pnl.cart45);
			Timer t=new Timer(1000,new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent ae) {
							Action_pnl.cart.setIcon(Action_pnl.cartI);
					}
				});
				t.start();
				t.setRepeats(false);
			
		}
	}
	public boolean anyComboBox(Component component)
	{
		for(JComboBox temp:combo_list)
		{
			if(temp==component)
				return true;
			else
				continue;
		}	
		return false;
	}

	@Override
	public void mouseExited(MouseEvent e) {
	//	menu1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}
	public static void cartIt_Hyd()
	{
		String item="";
		if(!(Action_pnl.items_list.size()<=15))
		{
			JOptionPane.showMessageDialog(Display.frame,"<html><p>You have reached the maximum capacity</p>"+
					"<p>of cart.Please proceed to checkout</p><p>Or you can replace the items selected</p>");
			System.out.println(Action_pnl.items_list.size());
		}
		else
		{
			if(!(cb1.getSelectedItem().toString().equals("None"))&&(Action_pnl.items_list.size()<=15))
			{
				if(Action_pnl.items_list.contains(cb1.getSelectedItem().toString()))
				{
					JOptionPane.showMessageDialog(Display.frame,"<html><p>You have already added</p><b>"+cb1.getSelectedItem().toString()
				+"</b><p> to your cart</p>"+
				"<p>You can select quantity @ Checkout</p>","Alert",JOptionPane.PLAIN_MESSAGE,new ImageIcon(Display.error_URL));
				}
				else 
				{
					item=cb1.getSelectedItem().toString();
					Action_pnl.items_list.add(item);
				}
				cb1.setSelectedIndex(0);
				
			}
			if(!(bawarchi_cb.getSelectedItem().toString().equals("None"))&&(Action_pnl.items_list.size()<=15))
			{
				if(Action_pnl.items_list.contains(bawarchi_cb.getSelectedItem().toString()))
				{
					JOptionPane.showMessageDialog(Display.frame,"<html><p>You have already added</p><b>"+bawarchi_cb.getSelectedItem().toString()
				+"</b><p> to your cart</p>"+
				"<p>You can select quantity @ Checkout</p>","Alert",JOptionPane.PLAIN_MESSAGE,new ImageIcon(Display.error_URL));
				}
				else {
				item=bawarchi_cb.getSelectedItem().toString();
				Action_pnl.items_list.add(item);}
				bawarchi_cb.setSelectedIndex(0);
			}
			if(!(mcdonalds_cb.getSelectedItem().toString().equals("None"))&&(Action_pnl.items_list.size()<=15))
			{
				item=mcdonalds_cb.getSelectedItem().toString();
				Action_pnl.items_list.add(item);
				mcdonalds_cb.setSelectedIndex(0);
			}
			if(!(golconda_cb.getSelectedItem().toString().equals("None"))&&(Action_pnl.items_list.size()<=15))
			{
				item=golconda_cb.getSelectedItem().toString();
				Action_pnl.items_list.add(item);
				golconda_cb.setSelectedIndex(0);
			}
			if(!(more_cb.getSelectedItem().toString().contentEquals("None"))&&(Action_pnl.items_list.size()<=15))
			{
				item=more_cb.getSelectedItem().toString();
				Action_pnl.items_list.add(item);
				more_cb.setSelectedIndex(0);
			}
			if(!(dmart_cb.getSelectedItem().toString().equals("None"))&&(Action_pnl.items_list.size()<=15))
			{
				item=dmart_cb.getSelectedItem().toString();
				Action_pnl.items_list.add(item);
				dmart_cb.setSelectedIndex(0);
			}
			if(!(reliance_cb.getSelectedItem().equals("None"))&&(Action_pnl.items_list.size()<=15))
			{
				item=reliance_cb.getSelectedItem().toString();
				Action_pnl.items_list.add(item);
				dmart_cb.setSelectedIndex(0);
			}
			if(!(Action_pnl.items_list.size()<=15))
			{
				JOptionPane.showMessageDialog(Display.frame,"<html><p>You have reached the maximum capacity</p>"+
						"<p>of cart.Please proceed to checkout</p><p>Or you can replace the items selected</p>");
				System.out.println(Action_pnl.items_list.size());
			}
	    }
		
	}
	
}
