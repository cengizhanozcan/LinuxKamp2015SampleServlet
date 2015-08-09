package tr.org.lkd.lyk2015.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tr.org.lkd.lyk2015.model.Storage;
import tr.org.lkd.lyk2015.model.Todo;

/*
*	cengizhan Ozcan
*	2015
*/

@WebServlet(urlPatterns = "/list")
public class ListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("List Servert Do Get method.");
		List<Todo> list = Storage.convertListFromMap();

		req.setAttribute("deneme", "Todo List");

		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/list.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("List Post");
		String checkedId = req.getParameter("id");
		Long id = Long.parseLong(checkedId);
		Storage.getData().get(id).setDone(true);

		List<Todo> list = Storage.convertListFromMap();
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/list.jsp").forward(req, resp);
		

	}
}
