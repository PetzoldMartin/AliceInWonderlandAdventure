package commands;

import GamePlayEnums.GameStatus;
import de.fh_zwickau.oose.zuul.Command;
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
            commandWords.showspecialhelp(direction);
            
        }
        else{
        	 System.out.println("Ja wo ist denn das Kaninchen");
             System.out.println("du scheinst es verloren zu haben.");
             System.out.println("versuche es wieder zu finden");
             System.out.println("deine Befehlswörter sind:");
        commandWords.showAll();
        }
        return GameStatus.RUN;
    }

    //die spezzielle Hilfe für das Hilfe Kommando
	@Override
	public void showSpecialHelp() {
		System.out.println("Dies ist das komando für die Hilfe wie du schon herausgefunden hast");
		
	}
}
