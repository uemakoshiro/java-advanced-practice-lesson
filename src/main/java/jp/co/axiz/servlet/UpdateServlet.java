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
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
    @SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String result = "車体の色と現在速度を変更しました";
    	request.setCharacterEncoding("UTF-8");
    	String bodyColor = request.getParameter("bodyColor");
    	String strSpeed = request.getParameter("speed");
    	int speed = Integer.parseInt(strSpeed);
    	
    	HttpSession session = request.getSession();
    	ArrayList<Car> carList = (ArrayList<Car>) session.getAttribute("latestCar");
    	
    	Car car = new Car();
    	car.setCarName(carList.get(carList.size()-1).getCarName());
    	car.setMaxSpeed(carList.get(carList.size()-1).getMaxSpeed());
    	car.setBodyColor(bodyColor);
    	car.setSpeed(speed);
    	
    	carList.add(car);
    	
    	request.setAttribute("result", result);
    	session.setAttribute("latestCar", carList);
        request.getRequestDispatcher("update.jsp").forward(request, response);

    }
}
