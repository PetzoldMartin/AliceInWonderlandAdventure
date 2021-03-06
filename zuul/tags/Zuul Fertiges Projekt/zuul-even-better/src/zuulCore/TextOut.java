package zuulCore;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Die Klasse die s�mtliche Textausgaben des Spieles Entgegenimmt
 * und an die GUI weiterleitet
 * @author Aismael
 *
 */
public class TextOut extends Observable {

	/**
	 * der interne Speicher f�r Ausgabezeilen
	 */
	ArrayList<String> ausgaben;
	/**
	 * der Interne Speicher f�r Ausgaben die auf einer Zeile Zusammengesetzt werden sollen
	 */
	String textZeile;
	/**
	 * Der Konstruktor der TextOut Klasse
	 */
	public TextOut() {
		ausgaben = new ArrayList<String>();
		textZeile = "";
	}

	/**
	 * Die Methode die den Text den das {@link TextOut} entgegenimmt an die GUI
	 * �bergibt und aus dem Internen Speicher L�scht
	 */
	public void ausgabe() {
		String newEntry = null;
		ausgaben.add(textZeile);
		for (int j = 0; j < ausgaben.size(); j++) {
			if (ausgaben.get(j) != ">") {
				gameMakeTextout(ausgaben.get(j));
			} 
			else {
				newEntry = ausgaben.get(j);
			}

		}
		if (newEntry != null) {
			gameMakeTextout(newEntry);
		}
		clearTextOut();

	}

	
	public void clearTextOut(){
		ausgaben.clear();
		textZeile = "";
	}
	/**
	 * Die Methode die eine Textzeile engegenimmt
	 * @param line
	 */
	public void lineEntry(String line) {
		ausgaben.add(line);
	}

	/**
	 * Die Methode die eine Leerzeile erzeugt
	 */
	public void lineEntry() {
		ausgaben.add("");
	}

	/**
	 * die methode die eine Eingabe engegenimmt die auf die Zusammengesetzte Ausgabezeile geschrieben wird
	 * @param lineComp
	 */
	public void entry(String lineComp) {
		textZeile = textZeile + lineComp;
	}

	/**
	 * die methode die wenn der gesuchte Text vorhanden ist desen existenz best�tigt
	 * @param gesucht der Gesuchte Ausgabetext
	 * @return ob der gesuchte Text vorhanden ist
	 */
	public boolean AusgabeVorhanden(String gesucht) {
		for (int i = 0; i < ausgaben.size(); i++) {
			if (ausgaben.get(i).equals(gesucht))
				return true;
		}
		return false;

	}

	/**
	 * 
	 * @return die Aktuelle zusammengesetzte textzeile
	 */
	public String getTextZeile() {
		return textZeile;
	}
	
	/**
	 * Methode die eine Meldung an den Observer sendet
	 * wenn sich die Textausgaebe Ver�ndert
	 * @param textout der String der sich ver�ndert
	 */
	public void gameMakeTextout(String textout){
		setChanged();
		notifyObservers(textout);
	}

}
