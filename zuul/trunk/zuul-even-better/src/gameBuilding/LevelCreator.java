package gameBuilding;

import GameObjects.GameObject;
import GamePlayEnums.LockedStatus;
import GamePlayEnums.PlayerSize;
import de.fh_zwickau.oose.zuul.Room;

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
	    GameObject flower= new GameObject("flower","blumen blumen", true,true,true);
	    GameObject flower2= new GameObject("blumea","blumen blumen blumen die nicht ansprechen kannst und nicht aufnehmen", false,false,true);
	    
	    //Spielrelevante Items
	    //fountain
	    GameObject rabbit= new GameObject("Kaninchen","Das weiße Kaninchen",false,true,true);
	    GameObject wood = new GameObject("Holz","Holz für den Kamin",true,false,false);
	    //eastcave
	    GameObject desk1= new GameObject("Tisch","Ein Holztisch",false,false,true);
	    GameObject blueBerry= new GameObject("BlaueBeere","eine Schrumpfbeere",true,false,true);
	    //northcave
	    GameObject picture=new GameObject("Bild","ein Schönes Bild",false,false,true);
	    GameObject bed= new GameObject("Bett","Ein Kuschliges Bett",false,false ,true);
	    GameObject harp= new GameObject("Harfe","Eine Goldene Harfe",true,false,true);
	    //insideTheVase
	    GameObject desk2= desk1;
	    GameObject redberry= new GameObject("RoteBeere","eine Wachstumsbeere",true,false,true);
	    //attic
	    GameObject key1= new GameObject("Schluessel","ein Goldener Schlüssel",true,false,true);
	    //Southcave
	    GameObject boiler= new GameObject("Kessel","ein Kessel voller Wasser",true,false,true);
	    //madHaddersHouse
	    GameObject madHadder= new GameObject("Hutmacher","der Verückte Hutmacher",false,false,true);
	    GameObject desk3= desk1;
	    GameObject cup1= new GameObject("BlaueTasse","Eine Tasse die Nichtmehr im Schrank des Hutmachers ist",false,false,true);
	    GameObject cup2= new GameObject("RoteTasse","Eine Tasse die Nichtmehr im Schrank des Hutmachers ist",false,false,true);
	    GameObject pot= new GameObject("Teekanne","Eine TeeKanne die Nichtmehr im Schrank des Hutmachers ist",true,false,true);
	    GameObject key2= new GameObject("Schluessel","ein Goldener Schlüssel",true,false,false);;
	    //madHaddersKitchen
	    GameObject cat= new GameObject("Katze","Die Grinsekatze",false,true,true);
	    //insideTheFurnance
	    GameObject fireGhost= new GameObject("Feuergeist","Ein kleiner trauriger Feuergeist",false,true,true);
	    GameObject hairDryer= new GameObject("Foehn","Ein Foehn",true,false,false);
	    //madHaddersGarden
	    GameObject snownan= new GameObject("Schneemann","Ein Schneemann mit Möhrennase",false,true,true);
	    GameObject fountainInGarden= new GameObject("Brunnen","Ein Brunnen im Garten",false,false,true);
	    GameObject blueBerry2=blueBerry;
	    GameObject carrot= new GameObject("Moehre","Eine Orange Moehre",true,false,false);
	    //whitchcave
	    GameObject which= new GameObject("Hexe","Die Böse Hexe",false,false,true);
	    
	    
	    // Einfügen der Oben erstellten Objekte
	  //fountain
	    fountain.itemStore(flower);
	    fountain.itemStore(flower2);
	    fountain.itemStore(rabbit);
	    fountain.itemStore(wood);
	   //westcave
	   //Nothing
	   //eastcave
	   eastCave.itemStore(desk1);
	   eastCave.itemStore(blueBerry);
	   //northcave
	   northCave.itemStore(picture);
	   northCave.itemStore(bed);
	   northCave.itemStore(harp);
	   //insideTheVase
	   insideTheVase.itemStore(desk2);
	   insideTheVase.itemStore(redberry);
	   //attic
	   attic.itemStore(key1);
	   //southcave
	   southCave.itemStore(boiler);
	   //madHaddersHouse
	   madHaddersHouse.itemStore(madHadder);
	   madHaddersHouse.itemStore(desk3);
	   madHaddersHouse.itemStore(cup1);
	   madHaddersHouse.itemStore(cup2);
	   madHaddersHouse.itemStore(pot);
	   madHaddersHouse.itemStore(key2);
	   //madHaddersKitchen
	   madHaddersKitchen.itemStore(cat);
	   //insideTheFurnance
	   insideTheFurnance.itemStore(fireGhost);
	   insideTheFurnance.itemStore(hairDryer);
	   //madHaddersGarden
	   madHaddersGarden.itemStore(snownan);
	   madHaddersGarden.itemStore(fountainInGarden);
	   madHaddersGarden.itemStore(blueBerry2);
	   madHaddersGarden.itemStore(carrot);
	   //Whichcave
	   whichCave.itemStore(which);
	    // Uselist hinzufügen.
	    
	}

	public Room getStartRoom()
	{
		return startRoom;
		
	}
	
}
