package commands;

import GamePlayEnums.GameStatus;
import de.fh_zwickau.oose.zuul.Command;
import de.fh_zwickau.oose.zuul.Player;

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
	     * Startet das spiel neu
	     *  wenn es kein zweites Kommando Wort gibt, gibte Gamestatus RESTART zur�ck
	     * ansonsten Fehlerausgabe gibt Gamestatus RUN zur�ck
	     */
	     
	    public GameStatus execute(Player player)
	    {

	    	
	        
	        if(getSecondWord() == null) {
	        	System.out.println("Das Wunderland wird neu Getr�umt... ");
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

	  //Die spezielle Hilfe f�r das RestartCommand
		@Override
		public void showSpecialHelp() {
			System.out.println("mit diesem kommando startest du das spiel neu");
			
		}


}
