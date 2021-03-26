package travel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener{
	
	JButton b1,b2,b3,b13,b14;
	String username;
	
	public Dashboard(String username) {
		
		this.username = username;
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBounds(0,0,1950,40);
		p1.setBackground(new Color(0,0,102));
		add(p1);
		
		JLabel l1 = new JLabel("Dashboard");
		l1.setBounds(10,10,100,20);
		l1.setFont(new Font("Tahoma",Font.BOLD,18));
		l1.setForeground(Color.WHITE);
		p1.add(l1);
		
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(0,40,200,1000);
		p2.setBackground(new Color(0,0,102));
		add(p2);
		
		b1 = new JButton("Add Personal Details");
//		b1.setMargin(new Insets(0,0,0,50));
		b1.setBackground(new Color(0,0,102));
		b1.setForeground(Color.WHITE);
		b1.setOpaque(true);
		b1.setBorder(BorderFactory.createBevelBorder(0));
		b1.setBounds(0,0,200,35);
		b1.setVisible(true);
		b1.addActionListener(this);
		p2.add(b1);
		
		b2 = new JButton("Update Personal Details");
		b2.setBackground(new Color(0,0,102));
		b2.setForeground(Color.WHITE);
		b2.setOpaque(true);
		b2.setBorder(BorderFactory.createBevelBorder(0));
		b2.setBounds(0,35,200,35);
		b2.addActionListener(this);
		p2.add(b2);

		
		b3 = new JButton("View Details");
		b3.setBackground(new Color(0,0,102));
		b3.setForeground(Color.WHITE);
		b3.setOpaque(true);
		b3.setBorder(BorderFactory.createBevelBorder(0));
		b3.setBounds(0,70,200,35);
		b3.addActionListener(this);
		p2.add(b3);

		
		JButton b4 = new JButton("Delete Personal Details");
		b4.setBackground(new Color(0,0,102));
		b4.setForeground(Color.WHITE);
		b4.setOpaque(true);
		b4.setBorder(BorderFactory.createBevelBorder(0));
		b4.setBounds(0,105,200,35);
		p2.add(b4);

		
		JButton b5 = new JButton("Check Package");
		b5.setBackground(new Color(0,0,102));
		b5.setForeground(Color.WHITE);
		b5.setOpaque(true);
		b5.setBorder(BorderFactory.createBevelBorder(0));
		b5.setBounds(0,140,200,35);
		p2.add(b5);
		
		JButton b6 = new JButton("Book Package");
		b6.setBackground(new Color(0,0,102));
		b6.setForeground(Color.WHITE);
		b6.setOpaque(true);
		b6.setBorder(BorderFactory.createBevelBorder(0));
		b6.setBounds(0,175,200,35);
		p2.add(b6);
		
		JButton b7 = new JButton("View Package");
		b7.setBackground(new Color(0,0,102));
		b7.setForeground(Color.WHITE);
		b7.setOpaque(true);
		b7.setBorder(BorderFactory.createBevelBorder(0));
		b7.setBounds(0,210,200,35);
		p2.add(b7);
		
		JButton b8 = new JButton("View Hotels");
		b8.setBackground(new Color(0,0,102));
		b8.setForeground(Color.WHITE);
		b8.setOpaque(true);
		b8.setBorder(BorderFactory.createBevelBorder(0));
		b8.setBounds(0,245,200,35);
		p2.add(b8);
		
		JButton b9 = new JButton("Book Hotel");
		b9.setBackground(new Color(0,0,102));
		b9.setForeground(Color.WHITE);
		b9.setOpaque(true);
		b9.setBorder(BorderFactory.createBevelBorder(0));
		b9.setBounds(0,280,200,35);
		p2.add(b9);
		
		JButton b10 = new JButton("View Booked Hotel");
		b10.setBackground(new Color(0,0,102));
		b10.setForeground(Color.WHITE);
		b10.setOpaque(true);
		b10.setBorder(BorderFactory.createBevelBorder(0));
		b10.setBounds(0,315,200,35);
		p2.add(b10);
		
		JButton b11 = new JButton("Destinations");
		b11.setBackground(new Color(0,0,102));
		b11.setForeground(Color.WHITE);
		b11.setOpaque(true);
		b11.setBorder(BorderFactory.createBevelBorder(0));
		b11.setBounds(0,350,200,35);
		p2.add(b11);
		
		JButton b12 = new JButton("Payment");
		b12.setBackground(new Color(0,0,102));
		b12.setForeground(Color.WHITE);
		b12.setOpaque(true);
		b12.setBorder(BorderFactory.createBevelBorder(0));
		b12.setBounds(0,385,200,35);
		p2.add(b12);
		
		b13 = new JButton("Calculator");
		b13.setBackground(new Color(0,0,102));
		b13.setForeground(Color.WHITE);
		b13.setOpaque(true);
		b13.setBorder(BorderFactory.createBevelBorder(0));
		b13.setBounds(0,420,200,35);
		b13.addActionListener(this);
		p2.add(b13);
		
		b14 = new JButton("Notepad");
		b14.setBackground(new Color(0,0,102));
		b14.setForeground(Color.WHITE);
		b14.setOpaque(true);
		b14.setBorder(BorderFactory.createBevelBorder(0));
		b14.setBounds(0,455,200,35);
		b14.addActionListener(this);
		p2.add(b14);
		
		JButton b15 = new JButton("About");
		b15.setBackground(new Color(0,0,102));
		b15.setForeground(Color.WHITE);
		b15.setOpaque(true);
		b15.setBorder(BorderFactory.createBevelBorder(0));
		b15.setBounds(0,490,200,35);
		p2.add(b15);
		
		String filepath = "travel/management/system/icons/home.jpg";
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(filepath));
		Image i2 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l2 = new JLabel(i3);
		l2.setBounds(0,10,1950,1000);
		add(l2);
		
		JLabel l3 = new JLabel("Travel And Tourism Management System");
		l3.setBounds(400,80,1000,50);
		l3.setFont(new Font("Tahoma",Font.PLAIN,40));
		l3.setForeground(Color.WHITE);
		l2.add(l3);
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == b1) {
			new AddCustomer(username);
		}
		else if(ae.getSource() == b2) {
			new UpdateCustomer(username);
		}
		else if(ae.getSource() == b3){
			new ViewCustomer(username);
		}
		else if(ae.getSource() == b13) {
			try {
				String[] path = {"open","/System/Applications/Calculator.app"} ;
				Runtime.getRuntime().exec(path, null, new File("/System/Applications/"));
			}catch(Exception e) {}
			
		}else if(ae.getSource() == b14) {
			try {
				String[] path = {"open","/System/Applications/TextEdit.app"};
				Runtime.getRuntime().exec(path, null, new File("/System/Applications/"));
			}catch(Exception e) {}
		}
		
	}

	public static void main(String[] args) {
		
		new Dashboard("");

	}

}
