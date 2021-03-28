package travel.management.system;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Payment extends JFrame implements ActionListener{
	
	JButton b1,b2;
	
	public Payment() {
		
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setBounds(450,200,650,450);
		
		String filepath = "travel/management/system/icons/paytm.jpeg";
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(filepath));
		Image i2 = i1.getImage().getScaledInstance(650, 450, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(0,10,650,450);
		add(l1);
		
		b1 = new JButton("Pay");
		b1.setBounds(250,10,80,30);
		b1.setOpaque(true);
		b1.setBackground(new Color(133,193,233));
		b1.setForeground(Color.BLACK);
		b1.setBorder(BorderFactory.createBevelBorder(0));
		b1.addActionListener(this);
		l1.add(b1);
		
		b2 = new JButton("Back");
		b2.setBounds(350,10,80,30);
		b2.setOpaque(true);
		b2.setBackground(new Color(133,193,233));
		b2.setForeground(Color.BLACK);
		b2.setBorder(BorderFactory.createBevelBorder(0));
		b2.addActionListener(this);
		l1.add(b2);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == b1) {
			
			this.setVisible(false);
			new Paytm();
			
		}
		else if(ae.getSource() == b2) {
			this.setVisible(false);
		}
		
	}

	public static void main(String[] args) {
		new Payment();

	}

}
