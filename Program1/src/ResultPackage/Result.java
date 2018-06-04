package ResultPackage;

import java.text.DecimalFormat;
import java.util.Scanner;

import StudentPackage.RegisterStudent;

public class Result {
	Scanner sc = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("0.00");
	RegisterStudent rs;
	int n;
	String grade[];
	int gradePoints[];
	double sgpa=0.0;
	static double cgpa=0.0;
	static int semCount=0;

	public Result(RegisterStudent r) {
		this.rs=r;
		n = rs.sub.length;
		grade= new String[n];
		gradePoints= new int[n];
		getGrade();
		calSGPA();
		checkSGPA();
		// TODO Auto-generated constructor stub
	}
	
	void getGrade() {
		System.out.println("Enter Grades : S/A/B/C/D/E/F");
		for(int i=0; i<n;i++) {
			System.out.println("Grade for "+rs.sub[i]+" : ");
			grade[i]=sc.next();
			if(grade[i].equals("S"))
				gradePoints[i]=10;
			else if(grade[i].equals("A"))
				gradePoints[i]=9;
			else if(grade[i].equals("B"))
				gradePoints[i]=8;
			else if(grade[i].equals("C"))
				gradePoints[i]=7;
			else if(grade[i].equals("D"))
				gradePoints[i]=6;
			else if(grade[i].equals("E"))
				gradePoints[i]=5;
			else if(grade[i].equals("F"))
				gradePoints[i]=0;
			
		}
	}
	
	void calSGPA() {
		double sum=0;
		for(int i=0;i<n;i++)
			sum+=(rs.credits[i]*gradePoints[i]);
		sgpa=sum/rs.Tcredits;
	}
	
	void checkSGPA() {
		try {
			if(sgpa>10)
				throw new InvalidSGPA(sgpa);
			else if(sgpa==0.0)
				throw new NumberFormatException();
			else
			{
				System.out.println("SGPA for sem "+rs.sem+" : "+df.format(sgpa));
				cgpa=cgpa*semCount;
				cgpa+=sgpa;
				semCount++;
				cgpa=cgpa/semCount;
				System.out.println("CGPA : "+df.format(cgpa));
			}
		}
		catch (InvalidSGPA e) {
			System.out.println(e);
			// TODO: handle exception
		}
		catch (NumberFormatException e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}

}
