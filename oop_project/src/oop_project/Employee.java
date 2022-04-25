package oop_project;

public class Employee {

	//Variables for employee information
	private String registryNumber = "NaN";
	private String name = "NaN";
	
	//Constructor
	public Employee(String registryNumber, String name) {
		super();
		this.registryNumber = registryNumber;
		this.name = name;
	}

	
	//Gets n Sets
	public String getRegistryNumber() {
		return registryNumber;
	}

	public void setRegistryNumber(String registryNumber) {
		this.registryNumber = registryNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
