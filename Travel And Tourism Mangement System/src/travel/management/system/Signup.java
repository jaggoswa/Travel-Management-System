package travel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Signup extends JFrame implements ActionListener{
	
	JButton b1,b2;
	
	Signup(){
		
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setBounds(300,200,800,350);
		
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBounds(0,0,450,400);
		p1.setBackground(new Color(133,193,233));
		add(p1);
		
		JLabel l1 = new JLabel("Username");
		l1.setBounds(50,20,80,20);
		l1.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(l1);
		
		JTextField t1 = new JTextField();
		t1.setBounds(200,20,180,20);
		t1.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t1);
		
		JLabel l2 = new JLabel("Name");
		l2.setBounds(50,60,80,20);
		l2.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(l2);
		
		JTextField t2 = new JTextField();
		t2.setBounds(200,60,180,20);
		t2.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t2);
		
		JLabel l3 = new JLabel("Password");
		l3.setBounds(50,100,80,20);
		l3.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(l3);
		
		JTextField t3 = new JTextField();
		t3.setBounds(200,100,180,20);
		t3.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t3);
		
		JLabel l4 = new JLabel("Security Question");
		l4.setBounds(50,140,150,20);
		l4.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(l4);
		
		Choice c1 = new Choice();
		c1.add("Your favourite drama character?");
		c1.add("Your pet name?");
		c1.add("Your birth city?");
		c1.add("Your lucky number?");
		c1.setBounds(200, 140, 180, 20);
		p1.add(c1);
		
		JLabel l5 = new JLabel("Answer");
		l5.setBounds(50,180,80,20);
		l5.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(l5);
		
		JTextField t4 = new JTextField();
		t4.setBounds(200,180,180,20);
		t4.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t4);
		
		b1 = new JButton("Create");
		b1.setBounds(100,250,100,30);
		b1.setFont(new Font("Tahoma",Font.BOLD,14));
		b1.setOpaque(true);
		b1.setBackground(Color.WHITE);
		b1.setForeground(new Color(133,193,233));
		b1.setBorder(BorderFactory.createLineBorder(new Color(200,200,200)));
		b1.addActionListener(this);
		p1.add(b1);
		
		b2 = new JButton("Back");
		b2.setBounds(250,250,100,30);
		b2.setFont(new Font("Tahoma",Font.BOLD,14));
		b2.setOpaque(true);
		b2.setBackground(Color.WHITE);
		b2.setBorder(BorderFactory.createEmptyBorder());
		b2.setForeground(new Color(133,193,233));
		b2.setBorder(BorderFactory.createLineBorder(new Color(200,200,200)));
		b2.addActionListener(this);
		p1.add(b2);
		
		JPanel p2 = new JPanel();
		p2.setBounds(450,0,350,400);
		p2.setLayout(null);
		add(p2);
		
		String filepath = "travel/management/system/icons/signup.png";
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(filepath));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l6 = new JLabel(i3);
		l6.setBounds(70,30,200,200);
		p2.add(l6);
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == b1) {
			
		}
		else if(ae.getSource() == b2) {
			new Login().setVisible(true);
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		new Signup();

	}

}
