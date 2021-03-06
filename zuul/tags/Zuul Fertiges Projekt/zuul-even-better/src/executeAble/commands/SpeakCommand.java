package executeAble.commands;

import gameEnums.GameStatus;
import zuulCore.Game;
import zuulCore.GameObject;
import zuulCore.thingsWithstore.Player;

/**
 * Unterklasse der Basisklasse Command
 *  @author Martin Petzold
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

		if (hasSecondWord()&!hasThirdWord()) {
			if (player.getCurrentRoom().hasReadyToUseObject(getSecondWord())) {
				if (player.getCurrentRoom().getSpecialObject(getSecondWord())
						.isSpeakAble()) { // �berpr�ft ob der Gegenstand
											// Sprechen kann
					Game.textOut.lineEntry("du sprichst mit  "+ getSecondWord());
					if(player.getnDC().hasDialog(getSecondWord())){
					player.getnDC().getDialog(getSecondWord()).execute(player); 
					}else{
						Game.textOut.lineEntry("ich k�nnte damit reden wenn der text nicht fehlen w�rde");
					}
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
