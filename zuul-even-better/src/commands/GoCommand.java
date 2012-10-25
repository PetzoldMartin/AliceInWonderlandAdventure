package commands;

import de.fh_zwickau.oose.zuul.Command;
import de.fh_zwickau.oose.zuul.Player;

/**
 * Implementation of the 'go' user command.
 * 
 * @author Michael Kolling
 * @version 1.0 (December 2002)
 */
public class GoCommand extends Command
{
    /**
     * Constructor for objects of class GoCommand
     */
    public GoCommand()
    {
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message. Returns always 'false'.
     */
    public boolean execute(Player player)
    {
        if(hasSecondWord()) {
            String direction = getSecondWord();
            player.walk(direction);
        }
        else {
            // if there is no second word, we don't know where to go...
            System.out.println("wohin soll ich gehen?");
        }
        return false;
    }

	@Override
	public void showSpecialHelp() {
		System.out.println("der Befehl mit dem du laufen kannst");
		
	}
}
