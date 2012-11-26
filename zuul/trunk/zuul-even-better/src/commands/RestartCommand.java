package commands;

import de.fh_zwickau.oose.zuul.Player;
import GamePlayEnums.GameStatus;

public class RestartCommand extends Command 
{
/**
 * @author Martin Petzold
 * @version 0.1 (October 2012)
 */
	/*
	 * Konstruktor von Objekten der Klasse RestartCommand
	 */
	    public RestartCommand()
	    {
	    }


	    /**
	     * Startet das spiel neu,
	     *  wenn es kein zweites Kommando Wort gibt, gibte Gamestatus RESTART zurück.
	     *  Ansonsten bei Fehlerausgabe gibt Gamestatus RUN zurück
	     */
	     
	    public GameStatus execute(Player player)
	    {    	
	        
	        if(getSecondWord() == null) {
	        	System.out.println("Das Wunderland wird neu Geträumt... ");
		        System.out.println("Was getan war ist nun nie Geschehn... ");
		        System.out.println("Der Hutmacher hat noch alle Tassen im Schrank... ");
		        System.out.println("... ");
   
		        return GameStatus.RESTART ;
	        }
	        else {
	            System.out.println("Ich kann das nicht neu starten...");
	            return GameStatus.RUN;
	        }
	    }

	  //Die spezielle Hilfe für das RestartCommand
		@Override
		public void showSpecialHelp() {
			System.out.println("Mit diesen Befehl würd das Aktuelle Spiel neu gestartet. Alle Gegenstände verschwinden aus dem Inventar.");
			
		}


}
