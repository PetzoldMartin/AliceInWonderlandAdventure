package zuulCore;

import java.util.ArrayList;

/**
 * Die Klasse die s�mtliche Textausgaben des Spieles Entgegenimmt
 * und an die GUI weiterleitet
 * @author Aismael
 *
 */
public class TextOut {

	ArrayList<String> ausgaben;//der interne Speicher f�r Ausgabezeilen
	String textZeile;//der Interne Speicher f�r Ausgaben die auf einer Zeile Zusammengesetzt werden sollen
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
				System.out.println(ausgaben.get(j));
			} // NOPMD by Aismael on 27.11.12 15:07
			else {
				newEntry = ausgaben.get(j);
			}

		}
		if (newEntry != null) {
			System.out.print(newEntry);// NOPMD by Aismael on 27.11.12 15:07
		}
		ausgaben.clear();
		textZeile = "";

	}

	/**
	 * 
	 * @param line
	 */
	public void lineEntry(String line) {
		ausgaben.add(line);
	}

	/**
	 * 
	 */
	public void lineEntry() {
		ausgaben.add("");
	}

	/**
	 * 
	 * @param lineComp
	 */
	public void entry(String lineComp) {
		textZeile = textZeile + lineComp;
	}

	/**
	 * 
	 * @param gesucht
	 * @return
	 */
	public boolean AusgabeVorhanden(String gesucht) {
		for (int i = 0; i < ausgaben.size(); i++) {
			if (ausgaben.get(i) == gesucht)
				return true;
		}
		return false;

	}

	/**
	 * 
	 * @return
	 */
	public String getTextZeile() {
		return textZeile;
	}

}
