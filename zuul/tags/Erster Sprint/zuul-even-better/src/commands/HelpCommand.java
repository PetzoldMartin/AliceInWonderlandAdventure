package commands;

import GamePlayEnums.GameStatus;
import de.fh_zwickau.oose.zuul.CommandWords;
import de.fh_zwickau.oose.zuul.Player;

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
            	System.out.println("Es gibt das Befehlswort nicht. Daher kann auch keine Hilfe angezeigt werden. " +
            							"Bis auf diese Hilfe das keine Hilfe angezeigt werden kann. Ich hoffe es war Ihnen eine Hilfe.");
            }
            
            
        }
        else{
        	 System.out.println("Ja, wo ist denn das Kaninchen hin?");
             System.out.println("Du scheinst es aus den Augen verloren zu haben.");
             System.out.println("Versuche es wieder zu finden!");
             System.out.println("deine Befehlswörter sind:");
        commandWords.showAll();
        }
        return GameStatus.RUN;
    }

    //die spezielle Hilfe für das Hilfe Kommando
	@Override
	public void showSpecialHelp() {
		System.out.println("Dies ist das Kommando für die Hilfe wie du schon herausgefunden hast.");
		
	}
}
