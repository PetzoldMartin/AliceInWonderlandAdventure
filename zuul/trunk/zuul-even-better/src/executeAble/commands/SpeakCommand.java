package executeAble.commands;

import zuulCore.Game;
import zuulCore.Player;
import GamePlayEnums.GameStatus;

/**
 * Unterklasse der Basisklasse Command
 * 
 * Dient um mit GameObjekten zu Reden.
 * 
 */
// TODO REDO
public class SpeakCommand extends Command {

	@Override
	public GameStatus execute(Player player) {

		if (hasSecondWord()) {
			if (player.getCurrentRoom().hasObject(getSecondWord())) {
				if (player.getCurrentRoom().getSpecialObject(getSecondWord())
						.isSpeakAble()) { // Überprüft ob der Gegenstand
											// Sprechen kann
					Game.textOut.lineEntry("--> Gespräch <-- ."); // Noch unklar
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
