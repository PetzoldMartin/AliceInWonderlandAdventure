package de.fh_zwickau.oose.zuul;

import GamePlayEnums.LockedStatus;
import GamePlayEnums.PlayerSize;

/**
 * Diese Klasse repräsentiert den Spieler im Spiel.
 * 
 * @author Martin Petzold
 * @version 1.1 (October 2012)
 */

public class Player {
	private Room currentRoom;//der Raum indem sich der Spieler befindet.
	private PlayerSize size = PlayerSize.NORMAL;//die Grösse die der Spieler hat.

	/**
	 * Konstruktor für objekte der Klasse Player
	 */
	public Player() {
		currentRoom = null;
	}

	/**
	 * gibt den Raum zurück in dem sich der Spieler momentan befindet.
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}

	/**
	 * Setzt den Momentanen Raum des Spielers.
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
		if (nextRoom == null)//Überprüfung ob Raum vorhanden ist.
			System.out.println("Da ist keine Durchgang!");
		else {
			if (nextRoom.isClosed() == LockedStatus.UNLOCKED) {//Überprüfung ob Raum Verschlossen ist.
				if (nextRoom.getSizeExpected() == PlayerSize.NORMAL) {
					walkReally(nextRoom);
				} else {
					if (nextRoom.getSizeExpected() == size) {
						walkReally(nextRoom);
					} else {
						System.out.println("Hättest du nicht die Falsche Größe würdest du sogar da durch Passen!");
					}
				}
			} else {
				System.out.println("Die Tür ist verschlossen.");
			}
		}
	}

	/**
	 * Methode die den Player in einen anderen Raum befördert
	 * @param walkTrough
	 */
	private void walkReally(Room walkTrough) {
		setCurrentRoom(walkTrough);
		System.out.println(walkTrough.getLongDescription());
	}

	public PlayerSize getSize() {
		return size;
	}

	public void setSize(PlayerSize size) {
		this.size = size;
	}
}
