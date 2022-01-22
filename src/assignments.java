import java.io.Serializable;

public class assignments implements Serializable {
	private String assignment1="none";
	private String assignment2="none";
	private String assignment3="none";
	private String assignment4="none";
	
	public assignments() {
		this("none","none","none","none");
	}
	public assignments(String a,String b,String c,String d) {
		assignment1=a;
		assignment2=b;
		assignment3=c;
		assignment4=d;

	}
	public String get1() {
		return assignment1;
	}
	public String get2() {
		return assignment2;
	}
	public String get3() {
		return assignment3;
	}
	public String get4() {
		return assignment4;
	}
}
