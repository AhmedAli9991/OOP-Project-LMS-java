
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class studentpanel extends intializer{

	public studentpanel() {
		ObjectInputStream teacherobj = null;
		try {
			teacherobj = new ObjectInputStream(new FileInputStream("teacher.bin"));
			} catch (IOException e1) {}
		try {	
			while(true) {
				
				teacher a= (teacher) teacherobj.readObject();
				courses.add(a.getCourse());
			}
		}catch(ClassNotFoundException | IOException ex) {}
		
		student_quiz_marks = new quiz[courses.size()][students.size()]; 
		student_assignment_marks = new assignments[courses.size()][students.size()];			for(int i=0;i<student_quiz_marks.length;i++) {
	
		}
		JPanel u = new JPanel();
		JButton back = new JButton ("Back");
		JButton lout = new JButton("Logout"); 
		u.add(back);
		u.add(lout);
		add(u);
		JPanel[]P=new JPanel[courses.size()];
		JRadioButton[]RB=new JRadioButton[courses.size()];
		JButton check = new JButton("Check");
		ButtonGroup bg = new ButtonGroup();
		for(int i=0;i<RB.length;i++) {
			RB[i]=new JRadioButton(courses.get(i));
			bg.add(RB[i]);
			P[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
			P[i].add(RB[i]);
			add(P[i]);
		}
		JPanel c =new JPanel();
		c.add(check);
		add(c);
		u.setBackground(Color.GRAY);
		back.addActionListener(e->{
			studentlogin n = new studentlogin();
			dispose();
		});
		lout.addActionListener(e->{
			studentlogin n = new studentlogin();
			dispose();
		});
		check.addActionListener(e->{
			for(int i=0;i<RB.length;i++) {
				if(RB[i].isSelected()) {
					course_index = i;
					dispose();
					view ab = new view();
					
				}
			}
		});
		
		setVisible(true);
		setSize(750,700);
		setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}