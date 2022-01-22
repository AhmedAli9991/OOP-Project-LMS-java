
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
class teacherpanel extends intializer{
	ObjectInputStream studentobj;	
	public teacherpanel() {
			try {
				studentobj = new ObjectInputStream(new FileInputStream("student.bin"));
				} catch (IOException e1) {}
			try {	
				while(true) {
					
					student a= (student) studentobj.readObject();
					names.add(a.getName());
				}
			}catch(ClassNotFoundException | IOException ex) {}
			
			JRadioButton[]RB=new JRadioButton[names.size()];
			JButton update = new JButton("Update");
			ButtonGroup bg = new ButtonGroup();
			JPanel[]P = new JPanel[names.size()+1];
			JPanel u = new JPanel();
			JButton back = new JButton ("Back");
			JButton lout = new JButton("Logout"); 
			u.add(back);
			u.add(lout);
			add(u);
			student_quiz_marks=new quiz [teachers.size()][RB.length];
			student_assignment_marks=new assignments[teachers.size()][RB.length];

			for(int i=0;i<RB.length;i++) {
				RB[i]=new JRadioButton(names.get(i));
				bg.add(RB[i]);
				P[i]=new JPanel(new FlowLayout(FlowLayout.LEFT));
				P[i].add(RB[i]);
				add(P[i]);
			}
			P[names.size()] = new JPanel();
			P[names.size()].add(update);
			add(P[names.size()]);
			u.setBackground(Color.GRAY);
			back.addActionListener(e->{
				teacherlogin n = new teacherlogin();
				dispose();
			});
			lout.addActionListener(e->{
				teacherlogin n = new teacherlogin();
				dispose();
			});
			
			update.addActionListener(e->{
				for(int i=0;i<RB.length;i++) {
					if(RB[i].isSelected()) {
						quiz_index = i;
						assignment_index = i;
						update up = new update();
						dispose();	
					}
				}
			});
		
			setVisible(true);
			setSize(750,700);
			setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
