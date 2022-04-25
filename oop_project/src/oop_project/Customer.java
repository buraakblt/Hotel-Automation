package oop_project;

import java.util.ArrayList;

public class Customer implements CanSelectRoom{
	//Variables
	private String customerID = "NaN";
	private String customerName = "NaN";
	private int customerAge;
	public ArrayList<Rooms> selected_room = new ArrayList<Rooms>();
	
	//Constructor
	public Customer(String customerID, String customerName, int customerAge) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerAge = customerAge;
	}

	//Gets n Sets
	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
	
	public ArrayList<Rooms> getSelected_room() {
		return selected_room;
	}

	public void setSelected_room(ArrayList<Rooms> selected_room) {
		this.selected_room = selected_room;
	}

	
	
	//Selecting Room
	@Override
	public void selectRoom(Rooms rooms) {
		// TODO Auto-generated method stub
		this.selected_room.add(rooms);
	}
	
	//Setting Daily Amount
	public void setAmount(Rooms room, double dailyAmount) {
		room.setDailyAmount(dailyAmount);
	}
	
	//Setting Total Days of Stay
	public void setTotalDays(Rooms room, int days) {
		room.setTotalDaysofStay(days);
	}
	
	//Getting Total Amount
	public double getTotalAmount(Rooms room) {
		return (room.getDailyAmount()*room.getTotalDaysofStay());
	}
	

	


}
