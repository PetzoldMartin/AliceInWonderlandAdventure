package GamePlayRules;

import GamePlayEnums.LockedStatus;
import zuulCore.Game;
import zuulCore.Player;

public class openDoor extends gameplayRuleHead {

	public openDoor(String secondWord,
			String Direction) {
		super(secondWord, Direction, Direction);
	}

	@Override
	public void execute(Player player) {
		if (player.getCurrentRoom().getExit(maniO).isClosed() == LockedStatus.LOCKED) {
			player.getCurrentRoom().getExit(maniO)
					.setClosed(LockedStatus.UNLOCKED);
			Game.textOut.lineEntry("Die Tür ist Offen");
		} else {
			Game.textOut.lineEntry("da ist keine Verschlossene Tür");
		}
	}

}
