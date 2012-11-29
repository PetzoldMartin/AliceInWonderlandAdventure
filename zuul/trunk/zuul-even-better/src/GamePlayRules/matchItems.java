package GamePlayRules;

import zuulCore.Game;
import zuulCore.Player;

public class matchItems extends gameplayRuleHead {
	boolean firstDelete, secondDelete;

	public matchItems(String secondWord, String thirdWord,
			String manipulatetObject, boolean firstDelete, boolean secondDelete) {
		super(secondWord, thirdWord, manipulatetObject);
		this.firstDelete = firstDelete;
		this.secondDelete = secondDelete;
	}

	@Override
	public void execute(Player player) {
		System.out.println("x");

		if (player.getCurrentRoom().hasObject(secondWord)
				&& player.getCurrentRoom().hasObject(thirdWord)) {
			System.out.println("1");
			if (player.getCurrentRoom().hasObject(maniO)) {
				player.getCurrentRoom().getSpecialObject(maniO)
						.setVisebility(true);
				if (firstDelete) {
					player.getCurrentRoom().itemRemove(secondWord);
				}
				if (secondDelete) {
					player.getCurrentRoom().itemRemove(thirdWord);
				}
				right();
			}
		} else {
			if (player.hasObject(secondWord)
					&& player.getCurrentRoom().hasObject(thirdWord)) {
				System.out.println("2");
				if (player.getCurrentRoom().hasObject(maniO)) {
					player.getCurrentRoom().getSpecialObject(maniO)
							.setVisebility(true);
					if (firstDelete) {
						player.itemRemove(secondWord);
					}
					if (secondDelete) {
						player.getCurrentRoom().itemRemove(thirdWord);
					}
					right();
				}
			} else {
				if (player.getCurrentRoom().hasObject(secondWord)
						&& player.hasObject(thirdWord)) {
					System.out.println("3");
					if (player.getCurrentRoom().hasObject(maniO)) {
						player.getCurrentRoom().getSpecialObject(maniO)
								.setVisebility(true);
						if (firstDelete) {
							player.getCurrentRoom().itemRemove(secondWord);
						}
						if (secondDelete) {
							player.itemRemove(thirdWord);
						}
						right();
					}
				} else {
					if (player.hasObject(secondWord)
							&& player.hasObject(thirdWord)) {
						System.out.println("4");
						if (player.getCurrentRoom().hasObject(maniO)) {
							player.getCurrentRoom().getSpecialObject(maniO)
									.setVisebility(true);
							if (firstDelete) {
								player.itemRemove(secondWord);
							}
							if (secondDelete) {
								player.itemRemove(thirdWord);
							}
							right();
						}
					} else {
						Game.textOut.lineEntry("Das Kann ich nicht benutzen");
					}
				}
			}
		}

	}

	private void right() {
		Game.textOut.lineEntry("Du Hast ein neues Object erschaffen");

	}

}
