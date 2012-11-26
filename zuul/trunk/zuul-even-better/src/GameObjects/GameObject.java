package GameObjects;



/**
 * Klasse GameObject
 *
 * Erzeugt die Items die man Aufnehmen. Angucken. und Benutzen kann.
 * 
 */
public class GameObject {

	private String objName;	//Itemname
	private String amplification; //Itembeschreibung
	private boolean takeAble;
	private boolean speakAble;
	private boolean visebility;
	
	/**
	 * Standard Konstruktor der Alles Notwendige erstellt. 
	 */
	public GameObject() {
		objName = "-!-default-!-";
		amplification = "-!-defaul-!-";
		takeAble = false;
		speakAble = false;
		visebility = true;
	}
	
	
	/**
	 * Erstellt Item
	 * 
	 * @param objn Name des GameObject --> Ansprechung des Items über dessen Name :: Proplemzone: Gleiche Belegung des Namens erzeugt doppelte Löschung und Aufnahme.
	 * @param ampli Beschreibung des Objektes.
	 * @param takeA Ob man das GameObject aufnehmen kann.
	 * @param speakA Ob man mit dem GameObject reden kann.
	 */
	public GameObject(String objn,String ampli,boolean takeA,boolean speakA,boolean visibleA) {
		objName = objn;
		amplification = ampli;
		takeAble = takeA;
		speakAble = speakA;
		visebility = visibleA;
	}

	
	
	// -------- Get'er & Set'er -----------
	public String getObjName() {
		return objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}

	public String getAmplification() {
		return amplification;
	}

	public void setAmplification(String amplification) {
		this.amplification = amplification;
	}

	public boolean isTakeAble() {
		return takeAble;
	}

	public void setTakeAble(boolean takeAble) {
		this.takeAble = takeAble;
	}

	public boolean isSpeakAble() {
		return speakAble;
	}

	public void setSpeakAble(boolean speakAble) {
		this.speakAble = speakAble;
	}


	public boolean isVisebility() {
		return visebility;
	}


	public void setVisebility(boolean visebility) {
		this.visebility = visebility;
	}
}
