package gameBuilding;

import GameObjects.GameObject;
import GamePlayEnums.LockedStatus;
import GamePlayEnums.PlayerSize;
import de.fh_zwickau.oose.zuul.Room;

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
	    GameObject flower= new GameObject("flower","blumen blumen", true,true,true);
	    GameObject flower2= new GameObject("blumea","blumen blumen blumen die nicht ansprechen kannst und nicht aufnehmen", false,false,true);
	    
	    //Spielrelevante Items
	    //fountain
	    GameObject rabbit= new GameObject("Kaninchen","Das wei�e Kaninchen",false,true,true);
	    GameObject wood = new GameObject("Holz","Holz f�r den Kamin",true,false,false);
	    //eastcave
	    GameObject desk1= new GameObject("Tisch","Ein Holztisch",false,false,true);
	    GameObject blueBerry= new GameObject("BlaueBeere","eine Schrumpfbeere",true,false,true);
	    //northcave
	    GameObject picture=new GameObject("Bild","ein Sch�nes Bild",false,false,true);
	    GameObject bed= new GameObject("Bett","Ein Kuschliges Bett",false,false ,true);
	    GameObject harp= new GameObject("Harfe","Eine Goldene Harfe",true,false,true);
	    //insideTheVase
	    GameObject desk2= desk1;
	    GameObject redberry= new GameObject("RoteBeere","eine Wachstumsbeere",true,false,true);
	    //attic
	    GameObject key1= new GameObject("Schluessel","ein Goldener Schl�ssel",true,false,true);
	    //Southcave
	    GameObject boiler= new GameObject("Kessel","ein Kessel voller Wasser",true,false,true);
	    //madHaddersHouse
	    GameObject madHadder= new GameObject("Hutmacher","der Ver�ckte Hutmacher",false,false,true);
	    GameObject desk3= desk1;
	    GameObject cup1= new GameObject("BlaueTasse","Eine Tasse die Nichtmehr im Schrank des Hutmachers ist",false,false,true);
	    GameObject cup2= new GameObject("RoteTasse","Eine Tasse die Nichtmehr im Schrank des Hutmachers ist",false,false,true);
	    GameObject pot= new GameObject("Teekanne","Eine TeeKanne die Nichtmehr im Schrank des Hutmachers ist",true,false,true);
	    GameObject key2= new GameObject("Schluessel","ein Goldener Schl�ssel",true,false,false);;
	    //madHaddersKitchen
	    GameObject cat= new GameObject("Katze","Die Grinsekatze",false,true,true);
	    //insideTheFurnance
	    GameObject fireGhost= new GameObject("Feuergeist","Ein kleiner trauriger Feuergeist",false,true,true);
	    GameObject hairDryer= new GameObject("Foehn","Ein Foehn",true,false,false);
	    //madHaddersGarden
	    GameObject snownan= new GameObject("Schneemann","Ein Schneemann mit M�hrennase",false,true,true);
	    GameObject fountainInGarden= new GameObject("Brunnen","Ein Brunnen im Garten",false,false,true);
	    GameObject blueBerry2=blueBerry;
	    GameObject carrot= new GameObject("Moehre","Eine Orange Moehre",true,false,false);
	    //whitchcave
	    GameObject which= new GameObject("Hexe","Die B�se Hexe",false,false,true);
	    
	    
	    // Einf�gen der Oben erstellten Objekte
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
	    // Uselist hinzuf�gen.
	    
	}

	public Room getStartRoom()
	{
		return startRoom;
		
	}
	
}
