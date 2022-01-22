import java.util.ArrayList;

import javax.swing.JFrame;

public class intializer extends JFrame{
	static ArrayList<student>students=new ArrayList<student>();
	static ArrayList<teacher>teachers=new ArrayList<teacher>();
	ArrayList<String>courses=new ArrayList<String>();
	ArrayList<String>names=new ArrayList<String>();
	static quiz[][]student_quiz_marks;
	static assignments[][]student_assignment_marks;
	static String admin_name="HOD";
	static String admin_ID="111";
	static String admin_password="password";
	int quiz_index;
	int assignment_index;
	int course_index;
	public intializer() {
	}
}
