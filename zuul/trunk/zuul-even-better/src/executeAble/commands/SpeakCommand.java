package executeAble.commands;

import gameEnums.GameStatus;
import zuulCore.Game;
import zuulCore.GameObject;
import zuulCore.Player;

/**
 * Unterklasse der Basisklasse Command
 * 
 * Dient um mit GameObjekten zu Reden.
 * 
 */
public class SpeakCommand extends Command {

	/**
	 * L�st wenn das {@link GameObject} mit dem der Spieler reden will vorhanden ist und man mit ihm sprechen kann ein
	 * gespr�ch aus
	 */
	@Override
	public GameStatus execute(Player player) {

		if (hasSecondWord()) {
			if (player.getCurrentRoom().hasObject(getSecondWord())) {
				if (player.getCurrentRoom().getSpecialObject(getSecondWord())
						.isSpeakAble()) { // �berpr�ft ob der Gegenstand
											// Sprechen kann
					Game.textOut.lineEntry("du sprichst mit  "+ getSecondWord());
					player.getnDC().getDialog(getSecondWord()).execute(player); 
				} else {
					Game.textOut
							.lineEntry("So verr�ckt bin ich nun auch wieder nicht.");

				}

			} else {
				Game.textOut
						.lineEntry("So verr�ckt bin ich nun auch wieder nicht.");

			}
		} else {
			Game.textOut
					.lineEntry("So verr�ckt bin ich nun auch wieder nicht.");
		}
		return GameStatus.RUN;
	}

	/**
	 * //Die spezielle Hilfe f�r das SpeakCommand
	 */
	@Override
	public void showSpecialHelp() {
		Game.textOut
				.lineEntry("Du versuchst mit etwas oder jemand zu sprechen.");
	}

}
