

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class telephoneSearch
 */
@WebServlet("/telephoneSearch")
public class telephoneSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public telephoneSearch() {
        super();
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
			if(pno==null)
				pno="";
			if(name==null)
				name="";
			try {
				Statement stmt;
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javalab", "rohitkeshri587", "sql123");
				stmt = con.createStatement();
				String q = "select * from tele where name='"+name+"' or pno='"+pno+"';";
				ResultSet rs = stmt.executeQuery(q);
				if(rs.isBeforeFirst())
				{
					while(rs.next()) {
					out.println(rs.getString("pno"));
					out.println(rs.getString("name"));
					out.println(rs.getString("addr"));
					out.println(rs.getString("comp"));
					out.println(rs.getString("pin"));
					out.println("\n");
					}
				}
				else
					out.println("Not found");
				out.print("<a href=\"search.html\">Back</a>");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
