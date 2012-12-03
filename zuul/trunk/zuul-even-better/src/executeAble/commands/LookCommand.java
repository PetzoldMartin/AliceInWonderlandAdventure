package executeAble.commands;

import gameEnums.GameStatus;
import zuulCore.Game;
import zuulCore.Player;

//TODO REDO
public class LookCommand extends Command {

	public LookCommand() {
	}

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
					}
				} else {
					// Gegenstand aus Inventar oder Raum ansehen
					if (player.hasObject(getSecondWord())
							&& player.getSpecialObject(getSecondWord())
									.isVisebility()) {
						Game.textOut.lineEntry(player.getSpecialObject(
								getSecondWord()).getAmplification());
					} else {
						if (player.getCurrentRoom().hasObject(
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
