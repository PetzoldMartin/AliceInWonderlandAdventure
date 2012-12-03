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
	 * Löst wenn das {@link GameObject} mit dem der Spieler reden will vorhanden ist und man mit ihm sprechen kann ein
	 * gespräch aus
	 */
	@Override
	public GameStatus execute(Player player) {

		if (hasSecondWord()) {
			if (player.getCurrentRoom().hasObject(getSecondWord())) {
				if (player.getCurrentRoom().getSpecialObject(getSecondWord())
						.isSpeakAble()) { // Überprüft ob der Gegenstand
											// Sprechen kann
					player.getnDC().getDialog(getSecondWord()).execute(player); // Noch unklar
																	// wie
																	// implementiert
																	// :D *TODO
																	// Dingen QA
																	// wie man
																	// das macht
																	// -.-'
				} else {
					Game.textOut
							.lineEntry("So verrückt bin ich nun auch wieder nicht.");

				}

			} else {
				Game.textOut
						.lineEntry("So verrückt bin ich nun auch wieder nicht.");

			}
		} else {
			Game.textOut
					.lineEntry("So verrückt bin ich nun auch wieder nicht.");
		}
		return GameStatus.RUN;
	}

	/**
	 * //Die spezielle Hilfe für das SpeakCommand
	 */
	@Override
	public void showSpecialHelp() {
		Game.textOut
				.lineEntry("Du versuchst mit etwas oder jemand zu sprechen.");
	}

}
