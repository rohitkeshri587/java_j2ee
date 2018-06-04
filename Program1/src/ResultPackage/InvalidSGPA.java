package ResultPackage;

public class InvalidSGPA extends Exception {
	double sgpa;
	public InvalidSGPA(double s) {
		// TODO Auto-generated constructor stub
		this.sgpa=s;
	}
	
	public String toString() {
		String s= "SGPA can't be greater than 10 for a semester";
		return s;
	}
	
	public InvalidSGPA(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public InvalidSGPA(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public InvalidSGPA(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public InvalidSGPA(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
