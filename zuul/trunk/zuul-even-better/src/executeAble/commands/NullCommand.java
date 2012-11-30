package executeAble.commands;

import zuulCore.Game;
import zuulCore.Player;
import GamePlayEnums.GameStatus;

/**
 * Implementation des null Commands
 * 
 * @author Martin Petzold
 * @version 1.1 (October 2012)
 */
public class NullCommand extends Command
{
    
    /**
     * Konstruktor des Null Kommandos
     */
    public NullCommand()
    {
        // nichts zu tun
    }
    
    /**
     * Schreibt eine Fehlernachricht auf die Ausgabe
     */
    public GameStatus execute(Player player)
    {
    	Game.textOut.lineEntry("Was willst du...(Schreibe hilfe oder ? für Hilfe.)");
        return GameStatus.RUN;
    }

	@Override
	public void showSpecialHelp() {
		// TODO Auto-generated method stub
		
	}
}
