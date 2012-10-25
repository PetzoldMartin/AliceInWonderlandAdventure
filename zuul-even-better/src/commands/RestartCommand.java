package commands;

import de.fh_zwickau.oose.zuul.Command;
import de.fh_zwickau.oose.zuul.Player;

public class RestartCommand extends Command 
{

	    public RestartCommand()
	    {
	    }


	    public boolean execute(Player player)
	    {

	    	
	        System.out.println("Das Wunderland wird neu Geträumt... ");
	        System.out.println("Was getan war ist nun nie Geschehn... ");
	        System.out.println("Der Hutmacher hat noch alle Tassen im Schrank... ");
	        System.out.println("... ");
	        
	        
	        
	        return false;
	    }


		@Override
		public void showSpecialHelp() {
			// TODO Auto-generated method stub
			
		}


}
