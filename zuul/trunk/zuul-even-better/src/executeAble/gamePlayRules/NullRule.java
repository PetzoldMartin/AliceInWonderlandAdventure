package executeAble.gamePlayRules;

import zuulCore.Game;
import zuulCore.Player;
import GamePlayEnums.GameStatus;

public class NullRule extends gameplayRuleHead {

	public NullRule() {
		super(null, null, null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public GameStatus execute(Player player) {
		Game.textOut.lineEntry("Das ist keine Sinnvolle Nutzung");
		return GameStatus.RUN;

	}


}
