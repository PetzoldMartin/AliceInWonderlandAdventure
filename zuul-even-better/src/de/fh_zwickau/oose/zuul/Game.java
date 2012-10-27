package de.fh_zwickau.oose.zuul;

import GamePlayEnums.GameStatus;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.
 * 
 * @author Martin Petzold
 * @version 1.1 (October 2012)
 */

class Game 
{
    private Parser parser;
    private Player player;
    private LevelCreator LC;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {

        parser = new Parser();
        newGameInitialize();
        
    }
    
    /**
     * The main class creates a new Game object and starts its main method.
     */
    public static void main(String[] args) {
    	Game game = new Game();
    	game.play();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void newGameInitialize()
    {
        player = new Player();
    	LC= new LevelCreator();

    	player.setCurrentRoom(LC.getStartRoom());
    }
    

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        GameStatus gameStatus = GameStatus.RUN;
        while(gameStatus==GameStatus.RUN) {
            Command command = parser.getCommand();
                gameStatus = command.execute(player);
        }
        if(gameStatus==GameStatus.RESTART){
        	this.newGameInitialize();
        	this.play();
        }else{
        	System.out.println("Danke fürs Spielen.  Schade das du Gehst.");
        }
        
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Aufstehen Alice!");
        System.out.println("Weisst du wo du bist?");
        System.out.println("Du bist dem Weissen Kaninchen gefolgt.");
        System.out.println();
        System.out.println(player.getCurrentRoom().getLongDescription());
    }

	public LevelCreator getLC() {
		return LC;
	}
}
