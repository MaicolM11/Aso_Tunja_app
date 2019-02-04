package model;

import java.util.ArrayList;

public class Client {

	
	private String name;
	private String lastName;
	private int id;
	private ArrayList < Double > register = new ArrayList < Double > ();
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	
	


	
	public Client(String name, String lastName, int id) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.id = id;
	}
	
	
	public Object[] getRegisterToTable() {
		
		Object[] vector = new Object[register.size()];
		
		
		for (int i = 0; i < register.size(); i++) {
			vector[i]= register.get(i);
		}
		return vector;
	}
	
	

	public ArrayList<Double> getRegister() {
		return register;
	}
	public void setRegister(ArrayList<Double> register) {
		this.register = register;
	}
	public Object[] toObjectVector() {
		return new Object[] { name, lastName, id };
	}
	
	
	public double getTotalRegister() {
		double aux = 0;
		
		for (int i = 0; i < register.size(); i++) {
			aux+=register.get(i);
		}
		
		return aux;
		
	}
	
	public void addWeek(double week) {
		register.add(week);
	}
	
	
	public int getSizeArray() {
		return register.size();
	}

	

}
