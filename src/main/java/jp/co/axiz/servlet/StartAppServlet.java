package main.java.jp.co.axiz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.axiz.app.App;
import jp.co.axiz.app.CardGameApp;
import jp.co.axiz.app.ClockApp;
import jp.co.axiz.app.DartsGameApp;
import jp.co.axiz.app.GameApp;

/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/StartAppServlet")
public class StartAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartAppServlet() {
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
		// doGet(request, response);
		
		request.setCharacterEncoding("UTF-8");
	    String name = request.getParameter("name");
	    if(name.isEmpty()) {
		    request.getRequestDispatcher("/appStart.jsp").forward(request, response);
	    }
	    String app = request.getParameter("app");
	    
	    String result = "アプリの実行に失敗しました。";
	    App item = new CardGameApp();
	    
	    if("card".equals(app)) {
	    	item = new CardGameApp("トランプ");
	    	result = lock(item, name);
	    }else if("darts".equals(app)) {
	    	item = new DartsGameApp("ダーツ");
	    	result = lock(item, name);
	    }else if("clock".equals(app)) {
	    	item = new ClockApp();
	    	result = lock(item, name);
	    }
	    
	    if(item instanceof GameApp) {
	    	GameApp gameApp = (GameApp)item;
	    	request.setAttribute("playTime", gameApp.getPlayTime());
	    }
	    
	    request.setAttribute("result", result);
	    request.getRequestDispatcher("/appStart.jsp").forward(request, response);
	}

	private String lock(App item, String name) {
		return item.start(name);
	}

}
