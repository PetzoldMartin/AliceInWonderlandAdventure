package de.fh_zwickau.oose.zuul;

public class LevelCreator 

{
	private Room startRoom;
	
	public LevelCreator()
	{	
	createRooms();
    
	}
	
	private void createRooms() {
		Room fountain, westCave, eastCave, northCave, southCave,insideTheVase,attic,madHaddersHouse,madHaddersGarden,madHaddersKitchen,insideTheFurnance,whichCave;
	    // create the rooms
	    fountain = new Room("you are in a fountain");
	    westCave = new Room("you are in a cave near the fountain");
	    eastCave = new Room("you are in a cave near the fountain");
	    northCave = new Room("you are in a cave near the fountain");
	    southCave = new Room("you are in a cave near the fountain");
	    insideTheVase = new Room("you are inside of a brown Vase",0);
	    attic = new Room("the attic of the eastCave",2);
	    madHaddersHouse = new Room("The crazy House of Mad Hadder");
	    madHaddersGarden = new Room("The Garden from Mad Hadder");
	    madHaddersKitchen = new Room("The Kitchen from Mad Hadder");
	    insideTheFurnance = new Room("you are inside the Furnance the Walls are black",0);
	    whichCave = new Room("The Cave of the bad Which");
	    
	    // initialise room exits
	    fountain.setExit("east", eastCave);
	    fountain.setExit("west", westCave);
	    fountain.setExit("north", northCave);
	    fountain.setExit("south", southCave);
	    westCave.setExit("east", fountain);
	    westCave.setExit("vase", insideTheVase);
	    insideTheVase.setExit("out", westCave);
	    eastCave.setExit("west", fountain);
	    eastCave.setExit("up", attic);
	    attic.setExit("down", eastCave);
	    northCave.setExit("south", fountain);
	    southCave.setExit("north", fountain);
	    southCave.setExit("south", madHaddersHouse);
	    madHaddersHouse.setExit("north", southCave);
	    madHaddersHouse.setExit("west", madHaddersGarden);
	    madHaddersHouse.setExit("east", madHaddersKitchen);
	    madHaddersHouse.setExit("south", whichCave);
	    madHaddersGarden.setExit("east", madHaddersHouse);
	    madHaddersKitchen.setExit("west", madHaddersHouse);
	    madHaddersKitchen.setExit("furnance", insideTheFurnance);
	    insideTheFurnance.setExit("out", madHaddersKitchen);
	    whichCave.setExit("out", madHaddersHouse);
	    // the player starts the game outside
	    startRoom=fountain;
		
	    
	    madHaddersHouse.setClosed(true);
	    whichCave.setClosed(true);
	}

	public Room getStartRoom()
	{
		return startRoom;
		
	}
	
}
