package commands;

import java.util.ArrayList;

import GameObjects.GameObject;
import GamePlayEnums.GameStatus;
import de.fh_zwickau.oose.zuul.Player;

public class LookCommand extends Command {

	public LookCommand() {
	}

	public GameStatus execute(Player player) {
		boolean contain;
		if (hasSecondWord()) {
			contain = false;
			// inventar
			if (getSecondWord().equals("inventar")) {
				if (player.getInventory().size() == 0) {
					System.out.print("Ich habe kein Inventar");
					contain = true;
				} else {

					System.out.print("In dein Inventar befindet sich: ");
					contain = itemShow(player.getInventory(), contain);
				}
				System.out.println(".");
			}
			// Raum anzeigen
			if (getSecondWord().equals("room")) {
				if (player.getCurrentRoom().getWarehouse().size() == 0) {
					System.out.print("Der Raum ist Leer");
					contain = true;
				} else {
					System.out.print("Im Raum erkennst du: ");
					contain = itemShow(player.getCurrentRoom().getWarehouse(),
							contain);
				}
				System.out.println(".");
			}
			// beschreibung invetar gegestand
			contain = itemDescription(player.getInventory(), contain);

			// beschreibung gegenstand room
			contain = itemDescription(player.getCurrentRoom().getWarehouse(),
					contain);

			if (!contain) {
				System.out.println("Gegenstand ist nicht vorhanden.");
			}

		}

		else {
			// Ausgabe, das das 2. Wort fehlt. (Richtung)
			System.out.println("Was soll ich den Betrachten?");
		}
		return GameStatus.RUN;
	}

	private boolean itemShow(ArrayList<GameObject> searchArea, boolean contain) {
		int k=1;
		for (int j = 0; j < searchArea.size(); j++){
			if (searchArea.get(j).isVisebility() == false){
				k++;
			}
		}
		for (int j = 0; j < searchArea.size(); j++) {
			if (searchArea.get(j).isVisebility() == true) {
				System.out.print(searchArea.get(j).getObjName());
				if (j < searchArea.size() - k) {
					System.out.print(", ");
				}
				
				contain = true;
			
			}
			
		}
		return contain;
	}

	private boolean itemDescription(ArrayList<GameObject> searchArea,
			boolean contain) {
		for (int k = 0; k < searchArea.size(); k++) {
			if (searchArea.get(k).getObjName().equals(getSecondWord())) {
				if (searchArea.get(k).isVisebility() == true) {
					System.out.println(searchArea.get(k).getAmplification());
					contain = true;
				}
			}
		}
		return contain;
	}

	@Override
	public void showSpecialHelp() {
		// Ausgabe wenn die Hilfe zu diesem Kommand abgefragt wird
		System.out.println("Nutze Guck um Gegenstände genauer zu betrachten! ");
		System.out
				.println("Um dein Inventar anzuschaun nutz >Guck inventar< !");
		System.out.println("Um dein Raum anzuschaun nutz >Guck room< !");
	}
}
