package gameObserver;

import java.util.Observable;

public class InventarActioner extends Observable {
	public InventarActioner(){
		
	}
	public void setInventarListe(String name) {
		setChanged();
		notifyObservers(name);
		
	}
	
	

}
