package executeAble.gamePlayRules;

import zuulCore.Game;
import zuulCore.Player;
import GamePlayEnums.GameStatus;
/**
 * Die Spielregel die Zurückgegeben wird wenn die Geforderte Spielregel nicht vorhanden ist
 * @author Martin Petzold
 *
 */
public class NullRule extends gameplayRuleHead {

	/**
	 * Konstruktor der {@link NullRule}
	 */
	public NullRule() {
		super(null, null, null);
	}

	/**
	 * Die Auswirkung der {@link NullRule}
	 * Schreibt eine Fehlernachricht auf die Ausgabe
	 */
	@Override
	public GameStatus execute(Player player) {
		Game.textOut.lineEntry("Das ist keine Sinnvolle Nutzung");
		return GameStatus.RUN;

	}


}
