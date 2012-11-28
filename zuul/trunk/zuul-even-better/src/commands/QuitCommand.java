package commands;

import zuulCore.Game;
import zuulCore.Player;
import GamePlayEnums.GameStatus;

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
     * Beendet das Spiel wenn es kein zweites Kommando Wort gibt, gibt Gamestatus STOP zur�ck
     * ansonsten Fehlerausgabe gibt Gamestatus RUN zur�ck
     */
    public GameStatus execute(Player player)
    {
        if(getSecondWord() == null) {
            return GameStatus.STOP;
        }
        else {
        	Game.textOut.lineEntry("Ich kann das nicht beenden...");
            return GameStatus.RUN;
        }
    }

    //Die spezielle Hilfe f�r das QuitCommand
	@Override
	public void showSpecialHelp() {
		Game.textOut.lineEntry("Mithilfe dieses Befehls Beendest du das Spiel.");
		
	}

}
