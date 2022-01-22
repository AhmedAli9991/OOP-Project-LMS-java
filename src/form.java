import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class form extends JFrame implements ActionListener{
	private JRadioButton std = new JRadioButton("Student");
	private JRadioButton prof = new JRadioButton("Teacher");
	private JRadioButton admin = new JRadioButton("Administration");
	private JButton submit = new JButton("Submit");

	public form(){
		ButtonGroup bg = new ButtonGroup();
		bg.add(std);
		bg.add(prof);
		bg.add(admin);
		add(std);
		add(prof);
		add(admin);
		add(submit);
		submit.addActionListener(this);
	
		setVisible(true);
		setSize(750,700);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	public void actionPerformed(ActionEvent e) {
		if(std.isSelected()) {
			studentlogin x = new studentlogin ();
			dispose();}
		else if(prof.isSelected()){
			teacherlogin x = new teacherlogin();
			dispose();}
		else if(admin.isSelected()) {
			adminlogin x = new adminlogin();
			dispose();}

		
	}
}