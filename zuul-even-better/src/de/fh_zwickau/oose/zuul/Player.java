package de.fh_zwickau.oose.zuul;

import GamePlayEnums.LockedStatus;
import GamePlayEnums.PlayerSize;

/**
 * This class represents players in the game. Each player has a current
 * location.
 * 
 * @author Michael Kolling
 * @version 1.0 (December 2002)
 */

public class Player {
	private Room currentRoom;
	private PlayerSize size = PlayerSize.NORMAL;

	/**
	 * Constructor for objects of class Player
	 */
	public Player() {
		currentRoom = null;
	}

	/**
	 * Return the current room for this player.
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}

	/**
	 * Set the current room for this player.
	 */
	public void setCurrentRoom(Room room) {
		currentRoom = room;
	}

	/**
	 * Try to walk in a given direction. If there is a door this will change the
	 * player's location.
	 */
	public void walk(String direction) {
		// Try to leave current room.
		Room nextRoom = currentRoom.getExit(direction);

		if (nextRoom == null)
			System.out.println("There is no door!");
		else {
			if (nextRoom.isClosed() == LockedStatus.UNLOCKED) {
				if (nextRoom.getSizeExpected() == PlayerSize.NORMAL) {
					walkReally(nextRoom);
				} else {
					if (nextRoom.getSizeExpected() == size) {
						walkReally(nextRoom);
					} else {
						System.out.println("you have the wrong size");
					}
				}
			}else{
				System.out.println("the Door is locked");
			}
		}
	}

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
