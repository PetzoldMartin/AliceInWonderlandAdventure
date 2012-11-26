package de.fh_zwickau.oose.zuul;


import java.util.ArrayList;

import GameObjects.GameObject;
import GamePlayEnums.LockedStatus;
import GamePlayEnums.PlayerSize;

/**
 * Diese Klasse repr�sentiert den Spieler im Spiel.
 * 
 * @author Martin Petzold
 * @version 1.1 (October 2012)
 */

public class Player {
	private Room currentRoom;//der Raum indem sich der Spieler befindet.
	private PlayerSize size = PlayerSize.NORMAL;//die Gr�sse die der Spieler hat.
	 private ArrayList<GameObject>  inventory;
	/**
	 * Konstruktor f�r objekte der Klasse Player
	 */
	public Player() {
		currentRoom = null;
		inventory = new ArrayList<GameObject>();	}
	
	
	
    //* M�sste in einer eigenen klasse. 
	public void itemStore(GameObject item) {
		inventory.add(item);
	}
	
	public void itemRemove(GameObject item) {
		for(int i=0; i<inventory.size();i++) {
			if(inventory.get(i).equals(item)) { 
				inventory.remove(i);
			}
		}
	}

	/**
	 * gibt den Raum zur�ck in dem sich der Spieler momentan befindet.
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
	 * �berpr�fung ob der Spieler in die gesuchte Richtung laufen kann
	 * 
	 */
	public void walk(String direction) {
		// Versuch den aktuellen Raum zu verlassen
		Room nextRoom = currentRoom.getExit(direction);
		if (nextRoom == null)//�berpr�fung ob Raum vorhanden ist.
			Game.textOut.lineEntry("Da ist keine Durchgang!");
		else {
			if (nextRoom.isClosed() == LockedStatus.UNLOCKED) {//�berpr�fung ob Raum Verschlossen ist.
				if (nextRoom.getSizeExpected() == PlayerSize.NORMAL) {
					walkReally(nextRoom);
				} else {
					if (nextRoom.getSizeExpected() == size) {
						walkReally(nextRoom);
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

	public void setSize(PlayerSize size) {
		this.size = size;
	}

	public ArrayList<GameObject> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<GameObject> inventory) {
		this.inventory = inventory;
	}
}
