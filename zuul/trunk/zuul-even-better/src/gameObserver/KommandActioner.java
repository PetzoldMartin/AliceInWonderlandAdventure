package gameObserver;

import java.util.Observable;

/**
 * Der Actioner der die Game Kommandos enthält
 * @author Aismael
 *
 */
public class KommandActioner extends Observable {
	public KommandActioner(){
		
	}
	/**
	 * Die Methode die meldet wenn sich die Game Kommandos ändern
	 * @param Ausgaben der String der die GameKommandos enthält
	 */
	public void setCurrentAusgaben(String Ausgaben) {
		setChanged();
		notifyObservers(Ausgaben);
		
	}
	
	

}
