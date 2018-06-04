package StudentPackage;

public class CreditLimit extends Exception {
	int credits,sem;
	public CreditLimit(int c, int s) {
		// TODO Auto-generated constructor stub
		this.credits=c;
		this.sem=s;
	}
	
	public String toString() {
		String s= "Error! you have registered "+credits+" credits for sem "+sem+" .\nMaximum credits allowed in a sem is 30.";
		return s;
	}

	public CreditLimit(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CreditLimit(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CreditLimit(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public CreditLimit(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
