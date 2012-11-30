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
						.isSpeakAble()) { // �berpr�ft ob der Gegenstand
											// Sprechen kann
					Game.textOut.lineEntry("--> Gespr�ch <-- ."); // Noch unklar
																	// wie
																	// implementiert
																	// :D *TODO
																	// Dingen QA
																	// wie man
																	// das macht
																	// -.-'
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
