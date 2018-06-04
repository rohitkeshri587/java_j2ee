

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class telephoneEntry
 */
@WebServlet("/telephoneEntry")
public class telephoneEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public telephoneEntry() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String name = request.getParameter("sname");
		String pno = request.getParameter("pno");
		String addr = request.getParameter("addr");
		String comp = request.getParameter("comp");
		String pin = request.getParameter("pin");
		
		try {
			Statement stmt;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javalab", "rohitkeshri587", "sql123");
			stmt = con.createStatement();
			String q ="insert into tele values('"+pno+"','"+name+"','"+addr+"','"+comp+"','"+pin+"');";
			System.out.println("1st checkpoint");
			stmt.executeUpdate(q);
			out.println("Data inserted");
			out.print("<a href=\"entry.html\">Back</a>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
