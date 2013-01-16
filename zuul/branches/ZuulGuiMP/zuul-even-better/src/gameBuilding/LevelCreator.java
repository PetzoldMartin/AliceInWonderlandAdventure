package gameBuilding;


import gameEnums.LockedStatus;
import gameEnums.PlayerSize;
import zuulCore.GameObject;
import zuulCore.thingsWithstore.Player;
import zuulCore.thingsWithstore.Room;

public class LevelCreator 

{
	/**
	 * Diese Klasse beinhaltet alle R�ume des Spiels und kann den Startraum zur�ckgehen
	 * @author Martin Petzold
	 * @version 0.1 (October 2012)
	 */
	private Room startRoom;
	private Player player;
	
	/**
	 * der Konstruktor des LevelCreators
	 */
	public LevelCreator(Player player)
	{	
		this.player=player;
	createRooms();
    
	}
	
	// die Methode die Alle R�ume erstellt die Verbindungen zwischen den R�umen festlegt und alle Attribute der R�ume festlegt
	private void createRooms() {
		Room fountain, westCave, eastCave, northCave, southCave,insideTheVase,attic,madHaddersHouse,madHaddersGarden,madHaddersKitchen,insideTheFurnance,whichCave;
	    // erstellen der R�ume mit der erwarteten Player Gr��e, wenn keine Gr��e angegeben, Gr��e Normal
	    fountain = new Room("fountain","Du befindest dich in einem Brunnen");
	    westCave = new Room("westCave","Du bist in einer H�hle in der n�he des Brunnens.");
	    eastCave = new Room("eastCave","Du bist in einer H�hle in der n�he des Brunnens.");
	    northCave = new Room("northCave","Du bist in einer H�hle in der n�he des Brunnens.");
	    southCave = new Room("southCave","Du bist in einer H�hle in der n�he des Brunnens.");
	    insideTheVase = new Room("insideTheVase","Du bist in einer braunen Vase",PlayerSize.KLEIN);
	    attic = new Room("attic","Der Dachbode!? der Osth�hle.",PlayerSize.GROSS);
	    madHaddersHouse = new Room("madHaddersHouse","Das ver�ckte Haus des noch Ver�ckteren Hutmachers.");
	    madHaddersGarden = new Room("madHaddersGarden","Der Garten des Ver�ckten Hutmachers.");
	    madHaddersKitchen = new Room("madHaddersKitchen","Die unaufger�umte K�che des Verr�ckten Hutmachers.");
	    insideTheFurnance = new Room("insideTheFurnance","Du bist im Inneren des Ofens, die W�nde sind schwarz.",PlayerSize.KLEIN);
	    whichCave = new Room("whichCave","Der Eingang zum Schloss der Roten K�nigin.");
	    
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
	    southCave.setExit("sueden", madHaddersHouse);
	    madHaddersHouse.setExit("norden", southCave);
	    madHaddersHouse.setExit("westen", madHaddersGarden);
	    madHaddersHouse.setExit("osten", madHaddersKitchen);
	    madHaddersHouse.setExit("sueden", whichCave);
	    madHaddersGarden.setExit("osten", madHaddersHouse);
	    madHaddersKitchen.setExit("westen", madHaddersHouse);
	    madHaddersKitchen.setExit("ofen", insideTheFurnance);
	    insideTheFurnance.setExit("raus", madHaddersKitchen);
	    whichCave.setExit("norden", madHaddersHouse);
	    
	    // Der Startraum f�r den Spieler
	    startRoom=fountain;
		
	    // Verschlossene R�ume
	    madHaddersHouse.setClosed(LockedStatus.LOCKED);
	    whichCave.setClosed(LockedStatus.LOCKED);
	    
	    //--------------------------------------------------------
	    
	    // Items Personen des Players
	    GameObject flower3 = new GameObject("Blumenstrauss","Verschiedene Blumen!",true,false,false);
	    
	    //Items.Personen etc Erstellen
	    GameObject flower= new GameObject("Lilie","blumen blumen", true,true,false);
	    GameObject flower2= new GameObject("Rose","blumen blumen blumen die nicht ansprechen kannst und nicht aufnehmen", false,false,false);
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
	    GameObject key1= new GameObject("Schluessel","ein Goldener Schl�ssel. Die Gravuren zeigen den Hutmacher wie er die Merzmaus jagt.",true,false,true);
	    //Southcave
	    GameObject boiler= new GameObject("Kessel","ein Kessel voller Wasser",true,false,true);
	    //madHaddersHouse
	    GameObject madHadder= new GameObject("Hutmacher","der Ver�ckte Hutmacher",false,true,true);
	    GameObject desk3= desk1;
	    GameObject cup1= new GameObject("BlaueTasse","Eine Tasse die Nichtmehr im Schrank des Hutmachers ist",true,false,true);
	    GameObject cup2= new GameObject("RoteTasse","Eine Tasse die Nichtmehr im Schrank des Hutmachers ist",true,false,true);
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
	    GameObject cup1Filled= new GameObject("BlaueTasseVollTee","Eine Volle Tasse die Nichtmehr im Schrank des Hutmachers ist",true,false,false);
	    GameObject cup2Filled= new GameObject("RoteTasseVollTee","Eine Volle Tasse die Nichtmehr im Schrank des Hutmachers ist",true,false,false);
	    GameObject potFilled= new GameObject("TeekanneVollTee","Eine Volle TeeKanne die Nichtmehr im Schrank des Hutmachers ist",true,false,false);
	    GameObject furnance= new GameObject("Ofen", "Ein Russiger Ofen", false, false, true);
	    GameObject furnance2= new GameObject("BrennenderOfen", "Ein Russiger brennender Ofen", false, false, false);
	    GameObject Warhammer= new GameObject("KriegshammerFuer40K", "der Weltenzerst�rende Kriegshammer", true, true, false);
	    // Einf�gen der Oben erstellten Objekte
	  //fountain
	    fountain.itemStore(flower);
	    fountain.itemStore(flower2);
	    fountain.itemStore(rabbit);
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
	   //attic"
	   attic.itemStore(key1);
	   //Southcave
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
	   madHaddersKitchen.itemStore(furnance);
	   madHaddersKitchen.itemStore(furnance2);
	   //insideTheFurnance
	   insideTheFurnance.itemStore(fireGhost);
	   //madHaddersGarden
	   madHaddersGarden.itemStore(snownan);
	   madHaddersGarden.itemStore(fountainInGarden);
	   madHaddersGarden.itemStore(blueBerry2);
	   //Whitchcave
	   whichCave.itemStore(which);
	    // Uselist hinzuf�gen.
	   player.itemStore(flower3);
	   player.itemStore(hairDryer);
	   player.itemStore(carrot);
	   player.itemStore(cup1Filled);
	   player.itemStore(cup2Filled);
	   player.itemStore(potFilled);
	   player.itemStore(key2);
	   player.itemStore(Warhammer);
	   player.itemStore(wood);

	}

	public Room getStartRoom()
	{
		return startRoom;
		
	}
	
}
