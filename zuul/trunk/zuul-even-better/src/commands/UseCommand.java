package commands;

//TODO REDO
import gameBuilding.UsableCreator;

import java.util.ArrayList;

import zuulCore.Game;
import zuulCore.Player;
import zuulCore.TextOut;

import GameObjects.GameObject;
import GamePlayEnums.GameStatus;

public class UseCommand extends Command {

	public UseCommand() {
		super();
	}

	/**
	 * Versuche in einen Raum zu gehen, wenn ein Ausgang vorhanden ist. ,der
	 * Spieler die richtige Größe hat und der Raum nicht verschlossen ist
	 * erfolgreich gehe in den Raum wenn das nicht möglich ist schreibe Error
	 * Nachricht. Returns immer Gamestatus RUN
	 */
	public GameStatus execute(Player player) {

		if (hasSecondWord() && hasThirdWord()) {

				player.getUC().getRule(getSecondWord(),getThirdWord()).execute(player);			
		} else {
			Game.textOut.lineEntry("Das Kann ich nicht benutzen");
		}
		return GameStatus.RUN;
	}

	@Override
	public void showSpecialHelp() {
		// Ausgabe wenn die Hilfe zu diesem Command abgefragt wird
		Game.textOut.lineEntry("Commando zum kombinieren von Gegenständen oder Gegenstand und Richtung");

	}

}
