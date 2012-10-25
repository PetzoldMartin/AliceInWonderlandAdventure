package commands;

import de.fh_zwickau.oose.zuul.Command;
import de.fh_zwickau.oose.zuul.CommandWords;
import de.fh_zwickau.oose.zuul.Player;

/**
 * Implementation of the 'help' user command.
 * 
 * @author Michael Kolling
 * @version 1.0 (December 2002)
 */
public class HelpCommand extends Command
{
    private CommandWords commandWords;
    
    /**
     * Constructor for objects of class HelpCommand
     */
    public HelpCommand(CommandWords words)
    {
        commandWords = words;
    }
    
    /**
     * Print out some help information. Here we print some stupid, 
     * cryptic message and a list of the command words.
     * Returns always false.
     */
    public boolean execute(Player player)
    {
       
        if(hasSecondWord()) {
            String direction = getSecondWord();
            commandWords.showspecialhelp(direction);
            
        }
        else{
        	 System.out.println("Ja wo ist denn das Kaninchen");
             System.out.println("du scheinst es verloren zu haben.");
             System.out.println("versuche es wieder zu finden");
             System.out.println("deine Befehlswörter sind:");
        commandWords.showAll();
        }
        return false;
    }

	@Override
	public void showSpecialHelp() {
		// TODO Auto-generated method stub
		
	}
}
