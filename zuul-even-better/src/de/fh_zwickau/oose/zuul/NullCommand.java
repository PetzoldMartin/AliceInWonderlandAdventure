package de.fh_zwickau.oose.zuul;

import GamePlayEnums.GameStatus;

/**
 * Implementation of the 'help' user command.
 * 
 * @author Martin Petzold
 * @version 1.1 (October 2012)
 */
public class NullCommand extends Command
{
    
    /**
     * Constructor for objects of class HelpCommand
     */
    public NullCommand()
    {
        // nothing to do
    }
    
    /**
     * Print out an error message
     */
    public GameStatus execute(Player player)
    {
    	System.out.println("Was willst du...(Schreibe hilfe oder ? f�r Hilfe.)");
        return GameStatus.RUN;
    }

	@Override
	public void showSpecialHelp() {
		// TODO Auto-generated method stub
		
	}
}
