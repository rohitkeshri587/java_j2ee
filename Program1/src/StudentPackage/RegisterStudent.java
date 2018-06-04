package StudentPackage;
import java.util.Scanner;

import Default.Student;

public class RegisterStudent implements Student {
	Scanner sc= new Scanner(System.in);
	String name;
	String branch;
	public int sem;
	public String sub[];
	public int credits[];
	public int Tcredits=0;
	
	public RegisterStudent(int s) {
		// TODO Auto-generated constructor stub
		sem=s;
		System.out.println("Student Registration for sem "+sem);
		getName();
		getBranch();
		register();
		creditCheck();
	}

	@Override
	public void getName() {
		// TODO Auto-generated method stub
		System.out.println("Enter name of student");
		this.name = sc.next();
		
	}

	@Override
	public void getBranch() {
		// TODO Auto-generated method stub
		System.out.println("Enter name of branch");
		this.branch = sc.next();
		
	}
	
	public void register() {
		System.out.println("Enter number of subjects\n");
		int n= sc.nextInt();
		sub=new String[n];
		credits=new int[n];
		for(int i=0;i<n;i++) {
		System.out.println("Enter subject "+(i+1));
		sub[i]=sc.next();
		System.out.println("Enter credits for subject "+(i+1));
		credits[i]=sc.nextInt();		
	
		}
	}	
	
	public void creditCheck() {
		for(int i=0;i<credits.length;i++)
			Tcredits+=credits[i];
		try {
			if(Tcredits>30)
				throw new CreditLimit(Tcredits,sem);
			else
				System.out.println("Total credits registered for sem "+sem+" = "+Tcredits);
		}
		catch (CreditLimit e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}

}
