package executeAble.commands;

import zuulCore.CommandWords;
import zuulCore.Game;
import zuulCore.Player;
import gameEnums.GameStatus;

/**
 * Implementiert das Hilfe Kommando
 * 
 * @author Martin Petzold
 * @version 1.1 (October 2012)
 */
public class HelpCommand extends Command
{
    private CommandWords commandWords;
    
    /**
     * Konstruktor von Objekten der Klasse HelpCommando
     */
    public HelpCommand(CommandWords words)
    {
        commandWords = words;
    }
    
    /**
     * Ohne zweites Kommando Wort werden ein Text und die Befehlswörter Ausgegeben
     * bei einem zweiten Kommandowort wird die Spezielle Hilfe Ausgegeben
     * Gibt immer den gamestatus RUN zurück
     */
    public GameStatus execute(Player player)
    {
       
        if(hasSecondWord()) {
            String direction = getSecondWord();
            try {
            	commandWords.showspecialhelp(direction);
            } catch (NullPointerException except) {
            	Game.textOut.lineEntry("Es gibt das Befehlswort nicht. Daher kann auch keine Hilfe angezeigt werden. " +
            							"Bis auf diese Hilfe das keine Hilfe angezeigt werden kann. Ich hoffe es war Ihnen eine Hilfe.");
            }
            
            
        }
        else{
        	Game.textOut.lineEntry("Ja, wo ist denn das Kaninchen hin?");
        	Game.textOut.lineEntry("Du scheinst es aus den Augen verloren zu haben.");
        	Game.textOut.lineEntry("Versuche es wieder zu finden!");
        	Game.textOut.lineEntry("deine Befehlswörter sind:");
        commandWords.showAll();
        }
        return GameStatus.RUN;
    }

    //die spezielle Hilfe für das Hilfe Kommando
	@Override
	public void showSpecialHelp() {
		Game.textOut.lineEntry("Dies ist das Kommando für die Hilfe wie du schon herausgefunden hast.");
		
	}
}
