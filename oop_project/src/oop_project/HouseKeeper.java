package oop_project;

import java.util.ArrayList;

public class HouseKeeper extends Employee implements CanAddRoom{

	//ArrayList to adding rooms for housekeeper
	ArrayList<Rooms> rooms = new ArrayList<Rooms>();
	
	//Constructor
	public HouseKeeper(String registryNumber, String name) {
		super(registryNumber, name);
		// TODO Auto-generated constructor stub
	}
	
	//Gets n Sets
	public ArrayList<Rooms> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Rooms> rooms) {
		this.rooms = rooms;
	}

	
	
	//Adding room for housekeeper
	@Override
	public void addRoom(Rooms rooms) {
		// TODO Auto-generated method stub
		this.rooms.add(rooms);
	}


}
