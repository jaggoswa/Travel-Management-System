package travel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.*;

public class About extends JFrame implements ActionListener{
	
	String s;
	JButton b1;
	
	public About() {
		
		setLayout(null);
		setBounds(550,200,450,480);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel l1 = new JLabel("Travel And Tourism Management System");
		l1.setBounds(50,10,400,50);
		l1.setForeground(Color.RED);
		l1.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(l1);
		
		s = "                                    About Projects          \n  "
                + "\nThe objective of the Travel and Tourism Management \nSystem "
                + "project is to develop a system that automates the \nprocesses "
                + "and activities of a travel and the purpose is to \ndesign a "
                + "system using which one can perform all \noperations related to "
                + "traveling.\n\n"
                + "This application will help in accessing the information \nrelated "
                + "to the travel to the particular destination with great \nease. "
                + "The users can track the information related to their \ntours with "
                + "great ease through this application.\nThe travel agency information "
                + "can also be obtained \nthrough this application.\n\n"
                + "Advantages of Project:"
                + "\nGives accurate information"
                + "\nSimplifies the manual work"
                + "\nIt minimizes the documentation related work"
                + "\nProvides up to date information"
                + "\nFriendly Environment by providing warning messages."
                + "\ntravelers details can be provided"
                + "\nbooking confirmation notification";
		
		TextArea t1 = new TextArea(s,10,30,Scrollbar.VERTICAL);
		t1.setEditable(false);
		t1.setBounds(20,70,400,300);
		add(t1);
		
		b1 = new JButton("Back");
		b1.setBounds(170,380,80,30);
		b1.setOpaque(true);
		b1.setBackground(new Color(133,193,233));
		b1.setForeground(Color.BLACK);
		b1.setBorder(BorderFactory.createBevelBorder(0));
		b1.addActionListener(this);
		add(b1);

		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		this.setVisible(false);
	}

	public static void main(String[] args) {
		
		new About();

	}

}
