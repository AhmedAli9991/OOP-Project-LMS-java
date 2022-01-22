
import java.io.Serializable;

public class student implements Serializable{
	private String Name;
	private String reg_no;
	private String pass;
	public student(String a,String b,String c) {
		Name=a;
		reg_no=b;
		pass=c;
	}
	public student(student a) {
		Name=a.getName();
		reg_no=a.getreg();
		pass=a.getpass();
	}
	public String getName() {
		return Name;
	}
	public String getreg() {
		return reg_no;
	}
	public String getpass() {
		return pass;
	}
}
