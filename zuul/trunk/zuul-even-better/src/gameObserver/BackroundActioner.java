package gameObserver;

import java.util.Observable;

/**
 * Die Klasse die den namen des Aktuellen Raumes beinhaltet
 * @author Aismael
 * 
 */
public class BackroundActioner extends Observable {
	public BackroundActioner() {

	}

	/**
	 * die Methode die den Aktuellen Raumnamen Meldet
	 * @param name der Raumname
	 */
	public void setCurrentRoom(String name) {
		setChanged();
		notifyObservers(name);

	}

}
