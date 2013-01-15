package zuulCore;

import executeAble.commands.Command;
import gameEnums.GameStatus;
import gui.GameGui;

import java.util.Observable;
import java.util.Observer;

import observer.gameObserver.BackroundActioner;
import observer.gameObserver.GameListener;
import observer.gameObserver.InventarActioner;
import observer.gameObserver.KommandActioner;
import observer.gameObserver.RoomInventarActioner;
import observer.gameObserver.TextOutActioner;
import observer.gameObserver.TextoutListener;
import observer.guiObserver.GuiActioner;
import observer.guiObserver.GuiListener;
import zuulCore.thingsWithstore.Player;

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

public class Game extends Observable implements Runnable,Observer

{
    private Parser parser;// der Textparser des Spieles
    private Player player;// die Instanz der Player Klasse des Spieles
	private GameStatus gameStatus;
	private boolean ischanged;
//    private LevelCreator nLC;//der Level/Raum Creator des Spieles
	public static TextOut textOut;
	
    /**
     * Konstruktor der Game Klasse erstellt den Parser und Ruft die Initialisierungsmethode auf
     */
    public Game() 
    {

        newGameInitialize();
        gameStatus=GameStatus.RUN;
        
        
        
    }
    
    /**
     * Die Main Klasse erstellt ein Spiel  verbindet den gamecore mit der gui und ruft die Hauptmethode auf.
     */
    public static void main(String[] args) {
    	Game game = new Game();
    	GameGui gG= new GameGui();
    	
    	//Beobachter die das game beobachten
    	BackroundActioner backRndActioner=new BackroundActioner();
    	KommandActioner kmdActioner=new KommandActioner();
    	InventarActioner invActioner=new InventarActioner();
    	RoomInventarActioner rommInvActioner=new RoomInventarActioner();
    	TextOutActioner tOA= new TextOutActioner();
    	TextoutListener tol= new TextoutListener(tOA);
    	GameListener gameListener= new GameListener(backRndActioner,kmdActioner,invActioner,rommInvActioner);
    	game.addObserver(gameListener);
    	
    	//actioner bei Gui eingetragen
    	textOut.addObserver(tol);
    	backRndActioner.addObserver(gG);
    	kmdActioner.addObserver(gG);
    	invActioner.addObserver(gG);
    	rommInvActioner.addObserver(gG);
    	tOA.addObserver(gG);
    	
    	//beobachter die die Gui beobachten
    	GuiActioner gAct=new GuiActioner();
    	GuiListener gLst = new GuiListener(gAct);
    	
    	//von dem Game bobachtete klassen
    	gAct.addObserver(game);
    	gG.getGst().addObserver(gLst);
    	
    	//Spielstart
    	Thread a1= new Thread(game);
    	Thread a2= new Thread(gG);
    	a2.start();
    	a1.start();
    }

    /**
     * Die Spiel Initialisier Methode erstellt den Spieler, den LevelCreator der die Räume erstellt
     * und setzt den Startraum fest
     */
    private void newGameInitialize()
    {
        player = new Player();
        player.setCurrentRoom(player.getnLC().getStartRoom());
        parser = new Parser(player.getnCW());
    	textOut=new TextOut();        
    	
    }
    

    /**
     *  Die Hauptmethode des Spieles
     */
    public void play() 
    {    
    	updateGuiStats();
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        GameStatus gameStatus = GameStatus.RUN;
        textOut.ausgabe();
        //Haupt-Spiel-Schleifschen
        while(gameStatus==GameStatus.RUN) {
            Command command = parser.consoleReader();
                gameStatus = command.execute(player);
                textOut.ausgabe();
                updateGuiStats();
        	if (ischanged){
                gameStatus = this.gameStatus;
                textOut.ausgabe();
                updateGuiStats();
                ischanged=false;
        	}
        }
        if(gameStatus==GameStatus.RESTART){
        	this.newGameInitialize();
        	this.play();
        }else{
        	textOut.lineEntry("Danke fürs Spielen.  Schade das du Gehst.");
        	textOut.ausgabe();
        }
        
    }

    /**
     * Schreibt die Willkommensnachricht für den Spieler auf die Konsole
     */
    private void printWelcome()
    {
    	textOut.lineEntry();
    	textOut.lineEntry("Aufstehen Alice!");
    	textOut.lineEntry("Weisst du wo du bist?");
    	textOut.lineEntry("Du bist dem Weißen Kaninchen gefolgt. Finde es!");
    	textOut.lineEntry();
    	textOut.lineEntry(player.getCurrentRoom().getLongDescription());
    	Game.textOut.lineEntry(">");
    	
    }


	public Player getPlayer() {
		return player;
	}
	
	public Parser getParser() {
		return parser;
	}

	public TextOut getTextOut() {
		return textOut;
	}
	
	/**
	 * Methode die meldet wenn es neuigkeiten für die Gui gibt
	 */
	public void updateGuiStats(){
		setChanged();
		notifyObservers(player);
	}

	@Override
	public void run() {
		this.play();	
	}

	/**
	 * methode die Änderungen der Gui an das spiel weitergibt 
	 */
	@Override
	public void update(Observable o, Object arg) {
		Command command = parser.getCommand((String)arg);
		 gameStatus = command.execute(player);
		 ischanged=true;
	}
}
