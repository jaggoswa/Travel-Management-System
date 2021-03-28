package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame{
	
	public CheckPackage() {
		
		setBounds(420,200,700,470);
		
		JTabbedPane pane = new JTabbedPane();
		
		String[] package1 = new String[]{"GOLD PACKAGE","6 Days And 7 Nights",
										"Airport Assistance","Half Day City Tour",
										"Daily Buffet","Welcome Drinks On Arrival",
										"Full Day 3 Island Cruise","English Speaking Guide",
										"BOOK NOW","SUMMER SPECIAL","Rs 12000/-","package1.jpg"};
		
		String[] package2 = new String[]{"SILVER PACKAGE","5 Days And 6 Nights",
										"Toll Free And Entrance Free Tickets","Meet And Greet At Airport",
										"Welcome Drinks On Arrival","Night Safari",
										"Full Day 3 Island Cruise","Cruise with Dinner",
										"BOOK NOW","WINTER SPECIAL","Rs 24000/-","package2.jpg"};
		
		String[] package3 = new String[]{"BRONZE PACKAGE","6 Days And 5 Nights",
										"Return Airfare","Free Clubbing",
										"Horse Riding & Other Games","Welcome Drinks On Arrival",
										"Daily Buffet","Stay in 5 Star Hotel",
										"BOOK NOW","WINTER SPECIAL","Rs 32000/-","package3.jpg"};
		
		JPanel p1 = createPackage(package1);
		JPanel p2 = createPackage(package2);
		JPanel p3 = createPackage(package3);
		
		pane.addTab("Package1", null, p1);
		pane.addTab("Package2", null, p2);
		pane.addTab("Package3", null, p3);
		add(pane);
		
		setVisible(true);
	}
	
	JPanel createPackage(String[] pack) {
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.WHITE);
		
		JLabel l1 = new JLabel(pack[0]);
		l1.setBounds(50,5,300,30);
		l1.setFont(new Font("Tahoma",Font.PLAIN,20));
		p1.add(l1);
		
		JLabel l2 = new JLabel(pack[1]);
		l2.setBounds(30,60,300,25);
		l2.setFont(new Font("Tahoma",Font.PLAIN,18));
		l2.setForeground(Color.RED);
		p1.add(l2);
		
		JLabel l3 = new JLabel(pack[2]);
		l3.setBounds(30,100,300,25);
		l3.setFont(new Font("Tahoma",Font.PLAIN,18));
		l3.setForeground(Color.BLUE);
		p1.add(l3);
		
		JLabel l4 = new JLabel(pack[3]);
		l4.setBounds(30,140,300,25);
		l4.setFont(new Font("Tahoma",Font.PLAIN,18));
		l4.setForeground(Color.RED);
		p1.add(l4);
		
		JLabel l5 = new JLabel(pack[4]);
		l5.setBounds(30,180,300,25);
		l5.setFont(new Font("Tahoma",Font.PLAIN,18));
		l5.setForeground(Color.BLUE);
		p1.add(l5);
		
		JLabel l6 = new JLabel(pack[5]);
		l6.setBounds(30,220,300,25);
		l6.setFont(new Font("Tahoma",Font.PLAIN,18));
		l6.setForeground(Color.RED);
		p1.add(l6);
		
		JLabel l7 = new JLabel(pack[6]);
		l7.setBounds(30,260,300,25);
		l7.setFont(new Font("Tahoma",Font.PLAIN,18));
		l7.setForeground(Color.BLUE);
		p1.add(l7);
		
		JLabel l8 = new JLabel(pack[7]);
		l8.setBounds(30,300,300,25);
		l8.setFont(new Font("Tahoma",Font.PLAIN,18));
		l8.setForeground(Color.RED);
		p1.add(l8);
		
		JLabel l9 = new JLabel(pack[8]);
		l9.setBounds(30,340,300,25);
		l9.setFont(new Font("Tahoma",Font.PLAIN,20));
		l9.setForeground(Color.BLUE);
		p1.add(l9);
		
		JLabel l10 = new JLabel(pack[9]);
		l10.setBounds(260,360,200,25);
		l10.setFont(new Font("Tahoma",Font.PLAIN,20));
		l10.setForeground(Color.RED);
		p1.add(l10);
		
		JLabel l11 = new JLabel(pack[10]);
		l11.setBounds(550,360,100,25);
		l11.setFont(new Font("Tahoma",Font.PLAIN,20));
		l11.setForeground(Color.RED);
		p1.add(l11);
		
		String filepath = "travel/management/system/icons/" + pack[11];
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(filepath));
		Image i2 = i1.getImage().getScaledInstance(350, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l12 = new JLabel(i3);
		l12.setBounds(320,20,350,300);
		p1.add(l12);
		
		return p1;
	}

	public static void main(String[] args) {
		new CheckPackage();

	}

}
