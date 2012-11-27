package gameBuilding;

import java.util.ArrayList;

public class UsableCreator {
	
		ArrayList<Object> useAbleList;

	public UsableCreator() {
		useAbleList = new ArrayList<Object>();
		
		createUseableList();
	}
	
	/**
	 * Einfügen der Benutzbaren Items
	 * 1 = Beide Gegenstände Werden gelöscht. 1 Neues wird Freigegeben.
	 * 2 = sichtbarkeit ändern. 1 Gegestand weg.
	 * 
	 */
	private void createUseableList() {
		
		fourAdder("Moehre","Kaninchen",2,"Holz");
		fourAdder("Lilie","Rose",1,"Blumenstrauß");
	}
	
	/**
	 * Vereinfacht die Darstellung und Übersicht für die einfügen der UseAbleElemente
	 * 
	 * @param string GameObject 1
	 * @param string2 GameObject 2
	 * @param string3 GameObject was Erschaffen/Verändert wird (nicht immer relavant)
	 * @param i Anwendungsfall
	 */
	private void fourAdder(String string, String string2, int i,String string3) {
		useAbleList.add(string);
		useAbleList.add(string2);
		useAbleList.add(i);
		useAbleList.add(string3);
	}
	
	public ArrayList<Object> getUseAbleList() {
		return useAbleList;
	}
}
