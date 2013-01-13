package gameObserver;

import java.util.Observable;
/**
 * der Actioner der das Rauminventar enth�lt
 * @author Aismael
 *
 */
public class RoomInventarActioner extends Observable {
	public RoomInventarActioner(){
		
	}
	/**
	 * Meldet wenn sich die Inventarliste des Raumes �ndert
	 * @param name der String der die Inventargegenst�nde des Raumes enth�lt
	 */
	public void setInventarListe(String name) {
		setChanged();
		notifyObservers(name);
		
	}
	
	

}
