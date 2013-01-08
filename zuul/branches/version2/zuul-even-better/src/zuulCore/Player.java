package zuulCore;


import gameBuilding.CommandWords;
import gameBuilding.DialogCreator;
import gameBuilding.LevelCreator;
import gameBuilding.UsableCreator;
import gameEnums.LockedStatus;
import gameEnums.PlayerSize;

/**
 * Diese Klasse repräsentiert den Spieler im Spiel.
 * 
 * @author Martin Petzold
 * @version 1.1 (October 2012)
 */

public class Player extends ThingWithStore {
	private Room currentRoom;//der Raum indem sich der Spieler befindet.
	private PlayerSize size = PlayerSize.NORMAL;//die Größe die der Spieler hat.
	 private UsableCreator nUC; // Erstellt liste der Verwendbaren Items
	 private DialogCreator nDC;//
	 private LevelCreator nLC;
	 private CommandWords nCW;
	
	/**
	 *
	 * Konstruktor für Objekte der Klasse Player
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
	 * gibt den Raum zurück in dem sich der Spieler momentan befindet.
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
	 * Überprüfung ob der Spieler in die gesuchte Richtung laufen kann
	 * 
	 */
	public void walk(String direction) {
		// Versuch den aktuellen Raum zu verlassen
		Room nextRoom = currentRoom.getExit(direction);
		Game.textOut.lineEntry(">");
		if (nextRoom == null)//Überprüfung ob Raum vorhanden ist.
			Game.textOut.lineEntry("Da ist keine Durchgang!");
		else {
			if (nextRoom.isClosed() == LockedStatus.UNLOCKED) {//Überprüfung ob Raum Verschlossen ist.
				if (nextRoom.getSizeExpected() == PlayerSize.NORMAL) {
					walkReally(nextRoom);
				} else {
					if (nextRoom.getSizeExpected() == size) {
						walkReally(nextRoom);
						this.setSize(PlayerSize.NORMAL);
					} else {
						Game.textOut.lineEntry("Hättest du nicht die Falsche Größe würdest du sogar da durch Passen!");
					}
				}
			} else {
				Game.textOut.lineEntry("Die Tür ist verschlossen.");
			}
		}
	}

	/**
	 * Methode die den Player in einen anderen Raum befördert
	 * @param walkTrough
	 */
	private void walkReally(Room walkTrough) {
		setCurrentRoom(walkTrough);
		Game.textOut.lineEntry(walkTrough.getLongDescription());
	}

	public PlayerSize getSize() {
		return size;
	}

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
