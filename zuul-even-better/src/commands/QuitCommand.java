package commands;

import GamePlayEnums.GameStatus;
import de.fh_zwickau.oose.zuul.Command;
import de.fh_zwickau.oose.zuul.Player;

/**
 * Implementation of the 'quit' user command.
 * 
 * @author Martin Petzold
 * @version 1.1 (October 2012)
 */
public class QuitCommand extends Command
{
    /**
     * Konstruktor von Objekten der Klasse  QuitCommand
     */
    public QuitCommand()
    {
    }

    /**
     * Beendet das Spiel wenn es kein zweites Kommando Wort gibt, gibte Gamestatus STOP zurück
     * ansonsten Fehlerausgabe gibt Gamestatus RUN zurück
     */
    public GameStatus execute(Player player)
    {
        if(getSecondWord() == null) {
            return GameStatus.STOP;
        }
        else {
            System.out.println("Ich kann das nicht beenden...");
            return GameStatus.RUN;
        }
    }

    //Die spezielle Hilfe für das QuitCommand
	@Override
	public void showSpecialHelp() {
		System.out.println("mit diesem Kommando Beendes du das Spiel");
		
	}

}
