package my.learning.javabean;

import java.io.Serializable;

public class OrderSystem implements Serializable {
	private static final long serialVersionUID = 1L;
	private String orderNumber="20240116001";
	private String shipAddress="Taiwan";
	private String customer="Mary";
	private String phone="0987654321";
	private int amount=0;

	public OrderSystem() {
		// TODO Auto-generated constructor stub
	}
	
	

	public OrderSystem(String orderNumber, String shipAddress, String customer, String phone, int amount) {
		this.orderNumber = orderNumber;
		this.shipAddress = shipAddress;
		this.customer = customer;
		this.phone = phone;
		this.amount = amount;
	}
	



	public OrderSystem(String shipAddress, String customer, String phone, int amount) {
		this.shipAddress = shipAddress;
		this.customer = customer;
		this.phone = phone;
		this.amount = amount;
	}



	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int account) {
		this.amount = account;
	}
	

}
