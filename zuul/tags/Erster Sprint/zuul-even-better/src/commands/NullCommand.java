package commands;

import de.fh_zwickau.oose.zuul.Player;

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
    	System.out.println("Was willst du...(Schreibe hilfe oder ? f�r Hilfe.)");
        return GameStatus.RUN;
    }

	@Override
	public void showSpecialHelp() {
		// TODO Auto-generated method stub
		
	}
}
