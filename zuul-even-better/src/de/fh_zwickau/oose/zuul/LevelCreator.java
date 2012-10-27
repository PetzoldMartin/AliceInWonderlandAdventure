package de.fh_zwickau.oose.zuul;

import GamePlayEnums.LockedStatus;
import GamePlayEnums.PlayerSize;

public class LevelCreator 

{
	/**
	 * 
	 * @author Martin Petzold
	 * @version 0.1 (October 2012)
	 */
	private Room startRoom;
	
	public LevelCreator()
	{	
	createRooms();
    
	}
	
	private void createRooms() {
		Room fountain, westCave, eastCave, northCave, southCave,insideTheVase,attic,madHaddersHouse,madHaddersGarden,madHaddersKitchen,insideTheFurnance,whichCave;
	    // create the rooms
	    fountain = new Room("du befindest dich in einem Brunnen");
	    westCave = new Room("du bist in einer Höhle in der nähe des Brunnens");
	    eastCave = new Room("du bist in einer Höhle in der nähe des Brunnens");
	    northCave = new Room("du bist in einer Höhle in der nähe des Brunnens");
	    southCave = new Room("du bist in einer Höhle in der nähe des Brunnens");
	    insideTheVase = new Room("du bist in einer braunen Vase",PlayerSize.LITTLE);
	    attic = new Room("der Dachbode!? der Osthöhle",PlayerSize.BIG);
	    madHaddersHouse = new Room("das verückte Haus des noch Verückteren Hutmachers");
	    madHaddersGarden = new Room("der Garten des Verückten Hutmachers");
	    madHaddersKitchen = new Room("die unaufgeräumte Küche des Verrückten Hutmachers");
	    insideTheFurnance = new Room("du bist im Inneren des Ofens die Wände sind schwarz",PlayerSize.LITTLE);
	    whichCave = new Room("Die Höhle der bösen Hexe");
	    
	    // initialise room exits
	    fountain.setExit("osten", eastCave);
	    fountain.setExit("westen", westCave);
	    fountain.setExit("norden", northCave);
	    fountain.setExit("sueden", southCave);
	    westCave.setExit("osten", fountain);
	    westCave.setExit("vase", insideTheVase);
	    insideTheVase.setExit("raus", westCave);
	    eastCave.setExit("westen", fountain);
	    eastCave.setExit("hoch", attic);
	    attic.setExit("runter", eastCave);
	    northCave.setExit("sueden", fountain);
	    southCave.setExit("norden", fountain);
	    southCave.setExit("süden", madHaddersHouse);
	    madHaddersHouse.setExit("norden", southCave);
	    madHaddersHouse.setExit("westen", madHaddersGarden);
	    madHaddersHouse.setExit("osten", madHaddersKitchen);
	    madHaddersHouse.setExit("süden", whichCave);
	    madHaddersGarden.setExit("osten", madHaddersHouse);
	    madHaddersKitchen.setExit("westen", madHaddersHouse);
	    madHaddersKitchen.setExit("ofen", insideTheFurnance);
	    insideTheFurnance.setExit("raus", madHaddersKitchen);
	    whichCave.setExit("norden", madHaddersHouse);
	    // the player starts the game outside
	    startRoom=fountain;
		
	    
	    madHaddersHouse.setClosed(LockedStatus.LOCKED);
	    whichCave.setClosed(LockedStatus.LOCKED);
	}

	public Room getStartRoom()
	{
		return startRoom;
		
	}
	
}
