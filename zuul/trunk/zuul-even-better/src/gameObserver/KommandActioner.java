package gameObserver;

import java.util.Observable;


public class KommandActioner extends Observable {
	public KommandActioner(){
		
	}
	public void setCurrentAusgaben(String Ausgaben) {
		setChanged();
		notifyObservers(Ausgaben);
		
	}
	
	

}
