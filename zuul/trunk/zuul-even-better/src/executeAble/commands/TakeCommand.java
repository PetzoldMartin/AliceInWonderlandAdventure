package executeAble.commands;

import gameEnums.GameStatus;
import zuulCore.Game;
import zuulCore.GameObject;
import zuulCore.Player;

/**
 * das {@link Command} das dafür sorgt das ein Spieler {@link GameObject}e in sein Inventar überführen kann
 * @author Aismael
 *
 */
public class TakeCommand extends Command {

	/**
	 * verschiebt ein {@link GameObject} sofern es vorhanden ist und mitnehmbar
	 * in das Inventar des Spielers
	 */
	@Override
	public GameStatus execute(Player player) {
		boolean isFound = false;
		if (hasSecondWord() && (!player.getCurrentRoom().isThereanyvisible())) {
			if (player.getCurrentRoom().hasObject(getSecondWord())) {
				if (player.getCurrentRoom().getSpecialObject(getSecondWord())
						.isTakeAble()
						&& player.getCurrentRoom()
								.getSpecialObject(getSecondWord())
								.isVisebility()) {
					Game.textOut.lineEntry("Du hast "
							+ player.getCurrentRoom()
									.getSpecialObject(getSecondWord())
									.getObjName() + " aufgenommen.");
					player.itemStore(player.getCurrentRoom().getSpecialObject(
							getSecondWord()));
					player.getCurrentRoom().itemRemove(getSecondWord());
					isFound = true;
				} else {
					Game.textOut.lineEntry("Du kannst das nicht aufnehmen.");
				}
				isFound = true;
			}

		}

		if (!isFound) {
			Game.textOut
					.lineEntry("Ich kann nix aufnehmen was nicht da ist...");
		}

		return GameStatus.RUN;
	}

	/**
	 * die Spezielle Hilfe für das {@link TakeCommand}
	 */
	@Override
	public void showSpecialHelp() {
		Game.textOut
				.lineEntry("Benutzen um ein Gegenstand im Raum aufzunehmen.");

	}

}
