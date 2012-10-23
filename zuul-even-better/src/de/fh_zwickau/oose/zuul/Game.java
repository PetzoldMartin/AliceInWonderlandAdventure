package de.fh_zwickau.oose.zuul;
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
 * @author  Michael Kolling and David J. Barnes
 * @version 1.1 (December 2002)
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
        player = new Player();
        parser = new Parser();
        createRooms();
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
    private void createRooms()
    {
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
                
        boolean finished = false;
        while(! finished) {
            Command command = parser.getCommand();
                finished = command.execute(player);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to The World of Zuul!");
        System.out.println("The World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(player.getCurrentRoom().getLongDescription());
    }
}
