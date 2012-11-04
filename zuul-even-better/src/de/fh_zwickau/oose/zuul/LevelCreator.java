package de.fh_zwickau.oose.zuul;

import GamePlayEnums.LockedStatus;
import GamePlayEnums.PlayerSize;

public class LevelCreator 

{
	/**
	 * Diese Klasse beinhaltet alle R�ume des Spieles und kan den Startraum zur�ckgeben
	 * @author Martin Petzold
	 * @version 0.1 (October 2012)
	 */
	private Room startRoom;
	
	/**
	 * der Konstruktor des LevelCreators
	 */
	public LevelCreator()
	{	
	createRooms();
    
	}
	
	// die Methode die Alle R�ume erstellt die Verbindungen zwischen den R�umen Festlegt und alle Attribute der R�ume festlegt
	private void createRooms() {
		Room fountain, westCave, eastCave, northCave, southCave,insideTheVase,attic,madHaddersHouse,madHaddersGarden,madHaddersKitchen,insideTheFurnance,whichCave;
	    // erstellen der R�ume mit der erwarteten Player Gr�sse, wenn keine Gr�sse angegeben, gr�sse Normal
	    fountain = new Room("du befindest dich in einem Brunnen");
	    westCave = new Room("du bist in einer H�hle in der n�he des Brunnens");
	    eastCave = new Room("du bist in einer H�hle in der n�he des Brunnens");
	    northCave = new Room("du bist in einer H�hle in der n�he des Brunnens");
	    southCave = new Room("du bist in einer H�hle in der n�he des Brunnens");
	    insideTheVase = new Room("du bist in einer braunen Vase",PlayerSize.LITTLE);
	    attic = new Room("der Dachbode!? der Osth�hle",PlayerSize.BIG);
	    madHaddersHouse = new Room("das ver�ckte Haus des noch Ver�ckteren Hutmachers");
	    madHaddersGarden = new Room("der Garten des Ver�ckten Hutmachers");
	    madHaddersKitchen = new Room("die unaufger�umte K�che des Verr�ckten Hutmachers");
	    insideTheFurnance = new Room("du bist im Inneren des Ofens die W�nde sind schwarz",PlayerSize.LITTLE);
	    whichCave = new Room("Die H�hle der b�sen Hexe");
	    
	    // Initialisieren der Raum Ein- und Ausg�nge
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
	    southCave.setExit("s�den", madHaddersHouse);
	    madHaddersHouse.setExit("norden", southCave);
	    madHaddersHouse.setExit("westen", madHaddersGarden);
	    madHaddersHouse.setExit("osten", madHaddersKitchen);
	    madHaddersHouse.setExit("s�den", whichCave);
	    madHaddersGarden.setExit("osten", madHaddersHouse);
	    madHaddersKitchen.setExit("westen", madHaddersHouse);
	    madHaddersKitchen.setExit("ofen", insideTheFurnance);
	    insideTheFurnance.setExit("raus", madHaddersKitchen);
	    whichCave.setExit("norden", madHaddersHouse);
	    
	    // Der Startraum f�r den Spieler
	    startRoom=fountain;
		
	    // verschlossene R�ume
	    madHaddersHouse.setClosed(LockedStatus.LOCKED);
	    whichCave.setClosed(LockedStatus.LOCKED);
	}

	public Room getStartRoom()
	{
		return startRoom;
		
	}
	
}
