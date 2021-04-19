package checkout;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com_Signup_Components.SIgnup_pnl;
import com_display.Display;

public class Checkout_panel implements MouseListener{

	public static JPanel checkout_pnl;
	private String back_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\check_back.jpg";
	private String done_URL="C:\\Users\\lenovo\\eclipse-workspace\\where to go\\img_res\\done.png";
	private ImageIcon back_icon=new ImageIcon(new ImageIcon(back_URL).getImage().getScaledInstance(Display.width,Display.height,Image.SCALE_SMOOTH));
	private static JLabel item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15;
	private static JLabel[] list_items= {item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15};
	private static int i=0,ih=150;
	private int n=0;
	private static JLabel back,done;
	
	public Checkout_panel()
	{
		back=new JLabel();
		back.setIcon(back_icon);
		back.setBounds(0,0,Display.width,Display.height);
		
		done=new JLabel();
		done.setIcon(new ImageIcon(done_URL));
		done.setBounds(500,200,32,32);
		done.addMouseListener(this);
		
		checkout_pnl=new JPanel();
		checkout_pnl.setPreferredSize(new Dimension(Display.width,Display.height));
		checkout_pnl.setLayout(null);
		checkout_pnl.setBounds(0,0,Display.width,Display.height);
		checkout_pnl.setVisible(false);
		
	//	checkout_pnl.add(back);
		
		
		Display.frame.add(checkout_pnl);
		
	}
	
	public static void listMenu(int n,JLabel[] order_list)
	{
		if(i>=1)
		{
			for(int k=0;k<i;k++)
			{
				list_items[k].setText("");
				list_items[k].setVisible(false);
			}
			i=0;
			ih=150;
		}
			
		
		for(JLabel temp:order_list)
		{
			if(i<n)
			{
				list_items[i]=new JLabel();
				list_items[i].setText(temp.getText());
				list_items[i].setForeground(Color.black);
				list_items[i].setFont(SIgnup_pnl.cm20);
				list_items[i].setBounds(100,ih,200,30);
				list_items[i].setVisible(true);
				checkout_pnl.add(list_items[i]);
				ih+=30;
				i++;
			}
		}
		checkout_pnl.add(done);
		checkout_pnl.add(back);
		
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		if(me.getComponent()==done)
		{
			Display.action_pnl.setVisible(true);
			Checkout_panel.checkout_pnl.setVisible(false);
		}
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		done.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}
}
