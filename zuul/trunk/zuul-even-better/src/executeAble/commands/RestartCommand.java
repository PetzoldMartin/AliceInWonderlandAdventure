package executeAble.commands;

import gameEnums.GameStatus;
import zuulCore.Game;
import zuulCore.Player;

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
	     * Startet das Spiel neu,
	     *  wenn es kein zweites Kommando Wort gibt, gibt Gamestatus RESTART zurück.
	     *  Ansonsten bei Fehlerausgabe gibt Gamestatus RUN zurück
	     */
	     
	    public GameStatus execute(Player player)
	    {    	
	        
	        if(getSecondWord() == null) {
	        	Game.textOut.lineEntry("Das Wunderland wird neu Geträumt... ");
	        	Game.textOut.lineEntry("Was getan war ist nun nie Geschehn... ");
	        	Game.textOut.lineEntry("Der Hutmacher hat noch alle Tassen im Schrank... ");
	        	Game.textOut.lineEntry("... ");
   
		        return GameStatus.RESTART ;
	        }
	        else {
	        	Game.textOut.lineEntry("Ich kann das nicht neu starten...");
	            return GameStatus.RUN;
	        }
	    }

	  //Die spezielle Hilfe für das RestartCommand
		@Override
		public void showSpecialHelp() {
			Game.textOut.lineEntry("Mit diesen Befehl würd das Aktuelle Spiel neu gestartet. Alle Gegenstände verschwinden aus dem Inventar.");
			
		}


}
