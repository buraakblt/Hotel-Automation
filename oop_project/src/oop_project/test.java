package oop_project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;




public class test {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		List<Customer> customers = new ArrayList<Customer>();
		List<Rooms> roomList = new ArrayList<Rooms>();
		List<Employee> workers = new ArrayList<Employee>();
		List<Rooms> roomList2 = new ArrayList<Rooms>();
		Scanner scanner = new Scanner(System.in);
		int menu = 1;
		
		do {
			System.out.println("---------------------------------------------------------------------------------------------------------------------\n"
					+ "[1] Rooms\n[2] Customer Adding\n[3] Registration\n[4] Customer Information\n[5] Rooms After Changes\n"
					+ "[6] Workers");
			int mainmenu = scanner.nextInt();
			
			switch (mainmenu) {
			case 1:{
				List<String> rooms = new ArrayList<String>();
				List<String> cleaning = new ArrayList<String>();
				FileReader fileReader;
				try {
					fileReader = new FileReader("rooms.txt");
					Scanner scan = new Scanner(fileReader);
					
					while(scan.hasNextLine()) {
						scan.next();         // read and skip 
						scan.next();         // read and skip 
					    rooms.add(scan.next()); // read and store
					    cleaning.add(scan.next());			    
					}
					scan.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				String[] room=rooms.toArray(new String[rooms.size()]);
				String[] clean=cleaning.toArray(new String[cleaning.size()]);
				System.out.println("Rooms for single person:");
				for (int i=0; i<5;i++)
				{
				    if(room[i].equals("0")) {
				    	if(clean[i].equals("0")) {
				    		System.out.printf("\n%d. room is empty and clear.",(i+1));
				    	}
				    	else {
				    		System.out.printf("\n%d. room is empty but not clear.",(i+1));
				    	}
				    	
				    }
				    else {
				    	System.out.printf("\n%d. room is not empty.",(i+1));
				    }
				}
				
				
		        System.out.println("\n\nRooms for two person:");	
				for (int i=5; i<room.length;i++)
				{
					if(room[i].equals("0")) {
				    	if(clean[i].equals("0")) {
				    		System.out.printf("\n%d. room is empty and clear.",(i+1));
				    	}
				    	else {
				    		System.out.printf("\n%d. room is empty but not clear.",(i+1));
				    	}
				    	
				    }
				    else {
				    	System.out.printf("\n%d. room is not empty.",(i+1));
				    }
				}
				System.out.println("\n\n[0] Main Menu");
				int y=scanner.nextInt();
				if(y == 0) {
					menu = 0;
				}
				else {
					System.out.println("Undefined number selected, you are being redirected to the main menu!");
					menu = 0;
				}
				System.out.println("\n");
				break;
			}
			case 2:{
				int addingMenu=0;
				do {
					Private_Customer_for_SingleRoom customer1 = new Private_Customer_for_SingleRoom("191180754", "Burak Bulut", 22);
					Rooms_for_Single room1 = new Rooms_for_Single("1");
					customer1.selectRoom(room1);
					customer1.setTotalDays(room1, 3);
					customer1.setAmount(room1, customer1.getDailyAmount());
					//System.out.printf("\nTotal amount with discount for private customer %s: %d TL", customer1.getCustomerName(), (int)customer1.getTotalAmount(room1));
					customers.add(customer1);
					roomList.add(room1);
					
					Private_Customer_for_DoubleRoom customer2 = new Private_Customer_for_DoubleRoom("181180037", "Berfin Gülbaþ", 22);
					Rooms_for_Two room2 = new Rooms_for_Two("6");
					customer2.selectRoom(room2);
					customer2.setTotalDays(room2, 1);
					customer2.setAmount(room2, customer2.getDailyAmount());
					//System.out.printf("\nTotal amount with discount for private customer %s: %d TL", customer2.getCustomerName(), (int)customer2.getTotalAmount(room2));
					customers.add(customer2);
					roomList.add(room2);
					
					Standart_Customer_for_SingleRoom customer3 = new Standart_Customer_for_SingleRoom("191180755", "Zeynep Akýn", 32);
					Rooms_for_Single room3 = new Rooms_for_Single("2");
					customer2.selectRoom(room3);
					customer2.setTotalDays(room3, 4);
					customer2.setAmount(room3, customer3.getDailyAmount());
					//System.out.printf("\nTotal amount with discount for private customer %s: %d TL", customer3.getCustomerName(), (int)customer3.getTotalAmount(room3));
					customers.add(customer3);
					roomList.add(room3);
					
					int forSingleRoom = 3;
					int forDoubleRoom = 7;
					int secim;
					String id;
					String name;
					int age;
					int days;
					
					Scanner scan = new Scanner(System.in);
					System.out.println("\nEnter the customer id:\n");
					id=scan.nextLine();
					
					System.out.println("Enter the customer name:\n");
					name=scan.nextLine();
					
					System.out.println("Enter the customer age:\n");
					age=scan.nextInt();
					
					System.out.println("How many days customer will stay:\n");
					days=scan.nextInt();
					
					
					
					System.out.println("[1] Private Customer\n[2] Standart Customer\n");
					secim = scanner.nextInt();
					String str = String.valueOf(forSingleRoom);
					String str1 = String.valueOf(forDoubleRoom);
					
					if(secim == 1) {
						System.out.println("[1] Room for single person\n[2] Room for two person\n");
						int secim2 = scanner.nextInt();
						if(secim2 == 1) {
							Map<String, Private_Customer_for_SingleRoom> map1 = new HashMap<String, Private_Customer_for_SingleRoom>(); 
							map1.put("customer" + forSingleRoom, new Private_Customer_for_SingleRoom(id, name, age));
							Map<String, Rooms_for_Single> mapp1 = new HashMap<String, Rooms_for_Single>(); 
							mapp1.put("room" + forSingleRoom, new Rooms_for_Single(str));
							map1.get("customer" + forSingleRoom).selectRoom(mapp1.get("room" + forSingleRoom));
							map1.get("customer" + forSingleRoom).setTotalDays(mapp1.get("room" + forSingleRoom), days);
							map1.get("customer" + forSingleRoom).setAmount(mapp1.get("room" + forSingleRoom), map1.get("customer" + forSingleRoom).getDailyAmount());
							customers.add(map1.get("customer" + forSingleRoom));
							roomList.add(mapp1.get("room" + forSingleRoom));
							forSingleRoom++;
							System.out.println("\n\n Add customers succeeded!");
						}
						else if(secim2 == 2){
							Map<String, Private_Customer_for_DoubleRoom> map2 = new HashMap<String, Private_Customer_for_DoubleRoom>(); 
							map2.put("customer" + forDoubleRoom, new Private_Customer_for_DoubleRoom(id, name, age));
							Map<String, Rooms_for_Two> mapp2 = new HashMap<String, Rooms_for_Two>(); 
							mapp2.put("room" + forDoubleRoom, new Rooms_for_Two(str1));
							map2.get("customer" + forDoubleRoom).selectRoom(mapp2.get("room" + forDoubleRoom));
							map2.get("customer" + forDoubleRoom).setTotalDays(mapp2.get("room" + forDoubleRoom), days);
							map2.get("customer" + forDoubleRoom).setAmount(mapp2.get("room" + forDoubleRoom), map2.get("customer" + forDoubleRoom).getDailyAmount());
							customers.add(map2.get("customer" + forDoubleRoom));
							roomList.add(mapp2.get("room" + forDoubleRoom));
							forDoubleRoom++;
							System.out.println("\n\n Add customers succeeded!");
						}
						else {
							System.out.println("Undefined number selected!");
							System.out.println("Add customers unsucceded, please try again!");
							break;
						}
					}
					else if(secim == 2) {
						System.out.println("[1] Room for single person\n[2] Room for two person\n");
						int secim2 = scanner.nextInt();
						if(secim2 == 1) {
							Map<String, Standart_Customer_for_SingleRoom> map3 = new HashMap<String, Standart_Customer_for_SingleRoom>(); 
							map3.put("customer" + forSingleRoom, new Standart_Customer_for_SingleRoom(id, name, age));
							Map<String, Rooms_for_Single> mapp3 = new HashMap<String, Rooms_for_Single>(); 
							mapp3.put("room" + forSingleRoom, new Rooms_for_Single(str));
							map3.get("customer" + forSingleRoom).selectRoom(mapp3.get("room" + forSingleRoom));
							map3.get("customer" + forSingleRoom).setTotalDays(mapp3.get("room" + forSingleRoom), days);
							map3.get("customer" + forSingleRoom).setAmount(mapp3.get("room" + forSingleRoom), map3.get("customer" + forSingleRoom).getDailyAmount());
							customers.add(map3.get("customer" + forSingleRoom));
							roomList.add(mapp3.get("room" + forSingleRoom));
							forSingleRoom++;
							System.out.println("\n\n Add customers succeeded!");
						}
						else if(secim2 == 2){
							Map<String, Standart_Customer_for_DoubleRoom> map4 = new HashMap<String, Standart_Customer_for_DoubleRoom>(); 
							map4.put("customer" + forDoubleRoom, new Standart_Customer_for_DoubleRoom(id, name, age));
							Map<String, Rooms_for_Two> mapp4 = new HashMap<String, Rooms_for_Two>(); 
							mapp4.put("room" + forDoubleRoom, new Rooms_for_Two(str1));
							map4.get("customer" + forDoubleRoom).selectRoom(mapp4.get("room" + forDoubleRoom));
							map4.get("customer" + forDoubleRoom).setTotalDays(mapp4.get("room" + forDoubleRoom), days);
							map4.get("customer" + forDoubleRoom).setAmount(mapp4.get("room" + forDoubleRoom), map4.get("customer" + forDoubleRoom).getDailyAmount());
							customers.add(map4.get("customer" + forDoubleRoom));
							roomList.add(mapp4.get("room" + forDoubleRoom));
							forDoubleRoom++;
							System.out.println("\n\n Add customers succeeded!");
						}
						else {
							System.out.println("Undefined number selected!");
							System.out.println("Add customers unsucceded, please try again!");
							break;
						}
					}
					System.out.println("\n[1] New Customer adding\n[2] Main Menu");
					int a = scanner.nextInt();
					
					if(a == 1) {
						addingMenu = a;
					}
					else if(a == 2) {
						addingMenu = 0;
						menu = a;
					}
					else {
						System.out.println("Undefined number selected!");
						System.out.println("\n[1] New Customer adding\n[2] Main Menu");
						a = scanner.nextInt();
						
						if(a == 1) {
							addingMenu = a;
						}
						else if(a == 2)
							menu = a;
						else {
							System.out.println("Undefined number selected, you are being redirected to the main menu!");
							menu = 0;
						}
					}
						
					
				}
				while(addingMenu != 0);
				
				break;
			}
			case 3:{

				File myObj = new File("customers.txt");
				
				try {
					
					
					FileWriter fileWritter = new FileWriter("customers.txt");
					BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
					
					bufferWritter.write("ID\t\tNAME\t\tAGE\tTOTAL AMOUNT\tROOM NUMBER\t\tROOM TYPE\t\tTOTAL DAYS\t\tRECEIPT DATE\t\t\tRELEASE DATE\n"
							+ "------------------------------------------------------------------------------------------"
							+ "-------------------------------------------------------------------------------------------------------\n");
					/*SimpleDateFormat sekil = new SimpleDateFormat();
			        Date tarih = new Date();*/
					
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Date currentDate = new Date();
					
					Calendar c = Calendar.getInstance();
				    c.setTime(currentDate);
					
					
					
					for(int a=0; a<customers.size(); a++) {
						bufferWritter.write(customers.get(a).getCustomerID()+"\t");
						bufferWritter.write(customers.get(a).getCustomerName()+"\t"); 
						bufferWritter.write(customers.get(a).getCustomerAge()+"\t");
						bufferWritter.write((int)customers.get(a).getTotalAmount(roomList.get(a))+" TL\t\t\t");
						bufferWritter.write(roomList.get(a).getRoomNumber()+"\t\t");
						
						if(roomList.get(a) instanceof Rooms_for_Single) {
							bufferWritter.write("for one person\t\t\t");
						}
						else if(roomList.get(a) instanceof Rooms_for_Two) {
							bufferWritter.write("for two person\t\t\t");
						}
						bufferWritter.write(roomList.get(a).getTotalDaysofStay()+"\t\t");
						bufferWritter.write(dateFormat.format(currentDate)+"\t\t");
						
						c.add(Calendar.DATE, roomList.get(a).getTotalDaysofStay());
						Date currentDatePlusOne = c.getTime();
						
						bufferWritter.write(dateFormat.format(currentDatePlusOne));
						bufferWritter.write("\n");
						c.add(Calendar.DATE, -roomList.get(a).getTotalDaysofStay());
						
					}
					bufferWritter.close();
					
					 } catch (IOException e) {
					System.out.println("Error Printing Tab Delimited File");
					 }
				
				System.out.println("Registration complete!");
				System.out.println("\n[0] Main Menu");
				int b = scanner.nextInt();
				if(b == 0) {
					menu = b;
				}
				else {
					System.out.println("Undefined number selected, you are being redirected to the main menu!");
					menu = 0;
					break;
				}
				break;
			}
			case 4:{
				List<String> lines = new ArrayList<String>();
				 try {
				FileReader fileReader = new FileReader("customers.txt");
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line = null;
				while ((line = bufferedReader.readLine()) != null) 
				lines.add(line);
				bufferedReader.close();
				 } catch (IOException e) {
				e.printStackTrace();
				 } 
				String[] info=lines.toArray(new String[lines.size()]);
				for(int i = 0; i<info.length; i++) {
					System.out.println(info[i]);
				}
				System.out.println("\n[0] Main Menu");
				int v = scanner.nextInt();
				if(v == 0)
					menu = 0;
				else {
					System.out.println("Undefined number selected, you are being redirected to the main menu!");
					menu = 0;
				}
				break;
			}
			case 5:{
                File myObj = new File("rooms2.txt");
				
				try {
					
					
					FileWriter fileWritter = new FileWriter("rooms2.txt");
					BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
					
					for(int a=0; a<10; a++) {
						bufferWritter.write(a+1+"\t");
						if(a<5) {
							bufferWritter.write("tek\t");
						}
						else {
							bufferWritter.write("cift\t");
						}
						String str2 = String.valueOf(a+1);
						String yaz="";
						for(int e = 0; e<roomList.size(); e++) {
							if(roomList.get(e).getRoomNumber().equals(str2)) {
								yaz = "1\t";
								break;
							}
							else {
								yaz = "0\t";
							}
						}
						bufferWritter.write(yaz);
						for(int e = 0; e<roomList.size(); e++) {
							if(roomList.get(e).getRoomNumber().equals(str2)) {
								yaz = "1\t";
								break;
							}
							else {
								yaz = "0\t";
							}
						}
						bufferWritter.write(yaz);
						bufferWritter.write("\n");
						
					}
					bufferWritter.close();
					
					 } catch (IOException e) {
					System.out.println("Error Printing Tab Delimited File");
					 }
				System.out.println("Room informations are changed successfully!");
				System.out.println("\n[0] Main Menu\n[1] Show rooms after change");
				int x = scanner.nextInt();
				if(x == 0) {
					menu = 0;
				}
				else if(x == 1) {
					List<String> lines = new ArrayList<String>();
					 try {
					FileReader fileReader = new FileReader("rooms2.txt");
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					String line = null;
					while ((line = bufferedReader.readLine()) != null) 
					lines.add(line);
					bufferedReader.close();
					 } catch (IOException e) {
					e.printStackTrace();
					 } 
					String[] info=lines.toArray(new String[lines.size()]);
					System.out.println("#\t1/2\tCondition\tDirty\n----------------------------------------------------------------");
					for(int i = 0; i<info.length; i++) {
						System.out.println(info[i]);
					}
					System.out.println("\n[0] Main Menu");
					int h = scanner.nextInt();
					if(h == 0)
						menu = 0;
					else {
						System.out.println("Undefined number selected, you are being redirected to the main menu!");
						menu = 0;
					}
				}
				else {
					System.out.println("Undefined number selected, you are being redirected to the main menu!");
					menu = 0;
				}
				break;
			}
			case 6:{
				System.out.println("[1] Add Worker\n[2] Show Workers");
				int choose = scanner.nextInt();
				if(choose == 1) {
					int workersMenu = 0;
					do {
						System.out.println("[1] Housekeeper\n[2] Technician");
						int choose2 = scanner.nextInt();
						
						int k = 1;
						if(choose2 == 1) {
							Scanner scan5 = new Scanner(System.in);
							
							System.out.println("Enter the worker id:");
							String id = scan5.nextLine();
							
							System.out.println("Enter the worker name:");
							String name = scan5.nextLine();
							
							System.out.println("Enter room number for adding worker:");
							int number = scan5.nextInt();
							
							
							if(number <= 5) {
								String str = String.valueOf(number);
								Map<String, HouseKeeper> map1 = new HashMap<String, HouseKeeper>(); 
								map1.put("worker" + k, new HouseKeeper(id, name));
								Map<String, Rooms_for_Single> mapp1 = new HashMap<String, Rooms_for_Single>(); 
								mapp1.put("room" + k, new Rooms_for_Single(str));
								map1.get("worker" + k).addRoom(mapp1.get("room" + k));
								workers.add(map1.get("worker" + k));
								roomList2.add(mapp1.get("room" + k));
								k++;
								System.out.println("\n\nAdd workers succeeded!");
							}
							else if(number > 5) {
								String str = String.valueOf(number);
								Map<String, HouseKeeper> map1 = new HashMap<String, HouseKeeper>(); 
								map1.put("worker" + k, new HouseKeeper(id, name));
								Map<String, Rooms_for_Two> mapp1 = new HashMap<String, Rooms_for_Two>(); 
								mapp1.put("room" + k, new Rooms_for_Two(str));
								map1.get("worker" + k).addRoom(mapp1.get("room" + k));
								workers.add(map1.get("worker" + k));
								roomList2.add(mapp1.get("room" + k));
								k++;
								System.out.println("\n\nAdd workers succeeded!");
							}
							
							
							
						}
						else if(choose2 == 2) {
                            Scanner scan5 = new Scanner(System.in);
							
							System.out.println("Enter the worker id:");
							String id = scan5.nextLine();
							
							System.out.println("Enter the worker name:");
							String name = scan5.nextLine();
							
							System.out.println("Enter room number for adding worker:");
							int number = scan5.nextInt();
							
							
							if(number <= 5) {
								String str = String.valueOf(number);
								Map<String, Technician> map1 = new HashMap<String, Technician>(); 
								map1.put("worker" + k, new Technician(id, name));
								Map<String, Rooms_for_Single> mapp1 = new HashMap<String, Rooms_for_Single>(); 
								mapp1.put("room" + k, new Rooms_for_Single(str));
								map1.get("worker" + k).addRoom(mapp1.get("room" + k));
								workers.add(map1.get("worker" + k));
								roomList2.add(mapp1.get("room" + k));
								k++;
								System.out.println("\n\nAdd workers succeeded!");
							}
							else if(number > 5) {
								String str = String.valueOf(number);
								Map<String, Technician> map1 = new HashMap<String, Technician>(); 
								map1.put("worker" + k, new Technician(id, name));
								Map<String, Rooms_for_Two> mapp1 = new HashMap<String, Rooms_for_Two>(); 
								mapp1.put("room" + k, new Rooms_for_Two(str));
								map1.get("worker" + k).addRoom(mapp1.get("room" + k));
								workers.add(map1.get("worker" + k));
								roomList2.add(mapp1.get("room" + k));
								k++;
								System.out.println("\n\nAdd workers succeeded!");
							}
						}
						else {
							System.out.println("Undefined number selected, you are being redirected to the main menu!");
							menu = 0;
						}
						System.out.println("\n[1] New Worker adding\n[2] Main Menu");
						int a = scanner.nextInt();
						
						if(a == 1) {
							workersMenu = 1;
						}
						else if(a == 2) {
							workersMenu = 0;
							menu = 0;
						}
						else {
							System.out.println("Undefined number selected, you are being redirected to the main menu!");
							menu = 0;
						}
					}while(workersMenu != 0);
					
				}
				else if(choose == 2) {
					File myObj = new File("workers.txt");
					
					try {
						
						
						FileWriter fileWritter = new FileWriter("workers.txt");
						BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
						
						bufferWritter.write("ID\t NAME\t     ROOM NUMBER\tROOM TYPE\t\t\tPROCESS DATE\n"
								+ "-------------------------------------------------------------------------------------------------------\n");
						/*SimpleDateFormat sekil = new SimpleDateFormat();
				        Date tarih = new Date();*/
						
						DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						Date currentDate = new Date();
						
						Calendar c = Calendar.getInstance();
					    c.setTime(currentDate);
						
						
						
						for(int a=0; a<workers.size(); a++) {
							bufferWritter.write(workers.get(a).getRegistryNumber()+"\t");
							bufferWritter.write(workers.get(a).getName()+"\t"); 
							bufferWritter.write(roomList2.get(a).getRoomNumber()+"\t\t");
							
							if(roomList2.get(a) instanceof Rooms_for_Single) {
								bufferWritter.write("for one person\t\t\t");
							}
							else if(roomList2.get(a) instanceof Rooms_for_Two) {
								bufferWritter.write("for two person\t\t\t");
							}
							bufferWritter.write(dateFormat.format(currentDate));
							bufferWritter.write("\n");
							
						}
						bufferWritter.close();
						
						 } catch (IOException e) {
						System.out.println("Error Printing Tab Delimited File");
						 }
					
					List<String> lines = new ArrayList<String>();
					 try {
					FileReader fileReader = new FileReader("workers.txt");
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					String line = null;
					while ((line = bufferedReader.readLine()) != null) 
					lines.add(line);
					bufferedReader.close();
					 } catch (IOException e) {
					e.printStackTrace();
					 } 
					String[] info=lines.toArray(new String[lines.size()]);
					for(int i = 0; i<info.length; i++) {
						System.out.println(info[i]);
					}
					System.out.println("\n[0] Main Menu");
					int v = scanner.nextInt();
					if(v == 0)
						menu = 0;
					else {
						System.out.println("Undefined number selected, you are being redirected to the main menu!");
						menu = 0;
					}
				}
				break;
			}
			default:{
				menu = 0;
			}
			}
			
		}
		while(menu != 1);
		
		
		
		scanner.close();
	}

}


