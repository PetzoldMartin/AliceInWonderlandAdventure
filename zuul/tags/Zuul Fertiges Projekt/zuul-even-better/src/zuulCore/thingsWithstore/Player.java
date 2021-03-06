package zuulCore.thingsWithstore;


import gameBuilding.CommandWords;
import gameBuilding.DialogCreator;
import gameBuilding.LevelCreator;
import gameBuilding.UsableCreator;
import gameEnums.LockedStatus;
import gameEnums.PlayerSize;
import zuulCore.Game;
import zuulCore.ThingWithStore;

/**
 * Diese Klasse repr�sentiert den Spieler im Spiel.
 * 
 * @author Martin Petzold
 * @version 1.1 (October 2012)
 */

public class Player extends ThingWithStore {
	/**
	 * der Raum indem sich der Spieler befindet.
	 */
	private Room currentRoom;
	/**
	 * die Gr��e die der Spieler hat.
	 */
	private PlayerSize size = PlayerSize.NORMAL;
	/**
	 *  enth�lt liste der Verwendbaren Items
	 */
	 private UsableCreator nUC; 
	 /**
	 *  enth�lt liste der Verwendbaren Dialoge
	 */
	 private DialogCreator nDC;
	 /**
		 *  enth�lt Personen Gegenst�nde R�ume
		 */
	 private LevelCreator nLC;
	 /**
	  * enth�lt die Commandow�rter
	  */
	 private CommandWords nCW;
	
	/**
	 *
	 * Konstruktor f�r Objekte der Klasse Player
	 */
	public Player() {
		super();
		currentRoom = null;
		 nUC=new UsableCreator();
		 nDC=new DialogCreator();
		 nCW=new CommandWords();
		 nLC=new LevelCreator(this);
	}
	
	


	/**
	 * gibt den Raum zur�ck in dem sich der Spieler momentan befindet.
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}

	/**
	 * Setzt den momentanen Raum des Spielers.
	 */
	public void setCurrentRoom(Room room) {
		currentRoom = room;
	}

	/**
	 * �berpr�fung ob der Spieler in die gesuchte Richtung laufen kann
	 * 
	 */
	public void walk(String direction) {
		// Versuch den aktuellen Raum zu verlassen
		Room nextRoom = currentRoom.getExit(direction);
		Game.textOut.lineEntry(">");
		if (nextRoom == null)//�berpr�fung ob Raum vorhanden ist.
			Game.textOut.lineEntry("Da ist keine Durchgang!");
		else {
			if (nextRoom.isClosed() == LockedStatus.UNLOCKED) {//�berpr�fung ob Raum Verschlossen ist.
				if (nextRoom.getSizeExpected() == PlayerSize.NORMAL) {
					walkReally(nextRoom);
				} else {
					if (nextRoom.getSizeExpected() == size) {
						walkReally(nextRoom);
						this.setSize(PlayerSize.NORMAL);
					} else {
						Game.textOut.lineEntry("H�ttest du nicht die Falsche Gr��e w�rdest du sogar da durch Passen!");
					}
				}
			} else {
				Game.textOut.lineEntry("Die T�r ist verschlossen.");
			}
		}
	}

	/**
	 * Methode die den Player in einen anderen Raum bef�rdert
	 * @param walkTrough
	 */
	private void walkReally(Room walkTrough) {
		setCurrentRoom(walkTrough);
		Game.textOut.lineEntry(walkTrough.getLongDescription());
	}

	public PlayerSize getSize() {
		return size;
	}
/**
 * 
 * @param size {@link PlayerSize}
 */
	public void setSize(PlayerSize size) {
		this.size = size;
	}
	
	public UsableCreator getUC() {
		return nUC;
	}




	public DialogCreator getnDC() {
		return nDC;
	}




	public LevelCreator getnLC() {
		return nLC;
	}




	public CommandWords getnCW() {
		return nCW;
	}

}
