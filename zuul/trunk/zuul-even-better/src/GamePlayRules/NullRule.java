package GamePlayRules;

import zuulCore.Game;
import zuulCore.Player;

public class NullRule extends gameplayRuleHead {

	public NullRule() {
		super(null, null, null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Player player) {
		Game.textOut.lineEntry("Das ist keine Sinnvolle Nutzung");

	}

}
