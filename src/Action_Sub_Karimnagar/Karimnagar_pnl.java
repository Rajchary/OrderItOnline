package Action_Sub_Karimnagar;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;

import Sub_Action_hyd.Hyderabad_pnl;
import com_Signup_Components.SIgnup_pnl;
import com_action_Components.Action_pnl;
import com_display.Display;

public class Karimnagar_pnl implements MouseListener{
	
	public static JPanel kar;
	public static JScrollPane kar_sp;
	int clicked=0;
	int i=0;
	private int width,height;
	
	private String bar_list[]= {"None","King Fisher","Royal Stag","Budwiser","Tuborg","Blender Spride"};
	private String geetha_list[]= {"None","Idli","Dosha","Bonda","Veg Meals","Upma","Full Meals"};
	private String more_list[]= {"None"};
	private String reliance_list[]= {"None"};
	private String dmart_list[]= {"None"};
	
	private String menu_URL=Hyderabad_pnl.menu_URL;
	private String geetha_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\geetha.png";
	private String bar_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\bar.png";
	
	private JLabel geetha_logo,geetha_name,geetha_menu;
	private JLabel bar_logo,bar_menu,bar_name;
	private JLabel more_logo,more_name,more_menu;
	private JLabel dmart_logo,dmart_name,dmart_menu;
	private JLabel reliance_logo,reliance_name,reliance_menu;
	
	private static JComboBox bar_cb;
	private static JComboBox geetha_cb;
	private static JComboBox more_cb;
	private static JComboBox dmart_cb;
	private static JComboBox reliance_cb;
	
	private JComboBox[] combo_list=new JComboBox[] {};
	
	public static Color name_Color=new Color(255,0,102);
	
