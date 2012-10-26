package commands;

import GamePlayEnums.GameStatus;
import de.fh_zwickau.oose.zuul.Command;
import de.fh_zwickau.oose.zuul.Player;

/**
 * Implementation of the 'quit' user command.
 * 
 * @author Michael Kolling
 * @version 1.0 (December 2002)
 */
public class QuitCommand extends Command
{
    /**
     * Constructor for objects of class QuitCommand
     */
    public QuitCommand()
    {
    }

    /**
     * "Quit" was entered. Check the argument to see whether
     * we really quit the game. Return true, if we should quit, false
     * otherwise.
     */
    public GameStatus execute(Player player)
    {
        if(getSecondWord() == null) {
            return GameStatus.STOP;
        }
        else {
            System.out.println("Ich kann das nicht beenden...");
            return GameStatus.GO;
        }
    }

	@Override
	public void showSpecialHelp() {
		System.out.println("mit diesem Kommando Beendes du das Spiel");
		
	}

}
