package oop_project;

public class Rooms {
	//Variables
	private String roomNumber = "NaN";
	private int totalDaysofStay;
	private double dailyAmount;
	
	
	//Constructors
	public Rooms(String roomNumber) {
		super();
		this.roomNumber = roomNumber;
	}
	
	public Rooms(String roomNumber, int totalDaysofStay, double dailyAmount) {
		super();
		this.roomNumber = roomNumber;
		this.totalDaysofStay = totalDaysofStay;
		this.dailyAmount = dailyAmount;
	}



	//Gets n Sets
	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getTotalDaysofStay() {
		return totalDaysofStay;
	}

	public void setTotalDaysofStay(int totalDaysofStay) {
		this.totalDaysofStay = totalDaysofStay;
	}

	public double getDailyAmount() {
		return dailyAmount;
	}

	public void setDailyAmount(double dailyAmount) {
		this.dailyAmount = dailyAmount;
	}

	
	

}
