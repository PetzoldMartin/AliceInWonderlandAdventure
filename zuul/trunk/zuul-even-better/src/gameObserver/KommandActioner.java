package gameObserver;

import java.util.Observable;

/**
 * Der Actioner der die Game Kommandos enth�lt
 * @author Aismael
 *
 */
public class KommandActioner extends Observable {
	public KommandActioner(){
		
	}
	/**
	 * Die Methode die meldet wenn sich die Game Kommandos �ndern
	 * @param Ausgaben der String der die GameKommandos enth�lt
	 */
	public void setCurrentAusgaben(String Ausgaben) {
		setChanged();
		notifyObservers(Ausgaben);
		
	}
	
	

}
