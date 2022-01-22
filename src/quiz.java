
import java.io.Serializable;

public class quiz implements Serializable {
	private String quiz1="none";
	private String quiz2="none";
	private String quiz3="none";
	private String quiz4="none";
	public quiz() {
		this("none","none","none","none");
	}
	public quiz(String a,String b,String c,String d) {
		quiz1=a;
		quiz2=b;
		quiz3=c;
		quiz4=d;

	}
	public String get1() {
		return quiz1;
	}
	public String get2() {
		return quiz2;
	}
	public String get3() {
		return quiz3;
	}
	public String get4() {
		return quiz4;
	}
}
