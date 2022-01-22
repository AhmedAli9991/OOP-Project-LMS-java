import java.awt.FlowLayout;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class newstudent extends intializer{
		public newstudent() {
			
			JLabel l1 = new JLabel("Enter number of students");
			JTextField t1 = new JTextField(70);
			JButton b1 = new JButton("Submit");
			JButton back = new JButton ("Back");
			add(l1);
			add(t1);
			add(back);
			add(b1);
			back.addActionListener(e->{
				admin n = new admin();
				dispose();
			});
			b1.addActionListener(e->{
				String nm = t1.getText();
				int n = Integer.parseInt(nm);
				for(int i=0;i<n;i++) {
					int j=i+1;
					JTextField field1=new JTextField();
					JTextField field2=new JTextField();
					JTextField field3=new JTextField();
					Object[] message = {
							"Enter name of Student "+j, field1,
							"Enter registration number of Student "+j, field2,
							"Enter password of Student "+j, field3,
						   };
					int option = JOptionPane.showConfirmDialog(null, message, "Enter all your values", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION){
						String a=field1.getText();
						String b=field2.getText();
						String c=field3.getText();
						
						students.add(new student(a,b,c));
					}
					if (option == JOptionPane.CANCEL_OPTION) {
						break;
					   }
				}
				
				try {
					ObjectOutputStream student= new ObjectOutputStream(new FileOutputStream("student.bin"));
					for(student j:students) {
						student.writeObject(j);
					}
					student.close();
				}catch(IOException ex) {}
				
			});
			
			setVisible(true);
			setSize(750,700);
			setLayout(new FlowLayout());
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}