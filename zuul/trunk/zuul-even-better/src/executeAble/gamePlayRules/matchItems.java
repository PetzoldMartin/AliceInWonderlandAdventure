package executeAble.gamePlayRules;

import zuulCore.Game;
import zuulCore.Player;
import GamePlayEnums.GameStatus;

public class matchItems extends gameplayRuleHead {
	boolean firstDelete, secondDelete;
	Player player;

	public matchItems(String secondWord, String thirdWord,
			String manipulatetObject, boolean firstDelete, boolean secondDelete) {
		super(secondWord, thirdWord, manipulatetObject);
		this.firstDelete = firstDelete;
		this.secondDelete = secondDelete;
	}

	/**
	 * @return 
	 * 
	 */
	@Override
	public GameStatus execute(Player player) {
		this.player = player;
		if (gameObjectIsAvaible(getSecondWord()) && gameObjectIsAvaible(getThirdWord())) {
			if (makeItemVisebill()) {
				removeGameObject(getSecondWord(), firstDelete);
				removeGameObject(getThirdWord(), secondDelete);
				right();
			} else {

				Game.textOut.lineEntry("Das Kann ich hier nicht benutzen");

			}
		} else {

			Game.textOut.lineEntry("Das Kann ich nicht benutzen");

		}

		return GameStatus.RUN;
	}

	private void right() {
		Game.textOut.lineEntry("Du Hast ein neues Object erschaffen");

	}

	/**
	 * 
	 * @return
	 */
	private boolean makeItemVisebill() {
		if (player.getCurrentRoom().hasObject(getManiO())) {
			player.getCurrentRoom().getSpecialObject(getManiO()).setVisebility(true);
			return true;
		} else {
			if (player.hasObject(getManiO())) {
				player.getSpecialObject(getManiO()).setVisebility(true);
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * 
	 * @param gString
	 * @return
	 */
	private boolean gameObjectIsAvaible(String gString) {
		if (player.hasObject(gString)
				|| player.getCurrentRoom().hasObject(gString)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param gString
	 * @param remove
	 */
	private void removeGameObject(String gString, boolean remove) {
		if (remove) {
			if (player.hasObject(gString)) {
				player.itemRemove(gString);
			} else {
				if (player.getCurrentRoom().hasObject(gString)) {
					player.getCurrentRoom().itemRemove(gString);
				}
			}
		}
	}

	
}
