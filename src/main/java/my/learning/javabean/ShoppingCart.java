package my.learning.javabean;

import java.io.Serializable;
import java.util.LinkedList;

public class ShoppingCart implements Serializable {
	private static final long serialVersionUID = 1L;
	private LinkedList<String> cartlist=new LinkedList<String>();
	private String submit=null;
	private String item=null;
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	private void addItem(String name) {
		cartlist.add(name);
	}
	private void removeItem(String name) {
		cartlist.remove(name);
	}
	
	public LinkedList<String> getItems(){
		return cartlist;
	}
	
	public void processRequest() {
		if(submit==null||submit.equals("add")) {
			addItem(item);
		}else if(submit.equals("delete")){
			removeItem(item);
		}
		submit=null;
		item=null;
	}
	
}
