package tr.org.lkd.lyk2015.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pUpdateId = req.getParameter("id");
		Long updateId = Long.parseLong(pUpdateId);
		Todo todo = Storage.getData().get(updateId);

		if (todo != null) {
			System.out.println(todo.getName());
 
			
			req.setAttribute("headerName", "Güncelle");
			req.setAttribute("info", " ");
			req.setAttribute("todo", todo);
			
			req.getRequestDispatcher("WEB-INF/update.jsp").forward(req, resp);

		} else {
			req.setAttribute("headerName", "Erorroorrro.");
			req.setAttribute("info", "Böyle bir Todo bulunmamaktadır.");
			req.getRequestDispatcher("WEB-INF/update.jsp").forward(req, resp);

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pUpdateId = req.getParameter("id");
		Long updateId = Long.parseLong(pUpdateId);
		String name = req.getParameter("name");
		String desc = req.getParameter("desc");
		String pIsDone = req.getParameter("check");
		String date = req.getParameter("dueDate");

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();

		try {
			cal.setTime(df.parse(date));

		} catch (ParseException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		boolean isDone = false;
		if (pIsDone != null) {
			if (pIsDone.equalsIgnoreCase("true")) {
				isDone = true;
			}
		}else
		{	
			isDone = false;
		}

		Storage.getData().get(updateId).setName(name);
		Storage.getData().get(updateId).setDesc(desc);
		Storage.getData().get(updateId).setDate(cal);
		Storage.getData().get(updateId).setDone(isDone);

		System.out.println(pIsDone + " " + name + " " + desc);

		req.setAttribute("info", "Güncelleme Basarili.");

		Todo todo = Storage.getData().get(updateId);
		req.setAttribute("todo", todo);
		req.getRequestDispatcher("WEB-INF/update.jsp").forward(req, resp);

	}
}
