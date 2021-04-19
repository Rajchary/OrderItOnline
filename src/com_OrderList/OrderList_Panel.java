package com_OrderList;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com_Signup_Components.SIgnup_pnl;
import com_action_Components.Action_pnl;
import com_display.Display;

public class OrderList_Panel implements MouseListener{

	public  static JLabel i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,minus;
	
	public static JLabel[] item_list=new JLabel[] {i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15};
	
	static OrderList_Panel op=new OrderList_Panel();
	
	public static JPanel order_panel;
	public static JScrollPane order_sp;
	private static int i=0,ih=0, j,index=0;
	public OrderList_Panel()
	{
		order_panel=new JPanel();
		order_panel.setPreferredSize(new Dimension(300,250));
		order_panel.setBackground(Color.darkGray);
		order_panel.setLayout(null);
		order_panel.setBorder(BorderFactory.createLineBorder(Color.black,3));
		
		minus=new JLabel();
		minus.setIcon(new ImageIcon(Display.minus_URL));
		minus.setBounds(200,10,30,30);
		minus.addMouseListener(this);
		
		order_sp=new JScrollPane(order_panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		order_sp.setBounds(870,105,300,150);
		order_sp.setVisible(false);
		
		order_panel.add(minus);
		
		Display.frame.add(order_sp);
	}
	public static void take_Order(int n)
	{
		if(n==0)
		{
			JOptionPane.showMessageDialog(Display.frame, "No items Selected !!","Alert",JOptionPane.PLAIN_MESSAGE,
					new ImageIcon(Display.error_URL));
			closeMenu(true);
		}
			
		else
		{
			for(JLabel temp:item_list)
			{
				if(i<n)
				{
					temp=new JLabel();
					temp.setText(Action_pnl.items_list.get(i).toString());
					temp.setBounds(0,ih,200,30);
					temp.setForeground(Color.white);
					temp.setFont(SIgnup_pnl.cm20);
					temp.setVisible(true);
					item_list[i]=temp;
					item_list[i].addMouseListener((MouseListener) op);
					order_panel.add(item_list[i]);
					ih+=30;
					i++;
				}
				
				else
				{
					break;
				}
					
			}
		}
	}
	public void intiateRemoveDialog(Component component)
	{
		for(j=0;j<item_list.length;j++)
		{
			if(component==item_list[j])
			{
				minus.setBounds(200,item_list[j].getBounds().y,30,30);
				minus.setVisible(true);
				index=j;
				break;
			}
		}
	}
	
	public static void closeMenu(boolean close)
	{
		if(close)
		{
			Action_pnl.header.setVisible(false);
			Action_pnl.close_icon.setVisible(false);
			Action_pnl.close_hint.setVisible(false);
			order_panel.setVisible(false);
			order_sp.setVisible(false);
			minus.setVisible(false);
		}
		else
		{
			order_panel.setVisible(true);
			order_sp.setVisible(true);
			Action_pnl.header.setVisible(true);
			Action_pnl.close_icon.setVisible(true);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent me) {
		int k=0;
		if(me.getComponent()==minus)
		{
			if(index==0)
				Action_pnl.items_list.remove(0);
			else
				Action_pnl.items_list.remove(index);
			closeMenu(true);
			i=0;
			ih=0;
			while(k<=Action_pnl.items_list.size())
			{
				item_list[k].setText("");
				item_list[k].setVisible(false);
				k+=1;
			}
			take_Order(Action_pnl.items_list.size());
		}
	}
	@Override
	public void mouseEntered(MouseEvent me) {
		intiateRemoveDialog(me.getComponent());
		
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

	}
