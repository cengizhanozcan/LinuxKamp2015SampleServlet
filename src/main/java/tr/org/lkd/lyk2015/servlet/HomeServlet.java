package tr.org.lkd.lyk2015.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
*	cengizhan Ozcan
*	2015
*/

@WebServlet(urlPatterns = "/hello")
public class HomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Hello Burada");
		
		req.setAttribute("message", "this is my message");
		req.getRequestDispatcher("WEB-INF/home.jsp").forward(req, resp);
			
	}

}
