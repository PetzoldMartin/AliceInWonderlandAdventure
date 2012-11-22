package gameBuilding;

import de.fh_zwickau.oose.zuul.Room;
import GameObjects.GameObject;
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
	    fountain = new Room("Du befindest dich in einem Brunnen");
	    westCave = new Room("Du bist in einer H�hle in der n�he des Brunnens.");
	    eastCave = new Room("Du bist in einer H�hle in der n�he des Brunnens.");
	    northCave = new Room("Du bist in einer H�hle in der n�he des Brunnens.");
	    southCave = new Room("Du bist in einer H�hle in der n�he des Brunnens.");
	    insideTheVase = new Room("Du bist in einer braunen Vase",PlayerSize.LITTLE);
	    attic = new Room("Der Dachbode!? der Osth�hle.",PlayerSize.BIG);
	    madHaddersHouse = new Room("Das ver�ckte Haus des noch Ver�ckteren Hutmachers.");
	    madHaddersGarden = new Room("Der Garten des Ver�ckten Hutmachers.");
	    madHaddersKitchen = new Room("Die unaufger�umte K�che des Verr�ckten Hutmachers.");
	    insideTheFurnance = new Room("Du bist im Inneren des Ofens, die W�nde sind schwarz.",PlayerSize.LITTLE);
	    whichCave = new Room("Der Eingang zum Schloss der Roten K�nigin.");
	    
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
	    
	    //--------------------------------------------------------
	    
	    //Items.Personen etc Erstellen
	    GameObject flower= new GameObject("flower","blumen blumen", true,true);
	    GameObject flower2= new GameObject("blumea","blumen blumen blumen die nicht ansprechen kannst und nicht aufnehmen", false,false);
	    
	    // Einf�gen der Oben erstellten Objekte
	    fountain.itemStore(flower);
	    fountain.itemStore(flower2);
	    
	    // Uselist hinzuf�gen.
	    
	}

	public Room getStartRoom()
	{
		return startRoom;
		
	}
	
}
