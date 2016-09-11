package model;

import java.util.Date;

public class ToDoList {
	private static int count =0;
	int id;
	String itemName;
	Date date = new Date();
	boolean check;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ToDoList(String itemName, Date date, boolean check) {
		super();
		count++;
		this.date = date;
		this.id=count;
		this.itemName = itemName;
		this.date = date;
		this.check = check;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	
	
	

}