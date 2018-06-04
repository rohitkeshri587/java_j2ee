package StudentPackage;

import ResultPackage.Result;

public class StudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*RegisterStudent s1 = new RegisterStudent(1);
		ResultPackage.Result r1 = new ResultPackage.Result(s1);
		RegisterStudent s2 = new RegisterStudent(2);
		ResultPackage.Result r2 = new ResultPackage.Result(s2);
		RegisterStudent s3 = new RegisterStudent(3);
		ResultPackage.Result r3 = new ResultPackage.Result(s3);
		RegisterStudent s4 = new RegisterStudent(4);
		ResultPackage.Result r4 = new ResultPackage.Result(s4);*/
		RegisterStudent s1 = new RegisterStudent(1);
		Result r1 = new Result(s1);
		s1 = new RegisterStudent(2);
		r1 = new Result(s1);
		s1 = new RegisterStudent(3);
		r1 = new Result(s1);
		s1 = new RegisterStudent(4);
		r1 = new Result(s1);
	}

}
