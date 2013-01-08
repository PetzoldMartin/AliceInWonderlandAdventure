package zuulCore;

import java.util.HashMap;
import java.util.Iterator;


/**
 * Die Klasse die Etwas mit Inventar oder Raum daerstellt in dem
 * {@link GameObject}e abgelegt und wegenommen werden können
 * 
 * @author Aismael
 * 
 */
public class ThingWithStore {

	private HashMap<String, GameObject> store;//der interne speicher für Gameobjekte

	/**
	 * Konstruktor der {@link ThingWithStore} Klasse
	 */
	public ThingWithStore() {
		store = new HashMap<String, GameObject>();
	}

	/**
	 * Methode um ein {@link GameObject} aus der Sammlung der Klasse zu entfernen
	 * @param ObjektName name des zu entfernenden {@link GameObject}s
	 */
	public void itemRemove(String ObjektName) {
		store.remove(ObjektName);
	}

	/**
	 * Methode um ein {@link GameObject} in die Sammlung einzutragen
	 * @param item das einzutragende {@link GameObject}
	 */
	public void itemStore(GameObject item) {
		store.put(item.getObjName(), item);
	}

	/**
	 * Methode die Überprüft ob das Objekt in der Sammlung vorhanden und sichtbar ist
	 * @param Objektname der name des zu überprüfenden Objects
	 * @return ob das {@link GameObject} vorhanden ist
	 */
	public boolean hasReadyToUseObject(String Objektname) {

		if(store.containsKey(Objektname)){
		return store.get(Objektname).isVisebility();}else{
			return false;
		}

	}

	public boolean hasObject(String Objektname) {

		return store.containsKey(Objektname);

	}
	/**
	 * Methode die das {@link GameObject} zurückgibt wenn es vorhanden ist ansonsten wird ein default Object zurückgegeben
	 * @param ObjektName der Name des auszugebenden {@link GameObject}s
	 * @return das {@link GameObject}
	 */
	public GameObject getSpecialObject(String ObjektName) {
		if (store.containsKey(ObjektName)) {
			return store.get(ObjektName);
		} else {
			return new GameObject();
		}

	}

	/**
	 * Methode die eine Aufzählung aller in der Liste vorhandenen und sichtbaren objeckte an die Textausgabe gibt
	 */
	public void getAllItems() {
		for (Iterator<String> i = store.keySet().iterator(); i.hasNext();) {
			String isUsed = i.next();
			if (store.get(isUsed).isVisebility()) {
				Game.textOut.entry(isUsed + "  ");
			}

		}
		Game.textOut.lineEntry();
	}

	/**
	 * methode die Angibt ob sichtbare {@link GameObject}e vorhanden sind
	 * @return
	 */
	public boolean isThereanyvisible() {
		for (Iterator<String> i = store.keySet().iterator(); i.hasNext();) {
			if (store.get(i.next()).isVisebility()) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Die Methode die Angibt ob die Liste leer ist
	 * @return ob die Liste leer ist
	 */
	public boolean isempty() {
		return store.isEmpty();
	}
}
