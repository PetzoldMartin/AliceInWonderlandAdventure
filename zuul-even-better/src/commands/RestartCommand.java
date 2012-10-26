package commands;

import GamePlayEnums.GameStatus;
import de.fh_zwickau.oose.zuul.Command;
import de.fh_zwickau.oose.zuul.Player;

public class RestartCommand extends Command 
{

	    public RestartCommand()
	    {
	    }


	    public GameStatus execute(Player player)
	    {

	    	
	        System.out.println("Das Wunderland wird neu Geträumt... ");
	        System.out.println("Was getan war ist nun nie Geschehn... ");
	        System.out.println("Der Hutmacher hat noch alle Tassen im Schrank... ");
	        System.out.println("... ");
	        
	        
	        
	        return GameStatus.RESTART ;
	    }


		@Override
		public void showSpecialHelp() {
			System.out.println("mit diesem kommando startest du das spiel neu");
			
		}


}
