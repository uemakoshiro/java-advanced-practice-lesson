package jp.co.axiz.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/inputServlet")
public class InputServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String result = "未入力の項目があります。";
    	request.setCharacterEncoding("UTF-8");
    	String carName = request.getParameter("carName");
    	String bodyColor = request.getParameter("bodyColor");
    	String strMaxSpeed = request.getParameter("maxSpeed");
    	int maxSpeed = Integer.parseInt(strMaxSpeed);
    	
    	if(Utility.isNullOrEmpty(carName) || Utility.isNullOrEmpty(bodyColor) || Utility.isNullOrEmpty(strMaxSpeed)) {
    		request.setAttribute("result", result);
            request.getRequestDispatcher("input.jsp").forward(request, response);
    	}
    	
    	Car car = new Car(carName, bodyColor, maxSpeed);
    	ArrayList<Car> carList = new ArrayList<Car>();
    	carList.add(car);
    	
    	HttpSession session = request.getSession();
    	session.setAttribute("latestCar", carList);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }
}
