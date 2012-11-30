package executeAble.gamePlayRules;

import zuulCore.Game;
import zuulCore.Player;
import GamePlayEnums.GameStatus;
import GamePlayEnums.LockedStatus;

public class openDoor extends gameplayRuleHead {

	public openDoor(String secondWord,
			String Direction) {
		super(secondWord, Direction, Direction);
	}

	@Override
	public GameStatus execute(Player player) {
		if (player.getCurrentRoom().getExit(getManiO()).isClosed() == LockedStatus.LOCKED) {
			player.getCurrentRoom().getExit(getManiO())
					.setClosed(LockedStatus.UNLOCKED);
			Game.textOut.lineEntry("Die T�r ist Offen");
		} else {
			Game.textOut.lineEntry("da ist keine Verschlossene T�r");
		}
		return GameStatus.RUN;
	}


}
