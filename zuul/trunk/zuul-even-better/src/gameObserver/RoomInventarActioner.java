package gameObserver;

import java.util.Observable;

public class RoomInventarActioner extends Observable {
	public RoomInventarActioner(){
		
	}
	public void setInventarListe(String name) {
		setChanged();
		notifyObservers(name);
		
	}
	
	

}
