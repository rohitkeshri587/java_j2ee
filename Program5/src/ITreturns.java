

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ITreturns
 */
@WebServlet("/ITreturns")
public class ITreturns extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ITreturns() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("sname");
		String sex = request.getParameter("sex");
		double sal = Double.parseDouble(request.getParameter("salary"));
		double tax = Double.parseDouble(request.getParameter("tax"));
		PrintWriter out = response.getWriter();
		out.println(""+name+sex+sal+tax);
		File file = new File("C:\\Users\\hp\\a.txt");
		file.createNewFile();
		FileOutputStream fout = new FileOutputStream(file);
		fout.write((""+name+sex+sal+tax).getBytes());
		fout.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
