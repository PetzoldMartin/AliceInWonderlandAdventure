package commands;

import GamePlayEnums.GameStatus;
import de.fh_zwickau.oose.zuul.Game;
import de.fh_zwickau.oose.zuul.Player;
import de.fh_zwickau.oose.zuul.TextOut;

/**
 * implementiert das geh Kommando
 * 
 * @author Martin Petzold
 * @version 1.1 (October 2012)
 */
public class GoCommand extends Command
{
    /**
     * Konstruktor von Objekten der Klasse GoCommand
     */
    public GoCommand()
    {
    }

    /** 
     * Versuche in einen Raum zu gehen, wenn ein Ausgang vorhanden ist.
     * ,der Spieler die richtige Grösse hat und der Raum nicht verschlossen ist
     * erfolgreich gehe in den Raum
     * wenn das nicht möglich ist schreibe Error Nachricht. Returnt immer Gamestatus RUN
     */
    public GameStatus execute(Player player)
    {
        if(hasSecondWord()) {
            String direction = getSecondWord();
            player.walk(direction);
        }
        else {
            //Ausgabe, das das 2. Wort fehlt. (Richtung)
        	Game.textOut.lineEntry("Wohin soll ich gehen?");
        }
        return GameStatus.RUN;
    }

	@Override
	public void showSpecialHelp() {
		//Ausgabe wenn die Hilfe zu diesem Kommand abgefragt wird
		Game.textOut.lineEntry("Es dient dazu dich im Wunderland zu bewegen.");
		
	}
}
