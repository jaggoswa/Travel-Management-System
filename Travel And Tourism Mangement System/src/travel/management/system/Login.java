package travel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	
	JButton b1,b2,b3;
	
	Login(){
		setLayout(null); //Default - BorderLayout
		getContentPane().setBackground(Color.white);
		setBounds(300,200,700,350);
		
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBounds(0, 0, 350, 350);
		p1.setBackground(new Color(131,193,233));
		add(p1);
		
		String filepath = "travel/management/system/icons/login.png";
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(filepath));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(70, 50, 200, 200);
		p1.add(l1);
		
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(350,20,350,280);
		add(p2);
		
		JLabel l2 = new JLabel("Username");
		l2.setBounds(50,20,100,20);
		l2.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
		p2.add(l2);
		
		JTextField t1 = new JTextField();
		t1.setBounds(50,50,250,25);
		t1.setBorder(BorderFactory.createEmptyBorder());
		p2.add(t1);
		
		JLabel l3 = new JLabel("Password");
		l3.setBounds(50,90,100,20);
		l3.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
		p2.add(l3);
		
		JPasswordField t2 = new JPasswordField();
		t2.setBounds(50,120,250,25);
		t2.setBorder(BorderFactory.createEmptyBorder());
		p2.add(t2);
		
		b1 = new JButton("Login");
		b1.setBounds(50,170,110,30);
		b1.setOpaque(true);
		b1.setBackground(new Color(133,193,233));
		b1.setForeground(Color.WHITE);
		b1.setBorder(BorderFactory.createEmptyBorder());
		b1.addActionListener(this);
		p2.add(b1);
		
		b2 = new JButton("Sign up");
		b2.setBounds(190,170,110,30);
		b2.setOpaque(true);
		b2.setBackground(Color.WHITE);
		b2.setForeground(new Color(133,193,233));
		b2.setBorder(BorderFactory.createLineBorder(new Color(133,193,233)));
		b2.addActionListener(this);
		p2.add(b2);
		
		JLabel l4 = new JLabel("Trouble in login?");
		l4.setBounds(50,220,120,30);
		l4.setForeground(Color.RED);
		p2.add(l4);
		
		b3 = new JButton("Forgot Password");
		b3.setBounds(170,220,130,30);
		b3.setOpaque(true);
		b3.setBackground(Color.WHITE);
		b3.setForeground(new Color(133,193,233));
		b3.setBorder(BorderFactory.createLineBorder(new Color(133,193,233)));
		b3.addActionListener(this);
		p2.add(b3);
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == b1) {
			
		}
		else if(ae.getSource() == b2) {
			new Signup().setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource() == b3) {
			
		}
		
	}

	public static void main(String[] args) {
		new Login();

	}

}
