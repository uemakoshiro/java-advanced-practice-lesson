

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
	    String id = request.getParameter("id");
	    String pass = request.getParameter("password");
	    String result = "";
	    
	    if(Utility.isNullOrEmpty(id) || Utility.isNullOrEmpty(pass)) {
	    	String idEmp = "false";
	    	String passEmp = "false";
	    	if(Utility.isNullOrEmpty(id)) {
	    		idEmp = "true";
	    	}
	    	if(Utility.isNullOrEmpty(pass)) {
	    		passEmp = "true";
	    	}
	    	request.setAttribute("idEmp", idEmp);
	    	request.setAttribute("passEmp", passEmp);
		    request.getRequestDispatcher("/login.jsp").forward(request, response);
	    }
	    else if("axiz".equals(id) && "axizuser".equals(pass) || "technocore".equals(id) && "techno-pass".equals(pass)) {
	    	request.setAttribute("id", id);
		    request.getRequestDispatcher("/result.jsp").forward(request, response);
	    }else {
	    	result = "miss";
	    	request.setAttribute("result", result);
	    	request.getRequestDispatcher("/login.jsp").forward(request, response);
	    }
	    
	}

}
