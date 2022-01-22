
import java.io.Serializable;

public class teacher implements Serializable {
	private String Name;
	private String course;
	private String pass;
	
	public teacher(String a,String b,String c) {
		Name=a;
		course=b;
		pass=c;
	}
	public teacher(teacher a) {
		Name=a.getName();
		course=a.getCourse();
		pass=a.getpass();
	}
	public String getName() {
		return Name;
	}
	public String getCourse() {
		return course;
	}
	public String getpass() {
		return pass;
	}
}


