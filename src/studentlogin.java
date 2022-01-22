
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class studentlogin extends intializer implements ActionListener{
	
	private JLabel l1 = new JLabel("Name");
	private JTextField name = new JTextField(70);
	private JLabel r1 = new JLabel("");
	private JLabel l2 = new JLabel("registration number");
	private JTextField reg = new JTextField(70);
	private JLabel r2 = new JLabel("");
	private JLabel l3 = new JLabel("password");
	private JPasswordField pass = new JPasswordField(70);
	private JLabel r3 = new JLabel("");
	private JButton log=new JButton("Login");
	private JButton back = new JButton ("Back");

	public studentlogin() {
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
					ObjectInputStream studentobj = null;
					try {
						studentobj = new ObjectInputStream(new FileInputStream("student.bin"));
					} catch (IOException e1) {}
				try {	
					while(true) {
						
						student a= (student) studentobj.readObject();
						students.add(new student(a));
					}
					
				}catch(ClassNotFoundException | IOException ex) {}
				String nm = name.getText();
				String rg = reg.getText();
				String ps = pass.getText();
				for(int i=0;i<students.size();i++) {
					if(students.get(i).getName().equals(nm)&&students.get(i).getreg().equals(rg)&&students.get(i).getpass().equals(ps)) {
						quiz_index = i;
						assignment_index = i;
						studentpanel ab = new studentpanel();
						dispose();
					}
				}
				int a=0;
				int b=0;
				int c=0;
				for(student i:students) {
					if(i.getName().equals(nm))
						a=1;
				}
				for(student i:students) {
					if(i.getreg().equals(rg))
						b=1;
				}
				for(student i:students) {
					if(i.getpass().equals(ps))
						c=1;
				}
				if(a==0)
					r1.setText("Invalid name");
				if(b==0)
					r2.setText("Invalid registration number");
				if(c==0)
					r3.setText("Invalid password");
			}
			else if(e.getSource()==back) {
				form n = new form();
				dispose();
			
		}
			
	}
}