package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	// ここに必要な処理を記述してください。
    	request.setCharacterEncoding("UTF-8");
    	String english = request.getParameter("english");
    	if(english.isEmpty()) {
    		request.getRequestDispatcher("dictionary.jsp").forward(request, response);
    	}
    	Dictionary dic = new Dictionary();
    	String result = "見つかりませんでした";
    	if (dic.getDictionaryInfo().containsKey(english)) {
            result = "英語："+ english + "、日本語："+ dic.getDictionaryInfo().get(english);
        }  
    	request.setAttribute("result", result);
        request.getRequestDispatcher("dictionary.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
