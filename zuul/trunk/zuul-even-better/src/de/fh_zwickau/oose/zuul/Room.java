package de.fh_zwickau.oose.zuul;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

import GameObjects.GameObject;
import GamePlayEnums.LockedStatus;
import GamePlayEnums.PlayerSize;

/**
 * Klasse Room - ein Raum im Spiel.
 *
 * Diese Klasse ist ein Teil der "World of Zuul" Anwendung. 
 *
 * ein "Raum" repräsentiert ein Areal im Spiel
 * Er ist durch Ausgänge mit  den Nachbar Räumen verbunden
 * 
 * @author Martin Petzold
 * @version 1.1 (October 2012)
 */

public class Room 
{
    private String description;// Die Beschreibung des Raumes
    private HashMap<String, Room> exits;// stores exits of this room.
    private PlayerSize sizeExpected;// die vom Raum erwartete Spielergrösse
    private LockedStatus closed;// Status ob der Raum verschlossen ist oder nicht
    private ArrayList<GameObject> warehouse;
 
    
    /**
     * Konstruktor der Raumklasse mit Beschreibung und
     * ohne erwartete Spielergrösse
     */
    public Room(String description) 
    {
    	this.sizeExpected=PlayerSize.NORMAL;
        this.description = description;
        exits = new HashMap<String, Room>();
       closed=LockedStatus.UNLOCKED;
       warehouse = new ArrayList<GameObject>();
    }    
    /**
     * Konstruktor der Raumklasse mit Beschreibung und
     * mit erwarteter Spielergrösse
     */
    public Room(String description,PlayerSize sizeExpeced) 
    {
    	this.sizeExpected=sizeExpeced;
        this.description = description;
        exits = new HashMap<String, Room>();
        closed=LockedStatus.UNLOCKED;
        warehouse = new ArrayList<GameObject>();
    }


    public ArrayList<GameObject> getWarehouse() {
		return warehouse;
	}


	public void setWarehouse(ArrayList<GameObject> warehouse) {
		this.warehouse = warehouse;
	}


	//* Müsste in einer eigenen klasse. 
	public void itemStore(GameObject item) {
		warehouse.add(item);
	}
	
	public void itemRemove(GameObject item) {
		for(int i=0; i<warehouse.size();i++) {
			if(warehouse.get(i).equals(item)) { 
				warehouse.remove(i);
			}
		}
	}
	
	public void itemRemove(int index) {
		warehouse.remove(index);
	}


    
    /**
     * Diese Methode Definiert die Raumausgänge
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * Gibt die im Konstruktor übergebene Beschreibung zurück
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Gibt eine Lange Raumbeschreibung zurück, mit Ausgängen
     */
    public String getLongDescription()
    {
        return "" + description + ".\n" + getExitString();
    }
    
    /**
     * Gibt die Ausgänge des Raumes zurück
     */
	private String getExitString()
    {
        String returnString = "Ausgänge:";
        Set<String> keys = exits.keySet();
        for(Iterator<String> iter = keys.iterator(); iter.hasNext(); )
            returnString += " " + iter.next();
        	
        return returnString;
    }

    /**
     * gibt den Raum zurück der von einem Ausgang erreicht wird
     */
    public Room getExit(String direction) 
    {
    	if (exits.get(direction)!=null){
    		return exits.get(direction);
    	}
    	else{
    		return this;
    	}
    }

    /**
     * gibt de erwartete Spielergrösse zurück
     * @return sizeExpected {@link PlayerSize}
     */
	public PlayerSize getSizeExpected() {
		return sizeExpected;
	}

	/**
	 * 
	 * @param sizeExpected {@link PlayerSize}
	 */
	public void setSizeExpected(PlayerSize sizeExpected) {
		this.sizeExpected = sizeExpected;
	}

	/**
	 * 
	 * @return closed {@link LockedStatus}
	 */
	public LockedStatus isClosed() {
		return closed;
	}

	/**
	 * 
	 * @param closed {@link LockedStatus}
	 */
	public void setClosed(LockedStatus closed) {
		this.closed = closed;
	}
}