	private int ln_h=50;
	private int mh=90;
	private int ch=80;
	public Karimnagar_pnl()
	{
		width=Display.width;
		height=Display.height;
		int heightp=(int)(height*0.75);
		
		kar=new JPanel();
		kar.setPreferredSize(new Dimension(width,(int)(height*2)));
		kar.setLayout(null);
		kar.setBackground(Color.black);
		
		kar_sp=new JScrollPane(kar,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		kar_sp.setBounds(0,(int)(height*0.35),width,heightp);
		kar_sp.setVisible(false);
		
		geetha_logo=new JLabel();
		geetha_logo.setIcon(new ImageIcon(geetha_URL));
		geetha_logo.setBounds(30,ln_h,112,84);
		geetha_logo.addMouseListener(this);
		
		geetha_name=new JLabel("<html><p>Geetha Bhavan</p></html>");
		geetha_name.setForeground(new Color(255,0,102));
		geetha_name.setFont(SIgnup_pnl.cm20);
		geetha_name.setBounds(200,ln_h,150,50);
		ln_h+=200;
		
		geetha_menu=new JLabel();
		geetha_menu.setIcon(new ImageIcon(menu_URL));
		geetha_menu.setBounds(400,mh,61,61);
		geetha_menu.addMouseListener(this);
		mh+=200;
		
		geetha_cb=new JComboBox(geetha_list);
		geetha_cb.setBounds(500,ch,200,30);
		geetha_cb.addMouseListener(this);
		geetha_cb.setVisible(false);
		ch+=200;
		
		bar_logo=new JLabel();
		bar_logo.setIcon(new ImageIcon(bar_URL));
		bar_logo.setBounds(30,200,112,163);
		bar_logo.setForeground(Color.black);
		bar_logo.addMouseListener(this);

		bar_name=new JLabel("Rocks On Bar");
		bar_name.setFont(SIgnup_pnl.cm20);
		bar_name.setForeground(name_Color);
		bar_name.setBounds(200,ln_h,150,50);
		ln_h+=200;
		
		bar_menu=new JLabel();
		bar_menu.setIcon(new ImageIcon(menu_URL));
		bar_menu.setBounds(400,mh,61,61);
		bar_menu.addMouseListener(this);
		mh+=200;
		
		bar_cb=new JComboBox(bar_list);
		bar_cb.addMouseListener(this);
		bar_cb.setVisible(false);
		bar_cb.setBounds(500,ch,200,30);
		ch+=200;
		
		more_logo=new JLabel();
		more_logo.setIcon(new ImageIcon(Hyderabad_pnl.more_URL));
		more_logo.addMouseListener(this);
		more_logo.setBounds(20,ln_h,150,79);
		
		more_name=new JLabel("<html><p>More</p><p>Super Market</p>");
		more_name.setFont(SIgnup_pnl.cn24);
		more_name.setForeground(name_Color);
		more_name.setBounds(200,ln_h,200,150);
		ln_h+=200;
		
		more_menu=new JLabel();
		more_menu.setIcon(new ImageIcon(menu_URL));
		more_menu.addMouseListener(this);
		more_menu.setBounds(400,mh,64,64);
		mh+=200;
		
		more_cb=new JComboBox(more_list);
		more_cb.addMouseListener(this);
		more_cb.setVisible(false);
		more_cb.setBounds(500,ch,200,30);
		ch+=200;
		
		dmart_logo=new JLabel();
		dmart_logo.setIcon(new ImageIcon(Hyderabad_pnl.dmart_URL));
		dmart_logo.addMouseListener(this);
		dmart_logo.setBounds(20,ln_h,150,50);
		
		dmart_name=new JLabel("Dmart");
		dmart_name.setFont(SIgnup_pnl.cn24);
		dmart_name.setForeground(name_Color);
		dmart_name.setBounds(200,ln_h,200,100);
		ln_h+=200;
		
		dmart_menu=new JLabel();
		dmart_menu.setIcon(new ImageIcon(menu_URL));
		dmart_menu.addMouseListener(this);
		dmart_menu.setBounds(400,mh,64,64);
		mh+=200;
		
		dmart_cb=new JComboBox(dmart_list);
		dmart_cb.addMouseListener(this);
		dmart_cb.setVisible(false);
		dmart_cb.setBounds(500,ch,200,30);
		ch+=200;
		
		reliance_logo=new JLabel();
		reliance_logo.setIcon(new ImageIcon(Hyderabad_pnl.reliance_URL));
		reliance_logo.addMouseListener(this);
		reliance_logo.setBounds(20,ln_h,170,100);
		
		reliance_name=new JLabel("Reliance Fresh");
		reliance_name.setFont(SIgnup_pnl.cn24);
		reliance_name.setForeground(name_Color);
		reliance_name.setBounds(200,ln_h,200,100);
		ln_h+=200;
		
		reliance_menu=new JLabel();
		reliance_menu.setIcon(new ImageIcon(menu_URL));
		reliance_menu.addMouseListener(this);
		reliance_menu.setBounds(400,mh,64,64);
		mh+=200;
		
		reliance_cb=new JComboBox(reliance_list);
		reliance_cb.addMouseListener(this);
		reliance_cb.setVisible(false);
		reliance_cb.setBounds(500,ch,200,30);
		ch+=200;
		
		kar.add(geetha_logo);kar.add(geetha_name);kar.add(geetha_menu);kar.add(geetha_cb);
		kar.add(bar_logo);kar.add(bar_name);kar.add(bar_cb);kar.add(bar_menu);
		kar.add(more_logo);kar.add(more_name);kar.add(more_menu);kar.add(more_cb);
		kar.add(dmart_logo);kar.add(dmart_name);kar.add(dmart_menu);kar.add(dmart_cb);
		kar.add(reliance_logo);kar.add(reliance_name);kar.add(reliance_menu);kar.add(reliance_cb);
		Display.action_pnl.add(kar_sp);
	
		combo_list=new JComboBox[] {bar_cb,geetha_cb,more_cb,dmart_cb,reliance_cb};
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		if(me.getComponent()==geetha_menu)
		{
			if(geetha_cb.isVisible())
				geetha_cb.setVisible(false);
			else
				geetha_cb.setVisible(true);
		}
		else if(me.getComponent()==bar_menu)
		{
			if(bar_cb.isVisible())
				bar_cb.setVisible(false);
			
			else
				bar_cb.setVisible(true);
		}
		else if(me.getComponent()==more_menu)
		{
			if(more_cb.isVisible())
				more_cb.setVisible(false);
			else
				more_cb.setVisible(true);
		}
		else if(me.getComponent()==dmart_menu)
		{
			if(dmart_cb.isVisible())
				dmart_cb.setVisible(false);
			else
				dmart_cb.setVisible(true);
		}
		else if(me.getComponent()==reliance_menu)
		{
			if(reliance_cb.isVisible())
				reliance_cb.setVisible(false);
			else
				reliance_cb.setVisible(true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		geetha_logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		geetha_menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		geetha_cb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		bar_logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bar_menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bar_cb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		more_logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		more_menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		more_cb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		dmart_logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dmart_menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dmart_cb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		reliance_logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reliance_menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reliance_cb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		if(anyComboBox(me.getComponent()))
		{
			Action_pnl.cart.setIcon(Action_pnl.cart45);
			Timer t=new Timer(1000,new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Action_pnl.cart.setIcon(Action_pnl.cartI);
				}
				
			});
			t.start();
			t.setRepeats(false);
		}
		
	}
	private boolean anyComboBox(Component component)
	{
		for(JComboBox temp:combo_list)
		{
			if(temp==component)
				return true;
			else
				continue;
		}
		return false;
	/**	if(component==geetha_cb||component==bar_cb||component==more_cb||component==dmart_cb||component==reliance_cb)
			return true;
		else
			return false;*/
	}

	@Override
	public void mouseExited(MouseEvent me) {


	}

	@Override
	public void mousePressed(MouseEvent me) {
		
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		
	}
	
	public static void cartIT_Knr()
	{
		String item="";
		if(!(Action_pnl.items_list.size()<=15))
		{
			JOptionPane.showMessageDialog(Display.frame,"<html><p>You have reached the maximum capacity</p>"+
					"<p>of cart.Please proceed to checkout</p><p>Or you can replace the items selected</p>","Error",JOptionPane.PLAIN_MESSAGE,
					new ImageIcon(Display.error_URL));
			System.out.println(Action_pnl.items_list.size());
		}
		else
		 {
			
			if(!(geetha_cb.getSelectedItem().toString().equals("None"))&&(Action_pnl.items_list.size()<=15))
			{	
				item=geetha_cb.getSelectedItem().toString();
				Action_pnl.items_list.add(item);
				geetha_cb.setSelectedIndex(0);
			}
			if(!(bar_cb.getSelectedItem().toString().equals("None"))&&(Action_pnl.items_list.size()<=15))
			{
				item=bar_cb.getSelectedItem().toString();
				Action_pnl.items_list.add(item);
				bar_cb.setSelectedIndex(0);
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
