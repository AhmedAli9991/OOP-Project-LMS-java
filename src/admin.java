import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class admin extends intializer{
		public admin() {
			
			JButton b1= new JButton("Students");
			JButton b2= new JButton("Teacher");
			JButton back = new JButton ("Back");
			JButton lout = new JButton("Logout"); 
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			p1.add(back);
			p1.add(lout);
			p2.add(b1);
			p2.add(b2);
			add(p1);
			add(p2);
			back.addActionListener(e->{
				adminlogin n = new adminlogin();
				dispose();
			});
			lout.addActionListener(e->{
				adminlogin n = new adminlogin();
				dispose();
			});
			b1.addActionListener(e->{
				newstudent ab = new newstudent();
				dispose();
			});
			b2.addActionListener(e->{
				newteacher ab = new newteacher();
				dispose();
			});
			setVisible(true);
			setSize(750,700);
			setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}


