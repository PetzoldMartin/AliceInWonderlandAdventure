package executeAble.commands;

//TODO REDO
import executeAble.gamePlayRules.GameplayRule;
import zuulCore.Game;
import zuulCore.GameObject;
import zuulCore.Player;
import gameEnums.GameStatus;
/**
 * 
 * @author Aismael
 * das {@link Command} das den Spieler {@link GameObject}e auf verschiedene Weise je nach {@link GameplayRule}
 * benutzen lässt
 */
public class UseCommand extends Command {

	public UseCommand() {
		super();
	}

	/**
	 * die Methode die wenn das {@link UseCommand} ein secondWord und ein Thirdword hat die zu den Gegenständen passende 
	 * {@link GameplayRule} aufruft
	 */
	public GameStatus execute(Player player) {

		if (hasSecondWord() && hasThirdWord()) {

			return	player.getUC().getRule(getSecondWord(),getThirdWord()).execute(player);			
		} else {
			Game.textOut.lineEntry("Das Kann ich nicht benutzen");
		}
		return GameStatus.RUN;
	}

	/**
	 * die spezielle hilfe für das {@link UseCommand}
	 */
	@Override
	public void showSpecialHelp() {
		// Ausgabe wenn die Hilfe zu diesem Command abgefragt wird
		Game.textOut.lineEntry("Commando zum kombinieren von Gegenständen oder Gegenstand und Richtung");
		
		
	}

}
