package gameObserver;

import java.util.Observable;
/**
 * der Actioner der das Rauminventar enthält
 * @author Aismael
 *
 */
public class RoomInventarActioner extends Observable {
	public RoomInventarActioner(){
		
	}
	/**
	 * Meldet wenn sich die Inventarliste des Raumes ändert
	 * @param name der String der die Inventargegenstände des Raumes enthält
	 */
	public void setInventarListe(String name) {
		setChanged();
		notifyObservers(name);
		
	}
	
	

}
