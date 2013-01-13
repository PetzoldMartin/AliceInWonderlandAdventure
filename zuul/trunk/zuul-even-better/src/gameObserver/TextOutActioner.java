package gameObserver;

import java.util.Observable;
/**
 * die Klasse die die Textausgabe enthält
 * @author Aismael
 *
 */
public class TextOutActioner extends Observable {
	public TextOutActioner(){
		
	}
	/**
	 * die methode die Änderungen des Ausgabetextes meldet
	 * @param arg der zu übergebende Text
	 */
	public void setTextOutLine(String arg) {
		setChanged();
		notifyObservers(arg);
		
	}
	
	

}
