import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class sample implements ActionListener{
	JFrame jf = new JFrame("Representative-Customer Application");
	JFrame jf2 = new JFrame("Display");
	
	JTextArea jta = new JTextArea(10,5);
	
	JLabel jl1 = new JLabel("Rep No");
	JTextField jtf1 = new JTextField();

	JLabel jl2 = new JLabel("Rep Name");
	JTextField jtf2 = new JTextField();

	JLabel jl3 = new JLabel("State");
	JTextField jtf3 = new JTextField();

	JLabel jl4 = new JLabel("Commission");
	JTextField jtf4 = new JTextField();

	JLabel jl5 = new JLabel("Rate");
	JTextField jtf5 = new JTextField();
	
	JButton btn1 = new JButton("Submit");
		
	JLabel jl6 = new JLabel("Cust No");
	JTextField jtf6 = new JTextField();

	JLabel jl7 = new JLabel("Cust Name");
	JTextField jtf7 = new JTextField();

	JLabel jl8 = new JLabel("State");
	JTextField jtf8 = new JTextField();

	JLabel jl9 = new JLabel("Credit Limit");
	JTextField jtf9 = new JTextField();

	JLabel jl10 = new JLabel("Rep No");
	JTextField jtf10 = new JTextField();
	
	JButton btn2 = new JButton("Submit");
		
	JButton btn3 = new JButton("View");
	
	sample(){
		btn1.addActionListener(this);
		btn2.addActionListener(this);				
		btn3.addActionListener(this);
		
		jl1.setBounds(10, 10, 120, 30);
		jtf1.setBounds(200, 10, 120, 30);
		jl2.setBounds(10, 40, 120, 30);
		jtf2.setBounds(200, 40, 120, 30);
		jl3.setBounds(10, 70, 120, 30);
		jtf3.setBounds(200, 70, 120, 30);
		jl4.setBounds(10, 100, 120, 30);
		jtf4.setBounds(200, 100, 120, 30);
		jl5.setBounds(10, 130, 120, 30);
		jtf5.setBounds(200, 130, 120, 30);
		btn1.setBounds(120, 180, 120, 30);
		
		jl6.setBounds(10, 220, 120, 30);
		jtf6.setBounds(200, 220, 120, 30);
		jl7.setBounds(10, 250, 120, 30);
		jtf7.setBounds(200, 250, 120, 30);
		jl8.setBounds(10, 280, 120, 30);
		jtf8.setBounds(200, 280, 120, 30);
		jl9.setBounds(10, 310, 120, 30);
		jtf9.setBounds(200, 310, 120, 30);
		jl10.setBounds(10, 340, 120, 30);
		jtf10.setBounds(200, 340, 120, 30);
		btn2.setBounds(120, 380, 120, 30);
		
		btn3.setBounds(120, 420, 120, 30);
		
		jf.add(jl1);
		jf.add(jtf1);
		jf.add(jl2);
		jf.add(jtf2);
		jf.add(jl3);
		jf.add(jtf3);
		jf.add(jl4);
		jf.add(jtf4);
		jf.add(jl5);
		jf.add(jtf5);
		jf.add(btn1);
		jf.add(jl6);
		jf.add(jtf6);
		jf.add(jl7);
		jf.add(jtf7);
		jf.add(jl8);
		jf.add(jtf8);
		jf.add(jl9);
		jf.add(jtf9);
		jf.add(jl10);
		jf.add(jtf10);
		jf.add(btn2);
		jf.add(btn3);
		jf.setSize(400, 550);
		jf.setLayout(null);
		jf.setVisible(true);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn1) {
			try 
			{
				Statement stmt;
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn =    DriverManager.getConnection("jdbc:mysql://localhost:3306/javalab", "rohitkeshri587", "sql123");
				if (conn != null)
				{
					System.out.println("Connection successful !!!");
					String Repno = jtf1.getText();
					String Repname = jtf2.getText();
					String state = jtf3.getText();
					String commission = jtf4.getText();
					String rate = jtf5.getText();
					stmt = (Statement) conn.createStatement();
					System.out.println(Repno + Repname + state + commission);
					String query1 = "insert into Representative values('"+ Repno + "','" + Repname + "','" + state+ "','" + commission + "','" + rate + "');";
					stmt.executeUpdate(query1);
				} 
				else
					System.out.println("Connection  not successful !!!");
			} 
			catch (SQLException ex)
			{
				System.out.println(ex.getMessage());
			} 
			catch (ClassNotFoundException exx) 
			{
				System.out.println(exx.getMessage());
			}
		}
		
		
		if(e.getSource()==btn2) {
			try
			{
				Statement stmt2;
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javalab", "rohitkeshri587", "sql123");
				if (conn != null) 
				{
					System.out.println("Connection successful !!!");
					String Custno = jtf6.getText();
					String CustName = jtf7.getText();
					String state = jtf8.getText();
					String Credit = jtf9.getText();
					int cr = Integer.parseInt(Credit);
					String Rno = jtf10.getText();
					stmt2 = (Statement) conn.createStatement();
					System.out.println(Custno + CustName + state + cr + Rno);
                    String query2 = "insert into Customer values('"+ Custno + "','" + CustName +"','" + state+ "','" + cr + "','" + Rno + "');";
					stmt2.executeUpdate(query2);

				} 
				else
					System.out.println("Connection  not successful !!!");
			} 
			catch (SQLException ex) 
			{
				System.out.println(ex.getMessage());
			}
			catch (ClassNotFoundException exx)
			{
				System.out.println(exx.getMessage());
			}

		}
		
		
		if(e.getSource()==btn3) {
			try {
				jta.setBounds(0, 0, 400, 400);
				jf2.setSize(400, 400);
				jf2.add(jta);
				jf2.setLayout(null);
				Statement stmt;
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javalab", "rohitkeshri587", "sql123");
				stmt = con.createStatement();
				String query ="SELECT * FROM Representative WHERE RepNo IN (SELECT RepNo FROM Customer WHERE Credit > 15000 )";
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next())
				{
					jta.append("Representative Information");
					jta.append("\n");
					jta.append("Number:");
					jta.append(rs.getString("RepNo"));
					jta.append("\n");
					jta.append("Name:");
					jta.append(rs.getString("RepName"));
					jta.append("\n");
					jta.append("State:");
					jta.append(rs.getString("State"));
					jta.append("\n");
					jta.append("Comission:");
					jta.append(rs.getString("Comission"));
					jta.append("\n");
					jta.append("Rate:");
					jta.append(rs.getString("Rate"));
					jta.append("\n");
				}
				jf.setVisible(false);
				jf2.setVisible(true);
				
			}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
	}
}
