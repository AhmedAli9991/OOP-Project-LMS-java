
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class update extends intializer{
	ObjectInputStream quiz_marks;
	ObjectInputStream assignment_marks;
	ObjectOutputStream quizes;
	ObjectOutputStream assignment;
	
		public update(){
			
			JPanel p1=new JPanel();
			JPanel p2=new JPanel();
			JPanel p3=new JPanel();
			JPanel p4=new JPanel();
			JPanel p5=new JPanel();
			JPanel p6=new JPanel();
			JPanel p7=new JPanel();
			JPanel p8=new JPanel();
			JPanel p9=new JPanel();
			JPanel w=new JPanel();
			JPanel s=new JPanel();
		
			JLabel l = new JLabel("Quiz Marks");
			JLabel l1 = new JLabel("Quiz 1");
			JLabel m1 = new JLabel("/10");
			JLabel l2 = new JLabel("Quiz 2");
			JLabel m2 = new JLabel("/10");
			JLabel l3 = new JLabel("Quiz 3");
			JLabel m3 = new JLabel("/10");
			JLabel l4 = new JLabel("Quiz 4");
			JLabel m4 = new JLabel("/10");
			JTextField[]t=new JTextField[4];
			t[0]=new JTextField(5);
			t[1]=new JTextField(5);
			t[2]=new JTextField(5);
			t[3]=new JTextField(5);
			
			JLabel a = new JLabel("Assignment Marks");
			
			JLabel a1 = new JLabel("Assignment 1");
			JLabel c1 = new JLabel("/10");
			JLabel a2 = new JLabel("Assignment 2");
			JLabel c2 = new JLabel("/10");
			JLabel a3 = new JLabel("Assignment 3");
			JLabel c3 = new JLabel("/10");
			JLabel a4 = new JLabel("Assignment 4");
			JLabel c4 = new JLabel("/10");
			JTextField[]b=new JTextField[4];
			b[0]=new JTextField(5);
			b[1]=new JTextField(5);
			b[2]=new JTextField(5);
			b[3]=new JTextField(5);
			try {
				quiz_marks = new ObjectInputStream(new FileInputStream("Quiz marks.bin"));
			} catch (FileNotFoundException e1) {} catch (IOException e1) {}
			File file1 =new File("Quiz marks.bin");
			if(file1.exists()) {
				try {
					for(int i=0;i<student_quiz_marks.length;i++) {
						for(int j=0;j<student_quiz_marks[i].length;j++) {
							quiz abc= (quiz) quiz_marks.readObject();
							student_quiz_marks[i][j]=abc;
							}
						}
					quiz_marks.close();
					
				}catch(FileNotFoundException ex) {} catch (ClassNotFoundException e1) {} catch (IOException e1) {}
				t[0].setText(student_quiz_marks[course_index][quiz_index].get1());
				t[1].setText(student_quiz_marks[course_index][quiz_index].get2());
				t[2].setText(student_quiz_marks[course_index][quiz_index].get3());
				t[3].setText(student_quiz_marks[course_index][quiz_index].get4());
				
			}
			try {
				assignment_marks = new ObjectInputStream(new FileInputStream("Assignment marks.bin"));
			} catch (IOException e1) {}
			File file2 =new File("Assignment marks.bin");		
			if(file2.exists()) {
				try {
					for(int i=0;i<student_assignment_marks.length;i++) {
						for(int j=0;j<student_assignment_marks[i].length;j++) {
							student_assignment_marks[i][j]=(assignments)assignment_marks.readObject();							
							}
						}
					assignment_marks.close();
					}catch(FileNotFoundException ex) {} catch (ClassNotFoundException e1) {} catch (IOException e1) {}
					b[0].setText(student_assignment_marks[course_index][assignment_index].get1());
					b[1].setText(student_assignment_marks[course_index][assignment_index].get1());
					b[2].setText(student_assignment_marks[course_index][assignment_index].get1());
					b[3].setText(student_assignment_marks[course_index][assignment_index].get1());
				}
			
			
			JButton update = new JButton("Update");
			
			w.add(l);
			p1.add(l1);
			p1.add(t[0]);
			p1.add(m1);
			p2.add(l2);
			p2.add(t[1]);
			p2.add(m2);
			p3.add(l3);
			p3.add(t[2]);
			p3.add(m3);
			p4.add(l4);
			p4.add(t[3]);
			p4.add(m4);
			s.add(a);
			p5.add(a1);
			p5.add(b[0]);
			p5.add(c1);
			p6.add(a2);
			p6.add(b[1]);
			p6.add(c2);
			p7.add(a3);
			p7.add(b[2]);
			p7.add(c3);
			p8.add(a4);
			p8.add(b[3]);
			p8.add(c4);
			
			p9.add(update);
			
			JPanel u = new JPanel();
			JButton back = new JButton ("Back");
			JButton lout = new JButton("Logout"); 
			u.add(back);
			u.add(lout);
			add(u);
			
			add(w);
			add(p1);
			add(p2);
			add(p3);
			add(p4);
			add(s);
			add(p5);
			add(p6);
			add(p7);
			add(p8);
			add(p9);
			u.setBackground(Color.GRAY);
			w.setBackground(Color.PINK);
			s.setBackground(Color.ORANGE);
			back.addActionListener(e->{
				teacherpanel n = new teacherpanel();
				dispose();
			});
			lout.addActionListener(e->{
				teacherlogin n = new teacherlogin();
				dispose();
			});
			update.addActionListener(e->{
				try {
					quizes = new ObjectOutputStream(new FileOutputStream("Quiz marks.bin"));
					assignment=new ObjectOutputStream(new FileOutputStream("Assignment marks.bin"));
				} catch (IOException e1) {}
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
				student_quiz_marks[course_index][quiz_index] = new quiz(t[0].getText(),t[1].getText(),t[2].getText(),t[3].getText());
				student_assignment_marks[course_index][assignment_index] =new assignments( b[0].getText(),b[1].getText(),b[2].getText(),b[3].getText());
				try {
					for(int i=0;i<student_quiz_marks.length;i++) {
						for(int j=0;j<student_quiz_marks[i].length;j++) {
							quizes.writeObject(student_quiz_marks[i][j]);
							
						}
					}
					quizes.close();
					for(int i=0;i<student_assignment_marks.length;i++) {
						for(int j=0;j<student_assignment_marks[i].length;j++) {
								assignment.writeObject(student_assignment_marks[i][j]);
						}
					}
					assignment.close();
				}catch(IOException ex) {
				}
			});
			
			setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
			setVisible(true);
			setSize(750,700);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
