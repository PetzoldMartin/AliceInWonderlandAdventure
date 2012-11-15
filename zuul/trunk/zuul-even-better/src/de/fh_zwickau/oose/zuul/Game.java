package de.fh_zwickau.oose.zuul;

import gameBuilding.LevelCreator;
import commands.Command;

import GamePlayEnums.GameStatus;

/**
 *  Diese Klasse ist die Hauptklasse der "World of Zuul" Anwendung
 *  "World of Zuul" ist ein einfaches Text basiertes Adventure Spiel.
 *  
 * 
 *  Um das Spiel zu spielen erzeuge Eine Instanz dieser Klasse und rufe 
 *  die play klasse auf
 * 
 *  Diese Main Klasse initiallisiert alle anderen Klassen.
 * 
 * @author Martin Petzold
 * @version 1.1 (October 2012)
 */

class Game 
{
    private Parser parser;// der Textparser des Spieles
    private Player player;// die Instanz der Player Klasse des Spieles
    private LevelCreator LC;//der Level/Raum Creator des Spieles

    /**
     * Konstruktor der Game Klasse erstellt den Parser und Ruft die Initialisierungsmethode auf
     */
    public Game() 
    {

        parser = new Parser();
        newGameInitialize();
        
    }
    
    /**
     * Die Main Klasse erstellt ein Spiel und ruft die Hauptmethode auf.
     */
    public static void main(String[] args) {
    	Game game = new Game();
    	game.play();
    }

    /**
     * Die Spiel Initialisier Methode erstellt den Spieler, den LevelCreator der die Räume erstellt
     * und setzt den Startraum fest
     */
    private void newGameInitialize()
    {
        player = new Player();
    	LC= new LevelCreator();
    	player.setCurrentRoom(LC.getStartRoom());
    }
    

    /**
     *  Die Hauptmethode des Spieles
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        GameStatus gameStatus = GameStatus.RUN;
        
        //Haupt-Spiel-Schleifschen
        while(gameStatus==GameStatus.RUN) {
            Command command = parser.consoleReader();
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
     * Schreibt die Willkommensnachricht für den Spieler auf die Konsole
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Aufstehen Alice!");
        System.out.println("Weisst du wo du bist?");
        System.out.println("Du bist dem Weißen Kaninchen gefolgt. Finde es!");
        System.out.println();
        System.out.println(player.getCurrentRoom().getLongDescription());
    }

	public LevelCreator getLC() {
		return LC;
	}
	public Player getPlayer() {
		return player;
	}
	
	public Parser getPlarser() {
		return parser;
	}
}
