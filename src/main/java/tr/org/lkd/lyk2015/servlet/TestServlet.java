package tr.org.lkd.lyk2015.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tr.org.lkd.lyk2015.model.Storage;

/*
*	cengizhan Ozcan
*	2015
*/

@WebServlet(urlPatterns="/test")
public class TestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Test Verileri Yükleniyor.");
		Storage.generateData();
		
		req.getRequestDispatcher("WEB-INF/test.jsp").forward(req, resp);

	}
}

