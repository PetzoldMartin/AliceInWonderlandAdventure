package executeAble.commands;

import zuulCore.Game;
import zuulCore.Player;
import GamePlayEnums.GameStatus;

/**
 * implementiert das gehe Kommando
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
     * ,der Spieler die richtige Größe hat und der Raum nicht verschlossen ist
     * erfolgreich gehe in den Raum
     * wenn das nicht möglich ist schreibe Error Nachricht. Returns immer Gamestatus RUN
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
		//Ausgabe wenn die Hilfe zu diesem Command abgefragt wird
		Game.textOut.lineEntry("Es dient dazu dich im Wunderland zu bewegen.");
		
	}
}
