package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Destinations extends JFrame implements Runnable{
	
	Thread t1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JLabel[] label = {l1,l2,l3,l4,l5,l6,l7,l8,l9,l10};
	JLabel caption;
	
	public Destinations() {
		
		setBounds(450,200,600,400);
		
		String filepath;
		
		ImageIcon i1 = null, i2 = null, i3 = null, i4 = null, i5 = null,
				i6 = null, i7 = null, i8 = null, i9 = null, i10 = null;
		
		ImageIcon[] image = {i1,i2,i3,i4,i5,i6,i7,i8,i9,i10};
		
		Image j1 = null, j2 = null, j3 = null, j4 = null, j5 = null,
				j6 = null, j7 = null, j8 = null, j9 = null, j10 = null;
		
		Image[] jimage = {j1,j2,j3,j4,j5,j6,j7,j8,j9,j10};
		
		ImageIcon i11 = null, i12 = null, i13 = null, i14 = null, i15 = null,
				i16 = null, i17 = null, i18 = null, i19 = null, i20 = null;
		
		ImageIcon[] iimage = {i11,i12,i13,i14,i15,i16,i17,i18,i19,i20};
		
		caption = new JLabel();
		caption.setBounds(50,180,500,300);
		caption.setForeground(Color.WHITE);
		caption.setFont(new Font("Tahoma",Font.PLAIN,26));
		add(caption);
		
		for(int i=0; i<10; i++) {
			filepath = "travel/management/system/icons/dest" + (i+1) + ".jpg";
			image[i] = new ImageIcon(ClassLoader.getSystemResource(filepath));
			jimage[i] = image[i].getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
			iimage[i] = new ImageIcon(jimage[i]);
			label[i] = new JLabel(iimage[i]);
			label[i].setBounds(0,0,600,400);
			add(label[i]);
		}
		
		t1 = new Thread(this);
		t1.start();
		
		setVisible(true);
		
	}
	
	public void run() {
		
		String[] names = {"JW Marriott Hotel","Mandarin Oriental Hotel","Four Seasons Hotel",
						  "Radisson Hotel","Classio Hotel","The Bay Club Hotel",
						  "Breeze Blows Hotel","Quick Stop Hotel","Happy Mornings Motel",
						  "Moss View Hotel"};
		
		try {
			for(int i=0; i<10; i++) {
				this.label[i].setVisible(true);
				caption.setText(names[i]);
				Thread.sleep(3000);
				this.label[i].setVisible(false);
			}
			Thread.sleep(3000);
			this.setVisible(false);
		}catch(Exception e){}
	}

	public static void main(String[] args) {
		new Destinations();

	}

}
