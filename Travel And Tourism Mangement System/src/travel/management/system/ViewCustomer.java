package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ViewCustomer extends JFrame implements ActionListener{
	
	JButton b1;
	
	public ViewCustomer(String username) {
		setLayout(null);
		setBounds(300,150,800,500);
		getContentPane().setBackground(Color.WHITE);
		setUndecorated(true);
		
		JLabel l1 = new JLabel("Username:");
		l1.setFont(new Font("Tahoma",Font.PLAIN,14));
		l1.setBounds(30,50,100,25);
		add(l1);
		
		JLabel l2 = new JLabel();
		l2.setBounds(200,50,100,25);
		l2.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l2);
		
		JLabel l3 = new JLabel("ID:");
		l3.setBounds(30,90,100,25);
		l3.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l3);
		
		JLabel l4 = new JLabel();
		l4.setBounds(200,90,100,25);
		l4.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l4);
		
		JLabel l5 = new JLabel("Number:");
		l5.setBounds(30,130,100,25);
		l5.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l5);
		
		JLabel l6 = new JLabel();
		l6.setBounds(200,130,100,25);
		l6.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l6);
		
		JLabel l7 = new JLabel("Name:");
		l7.setBounds(30,170,100,25);
		l7.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l7);
		
		JLabel l8 = new JLabel();
		l8.setBounds(200,170,100,25);
		l8.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l8);
		
		JLabel l9 = new JLabel("Gender:");
		l9.setBounds(30,210,100,25);
		l9.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l9);
		
		JLabel l10 = new JLabel();
		l10.setBounds(200,210,100,25);
		l10.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l10);
		
		JLabel l11 = new JLabel("Country:");
		l11.setBounds(420,50,100,25);
		l11.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l11);
		
		JLabel l12 = new JLabel();
		l12.setBounds(520,50,100,25);
		l12.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l12);
		
		JLabel l13 = new JLabel("Address:");
		l13.setBounds(420,90,100,25);
		l13.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l13);
		
		JLabel l14 = new JLabel();
		l14.setBounds(520,90,100,25);
		l14.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l14);
		
		JLabel l15 = new JLabel("Email:");
		l15.setBounds(420,130,100,25);
		l15.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l15);
		
		JLabel l16 = new JLabel();
		l16.setBounds(520,130,200,25);
		l16.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l16);
		
		JLabel l17 = new JLabel("Phone:");
		l17.setBounds(420,170,100,25);
		l17.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l17);
		
		JLabel l18 = new JLabel();
		l18.setBounds(520,170,100,25);
		l18.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l18);
		
		b1 = new JButton("Back");
		b1.setBounds(350,260,100,30);
		b1.setOpaque(true);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBorder(BorderFactory.createEmptyBorder());
		b1.addActionListener(this);
		add(b1);
		
		String filepath = "travel/management/system/icons/viewall.jpg";
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(filepath));
		Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l19 = new JLabel(i3);
		l19.setBounds(100,250,600,300);
		add(l19);
		
		try {
			Conn conn = new Conn();
			String query = "Select * from customer where username = ?";
			PreparedStatement stmt = conn.c.prepareStatement(query);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				l2.setText(rs.getString("username"));
				l4.setText(rs.getString("id"));
				l6.setText(rs.getString("number"));
				l8.setText(rs.getString("name"));
				l10.setText(rs.getString("gender"));
				l12.setText(rs.getString("country"));
				l14.setText(rs.getString("address"));
				l16.setText(rs.getString("email"));
				l18.setText(rs.getString("phone"));
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == b1){
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		
		new ViewCustomer("");

	}

}
