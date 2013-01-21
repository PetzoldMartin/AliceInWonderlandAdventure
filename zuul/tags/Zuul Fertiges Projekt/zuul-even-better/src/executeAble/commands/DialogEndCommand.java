package executeAble.commands;

import gameEnums.GameStatus;
import zuulCore.Game;
import zuulCore.thingsWithstore.Player;
/**
 * die Klasse die ein Kommand zum beenden eines Dialogs erzeugt
 * @author Aismael
 *
 */
public class DialogEndCommand extends Command {


	/**
	 * der Konstruktor des Gameendkommands
	 */
	public DialogEndCommand(){
	}
	
	@Override
	/**
	 * Die Methode die die Dialogkommands aus dem DialogCreator löscht und die die ursprünglichen Commands wieder einfügt
	 * @param player der Spieler des Spiels
	 * 
	 */
	public GameStatus execute(Player player) {
		player.getnCW().clearCommands();
		player.getnCW().initialeCommands();
		Game.textOut.lineEntry("Du hast das Gespräch beendet");
		Game.textOut.lineEntry(player.getCurrentRoom().getLongDescription());
		return GameStatus.RUN;
	}

	@Override
	/**
	 * zeigt die spezielle Hilfe des Dialogend Kommands
	 */
	public void showSpecialHelp() {
		Game.textOut.lineEntry("Das Kommando was das Gespräch beendet");
		
	}

}

