package tr.org.lkd.lyk2015.model;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*	cengizhan Ozcan
*	2015
*/

public class Storage {

	static private Map< Long, Todo> data = new HashMap<Long, Todo>();
	static private Long counter = 1L;
	
	private Storage() {

	}
 

	public static Map<Long, Todo> getData() {
		return data;
	}


	public static void setData(Map<Long, Todo> data) {
		Storage.data = data;
	}


	static public void generateData(){
		
		Calendar cal = Calendar.getInstance();
	 
		 
		Todo todo1 = new Todo();
		todo1.setId(counter);
		todo1.setName("HomeWork1");
		todo1.setDesc("Description1");
		todo1.setDate(Calendar.getInstance());
		todo1.setDone(false);
		data.put(counter++, todo1);
		
		Todo todo2  = new Todo();
		todo2.setId(counter);
		todo2.setName("HomeWork2");
		todo2.setDesc("Description2");
		todo2.setDate(Calendar.getInstance());
		todo2.setDone(false);
		data.put(counter++, todo2);
		
		Todo todo3  = new Todo();
		todo3.setId(counter);
		todo3.setName("HomeWork3");
		todo3.setDesc("Description3");
		todo3.setDate(Calendar.getInstance());
		todo3.setDone(false);
		data.put(counter++, todo3);
		
		System.out.println("Storage Class'ı Calisti");
	}
	
	
	
	static public Long getCounter(){
		return counter;
	}
	
	static public void increaseCounter(){
		counter++;
	}
	
	static public List<Todo> convertListFromMap() {
		
		List<Todo> list = new ArrayList<Todo>(Storage.getData().values());
		
		for (Todo todo : list) {
			System.out.println(todo.getName()); 
		}
		return list;
	}
	
}

