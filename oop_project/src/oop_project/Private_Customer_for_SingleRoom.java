package oop_project;

public class Private_Customer_for_SingleRoom extends Private_Customer {

	// Variable for amount
	private double dailyAmount = 100.0;
	
	//Constructor
	public Private_Customer_for_SingleRoom(String customerID, String customerName, int customerAge) {
		super(customerID, customerName, customerAge);
		// TODO Auto-generated constructor stub
	}

	//Overriding setAmount method
	@Override
	public void setAmount(Rooms room, double dailyAmount) {
		// TODO Auto-generated method stub
		this.dailyAmount = dailyAmount;
		super.setAmount(room, dailyAmount);
	}

	//Overriding selectRoom method
	@Override
	public void selectRoom(Rooms room) {
		// TODO Auto-generated method stub
		if(room instanceof Rooms_for_Single) {
			super.selectRoom(room);
		}
		else {
			System.out.println("This room is not suitable for you!");
		}
	}

	//Gets n Sets
	public double getDailyAmount() {
		return dailyAmount;
	}

	public void setDailyAmount(double dailyAmount) {
		this.dailyAmount = dailyAmount;
	}
	
	
	

	
}
