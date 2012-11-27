package gameBuilding;

import java.util.ArrayList;

public class UsableCreator {
	
		ArrayList<Object> useAbleList;

	public UsableCreator() {
		useAbleList = new ArrayList<Object>();
		
		createUseableList();
	}
	
	/**
	 * Einf�gen der Benutzbaren Items
	 * 1 = Beide Gegenst�nde Werden gel�scht. 1 Neues wird Freigegeben.
	 * 2 = sichtbarkeit �ndern. 1 Gegestand weg.
	 * 
	 */
	private void createUseableList() {
		
		fourAdder("Moehre","Kaninchen",2,"Holz");
		fourAdder("Lilie","Rose",1,"Blumenstrau�");
	}
	
	/**
	 * Vereinfacht die Darstellung und �bersicht f�r die einf�gen der UseAbleElemente
	 * 
	 * @param string GameObject 1
	 * @param string2 GameObject 2
	 * @param string3 GameObject was Erschaffen/Ver�ndert wird (nicht immer relavant)
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
