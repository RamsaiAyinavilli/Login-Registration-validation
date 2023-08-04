package servlet.Registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String upwd = request.getParameter("pass");
		String umobile = request.getParameter("contact");
	
		/*PrintWriter out = response.getWriter();
		out.print(uname);
		out.print(uemail);
		out.print(upwd);
		out.print(umobile);*/
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://@localhost:3306/rs","root","ramsai321");
		PreparedStatement pst = con.prepareStatement("insert into users(uname,upwd,uemail,umobile)values(?,?,?,?)");
		pst.setString(1, uname);
		pst.setString(2, upwd);
		pst.setString(3, uemail);
		pst.setString(4, umobile);
		
		int rowCount=pst.executeUpdate();
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		if(rowCount > 0) {
			//need craete dispatcher
			request.setAttribute("status", "success");
		}
		else {
			request.setAttribute("status", "failed");
		}
		dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		
		
	}

}
