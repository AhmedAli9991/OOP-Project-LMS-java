import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class view extends intializer implements ActionListener{
	
	private JButton back = new JButton ("Back");
	private JButton lout = new JButton("Logout"); 
	ObjectInputStream quiz_marks;
	ObjectInputStream assignment_marks;	
	public view() {
			JLabel[]q = new JLabel[4];
			JLabel[]qm = new JLabel[4];
			JLabel[]qt = new JLabel[4];
			JLabel[]a = new JLabel[4];
			JLabel[]am = new JLabel[4];
			JLabel[]at = new JLabel[4];
			int c=1;
			for(int i=0;i<4;i++) {
				q[i]=new JLabel("Quiz "+c);
				a[i]=new JLabel("assignment "+c);
				qt[i]=new JLabel("10");
				at[i]=new JLabel("10");
				c++;
			}
			for(int i=0;i<student_quiz_marks.length;i++) {
				for(int j=0;j<student_quiz_marks[i].length;j++) {
					student_quiz_marks[i][j]=new quiz();
				}
			}
			for(int i=0;i<student_assignment_marks.length;i++) {
				for(int j=0;j<student_assignment_marks[i].length;j++) {
					student_assignment_marks[i][j]=new assignments();
				}
			}
			try {
				quiz_marks = new ObjectInputStream(new FileInputStream("Quiz marks.bin"));
			} catch (FileNotFoundException e1) {} catch (IOException e1) {}
		try {
				for(int i=0;i<student_quiz_marks.length;i++) {
					for(int j=0;j<student_quiz_marks[i].length;j++) {
						quiz abc = (quiz)quiz_marks.readObject();
						student_quiz_marks[i][j]=abc;
						
					}
				}quiz_marks.close();
		}catch(FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "No Marks have been uploaded yet");
		} catch (IOException e) {} catch (ClassNotFoundException e) {}
		try {
			assignment_marks = new ObjectInputStream(new FileInputStream("Assignment marks.bin"));
			} catch (FileNotFoundException e1) {} catch (IOException e1) {}
		try {		
		for(int i=0;i<student_assignment_marks.length;i++) {
					for(int j=0;j<student_assignment_marks[i].length;j++) {
							assignments abc= (assignments) assignment_marks.readObject();
							student_assignment_marks[i][j] =abc ;	
					}
				}assignment_marks.close();
		}catch(FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "No Marks have been uploaded yet");
		} catch (IOException e) {} catch (ClassNotFoundException e) {}
		
			String marks1 = student_quiz_marks[course_index][quiz_index].get1(); 
			qm[0] = new JLabel(marks1+"/");
			String marks2 = student_quiz_marks[course_index][quiz_index].get2(); 
			qm[1] = new JLabel(marks2+"/");
			String marks3 = student_quiz_marks[course_index][quiz_index].get3(); 
			qm[2] = new JLabel(marks3+"/");
			String marks4 = student_quiz_marks[course_index][quiz_index].get4(); 
			qm[3] = new JLabel(marks4+"/");
			
			String marks5 = student_assignment_marks[course_index][assignment_index].get1(); 
			am[0] = new JLabel(marks5+"/");
			String marks6 = student_assignment_marks[course_index][assignment_index].get2(); 
			am[1] = new JLabel(marks6+"/");
			String marks7 = student_assignment_marks[course_index][assignment_index].get3(); 
			am[2] = new JLabel(marks7+"/");
			String marks8 = student_assignment_marks[course_index][assignment_index].get4(); 
			am[3] = new JLabel(marks8+"/");
			
			JPanel u = new JPanel();
			u.add(back);
			u.add(lout);
			add(u);

			JPanel[]p1 = new JPanel[4];
			JPanel qq = new JPanel();
			JLabel quiz= new JLabel("Quiz Marks");
			qq.add(quiz);
			for(int i=0;i<4;i++) {
				p1[i] = new JPanel();
				p1[i].add(q[i]);
				p1[i].add(qm[i]);
				p1[i].add(qt[i]);
			}
			add(qq);
			add(p1[0]);
			add(p1[1]);
			add(p1[2]);
			add(p1[3]);
			JPanel[]p2 = new JPanel[4];
			JPanel aa = new JPanel();
			JLabel assignments= new JLabel("Assignment Marks");
			aa.add(assignments);
			for(int i=0;i<4;i++) {
				p2[i] = new JPanel();
				p2[i].add(a[i]);
				p2[i].add(am[i]);
				p2[i].add(at[i]);
			}
			add(aa);
			add(p2[0]);
			add(p2[1]);
			add(p2[2]);
			add(p2[3]);
			back.addActionListener(this);
			lout.addActionListener(this);
			u.setBackground(Color.GRAY);
			qq.setBackground(Color.PINK);
			aa.setBackground(Color.ORANGE);
			
			setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
			setVisible(true);
			setSize(750,700);			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			studentpanel n = new studentpanel();
			dispose();
		
		}
		else if(e.getSource()==lout) {
			studentlogin n = new studentlogin();
			dispose();
		}
	}
}

