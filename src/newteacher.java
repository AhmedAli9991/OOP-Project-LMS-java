
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class newteacher extends intializer{
		public newteacher() {
			JLabel l1 = new JLabel("Enter number of teachers and courses");
			JTextField t1 = new JTextField(70);
			JButton back = new JButton ("Back");
			JButton b1 = new JButton("Submit");
			
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
							"Enter name of teacher "+j, field1,
							"Enter Course of teacher "+j, field2,
							"Enter password of teacher "+j, field3,
						   };
					int option = JOptionPane.showConfirmDialog(null, message, "Enter all your values", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION){
						teachers.add(new teacher(field1.getText(),field2.getText(),field3.getText()));
					}
					if (option == JOptionPane.CANCEL_OPTION) {
						break;
					   }
				}
				try{
				ObjectOutputStream teacher= new ObjectOutputStream(new FileOutputStream("teacher.bin"));
				
					for(teacher t:teachers) {
						teacher.writeObject(t);
					}
					teacher.close();
					}catch(IOException ex) {}

			});
			
			setVisible(true);
			setSize(750,700);
			setLayout(new FlowLayout());
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
	}
