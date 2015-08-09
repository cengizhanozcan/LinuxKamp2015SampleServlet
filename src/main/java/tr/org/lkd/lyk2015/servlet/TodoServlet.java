package tr.org.lkd.lyk2015.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

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


@WebServlet(urlPatterns="/todo")
public class TodoServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("WEB-INF/todo.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String desc = req.getParameter("desc");
		String date = req.getParameter("dueDate");
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal  = Calendar.getInstance();
		
		try {
			cal.setTime(df.parse(date));
			
		} catch (ParseException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		
		Todo todo = new Todo();
		todo.setName(name);
		todo.setDesc(desc);
		todo.setId(Storage.getCounter());
		todo.setDone(false);
		todo.setDate(cal);
		Storage.getData().put(todo.getId(), todo );
		Storage.increaseCounter();
		
		
		//redirect to /list
		resp.sendRedirect("list");
		
	}
}

