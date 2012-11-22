package gameBuilding;

import de.fh_zwickau.oose.zuul.Room;
import GameObjects.GameObject;
import GamePlayEnums.LockedStatus;
import GamePlayEnums.PlayerSize;

public class LevelCreator 

{
	/**
	 * Diese Klasse beinhaltet alle Räume des Spieles und kan den Startraum zurückgeben
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
	
	// die Methode die Alle Räume erstellt die Verbindungen zwischen den Räumen Festlegt und alle Attribute der Räume festlegt
	private void createRooms() {
		Room fountain, westCave, eastCave, northCave, southCave,insideTheVase,attic,madHaddersHouse,madHaddersGarden,madHaddersKitchen,insideTheFurnance,whichCave;
	    // erstellen der Räume mit der erwarteten Player Grösse, wenn keine Grösse angegeben, grösse Normal
	    fountain = new Room("Du befindest dich in einem Brunnen");
	    westCave = new Room("Du bist in einer Höhle in der nähe des Brunnens.");
	    eastCave = new Room("Du bist in einer Höhle in der nähe des Brunnens.");
	    northCave = new Room("Du bist in einer Höhle in der nähe des Brunnens.");
	    southCave = new Room("Du bist in einer Höhle in der nähe des Brunnens.");
	    insideTheVase = new Room("Du bist in einer braunen Vase",PlayerSize.LITTLE);
	    attic = new Room("Der Dachbode!? der Osthöhle.",PlayerSize.BIG);
	    madHaddersHouse = new Room("Das verückte Haus des noch Verückteren Hutmachers.");
	    madHaddersGarden = new Room("Der Garten des Verückten Hutmachers.");
	    madHaddersKitchen = new Room("Die unaufgeräumte Küche des Verrückten Hutmachers.");
	    insideTheFurnance = new Room("Du bist im Inneren des Ofens, die Wände sind schwarz.",PlayerSize.LITTLE);
	    whichCave = new Room("Der Eingang zum Schloss der Roten Königin.");
	    
	    // Initialisieren der Raum Ein- und Ausgänge
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
	    
	    // Der Startraum für den Spieler
	    startRoom=fountain;
		
	    // verschlossene Räume
	    madHaddersHouse.setClosed(LockedStatus.LOCKED);
	    whichCave.setClosed(LockedStatus.LOCKED);
	    
	    //--------------------------------------------------------
	    
	    //Items.Personen etc Erstellen
	    GameObject flower= new GameObject("flower","blumen blumen", true,true);
	    GameObject flower2= new GameObject("blumea","blumen blumen blumen die nicht ansprechen kannst und nicht aufnehmen", false,false);
	    
	    // Einfügen der Oben erstellten Objekte
	    fountain.itemStore(flower);
	    fountain.itemStore(flower2);
	    
	    // Uselist hinzufügen.
	    
	}

	public Room getStartRoom()
	{
		return startRoom;
		
	}
	
}
