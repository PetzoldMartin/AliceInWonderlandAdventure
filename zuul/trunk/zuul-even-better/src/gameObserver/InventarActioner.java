package gameObserver;

import java.util.Observable;
/**
 * der Actioner der das Spielerinventar enth�lt
 * @author Aismael
 *
 */
public class InventarActioner extends Observable {
	public InventarActioner(){
		
	}
	/**
	 * Meldet wenn sich die Inventarliste des Spielers �ndert
	 * @param name der String der die Inventargegenst�nde des Spielers enth�lt
	 */
	public void setInventarListe(String name) {
		setChanged();
		notifyObservers(name);
		
	}
	
	

}
