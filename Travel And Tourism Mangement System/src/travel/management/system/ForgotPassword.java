package travel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class ForgotPassword extends JFrame implements ActionListener{
	
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2,b3;
	
	public ForgotPassword() {
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setBounds(300,200,800,350);
		
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBounds(20,20,440,285);
		add(p1);
		
		JLabel l1 = new JLabel("Username");
		l1.setFont(new Font("Tahoma",Font.BOLD,14));
		l1.setBounds(30,20,80,20);
		p1.add(l1);
		
		t1 = new JTextField();
		t1.setBounds(200,20,120,20);
		t1.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t1);
		
		b1 = new JButton("Search");
		b1.setBounds(340,20,80,25);
		b1.setFont(new Font("Tahoma",Font.BOLD,14));
		b1.setOpaque(true);
		b1.setBackground(new Color(105,105,105));
		b1.setForeground(Color.WHITE);
		b1.setBorder(BorderFactory.createEmptyBorder());
		b1.addActionListener(this);
		p1.add(b1);
		
		JLabel l2 = new JLabel("Name");
		l2.setFont(new Font("Tahoma",Font.BOLD,14));
		l2.setBounds(30,60,80,20);
		p1.add(l2);
		
		t2 = new JTextField();
		t2.setBounds(200,60,120,20);
		t2.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t2);
		
		JLabel l3 = new JLabel("Your Security Question");
		l3.setFont(new Font("Tahoma",Font.BOLD,14));
		l3.setBounds(30,100,180,20);
		p1.add(l3);
		
		t3 = new JTextField();
		t3.setBounds(200,100,200,20);
		t3.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t3);
		
		JLabel l4 = new JLabel("Answer");
		l4.setFont(new Font("Tahoma",Font.BOLD,14));
		l4.setBounds(30,140,80,20);
		p1.add(l4);
		
		t4 = new JTextField();
		t4.setBounds(200,140,120,20);
		t4.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t4);
		
		b2 = new JButton("Retrieve");
		b2.setBounds(340,140,80,25);
		b2.setFont(new Font("Tahoma",Font.BOLD,14));
		b2.setOpaque(true);
		b2.setBackground(new Color(105,105,105));
		b2.setForeground(Color.WHITE);
		b2.setBorder(BorderFactory.createEmptyBorder());
		b2.addActionListener(this);
		p1.add(b2);
		
		JLabel l5 = new JLabel("Password");
		l5.setFont(new Font("Tahoma",Font.BOLD,14));
		l5.setBounds(30,180,80,20);
		p1.add(l5);
		
		t5 = new JTextField();
		t5.setBounds(200,180,120,20);
		t5.setBorder(BorderFactory.createEmptyBorder());
		p1.add(t5);
		
		b3 = new JButton("Back");
		b3.setBounds(120,230,100,30);
		b3.setFont(new Font("Tahoma",Font.BOLD,14));
		b3.setOpaque(true);
		b3.setBackground(new Color(105,105,105));
		b3.setForeground(Color.WHITE);
		b3.setBorder(BorderFactory.createLineBorder(new Color(105,105,105)));
		b3.addActionListener(this);
		p1.add(b3);
		
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBackground(Color.WHITE);
		p2.setBounds(460,0,360,350);
		add(p2);
		
		String filepath = "travel/management/system/icons/forgotpassword.jpg";
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(filepath));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l6 = new JLabel(i3);
		l6.setBounds(70,50,200,200);
		p2.add(l6);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		Conn conn = new Conn();
		
		if(ae.getSource() == b1) {
			String query = "Select name,security from account where username = ?";
			try {
				
				String username = t1.getText();
				
				PreparedStatement stmt = conn.c.prepareStatement(query);
				stmt.setString(1, username);
				
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					t2.setText(rs.getString("name"));
					t3.setText(rs.getString("security"));
				}
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,e);
			}
			
		}else if(ae.getSource() == b2) {
			
			String query = "Select password from account where username = ? and answer = ?";
			try {
				
				String username = t1.getText();
				String answer = t4.getText();
				
				PreparedStatement stmt = conn.c.prepareStatement(query);
				stmt.setString(1, username);
				stmt.setString(2, answer);
				
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					t5.setText(rs.getString("password"));
				}
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,e);
			}
			
		}else if(ae.getSource() == b3) {
			this.setVisible(false);
			new Login();
		}
		
	}

	public static void main(String[] args) {
		new ForgotPassword();

	}

}
