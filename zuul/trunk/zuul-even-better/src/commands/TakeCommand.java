package commands;

import zuulCore.Game;
import zuulCore.Player;
import GamePlayEnums.GameStatus;

//TODO REDO
public class TakeCommand extends Command {

	@Override
	public GameStatus execute(Player player) {
		boolean isFound = false;
		if (hasSecondWord() && (!player.getCurrentRoom().storeIsempty())) {
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

	@Override
	public void showSpecialHelp() {
		Game.textOut
				.lineEntry("Benutzen um ein Gegenstand im Raum aufzunehmen.");

	}

}
