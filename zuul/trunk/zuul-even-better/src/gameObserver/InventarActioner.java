package gameObserver;

import java.util.Observable;
/**
 * der Actioner der das Spielerinventar enthält
 * @author Aismael
 *
 */
public class InventarActioner extends Observable {
	public InventarActioner(){
		
	}
	/**
	 * Meldet wenn sich die Inventarliste des Spielers ändert
	 * @param name der String der die Inventargegenstände des Spielers enthält
	 */
	public void setInventarListe(String name) {
		setChanged();
		notifyObservers(name);
		
	}
	
	

}
