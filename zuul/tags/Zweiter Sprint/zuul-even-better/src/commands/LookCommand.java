package commands;

import java.util.ArrayList;

import GameObjects.GameObject;
import GamePlayEnums.GameStatus;
import de.fh_zwickau.oose.zuul.Game;
import de.fh_zwickau.oose.zuul.Player;

public class LookCommand extends Command {

	public LookCommand() {
	}

	public GameStatus execute(Player player) {
		boolean contain;
		if (hasSecondWord()) {
			contain = false;
			// Inventar
			if (getSecondWord().equals("inventar")) {
				if (player.getInventory().size() == 0) {
					Game.textOut.lineEntry("Ich habe kein Inventar");
					contain = true;
				} else {

					Game.textOut.entry("In dein Inventar befindet sich: ");
					contain = itemShow(player.getInventory(), contain);
				}
				Game.textOut.entry(".");
			}
			// Raum anzeigen
			if (getSecondWord().equals("room")) {
				if (player.getCurrentRoom().getWarehouse().size() == 0) {
					Game.textOut.entry("Der Raum ist Leer");
					contain = true;
				} else {
					Game.textOut.entry("Im Raum erkennst du: ");
					contain = itemShow(player.getCurrentRoom().getWarehouse(),
							contain);
				}
				Game.textOut.entry(".");
			}
			// Beschreibung inventar Gegenstand
			contain = itemDescription(player.getInventory(), contain);

			// Beschreibung Gegenstand room
			contain = itemDescription(player.getCurrentRoom().getWarehouse(),
					contain);

			if (!contain) {
				Game.textOut.lineEntry("Gegenstand ist nicht vorhanden.");
			}

		}

		else {
			// Ausgabe, das das 2. Wort fehlt. (Richtung)
			Game.textOut.lineEntry("Was soll ich den Betrachten?");
		}
		return GameStatus.RUN;
	}

	private boolean itemShow(ArrayList<GameObject> searchArea, boolean contain) {
		int k=1;
		boolean b =contain;
		for (int j = 0; j < searchArea.size(); j++){
			if (searchArea.get(j).isVisebility() == false){
				k++;
			}
		}
		for (int j = 0; j < searchArea.size(); j++) {
			if (searchArea.get(j).isVisebility() == true) {
				Game.textOut.entry(searchArea.get(j).getObjName());
				if (j < searchArea.size() - k) {
					Game.textOut.entry(", ");
				}
				
				b = true;
			
			}
			
		}
		return b;
	}

	private boolean itemDescription(ArrayList<GameObject> searchArea,
			boolean contain) {
		boolean b =contain;
		for (int k = 0; k < searchArea.size(); k++) {
			if (searchArea.get(k).getObjName().equals(getSecondWord())) {
				if (searchArea.get(k).isVisebility() == true) {
					Game.textOut.lineEntry(searchArea.get(k).getAmplification());
					b = true;
				}
			}
		}
		return b;
	}

	@Override
	public void showSpecialHelp() {
		// Ausgabe wenn die Hilfe zu diesem Command abgefragt wird
		Game.textOut.lineEntry("Nutze Guck um Gegenstände genauer zu betrachten! ");
		Game.textOut.lineEntry("Um dein Inventar anzuschaun nutz >Guck inventar< !");
		Game.textOut.lineEntry("Um dein Raum anzuschaun nutz >Guck room< !");
	}
}
