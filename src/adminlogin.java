import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class adminlogin extends intializer implements ActionListener{
	private JLabel l1 = new JLabel("Name");
	private JTextField name = new JTextField(70);
	private JLabel r1 = new JLabel("");
	private JLabel l2 = new JLabel("ID   ");
	private JTextField reg = new JTextField(70);
	private JLabel r2 = new JLabel("");
	private JLabel l3 = new JLabel("password");
	private JPasswordField pass = new JPasswordField(70);
	private JLabel r3 = new JLabel("");
	private JButton log=new JButton("Login");
	private JButton back = new JButton ("Back");
		
	public adminlogin() {
			add(l1);
			add(name);
			add(r1);
			add(l2);	
			add(reg);
			add(r2);
			add(l3);
			add(pass);
			add(r3);
			add(back);
			add(log);
			log.addActionListener(this);
			back.addActionListener(this);

			setVisible(true);
			setSize(750,700);
			setLayout(new FlowLayout());
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==log) {
			String nm = name.getText();
			String rg = reg.getText();
			String ps = pass.getText();
			int a=0;
			int b=0;
			int c=0;
			
			if(nm.equals(admin_name))
				a=1;
			else
				r1.setText("Invalid name");
			
			
			if(rg.equals(admin_ID))
				b=1;
			else
				r2.setText("Invalid ID");
			
			
			if(ps.equals(admin_password))
				c=1;
			else
				r3.setText("Invalid password");
			
			if(a==1&&b==1&&c==1) {
				admin ab = new admin();
				dispose();
			}

		}
		else if(e.getSource()==back) {
			form n = new form();
			dispose();
		}
	}
}
	
