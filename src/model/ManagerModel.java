package model;

import java.util.ArrayList;

public class ManagerModel {

	private ArrayList<Client> arrayList = new ArrayList<>();

	public void addRecord(Client record) {
		arrayList.add(record);
	}

	public void deleteRecord(int position) {
		arrayList.remove(position);
	}

	public void clean() {
		arrayList.clear();
	}

	public int getSize() {
		return arrayList.size();
	}

	public Client searchClient(int id) {

		for (int i = 0; i < arrayList.size(); i++) {	
			if (id==arrayList.get(i).getId()) {
				return arrayList.get(i);
			}
		}
		return null;
	}
	
	public double getTotalRecycle() {
		
		double aux =0;
		
		
		for (int i = 0; i < arrayList.size(); i++) {
			aux += arrayList.get(i).getTotalRegister();
		}
		
		
		return aux;
		
		
		
	}

}
