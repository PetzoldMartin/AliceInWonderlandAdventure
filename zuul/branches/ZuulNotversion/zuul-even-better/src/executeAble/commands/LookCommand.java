package executeAble.commands;

import gameEnums.GameStatus;
import zuulCore.Game;
import zuulCore.thingsWithstore.Player;

/**
 * Die Klasse für ein Kommand zum ansehen von Gegenständen Räumen und des Spielerinventars
 * @author Aismael
 *
 */
public class LookCommand extends Command {

	/**
	 * der Konstruktor des LookCommands
	 */
	public LookCommand() {
	}

	/**
	 * Die Methode zum auswerten was angesehen werden soll die dann die richtige beschreibung auf die Ausgabe schreibt
	 * @param der Spieler des Spieles
	 */
	public GameStatus execute(Player player) {
		if (hasSecondWord()) {
			// Inventar
			if (getSecondWord().equals("inventar")) {
				if (player.isThereanyvisible()) {
					Game.textOut.lineEntry("Ich habe kein Inventar");
				} else {
					Game.textOut.entry("In dein Inventar befindet sich: ");
					player.getAllItems();
				}
			} else {
				// Raum anzeigen
				if (getSecondWord().equals("raum")) {
					if (player.getCurrentRoom().isThereanyvisible()) {
						Game.textOut.entry("Der Raum ist Leer");
					} else {
						Game.textOut.entry("Im Raum erkennst du: ");
						player.getCurrentRoom().getAllItems();
						Game.textOut.lineEntry(player.getCurrentRoom().getLongDescription());
					}
				} else {
					// Gegenstand aus Inventar oder Raum ansehen
					if (player.hasReadyToUseObject(getSecondWord())
							&& player.getSpecialObject(getSecondWord())
									.isVisebility()) {
						Game.textOut.lineEntry(player.getSpecialObject(
								getSecondWord()).getAmplification());
					} else {
						if (player.getCurrentRoom().hasReadyToUseObject(
								getSecondWord())
								&& player.getCurrentRoom()
										.getSpecialObject(getSecondWord())
										.isVisebility()) {
							Game.textOut.lineEntry(player.getCurrentRoom()
									.getSpecialObject(getSecondWord())
									.getAmplification());
						} else {
							Game.textOut
									.lineEntry("Gegenstand ist nicht vorhanden.");
						}
					}
				}
			}

		}

		else {
			Game.textOut.lineEntry("Was soll ich den Betrachten?");
		}
		return GameStatus.RUN;
	}

	/**
	 * die spezielle Hilfe des LookKommands
	 */
	@Override
	public void showSpecialHelp() {
		// Ausgabe wenn die Hilfe zu diesem Command abgefragt wird
		Game.textOut
				.lineEntry("Nutze Guck um Gegenstände genauer zu betrachten! ");
		Game.textOut
				.lineEntry("Um dein Inventar anzuschaun nutz >Guck inventar< !");
		Game.textOut.lineEntry("Um dein Raum anzuschaun nutz >Guck room< !");
	}
}
