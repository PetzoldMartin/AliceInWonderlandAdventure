package gameObserver;

import java.util.Observable;
/**
 * die Klasse die die Textausgabe enth�lt
 * @author Aismael
 *
 */
public class TextOutActioner extends Observable {
	public TextOutActioner(){
		
	}
	/**
	 * die methode die �nderungen des Ausgabetextes meldet
	 * @param arg der zu �bergebende Text
	 */
	public void setTextOutLine(String arg) {
		setChanged();
		notifyObservers(arg);
		
	}
	
	

}
