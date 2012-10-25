package de.fh_zwickau.oose.zuul;
/**
 * Implementation of the 'help' user command.
 * 
 * @author Michael Kolling
 * @version 1.0 (December 2002)
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
    public boolean execute(Player player)
    {
    	System.out.println("I don't understand...(Type \"help\" for help.)");
        return false;
    }

	@Override
	public void showSpecialHelp() {
		// TODO Auto-generated method stub
		
	}
}
