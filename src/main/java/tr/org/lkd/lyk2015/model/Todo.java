package tr.org.lkd.lyk2015.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*
*	cengizhan Ozcan
*	2015
*/

public class Todo {

	private Long id;
	private String name;
	private String desc;
	private Calendar date;
	private boolean isDone;
	

	public Todo() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public boolean getIsDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String readableDate(){
		String value ="";
		try {
			
		value = date.get(Calendar.YEAR) +" "+ (date.get(Calendar.MONTH) + 1) + " "+date.get(Calendar.DAY_OF_MONTH);
		System.out.println(value +" readable Date");

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return value;
	}
	
	 
	
}

