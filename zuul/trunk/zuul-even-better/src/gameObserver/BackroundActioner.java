package gameObserver;

import java.util.Observable;

public class BackroundActioner extends Observable {
	public BackroundActioner(){
		
	}
	public void setCurrentRoom(String name) {
		setChanged();
		notifyObservers(name);
		
	}
	
	

}
