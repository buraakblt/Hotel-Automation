package oop_project;

public class Standart_Customer extends Customer {

	//Discount variable for standart customer
	private double discount = 0.0;
	
	//Construtor
	public Standart_Customer(String customerID, String customerName, int customerAge) {
		super(customerID, customerName, customerAge);
		// TODO Auto-generated constructor stub
	}

	//Overriding setAmount method
	@Override
	public void setAmount(Rooms room, double dailyAmount) {
		// TODO Auto-generated method stub
		super.setAmount(room, dailyAmount-(dailyAmount*discount));
	}

	
	//Gets n Sets
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	

	
	
}
