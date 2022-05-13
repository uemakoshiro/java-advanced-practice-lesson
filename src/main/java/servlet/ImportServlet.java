package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.Animal;
import app.Cat;
import app.Rabbit;

/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/importServlet")
public class ImportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImportServlet() {
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
        
    	String data = request.getParameter("data");
        Animal animal = null;

        if("cat".equals(data)) {
        	animal = new Cat();
        }else {
        	animal = new Rabbit();
        }
        String result = "";

        Path file = Paths.get(animal.getFilePath());

        BufferedReader br = null;

        try {
            br = Files.newBufferedReader(file);

            String text = br.readLine();

            int count = 0;
            
            while (text != null) {
            	count++;
                
            	if(count == 1) {
            		animal.name = text;
            	}else {
            		int textAge = Integer.parseInt(text);
            		animal.age = textAge;
            	}
                text = br.readLine();
            }
            result = animal.introduce();

        } catch (IOException e) {
        	result = "ファイルの読み込みに失敗しました。対象のファイルの存在や文字コードを確認してください。";
        } finally {
            if (br != null) {
                br.close();
            }
        }

        request.setAttribute("result", result);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
