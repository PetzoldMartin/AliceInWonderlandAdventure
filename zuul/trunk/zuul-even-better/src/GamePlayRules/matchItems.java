package GamePlayRules;

import zuulCore.Game;
import zuulCore.Player;

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
	 * 
	 */
	@Override
	public void execute(Player player) {
		this.player = player;
		if (gameObjectIsAvaible(secondWord) && gameObjectIsAvaible(thirdWord)) {
			if (makeItemVisebill()) {
				removeGameObject(secondWord, firstDelete);
				removeGameObject(thirdWord, secondDelete);
				right();
			} else {

				Game.textOut.lineEntry("Das Kann ich hier nicht benutzen");

			}
		} else {

			Game.textOut.lineEntry("Das Kann ich nicht benutzen");

		}

	}

	private void right() {
		Game.textOut.lineEntry("Du Hast ein neues Object erschaffen");

	}

	/**
	 * 
	 * @return
	 */
	private boolean makeItemVisebill() {
		if (player.getCurrentRoom().hasObject(maniO)) {
			player.getCurrentRoom().getSpecialObject(maniO).setVisebility(true);
			return true;
		} else {
			if (player.hasObject(maniO)) {
				player.getSpecialObject(maniO).setVisebility(true);
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
