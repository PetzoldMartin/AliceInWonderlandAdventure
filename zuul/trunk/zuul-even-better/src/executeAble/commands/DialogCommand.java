package executeAble.commands;

import gameEnums.GameStatus;

import java.util.HashMap;
import java.util.Iterator;

import zuulCore.Game;
import zuulCore.thingsWithstore.Player;

/**
 * Die Klasse für Dialogkommands die eine Dialogoption oder einen Dialoganfandarstellt
 * @author Martin Petzold
 *
 */
public class DialogCommand extends Command {

	/**
	 * die Hashmap die die Dialogoptionen beinhaltet
	 */
	HashMap<String,Command> dialogStore;
	/**
	 * der Text der das vom Player gesagte darstellt 
	 */
	private String textout;
	/**
	 * der integer der den zur ausahl benötigten namen Darstellt
	 */
	Integer name =1;
	/**
	 * der Text der die Antwort des Dialogpartners Darstellt
	 */
	private String textIn;
	
	/**
	 * Konstruktor zum erzeugen eines Dialogkommands als eine Dialogwurzel
	 * @param textIn der Text des Dialogpartners
	 */
	public DialogCommand(String textIn){
		dialogStore= new HashMap<String,Command>();
		textout="Gesprächsanfang";
		this.textIn=textIn;
	}
	/**
	 * Konstruktor zum erzeugen eines Dialogkommands
	 * @param textOut der Text des Spielers
	 * @param textIn der Text des Dialogpartners
	 */
	public DialogCommand(String textOut,String textIn){
		this(textIn);
		textout=textOut;
	}
	
	@Override
	/**
	 * Methode die die normalen Game Kommands aus den Commandwords löscht und diese durch die momentanen Dialogkommands
	 * ersetzt fügt automatisch ein Gameendkommand und ein Hilfekommand hinzu 
	 * @param player der Spieler des Spieles
	 */
	public GameStatus execute(Player player) {
		Integer k=1;
		player.getnCW().clearCommands();
		Game.textOut.lineEntry(textIn);
		Game.textOut.lineEntry("Deine Antwort möglichkeiten sind");
		for (Iterator<String> i = dialogStore.keySet().iterator(); i.hasNext();){
			String name =i.next();
			player.getnCW().insertCommand(k.toString(), dialogStore.get(name));
			Game.textOut.lineEntry(k.toString()+" :  "+ ((DialogCommand) dialogStore.get(name)).getTextout());
			k++;
			}
		player.getnCW().insertCommand(k.toString(), new DialogEndCommand());
		Game.textOut.lineEntry(k.toString()+" :  "+ "Auf wiedersehen");
		 player.getnCW().insertCommand("?", new HelpCommand(player.getnCW()));
		 Game.textOut.lineEntry("? :  "+ "Hilfe");
		return GameStatus.RUN;
	}
	@Override
	/**
	 * zeigt die spezielle Hilfe des Dialogkommands
	 */
	public void showSpecialHelp() {
		Game.textOut.lineEntry("damit kannst du "+textout + " sagen");
	}

	/**
	 * 
	 * @return der Text des Spielers
	 */
	public String getTextout() {
		return textout;
	}
	
	/**
	 * Die Methode um eine Dialogoption ein Dialogkommand in den Dialogstore Einzutragen
	 * @param d Das einzufügende DialogKommand
	 */
	public void insertDialog(DialogCommand d){
		dialogStore.put(name.toString(), d);
		name++;
	}
	
}
